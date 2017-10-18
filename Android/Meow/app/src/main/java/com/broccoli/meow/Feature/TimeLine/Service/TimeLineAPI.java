package com.broccoli.meow.Feature.TimeLine.Service;

import com.broccoli.meow.Feature.TimeLine.Model.TimeLineEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by Broccoli on 2017/8/7.
 */

interface TimeLineService {
    @GET("v1/gifs/search")
    Observable<ArrayList<TimeLineEntity>> search(
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

    public static void search(Observer<ArrayList<TimeLineEntity>> observer, String query, int limit, int offset) {

        Type type = new TypeToken<ArrayList<TimeLineEntity>>() {
        }.getType();
        Gson gson = new GsonBuilder().registerTypeAdapter(type, new TimeLineGsonAdapter()).create();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        TimeLineService timeLineService = retrofit.create(TimeLineService.class);

        timeLineService.search(query, limit, offset, API_KEY, "en", "G")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
}


