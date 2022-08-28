package com.example.text001;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.LinearViewHolder> {

    private Context mContext;
//    private OnItemClickListener mListener;

    public StaggeredGridAdapter(Context context){
//        OnItemClickListener listener

        this.mContext = context;
//        this.mListener = listener;
    }

    @Override
    public StaggeredGridAdapter.LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =View.inflate(mContext,R.layout.layout_staggered_grid_recyclerview_item,null);
        return new LinearViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StaggeredGridAdapter.LinearViewHolder holder, int position) {
        if (position % 2 != 0) {
            holder.imageView.setImageResource(R.drawable.pg1);
        } else {
            holder.imageView.setImageResource(R.drawable.pg2);
        }
//        holder.itemView.setOnClickListener((v) -> {mListener.onClick(position);});
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public class LinearViewHolder extends  RecyclerView.ViewHolder{

        private ImageView imageView;
        public LinearViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
        }
    }
//    public interface OnItemClickListener{
//        void onClick(int pos);
//    }
}
