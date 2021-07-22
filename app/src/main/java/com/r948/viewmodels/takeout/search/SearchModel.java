package com.r948.viewmodels.takeout.search;

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
 * 搜索
 */
public class SearchModel extends RepoViewModel {
    public static class SearchResult {

        /**
         * 搜索到的所有商家
         */
        private final ShowShop showShop;

        /**
         * 推荐商品图片
         */
        private final List<String> commodityImage;

        /**
         * 推荐商品名称
         */
        private final List<String> commodityName;

        /**
         * 推荐商品单价
         */
        private final List<String> commodityPrice;

        public SearchResult(ShowShop showShop, List<String> commodityImage, List<String> commodityName, List<String> commodityPrice) {
            this.showShop = showShop;
            this.commodityImage = commodityImage;
            this.commodityName = commodityName;
            this.commodityPrice = commodityPrice;
        }

        public ShowShop getShowShop() {
            return showShop;
        }

        public List<String> getCommodityImage() {
            return commodityImage;
        }

        public List<String> getCommodityName() {
            return commodityName;
        }

        public List<String> getCommodityPrice() {
            return commodityPrice;
        }
    }

    /**
     * 用户输入的搜索信息
     */
    private final MutableLiveData<String> search = new MutableLiveData<>();

    /**
     * 搜索结果页中搜索结果部分，用户选择的排序方式，
     * 取值为 {@link com.r948.utilities.Constants.SortKind}
     */
    private final MutableLiveData<String> sortKind = new MutableLiveData<>();

    private final MutableLiveData<List<SearchResult>> results = new MutableLiveData<>();


    public SearchModel(Repository repo, MutableLiveData<String> toastMsg) {
        super(repo, toastMsg);
    }

    public MutableLiveData<String> getSearch() {
        return search;
    }

    public MutableLiveData<String> getSortKind() {
        return sortKind;
    }

    public MutableLiveData<List<SearchResult>> getResults() {
        return results;
    }

    /**
     * 搜索经纬度附近的所有满足条件的商家
     *
     * @param keyWord 关键字
     * @param lat     纬度
     * @param lon     经度
     */
    public void queryNearByAndKeyWord(String keyWord, @Nullable Double lat, @Nullable Double lon) {
        List<SearchResult> results = new ArrayList<>();
        List<ShowShop> showShops = new ArrayList<>();
        List<List<String>> image = new ArrayList<>();
        List<List<String>> name = new ArrayList<>();
        List<List<String>> price = new ArrayList<>();

        showShops.add(new ShowShop("李家春饼", "https://p1.meituan.net/600.600/dealwatera/d23792912ea65572f488f157abc4063f349454.jpg", 8.7f, 405, "1301"));
        showShops.add(new ShowShop("朝天门火锅（盘锦旗舰店）", "https://p0.meituan.net/deal/1e864c0da5499113f91dab4216b5c0cc157956.jpg", 8.5f, 397, "1208"));
        showShops.add(new ShowShop("瑞合祥一品排骨（康桥店）", "https://p0.meituan.net/600.600/deal/37fc2c3b65dc9dd927ac7d2390696e5742758.jpg", 9.2f, 875, "2349"));

        List<String> images1 = new ArrayList<>();
        List<String> images2 = new ArrayList<>();
        List<String> images3 = new ArrayList<>();
        List<String> names1 = new ArrayList<>();
        List<String> names2 = new ArrayList<>();
        List<String> names3 = new ArrayList<>();
        List<String> prices1 = new ArrayList<>();
        List<String> prices2 = new ArrayList<>();
        List<String> prices3 = new ArrayList<>();
        images1.add("https://qcloud.dpfile.com/pc/HBcHMNeYzjpXDySGKn_Znh5TRo78SB_DroLjeUkGDnh9sqXKzTRyD-qvcIBIOqEN5g_3Oo7Z9EXqcoVvW9arsw.jpg");
        images1.add("https://qcloud.dpfile.com/pc/xJJ2rXcbmurJDxPemIzkvOmOQlWd9-qWhOviH8v2elhVsMg_v10-y8J1hCeT6DeG5g_3Oo7Z9EXqcoVvW9arsw.jpg");
        images1.add("https://qcloud.dpfile.com/pc/L87l99jyFqkSa6shPHh_u8BjqvFAhKuxtpuVDlcDvtbof9gs5992rk9HQeMdv6ps5g_3Oo7Z9EXqcoVvW9arsw.jpg");
        ///
        images2.add("https://qcloud.dpfile.com/pc/HBcHMNeYzjpXDySGKn_Znh5TRo78SB_DroLjeUkGDnh9sqXKzTRyD-qvcIBIOqEN5g_3Oo7Z9EXqcoVvW9arsw.jpg");
        images2.add("https://qcloud.dpfile.com/pc/L87l99jyFqkSa6shPHh_u8BjqvFAhKuxtpuVDlcDvtbof9gs5992rk9HQeMdv6ps5g_3Oo7Z9EXqcoVvW9arsw.jpg");
        images2.add("https://qcloud.dpfile.com/pc/xJJ2rXcbmurJDxPemIzkvOmOQlWd9-qWhOviH8v2elhVsMg_v10-y8J1hCeT6DeG5g_3Oo7Z9EXqcoVvW9arsw.jpg");
        ///
        images3.add("https://qcloud.dpfile.com/pc/L87l99jyFqkSa6shPHh_u8BjqvFAhKuxtpuVDlcDvtbof9gs5992rk9HQeMdv6ps5g_3Oo7Z9EXqcoVvW9arsw.jpg");
        images3.add("https://qcloud.dpfile.com/pc/HBcHMNeYzjpXDySGKn_Znh5TRo78SB_DroLjeUkGDnh9sqXKzTRyD-qvcIBIOqEN5g_3Oo7Z9EXqcoVvW9arsw.jpg");
        images3.add("https://qcloud.dpfile.com/pc/xJJ2rXcbmurJDxPemIzkvOmOQlWd9-qWhOviH8v2elhVsMg_v10-y8J1hCeT6DeG5g_3Oo7Z9EXqcoVvW9arsw.jpg");
        image.add(images1);
        image.add(images2);
        image.add(images3);
        ///////////
        names1.add("鹅肝");
        names1.add("甜虾拼盘");
        names1.add("烤鳗鱼");
        ///
        names2.add("鹅肝");
        names2.add("烤鳗鱼");
        names2.add("甜虾拼盘");
        //
        names3.add("甜虾拼盘");
        names3.add("鹅肝");
        names3.add("烤鳗鱼");
        name.add(names1);
        name.add(names2);
        name.add(names3);
        ////////////////
        prices1.add("150");
        prices1.add("85");
        prices1.add("60");
        //
        prices2.add("150");
        prices2.add("60");
        prices2.add("85");
        //
        prices3.add("60");
        prices3.add("150");
        prices3.add("85");

        price.add(prices1);
        price.add(prices2);
        price.add(prices3);

        for (int i = 0, s = showShops.size(); i < s; i++) {
            results.add(new SearchResult(showShops.get(i), image.get(i), name.get(i), price.get(i)));
            results.add(new SearchResult(showShops.get(i), image.get(i), name.get(i), price.get(i)));
            results.add(new SearchResult(showShops.get(i), image.get(i), name.get(i), price.get(i)));
        }

        this.results.postValue(results);
    }

    public void sort(String kind) {
        List<SearchResult> searchResultList = this.getResults().getValue();
        if (searchResultList == null || searchResultList.isEmpty()) return;
        switch (kind) {
            case Constants.SortKind.COMPREHENSIVE:
                break;
            case Constants.SortKind.DISTANCE:
                Collections.shuffle(searchResultList);
                break;
            case Constants.SortKind.SOLD:
                Collections.shuffle(searchResultList);
                break;
            default:
                toastMsg.setValue("error kind type");
        }
        this.getResults().setValue(searchResultList);
    }
}
