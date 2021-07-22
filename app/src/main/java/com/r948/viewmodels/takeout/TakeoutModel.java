package com.r948.viewmodels.takeout;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import com.r948.data.Repository;
import com.r948.models.ShowShop;
import com.r948.utilities.Constants;
import com.r948.viewmodels.RepoViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 外卖
 */
public class TakeoutModel extends RepoViewModel {
    private int shopId;

    /**
     * 外卖页面的走马灯图片 url
     */
    private final MutableLiveData<List<String>> horseLamp = new MutableLiveData<>();

    /**
     * 外卖页中推荐商家部分，用户选择的排序方式，
     * 取值为 {@link com.r948.utilities.Constants.SortKind}
     */
    private final MutableLiveData<String> sortKind = new MutableLiveData<>();

    /**
     * 附近所有的可推荐商家
     */
    private final MutableLiveData<List<ShowShop>> showShops = new MutableLiveData<>();

    public TakeoutModel(Repository repo, MutableLiveData<String> toastMsg) {
        super(repo, toastMsg);
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public MutableLiveData<List<String>> getHorseLamp() {
        return horseLamp;
    }

    public MutableLiveData<String> getSortKind() {
        return sortKind;
    }

    public MutableLiveData<List<ShowShop>> getShowShops() {
        return showShops;
    }

    public void updateHorseLamp() {
        horseLamp.postValue(repo.queryNetHorseLamp());
    }

    /**
     * 根据用户当前经纬度坐标，获取附近所有推荐商家
     *
     * @param lat 纬度
     * @param lon 经度
     */
    public void queryNearByShop(@Nullable Double lat, @Nullable Double lon) {
        double mLat = 0.0;
        double mLon = 0.0;

        List<ShowShop> showShops = new ArrayList<>();
        if (lat == null || lon == null) {
            toastMsg.postValue("请开始定位，以获取附近的推荐商家");
        } else {
            mLat = lat;
            mLon = lon;
        }

        showShops.add(new ShowShop("李家春饼", "https://p1.meituan.net/600.600/dealwatera/d23792912ea65572f488f157abc4063f349454.jpg", 8.7f, 405, "1301"));
        showShops.add(new ShowShop("朝天门火锅（盘锦旗舰店）", "https://p0.meituan.net/deal/1e864c0da5499113f91dab4216b5c0cc157956.jpg", 8.5f, 397, "1208"));
        showShops.add(new ShowShop("瑞合祥一品排骨（康桥店）", "https://p0.meituan.net/600.600/deal/37fc2c3b65dc9dd927ac7d2390696e5742758.jpg", 9.2f, 875, "2349"));
        showShops.add(new ShowShop("农家柴火炖鱼馆", "https://p1.meituan.net/600.600/deal/a13586111ca50c9e89fb680e0230d68d82749.jpg", 7.8f, 500, "3412"));
        showShops.add(new ShowShop("李家春饼", "https://p1.meituan.net/600.600/dealwatera/d23792912ea65572f488f157abc4063f349454.jpg", 8.7f, 405, "1301"));
        showShops.add(new ShowShop("朝天门火锅（盘锦旗舰店）", "https://p0.meituan.net/deal/1e864c0da5499113f91dab4216b5c0cc157956.jpg", 8.5f, 397, "1208"));
        showShops.add(new ShowShop("瑞合祥一品排骨（康桥店）", "https://p0.meituan.net/600.600/deal/37fc2c3b65dc9dd927ac7d2390696e5742758.jpg", 9.2f, 875, "2349"));
        showShops.add(new ShowShop("农家柴火炖鱼馆", "https://p1.meituan.net/600.600/deal/a13586111ca50c9e89fb680e0230d68d82749.jpg", 7.8f, 500, "3412"));

        this.showShops.postValue(showShops);
    }

    /**
     * 根据指定的推荐方式推当前查询到的推荐商家进行排序
     *
     * @param kind 排序方式
     */
    public void sort(String kind) {
        List<ShowShop> showShopList = this.getShowShops().getValue();
        if (showShopList == null || showShopList.isEmpty()) return;
        switch (kind) {
            case Constants.SortKind.COMPREHENSIVE:
                break;
            case Constants.SortKind.DISTANCE:
                Collections.shuffle(showShopList);
                break;
            case Constants.SortKind.SOLD:
                Collections.shuffle(showShopList);
                break;
            default:
                toastMsg.setValue("error kind type");
        }
        this.getShowShops().setValue(showShopList);
    }

}
