package com.liyi.example;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.liyi.example.databinding.MainBD;

/**
 * 因为DataBinding注解的原因，导致项目上传有点问题，如要运行demo，请解开其他页面以及xml的注释，在运行
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MainBD mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        addListeners();
    }

    private void addListeners() {
        mBinding.btnScreen.setOnClickListener(this);
        mBinding.btnList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_screen:
                navigateToPage(ScreenActivity.class);
                break;
            case R.id.btn_list:
                navigateToPage(ListActivity.class);
                break;
        }
    }

    private void navigateToPage(Class clz) {
        Intent intent = new Intent(this, clz);
        startActivity(intent);
    }
}
