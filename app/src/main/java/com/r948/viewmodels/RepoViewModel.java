package com.r948.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.r948.data.Repository;

/**
 * 与存储层有关的 ViewModel 需要继承本类，并通过 {@link RepoViewModelFactory} 生成
 */
public class RepoViewModel extends ViewModel {
    /**
     * 仓库对象，包含 LocalDataSource 和 NetDataSource
     */
    protected final Repository repo;

    /**
     * Toast 弹出消息
     */
    protected final MutableLiveData<String> toastMsg;

    public RepoViewModel(Repository repo, MutableLiveData<String> toastMsg) {
        this.repo = repo;
        this.toastMsg = toastMsg;
    }

    public MutableLiveData<String> getToastMsg() {
        return toastMsg;
    }
}
