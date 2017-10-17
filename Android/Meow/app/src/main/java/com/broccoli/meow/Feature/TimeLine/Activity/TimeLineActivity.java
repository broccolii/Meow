package com.broccoli.meow.Feature.TimeLine.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.broccoli.meow.Feature.TimeLine.Adapter.TimeLineRecyclerViewAdapter;
import com.broccoli.meow.Feature.TimeLine.Model.TimeLineEntity;
import com.broccoli.meow.Feature.TimeLine.Service.TimeLineAPI;
import com.broccoli.meow.R;
import java.util.ArrayList;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class TimeLineActivity extends AppCompatActivity {

    private Integer mPageNum = 0;

    private RecyclerView mRecyclerView;

    private TimeLineRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new TimeLineRecyclerViewAdapter(new ArrayList<TimeLineEntity>());

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));//这里用线性显示 类似于listview
        mRecyclerView.setAdapter(mAdapter);
        searchData();
    }

    private ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        String temp = " item";
        for(int i = 0; i < 200; i++) {
            data.add(i + temp);
        }

        return data;
    }

    void searchData() {
        Observer<ArrayList<TimeLineEntity>> observer = new Observer<ArrayList<TimeLineEntity>>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ArrayList<TimeLineEntity> value) {
                String msg = "onNext: value.size = " + value.size();
                Log.v("", msg);

                mAdapter.updateData(value);
            }

            @Override
            public void onError(Throwable e) {
                Log.v("", "onError" + e);
                Toast.makeText(TimeLineActivity.this ,"网络请求错误", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onComplete() {
                mPageNum += 1;
            }
        };

        TimeLineAPI.search(observer, "cat", 20, mPageNum);
    }
}


