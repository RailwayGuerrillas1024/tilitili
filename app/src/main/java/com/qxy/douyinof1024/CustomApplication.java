package com.qxy.douyinof1024;

import android.app.Application;

import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;

public class CustomApplication extends Application {
    //注册sdk

    @Override
    public void onCreate() {
        super.onCreate();
        String clientKey = "awdh924qrow4pjq3";  //抖音开放平台SDK的Client Key
        DouYinOpenApiFactory.init(new DouYinOpenConfig(clientKey));
    }
}
