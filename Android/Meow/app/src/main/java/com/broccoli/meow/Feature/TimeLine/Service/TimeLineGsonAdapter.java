package com.broccoli.meow.Feature.TimeLine.Service;

import com.broccoli.meow.Feature.TimeLine.Model.TimeLineEntity;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/**
 * Created by Broccoli on 2017/8/8.
 */

public class TimeLineGsonAdapter implements JsonDeserializer<TimeLineEntity> {
    public TimeLineEntity deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext content) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        System.out.println("进入到解析步骤");
        TimeLineEntity timeLineEntity = new TimeLineEntity();
        return timeLineEntity;
    }
}
