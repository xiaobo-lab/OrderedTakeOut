package com.r948.orderedtakeout.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.r948.orderedtakeout.data.Repository;

import java.lang.reflect.InvocationTargetException;

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
                return (T) modelClass.getConstructor(Repository.class).newInstance(repository);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
                throw new IllegalArgumentException("The view model must have RepoViewModel's constructor.");
            }
        }
        throw new IllegalArgumentException("The view model must to extend RepoViewModel.");
    }
}
