package com.broccoli.meow.Feature.TimeLine.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.broccoli.meow.Feature.TimeLine.Service.TimeLineAPI;
import com.broccoli.meow.R;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;


public class TimeLineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);

        searchData();
    }

    void searchData() {
        Subscriber subscriber = new Subscriber() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };

        TimeLineAPI.search(subscriber, "cat", 20, 0);
    }
}
