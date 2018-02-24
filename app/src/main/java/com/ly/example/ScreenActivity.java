package com.ly.example;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ly.screen.EasyScreen;

/**
 * 屏幕适配的示例页面
 */
public class ScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 创建设计稿（如果每个 Activity 的设计稿尺寸相同的话，建议直接在 Application 中创建）
        EasyScreen.createDesign(this, 640, 360);
        DataBindingUtil.setContentView(this, R.layout.activity_screen);
    }
}
