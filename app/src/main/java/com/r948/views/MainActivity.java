package com.r948.views;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.r948.orderedtakeout.R;
import com.r948.orderedtakeout.databinding.ActivityMainBinding;
import com.r948.utilities.StringUtil;
import com.r948.viewmodels.GeographyModel;

/**
 * 主页，包含外卖、订单、我的
 */
public class MainActivity extends AppCompatActivity {
    private static final String[] PERMISSIONS = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_WIFI_STATE, Manifest.permission.CHANGE_WIFI_STATE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupWithNavController(binding.navView, navController);
        requestPermission();
        createLocation();
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, PERMISSIONS, 0);
    }


    private void createLocation() {
        LocationClient client = new LocationClient(getApplicationContext());
        client.registerLocationListener(new MyLocationListener(GeographyModel.getInstance()));
        LocationClientOption option = new LocationClientOption();

        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        option.setCoorType("bd09ll");
        option.setScanSpan(10000);

        option.setOpenGps(true);
        option.setLocationNotify(true);
        option.setIgnoreKillProcess(true);
        option.SetIgnoreCacheException(false);
        option.setWifiCacheTimeOut(5 * 60 * 1000);
        option.setEnableSimulateGps(true);
        option.setNeedNewVersionRgc(true);
        option.setIsNeedAddress(true);
        option.setNeedNewVersionRgc(true);

        client.setLocOption(option);
        client.start();
    }

    private static class MyLocationListener extends BDAbstractLocationListener {
        private final GeographyModel geographyModel;

        public MyLocationListener(GeographyModel geographyModel) {
            this.geographyModel = geographyModel;
        }

        @Override
        public void onReceiveLocation(BDLocation location) {
            if (location == null) return;
            double latitude = location.getLatitude();    //获取纬度信息
            double longitude = location.getLongitude();    //获取经度信息
            String province = location.getProvince();    //获取省份
            String city = location.getCity();    //获取城市
            String district = location.getDistrict();    //获取区县
            if (StringUtil.haveNullOrEmpty(province, city, district)) return;
            geographyModel.getLatitude().postValue(latitude);
            geographyModel.getLongitude().postValue(longitude);
            geographyModel.getProvince().postValue(province);
            geographyModel.getCity().postValue(city);
            geographyModel.getDistrict().postValue(district);
        }
    }
}
