package com.qxy.douyinof1024;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;


public class MainActivity extends AppCompatActivity {

    private String mScope = "user_info,trial.whitelist";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.loginBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendAuth();
            }
        });
    }

    private boolean sendAuth() {

        DouYinOpenApi douYinOpenApi = DouYinOpenApiFactory.create(this);

        Authorization.Request request = new Authorization.Request();
        request.scope = mScope;                          // 用户授权时必选权限
        request.callerLocalEntry="com.qxy.douyinof1024.douyinapi.DouYinEntryActivity";
        return douYinOpenApi.authorize(request);               // 优先使用抖音app进行授权，如果抖音app因版本或者其他原因无法授权，则使用wap页授权

    }

}