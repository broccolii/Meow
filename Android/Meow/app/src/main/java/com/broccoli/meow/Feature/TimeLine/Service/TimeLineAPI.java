package com.broccoli.meow.Feature.TimeLine.Service;

import android.util.Log;

import com.broccoli.meow.Feature.TimeLine.Model.TimeLineEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.reactivestreams.Subscriber;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.Result;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by Broccoli on 2017/8/7.
 */

interface TimeLineSerivce {
    @GET("v1/gifs/search")
    Observable<TimeLineEntity> search(
            @Query("q") String query,
            @Query("limit") int limit,
            @Query("offset") int offset,
            @Query("api_key") String api_key,
            @Query("lang") String lang,
            @Query("rating") String rating
    );
}

public class TimeLineAPI {
    private static final String API_KEY = "9dfbfbb0af284a4a8296e568dfd6f3f7";
    private static final String BASE_URL = "https://api.giphy.com/";

    public static void search(Subscriber subscriber, String query, int limit, int offset) {

        Gson gson = new GsonBuilder().registerTypeAdapter(TimeLineEntity.class, new TimeLineGsonAdapter()).create();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        TimeLineSerivce timeLineService = retrofit.create(TimeLineSerivce.class);

        timeLineService.search(query, limit, offset, API_KEY, "en", "G")
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<TimeLineEntity>() {
                    @Override
                    public void accept(TimeLineEntity s) throws Exception {
//                        System.out.println(s.get);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行
                .subscribe();
    }
}


