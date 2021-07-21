package com.r948.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * 用户当前地理信息
 */
public class GeographyModel extends ViewModel {
    /**
     * 当前所在地区，如：大连市甘井子区
     */
    private final MutableLiveData<String> location = new MutableLiveData<>();

    /**
     * 当前所在经度
     */
    private final MutableLiveData<Double> longitude = new MutableLiveData<>();

    /**
     * 当前所在纬度
     */
    private final MutableLiveData<Double> latitude = new MutableLiveData<>();

    /**
     * 当前地区温度
     */
    private final MutableLiveData<Float> temperature = new MutableLiveData<>();

    public MutableLiveData<String> getLocation() {
        return location;
    }

    public MutableLiveData<Double> getLatitude() {
        return latitude;
    }

    public MutableLiveData<Double> getLongitude() {
        return longitude;
    }

    public MutableLiveData<Float> getTemperature() {
        return temperature;
    }
}
