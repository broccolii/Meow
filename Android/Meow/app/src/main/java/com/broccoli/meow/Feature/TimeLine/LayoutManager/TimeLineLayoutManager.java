package com.broccoli.meow.Feature.TimeLine.LayoutManager;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;

import com.broccoli.meow.Feature.TimeLine.Model.TimeLineEntity;

import java.util.ArrayList;

/**
 * Created by Broccoli on 2017/10/17.
 */

public class TimeLineLayoutManager extends LinearLayoutManager {

    private ArrayList<TimeLineEntity> mData;

    public TimeLineLayoutManager(Context context) {
        super(context);
    }

    public void setData(ArrayList<TimeLineEntity> data) {
        mData = data;
    }

    @Override
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
//        System.out.println("总共有几行" + getItemCount());

        if (getItemCount() == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
//        for (int i = 0; i < getItemCount(); ++i) {
//            System.out.println("计算高度: " + i + "行");
//            View v = recycler.getViewForPosition(i);
//            if (v != null) {
//                setMeasuredDimension(100, i * 20);
//            }
//        }

        for (int i = 0; i < getItemCount(); i++) {
            System.out.println("屏幕的高度是: " +  View.MeasureSpec.getSize(widthSpec));
            setMeasuredDimension(View.MeasureSpec.getSize(widthSpec), 80 * i);
        }
    }
}

