package com.tyh.tianyahui201912.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.GridView;

import com.google.gson.Gson;
import com.tyh.tianyahui201912.R;
import com.tyh.tianyahui201912.data.bean.MainBean;
import com.tyh.tianyahui201912.di.centerdaata.Conterceon;
import com.tyh.tianyahui201912.di.presonter.MainPresonter;
import com.tyh.tianyahui201912.ui.adapter.GridAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements Conterceon.IView {


    private MainPresonter mainPresonter;
    private RecyclerView recyclerView;
    private ArrayList<MainBean.SellerBean> datalist = new ArrayList<MainBean.SellerBean>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rv_View);

        mainPresonter = new MainPresonter();
        mainPresonter.bindingData(this);
        mainPresonter.conModelData();

    }


    @Override
    public void showData(final String requestData) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                MainBean mainBean = gson.fromJson(requestData, MainBean.class);
                List<MainBean.SellerBean> list = (List<MainBean.SellerBean>) mainBean.getData();
                datalist.addAll(list);
                GridAdapter gridAdapter = new GridAdapter();
                gridAdapter.setData(MainActivity.this, datalist);

                recyclerView.setAdapter(gridAdapter);

                //StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 3);
                recyclerView.setLayoutManager(gridLayoutManager);

                gridAdapter.notifyDataSetChanged();


            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresonter.unbundelData(this);
    }
}
