package com.r948.orderedtakeout.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.r948.orderedtakeout.data.Repository;

public class RepoViewModel extends ViewModel {
    // 仓库对象，包含 LocalDataSource 和 NetDataSource
    protected final Repository repo;
    // Toast 弹出消息
    protected final MutableLiveData<String> toastMsg = new MutableLiveData<>();

    public RepoViewModel(Repository repo) {
        this.repo = repo;
    }

    public MutableLiveData<String> getToastMsg() {
        return toastMsg;
    }
}
