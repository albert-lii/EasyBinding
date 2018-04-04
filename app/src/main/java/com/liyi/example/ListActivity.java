package com.liyi.example;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.liyi.fit.FitScreen;
import com.liyi.example.databinding.ListBD;

import java.util.ArrayList;

/**
 * ListView 使用 DataBinding 示例
 */
public class ListActivity extends AppCompatActivity {
    private ListBD Binding;
    private ArrayList<String> mList;
    private ListAdapter mListAdp;
    private RecyclerAdapter mRecyclerAdp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 创建设计稿（如果每个 Activity 的设计稿尺寸相同的话，建议直接在 Application 中创建）
        FitScreen.createDesign(this, 640, 360);
        Binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        initUI();
    }

    private void initUI() {
        generateData();
        mListAdp = new ListAdapter(mList);
        Binding.listView.setAdapter(mListAdp);

        mRecyclerAdp = new RecyclerAdapter(mList);
        Binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Binding.recyclerView.setHasFixedSize(true);
        Binding.recyclerView.setAdapter(mRecyclerAdp);
        addListeners();
    }

    private void addListeners() {
        Binding.btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Binding.listView.setVisibility(View.VISIBLE);
                Binding.recyclerView.setVisibility(View.GONE);
            }
        });
        Binding.btnRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Binding.listView.setVisibility(View.GONE);
                Binding.recyclerView.setVisibility(View.VISIBLE);
            }
        });
    }

    private void generateData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mList.add("当前 position 是：" + i);
        }
    }
}
