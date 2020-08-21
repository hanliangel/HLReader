package com.yyhd.base;

import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ObjectUtils;

import java.util.List;

/**
 * Created by hanli
 * date 2019-04-29.
 * ps: RecycleView的base基类，辅助做一些操作
 */
public abstract class BaseRecycleAdapter<T , VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {


    /**
     * 数据源
     */
    protected List<T> mList;

    @Override
    public int getItemCount() {
        if(mList != null){
            return mList.size();
        }
        return 0;
    }

    /**
     * 返回所有数据的集合
     * @return
     */
    public List<T> getData() {
        return mList;
    }


    /**
     * 设置数据源
     * @param list
     */
    public void setData(List<T> list) {
        if (list == null) {
            clear();
            return;
        }
        mList = list;
        notifyDataSetChanged();
    }

    /**
     * 添加一批数据到开头
     * @param list
     */
    public void appendToTop(List<T> list) {
        if (list == null) {
            return;
        }
        mList.addAll(0, list);
        notifyItemRangeInserted(0, list.size());
    }

    /**
     * 添加一条数据到开头
     * @param t
     */
    public void appendToTop(T t) {
        if (t == null) {
            return;
        }
        mList.add(0, t);
        notifyDataSetChanged();
    }

    /**
     * 添加一条数据到最后
     * @param t
     */
    public void append(T t) {
        if (t == null) {
            return;
        }
        mList.add(t);
        notifyDataSetChanged();
    }

    /**
     * 添加一批数据到最后
     * @param list
     */
    public void appendData(List<T> list) {
        if (list == null) {
            return;
        }
        mList.addAll(list);
        notifyDataSetChanged();
    }

    /**
     * 添加数据到列表当中，并且更新
     * @param position
     */
    public void removeToList(int position) {
        removeToList(position , true);
    }

    /**
     * 添加数据到列表当中
     * @param position
     * @param notifyDataSetChanged 是否更新
     */
    public void removeToList(int position , boolean notifyDataSetChanged){
        if (mList.size() <= position) {
            return;
        }
        mList.remove(position);
        if(notifyDataSetChanged){
            notifyItemRemoved(position);
            notifyItemRangeChanged(position , mList.size() - position);
        }
    }

    /**
     * 获得对应的数据实体bean
     * @param position
     * @return
     */
    public T getItemBean(int position){
        if (mList != null && !mList.isEmpty() && position < mList.size() && position > -1) {
            return mList.get(position);
        }
        return null;
    }

    /**
     * 清除数据源，并更新列表
     */
    public void clear() {
        if(mList != null){
            mList.clear();
            notifyDataSetChanged();
        }
    }

    /**
     * 添加下一批数据到最后
     * @param list
     */
    public void appendNextData(List<T> list) {
        if (ObjectUtils.isEmpty(list)) {
            return;
        }
        mList.addAll(list);

        notifyItemRangeChanged(mList.size() - list.size(), list.size());
    }

    //item 点击事件
    public interface OnItemClick {
        void onItemClickListener(int position);
    }

    protected OnItemClick onItemClick;

    public void setOnItemClickListener(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
