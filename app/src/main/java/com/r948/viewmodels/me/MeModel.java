package com.r948.viewmodels.me;

import androidx.lifecycle.MutableLiveData;

import com.r948.data.Repository;
import com.r948.viewmodels.RepoViewModel;

/**
 * 我的
 */
public class MeModel extends RepoViewModel {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户名称
     */
    private final MutableLiveData<String> userName = new MutableLiveData<>();

    /**
     * 用户头像
     */
    private final MutableLiveData<String> userIcon = new MutableLiveData<>();

    /**
     * 用户角色
     */
    private final MutableLiveData<Byte> role = new MutableLiveData<>();

    public MeModel(Repository repo) {
        super(repo);

    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public MutableLiveData<String> getUserName() {
        return userName;
    }

    public MutableLiveData<String> getUserIcon() {
        return userIcon;
    }

    public MutableLiveData<Byte> getRole() {
        return role;
    }
}
