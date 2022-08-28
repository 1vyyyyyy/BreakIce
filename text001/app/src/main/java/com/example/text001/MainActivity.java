package com.example.text001;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private TextView textView;
    private List<View> list_image = new ArrayList<>();
    private ViewPager pager;
    private int img[] = {R.drawable.vp1,R.drawable.vp2,R.drawable.vp3,
            R.drawable.vp4};
    private ImageView point[];
    private int pointId[] = {R.id.point1,R.id.point2,R.id.point3,R.id.point4};
//    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.fenlei);//标签点击事件
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LabelActivity.class);
                startActivity(intent);
            }
        });
        pager = findViewById(R.id.pager);
        initData();
        initPoint();
        ViewPagerAdapter adapter = new ViewPagerAdapter(list_image,img.length);
        pager.setAdapter(adapter);
        pager.setOnPageChangeListener(this);
        pager.setCurrentItem(img.length * 100);
//        recyclerView.findViewById(R.id.rv_pubu);
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
//        StaggeredGridAdapter staggeredGridAdapter = new StaggeredGridAdapter(MainActivity.this);
//        recyclerView.setAdapter(staggeredGridAdapter);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        RecyclerView recyclerView = findViewById(R.id.rv_pubu);
        StaggeredGridAdapter staggeredGridAdapter = new StaggeredGridAdapter(this);
        recyclerView.setAdapter(staggeredGridAdapter);
        recyclerView.setLayoutManager(manager);
    }
    private void initData(){
        for(int i : img){
            ImageView imageView = new ImageView(this);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            imageView.setImageResource(i);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(params);
            list_image.add(imageView);
        }
    }
    private void initPoint(){
        point = new ImageView[img.length];
        for (int i = 0; i < img.length; i++) {
            point[i] = findViewById(pointId[i]);
            point[i].setOnClickListener(this);
            point[i].setTag(i);
        }
    }

    private void pointChage(int position){
        position = position % (img.length);
        for (int i = 0; i < img.length; i++) {
            point[i].setImageResource(R.drawable.unchecked);
        }
        point[position].setImageResource(R.drawable.checked);
    }


    @Override
    public void onClick(View v) {
        int position = (Integer) v.getTag();
        pointChage(position);
        try {
            pager.setCurrentItem(pager.getCurrentItem()/img.length*img.length + position);
        } catch (Exception e) {
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        pointChage(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}