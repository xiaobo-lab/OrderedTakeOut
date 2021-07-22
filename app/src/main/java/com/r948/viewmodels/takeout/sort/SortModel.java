package com.r948.viewmodels.takeout.sort;

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
 * 商品分类查看页，如：早餐页
 */
public class SortModel extends RepoViewModel {

    /**
     * 该分类下所有商店
     */
    private final MutableLiveData<List<ShowShop>> showShops = new MutableLiveData<>();

    /**
     * 展示大图
     */
    private final MutableLiveData<String> imageUrl = new MutableLiveData<>();

    /**
     * 搜索结果页中搜索结果部分，用户选择的排序方式，
     * 取值为 {@link com.r948.utilities.Constants.SortKind}
     */
    private final MutableLiveData<String> sortKind = new MutableLiveData<>();

    public SortModel(Repository repo, MutableLiveData<String> toastMsg) {
        super(repo, toastMsg);
    }

    public MutableLiveData<List<ShowShop>> getShowShops() {
        return showShops;
    }

    public MutableLiveData<String> getImageUrl() {
        return imageUrl;
    }

    public MutableLiveData<String> getSortKind() {
        return sortKind;
    }

    /**
     * 根据用户当前经纬度坐标和商品类别获取所有商家和展示大图
     *
     * @param sort 商品类别
     * @param lat  纬度
     * @param lon  经度
     */
    public void queryNearbyAndSort(int sort, @Nullable Double lat, @Nullable Double lon) {
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

        this.imageUrl.postValue("https://v6.modao.cc/uploads4/images/4332/43324893/v2_q30acx.jpg");
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
