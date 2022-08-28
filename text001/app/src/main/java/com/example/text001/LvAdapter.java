package com.example.text001;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class LvAdapter extends BaseAdapter {
    List<User> mList;
    Context context;

    public LvAdapter(List<User> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mList!=null?mList.size():0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    static class  ViewHolder{
        TextView tvText;
        TextView tvLine;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView==null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_layout,null);
            holder.tvText = convertView.findViewById(R.id.tv_text);
            holder.tvLine = convertView.findViewById(R.id.tv_line);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        String name = mList.get(position).getName();
        holder.tvText.setText(name);
        return convertView;
    }

}
