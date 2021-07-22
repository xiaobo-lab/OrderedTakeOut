package com.r948.views.takeout;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import com.r948.data.Repository;
import com.r948.data.local.LocalDataSource;
import com.r948.data.net.dao.django.DjangoNetDataSource;
import com.r948.orderedtakeout.databinding.FragmentTakeoutBinding;
import com.r948.utilities.GlideImageLoader;
import com.r948.utilities.ThreadUtil;
import com.r948.viewmodels.GeographyModel;
import com.r948.viewmodels.RepoViewModelFactory;
import com.r948.viewmodels.takeout.TakeoutModel;
import com.youth.banner.indicator.CircleIndicator;

/**
 * 外卖
 */
public class TakeoutFragment extends Fragment {
    private FragmentTakeoutBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTakeoutBinding.inflate(inflater, container, false);

        binding.setGeography(new ViewModelProvider(this).get(GeographyModel.class));
        TakeoutModel takeoutModel = new ViewModelProvider(this,
                new RepoViewModelFactory(new Repository(LocalDataSource.getInstance(container.getContext()),
                        new DjangoNetDataSource()))).get(TakeoutModel.class);
        takeoutModel.getHorseLamp().observe(getViewLifecycleOwner(), strings ->
                binding.ivComm.addBannerLifecycleObserver(getViewLifecycleOwner()).setAdapter(new GlideImageLoader(strings))
                        .setIndicator(new CircleIndicator(container.getContext())));
        ThreadUtil.invoke(takeoutModel::updateHorseLamp);

        binding.setLifecycleOwner(getViewLifecycleOwner());
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
