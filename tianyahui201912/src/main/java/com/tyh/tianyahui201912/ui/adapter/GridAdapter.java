package com.tyh.tianyahui201912.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tyh.tianyahui201912.R;
import com.tyh.tianyahui201912.data.bean.MainBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.SubViewHolder> {
    Context context;
    ArrayList<MainBean.SellerBean> datalist;


    public void setData(Context context, ArrayList<MainBean.SellerBean> datalist) {
        this.context = context;
        this.datalist = datalist;
    }


    @NonNull
    @Override
    public SubViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_grid, viewGroup, false);
        SubViewHolder subViewHolder = new SubViewHolder(view);
        return subViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SubViewHolder subViewHolder, int i) {

        subViewHolder.tv1Title.setText(datalist.get(i).getName());
        subViewHolder.tv2Price.setText(datalist.get(i).getProductNums());
        Glide.with(context).load(datalist.get(i).getIcon()).into(subViewHolder.ivImageView);

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class SubViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_ImageView)
        ImageView ivImageView;
        @BindView(R.id.tv1_title)
        TextView tv1Title;
        @BindView(R.id.tv2_price)
        TextView tv2Price;
        public SubViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
