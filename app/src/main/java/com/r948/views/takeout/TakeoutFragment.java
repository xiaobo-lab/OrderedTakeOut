package com.r948.views.takeout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;

import com.r948.data.Repository;
import com.r948.data.local.LocalDataSource;
import com.r948.data.net.dao.django.DjangoNetDataSource;
import com.r948.models.ShowShop;
import com.r948.orderedtakeout.R;
import com.r948.orderedtakeout.databinding.FragmentTakeoutBinding;
import com.r948.orderedtakeout.databinding.ShopItemBinding;
import com.r948.utilities.Constants;
import com.r948.utilities.GlideImageLoader;
import com.r948.utilities.ThreadUtil;
import com.r948.viewmodels.GeographyModel;
import com.r948.viewmodels.RepoViewModelFactory;
import com.r948.viewmodels.takeout.TakeoutModel;
import com.r948.views.takeout.search.SearchActivity;
import com.r948.views.takeout.sort.SortActivity;
import com.r948.views.takeout.sort.shop.ShopActivity;
import com.youth.banner.indicator.CircleIndicator;

import java.util.List;

/**
 * 外卖
 */
public class TakeoutFragment extends Fragment {
    private FragmentTakeoutBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTakeoutBinding.inflate(inflater, container, false);
        LifecycleOwner owner = getViewLifecycleOwner();

        GeographyModel geographyModel = GeographyModel.getInstance();
        TakeoutModel takeoutModel = new ViewModelProvider(this,
                new RepoViewModelFactory(new Repository(LocalDataSource.getInstance(container.getContext()),
                        new DjangoNetDataSource()))).get(TakeoutModel.class);
        takeoutModel.getHorseLamp().observe(owner, strings ->
                binding.ivComm.addBannerLifecycleObserver(getViewLifecycleOwner()).setAdapter(new GlideImageLoader(strings))
                        .setIndicator(new CircleIndicator(container.getContext())));
        takeoutModel.getSortKind().observe(owner, takeoutModel::sort);
        takeoutModel.getShowShops().observe(owner, showShops -> binding.homepageShopList.setAdapter(new ListViewAdapter(showShops)));

        binding.etSearch.setOnClickListener(view -> etSearchClick());
        binding.ibLeft1.setOnClickListener(view -> startSortActivity(0, "早餐"));
        binding.ibLeft2.setOnClickListener(view -> startSortActivity(1, "快餐"));
        binding.ibCenter.setOnClickListener(view -> startSortActivity(2, "水果"));
        binding.ibRight1.setOnClickListener(view -> startSortActivity(3, "饮品"));
        binding.ibRight2.setOnClickListener(view -> startSortActivity(4, "甜点"));
        binding.btComprehensive.setOnClickListener(view -> takeoutModel.getSortKind().setValue(Constants.SortKind.COMPREHENSIVE));
        binding.btDistance.setOnClickListener(view -> takeoutModel.getSortKind().setValue(Constants.SortKind.DISTANCE));
        binding.btSold.setOnClickListener(view -> takeoutModel.getSortKind().setValue(Constants.SortKind.SOLD));
        binding.setTakeout(takeoutModel);
        binding.setGeography(geographyModel);

        ThreadUtil.invoke(takeoutModel::updateHorseLamp);
        ThreadUtil.invoke(() -> {
            takeoutModel.queryNearByShop(geographyModel.getLatitude().getValue(), geographyModel.getLongitude().getValue());
            takeoutModel.getSortKind().postValue(Constants.SortKind.COMPREHENSIVE);
        });

        binding.setLifecycleOwner(getViewLifecycleOwner());
        return binding.getRoot();
    }

    private void startSortActivity(int sort, String sortName) {
        Intent intent = new Intent(getActivity(), SortActivity.class);
        intent.putExtra("sort", sort);
        intent.putExtra("sortName", sortName);
        startActivity(intent);
    }

    private void etSearchClick() {
        startActivity(new Intent(getActivity(), SearchActivity.class));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
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
