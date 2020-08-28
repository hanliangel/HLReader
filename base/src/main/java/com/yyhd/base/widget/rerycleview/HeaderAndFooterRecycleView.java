package com.yyhd.base.widget.rerycleview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by hanli
 * date 2019-09-18.
 * ps: 支持header和footer的recycleView
 */
public class HeaderAndFooterRecycleView extends RecyclerView {

    /**
     * 扩展了支持header和footer的adapter
     */
    public HeaderAndFooterRecyclerViewAdapter mAdapter;


    public HeaderAndFooterRecycleView(Context context) {
        super(context);
        init(context);
    }

    public HeaderAndFooterRecycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public HeaderAndFooterRecycleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }


    private void init(Context context){
        mAdapter = new HeaderAndFooterRecyclerViewAdapter();
    }

    @Override
    public void setAdapter(Adapter adapter) {
        mAdapter.setAdapter(adapter);
        super.setAdapter(mAdapter);
    }

    /**
     * 添加头布局
     * @param headerView
     */
    public void addHeader(View headerView){
        mAdapter.addHeaderView(headerView);
    }

    /**
     * 添加底部布局
     * @param footerView
     */
    public void addFooter(View footerView){
        mAdapter.addFooterView(footerView);
    }

    /**
     * 移除header
     * @param headerView
     */
    public void removeHeader(View headerView){
        mAdapter.removeHeaderView(headerView);
    }

    /**
     * 移除footer
     * @param footerView
     */
    public void removeFooter(View footerView){
        mAdapter.removeFooterView(footerView);
    }


    public View getFooter(){
        return mAdapter.getFooterView();
    }


    public View getHeader(){
        return mAdapter.getHeaderView();
    }



}
