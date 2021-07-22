package com.r948.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.r948.data.Repository;

import java.lang.reflect.InvocationTargetException;

/**
 * 通过本类生成 {@link RepoViewModel}
 */
public class RepoViewModelFactory implements ViewModelProvider.Factory {
    private final Repository repository;

    public RepoViewModelFactory(Repository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (RepoViewModel.class.isAssignableFrom(modelClass)) {
            try {
                return (T) modelClass.getConstructor(Repository.class, MutableLiveData.class).newInstance(repository, repository.getMessage());
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
                throw new IllegalArgumentException("The view model must have RepoViewModel's constructor.");
            }
        }
        throw new IllegalArgumentException("The view model must to extend RepoViewModel.");
    }
}
