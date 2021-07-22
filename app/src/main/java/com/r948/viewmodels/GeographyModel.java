package com.r948.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * 用户当前地理信息
 */
public class GeographyModel extends ViewModel {
    private static final GeographyModel geography = new GeographyModel();

    private GeographyModel() { }

    public static GeographyModel getInstance() {
        return geography;
    }

    /**
     * 当前所在省份
     */
    private final MutableLiveData<String> province = new MutableLiveData<>();

    /**
     * 当前所在城市
     */
    private final MutableLiveData<String> city = new MutableLiveData<>();

    /**
     * 当前所在区县
     */
    private final MutableLiveData<String> district = new MutableLiveData<>();

    /**
     * 当前所在街道
     */
    private final MutableLiveData<String> street = new MutableLiveData<>();

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

    public MutableLiveData<Double> getLatitude() {
        return latitude;
    }

    public MutableLiveData<Double> getLongitude() {
        return longitude;
    }

    public MutableLiveData<Float> getTemperature() {
        return temperature;
    }

    public MutableLiveData<String> getProvince() {
        return province;
    }

    public MutableLiveData<String> getCity() {
        return city;
    }

    public MutableLiveData<String> getDistrict() {
        return district;
    }

    public MutableLiveData<String> getStreet() {
        return street;
    }
}
