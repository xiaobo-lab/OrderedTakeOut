package com.r948.views.takeout.sort;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.r948.data.Repository;
import com.r948.data.local.LocalDataSource;
import com.r948.data.net.dao.django.DjangoNetDataSource;
import com.r948.models.ShowShop;
import com.r948.orderedtakeout.R;
import com.r948.orderedtakeout.databinding.ActivitySortBinding;
import com.r948.orderedtakeout.databinding.ShopItemBinding;
import com.r948.utilities.Constants;
import com.r948.utilities.ThreadUtil;
import com.r948.viewmodels.GeographyModel;
import com.r948.viewmodels.RepoViewModelFactory;
import com.r948.viewmodels.takeout.sort.SortModel;
import com.r948.views.takeout.search.SearchActivity;
import com.r948.views.takeout.sort.shop.ShopActivity;

import java.util.List;

/**
 * 商品分类查看页，如：早餐页
 */
public class SortActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySortBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_sort);

        GeographyModel geography = GeographyModel.getInstance();
        SortModel sortModel = new ViewModelProvider(this, new RepoViewModelFactory(new Repository(LocalDataSource.getInstance(this), new DjangoNetDataSource()))).get(SortModel.class);
        sortModel.getSortKind().observe(this, sortModel::sort);
        sortModel.getShowShops().observe(this, showShops -> binding.clsShopList.setAdapter(new ListViewAdapter(showShops)));

        binding.btComprehensiveCls.setOnClickListener(view -> sortModel.getSortKind().setValue(Constants.SortKind.COMPREHENSIVE));
        binding.btDistanceCls.setOnClickListener(view -> sortModel.getSortKind().setValue(Constants.SortKind.DISTANCE));
        binding.btSoldCls.setOnClickListener(view -> sortModel.getSortKind().setValue(Constants.SortKind.SOLD));
        binding.ibSearchCls.setOnClickListener(view -> startActivity(new Intent(this, SearchActivity.class)));
        binding.tvClass.setText(getIntent().getStringExtra("sortName"));

        ThreadUtil.invoke(() -> {
            sortModel.queryNearbyAndSort(getIntent().getIntExtra("sort", 0), geography.getLatitude().getValue(), geography.getLongitude().getValue());
            sortModel.getSortKind().postValue(Constants.SortKind.COMPREHENSIVE);
        });
        binding.setSort(sortModel);
        binding.setLifecycleOwner(this);
    }


    private static class ListViewAdapter extends BaseAdapter {
        private final List<ShowShop> showShops;
        private final int size;

        private ListViewAdapter(List<ShowShop> showShops) {
            this.showShops = showShops;
            size = showShops.size();
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
            ShopItemBinding binding;
            if (convertView == null) {
                binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.shop_item, parent, false);
                convertView = binding.getRoot();
                convertView.setTag(binding);
            } else {
                binding = (ShopItemBinding) convertView.getTag();
            }
            binding.setShowShop(showShops.get(position));
            binding.getRoot().setOnClickListener(view -> {
                Intent intent = new Intent(parent.getContext(), ShopActivity.class);
                parent.getContext().startActivity(intent);
            });
            return convertView;
        }
    }
}
