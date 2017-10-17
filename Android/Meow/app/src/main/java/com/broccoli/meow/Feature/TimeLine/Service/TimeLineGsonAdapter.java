package com.broccoli.meow.Feature.TimeLine.Service;

import android.util.Log;

import com.broccoli.meow.Feature.TimeLine.Model.TimeLineEntity;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Broccoli on 2017/8/8.
 */

public class TimeLineGsonAdapter implements JsonDeserializer<ArrayList<TimeLineEntity>> {
    @Override
    public ArrayList<TimeLineEntity> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Log.v("", "进入到解析步骤");

        ArrayList<TimeLineEntity> list = new ArrayList<TimeLineEntity>();

        JsonArray array = json.getAsJsonObject().getAsJsonArray("data");
        for (JsonElement itemJSON : array) {
            JsonObject jsonObject = itemJSON.getAsJsonObject();
             JsonObject images = jsonObject.get("images").getAsJsonObject();
            JsonObject original = images.get("original").getAsJsonObject();

            Gson gson = new Gson();
            TimeLineEntity entity = gson.fromJson(original,TimeLineEntity.class);
            list.add(entity);
        }

        return list;
    }
}
