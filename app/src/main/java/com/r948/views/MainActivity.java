package com.r948.views;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.r948.orderedtakeout.R;
import com.r948.orderedtakeout.databinding.ActivityMainBinding;

/**
 * 主页，包含外卖、订单、我的
 */
public class MainActivity extends AppCompatActivity {
    private static final String[] PERMISSIONS = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupWithNavController(binding.navView, navController);
        requestPermission();
    }

    private void requestPermission() {
        for (int i = 0; i < PERMISSIONS.length; i++)
            if (ContextCompat.checkSelfPermission(this, PERMISSIONS[i]) != PackageManager.PERMISSION_GRANTED)
                ActivityCompat.requestPermissions(this, new String[]{PERMISSIONS[i]}, i);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "请授予权限", Toast.LENGTH_SHORT).show();
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.exit(0);
                }
            }.start();
        }
    }
}
