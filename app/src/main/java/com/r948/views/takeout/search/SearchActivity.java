package com.r948.views.takeout.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.r948.data.Repository;
import com.r948.data.local.LocalDataSource;
import com.r948.data.net.dao.django.DjangoNetDataSource;
import com.r948.orderedtakeout.R;
import com.r948.orderedtakeout.databinding.ActivitySearchBinding;
import com.r948.orderedtakeout.databinding.ShopCommItemBinding;
import com.r948.utilities.Constants;
import com.r948.utilities.ThreadUtil;
import com.r948.viewmodels.GeographyModel;
import com.r948.viewmodels.RepoViewModelFactory;
import com.r948.viewmodels.takeout.search.SearchModel;
import com.r948.views.takeout.sort.shop.ShopActivity;

import java.util.List;

/**
 * 搜索
 */
public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySearchBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        GeographyModel geography = GeographyModel.getInstance();
        SearchModel searchModel = new ViewModelProvider(this, new RepoViewModelFactory(new Repository(LocalDataSource.getInstance(this), new DjangoNetDataSource()))).get(SearchModel.class);

        searchModel.getSortKind().observe(this, searchModel::sort);
        searchModel.getResults().observe(this, results -> binding.searchResultList.setAdapter(new ListViewAdapter(results)));
        searchModel.getSearch().observe(this, keyWord -> ThreadUtil.invoke(() -> searchModel.queryNearByAndKeyWord(keyWord, geography.getLatitude().getValue(), geography.getLongitude().getValue())));

        binding.btComprehensiveRslt.setOnClickListener(view -> searchModel.getSortKind().setValue(Constants.SortKind.COMPREHENSIVE));
        binding.btDitanceRslt.setOnClickListener(view -> searchModel.getSortKind().setValue(Constants.SortKind.DISTANCE));
        binding.btSoldRslt.setOnClickListener(view -> searchModel.getSortKind().setValue(Constants.SortKind.SOLD));
        binding.etSearchRslt.addTextChangedListener(new MyTextWatcher(searchModel));

        binding.setSearch(searchModel);
        binding.setLifecycleOwner(this);
    }

    private static class MyTextWatcher implements TextWatcher {
        private final SearchModel searchModel;

        private MyTextWatcher(SearchModel searchModel) {
            this.searchModel = searchModel;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            searchModel.getSearch().postValue(s.toString());
            String kind = searchModel.getSortKind().getValue();
            searchModel.getSortKind().postValue(kind == null ? Constants.SortKind.COMPREHENSIVE : kind);
        }
    }

    private static class ListViewAdapter extends BaseAdapter {
        private final List<SearchModel.SearchResult> results;
        private final int size;

        private ListViewAdapter(List<SearchModel.SearchResult> results) {
            this.results = results;
            size = results.size();
        }

        @Override
        public int getCount() {
            return size;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ShopCommItemBinding binding;
            if (convertView == null) {
                binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.shop_comm_item, parent, false);
                convertView = binding.getRoot();
                convertView.setTag(binding);
            } else {
                binding = (ShopCommItemBinding) convertView.getTag();
            }
            SearchModel.SearchResult result = results.get(position);
            binding.setImages(result.getCommodityImage());
            binding.setNames(result.getCommodityName());
            binding.setPrices(result.getCommodityPrice());
            binding.setShop(result.getShowShop());

            binding.getRoot().setOnClickListener(view -> {
                Intent intent = new Intent(parent.getContext(), ShopActivity.class);
                parent.getContext().startActivity(intent);
            });
            return convertView;
        }
    }
}
