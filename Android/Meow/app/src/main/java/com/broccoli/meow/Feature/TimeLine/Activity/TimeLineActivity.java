package com.broccoli.meow.Feature.TimeLine.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.broccoli.meow.Feature.TimeLine.Adapter.DividerItemDecoration;
import com.broccoli.meow.Feature.TimeLine.Adapter.TimeLineRecyclerViewAdapter;
import com.broccoli.meow.Feature.TimeLine.LayoutManager.TimeLineLayoutManager;
import com.broccoli.meow.Feature.TimeLine.Model.TimeLineEntity;
import com.broccoli.meow.Feature.TimeLine.Service.TimeLineAPI;
import com.broccoli.meow.R;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class TimeLineActivity extends AppCompatActivity {

    private Integer mPageNum = 0;

    private RecyclerView mRecyclerView;

    private TimeLineRecyclerViewAdapter mAdapter;
    private TimeLineLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fresco.initialize(this);

        setContentView(R.layout.activity_time_line);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mLayoutManager = new TimeLineLayoutManager(this);
        mAdapter = new TimeLineRecyclerViewAdapter(new ArrayList<TimeLineEntity>(), this);

        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        SpacesItemDecoration decoration=new SpacesItemDecoration(20);
        mRecyclerView.addItemDecoration(decoration);



        searchData();
    }

    void searchData() {
        Observer<ArrayList<TimeLineEntity>> observer = new Observer<ArrayList<TimeLineEntity>>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ArrayList<TimeLineEntity> value) {
                String msg = "onNext: value.size = " + value.size();
                System.out.println(msg);

                mLayoutManager.setData(value);
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


