package com.example.text001;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class LabelActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView mListview;
    //private FrameLayout mFrame;
    private List<User> mList = new ArrayList<User>();

    private List<Fragment> fragmentList = new ArrayList<>();
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_label);
        //初始化view
        initView();
        initViewData();
        //加载fragment
        addFragment();
//        //默认选中0
        replese(0);
        mList.get(0).setSelect(true);
        //listView点击事件
        mListview.setOnItemClickListener(this);
        imageView = findViewById(R.id.label_back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LabelActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        ShowFragment showFragment = new ShowFragment();
        for (int i = 0; i < mList.size(); i++) {
            Fragment fragment = showFragment.getShowFragment(mList.get(i).getName());
            fragmentList.add(fragment);
        }
        for (int i = 0; i < fragmentList.size(); i++) {
            transaction.add(R.id.mFrame,fragmentList.get(i));
        }
        transaction.commit();
    }
//
    private void initView() {
        mListview = findViewById(R.id.mListview);
        //mFrame = findViewById(R.id.mFrame);
    }
//
    private void initViewData() {
        for (int i = 0; i < 10; i++) {
            mList.add(new User("内容"+i));
        }
        LvAdapter lvAdapter = new LvAdapter(mList,this);
        mListview.setAdapter(lvAdapter);
//        mListview.setOnItemClickListener(this);
    }
//
    private void replese(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        for (int i = 0; i < fragmentList.size(); i++) {
            Fragment fragment = fragmentList.get(i);
            transaction.hide(fragment);
        }
        transaction.show(fragmentList.get(position));
        transaction.commit();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        replese(position);
    }
}