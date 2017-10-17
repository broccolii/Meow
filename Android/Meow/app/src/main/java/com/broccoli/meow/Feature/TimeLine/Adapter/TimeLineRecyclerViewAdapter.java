package com.broccoli.meow.Feature.TimeLine.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.broccoli.meow.Feature.TimeLine.Activity.TimeLineActivity;
import com.broccoli.meow.Feature.TimeLine.Model.TimeLineEntity;
import com.broccoli.meow.R;

import java.util.ArrayList;

/**
 * Created by Broccoli on 2017/10/17.
 */

public class TimeLineRecyclerViewAdapter extends RecyclerView.Adapter<TimeLineRecyclerViewAdapter.NormalTextViewHolder> {

    private ArrayList<TimeLineEntity> mData;

    public TimeLineRecyclerViewAdapter(ArrayList<TimeLineEntity> mData) {
        this.mData = mData;
    }

    public void updateData(ArrayList<TimeLineEntity> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_line_item,parent, false);

        NormalTextViewHolder normalTextViewHolder = new NormalTextViewHolder(v);

        return normalTextViewHolder;
    }

    @Override
    public void onBindViewHolder(NormalTextViewHolder holder, int position) {
        holder.mTv.setText(mData.get(position).getGifURL());
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public class NormalTextViewHolder extends RecyclerView.ViewHolder {

        TextView mTv;

        public NormalTextViewHolder(View itemView) {
            super(itemView);
            mTv = (TextView) itemView.findViewById(R.id.item_tv);
        }
    }
}