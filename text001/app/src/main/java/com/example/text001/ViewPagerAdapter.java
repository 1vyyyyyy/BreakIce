package com.example.text001;


import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

    private List<View> list_image = new ArrayList<View>();
    private int imgLenth;

    public ViewPagerAdapter(List<View> list_image, int imgLenth){
        this.list_image = list_image;
        this.imgLenth = imgLenth;
    }

    @Override
    public int getCount() {
        return 10000;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub
        //取余很重要呀 list集合里面就那么几张图片
        container.addView(list_image.get(position % imgLenth));
        return list_image.get(position % imgLenth);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        //同上
        container.removeView(list_image.get(position % imgLenth));
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager)container).removeView(list_image.get(position % imgLenth));

    }

    /**
     * 载入图片进去，用当前的position 除以 图片数组长度取余数是关键
     */
    @Override
    public Object instantiateItem(View container, int position) {
        ((ViewPager)container).addView(list_image.get(position % imgLenth), 0);
        return list_image.get(position % imgLenth);
    }
}
