package com.broccoli.meow.Feature.TimeLine.LayoutManager;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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
        View view = recycler.getViewForPosition(0);
        if(view != null){
            measureChild(view, widthSpec, heightSpec);
            int measuredWidth = View.MeasureSpec.getSize(widthSpec);
            int measuredHeight = view.getMeasuredHeight();
            setMeasuredDimension(measuredWidth, measuredHeight);
        }
    }
}
