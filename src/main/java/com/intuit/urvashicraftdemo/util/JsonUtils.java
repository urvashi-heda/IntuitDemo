package com.intuit.urvashicraftdemo.util;

import com.unboundid.util.json.JSONBuffer;
import com.unboundid.util.json.JSONException;
import com.unboundid.util.json.JSONObject;

public class JsonUtils {

    private static final String MESSAGE_STRING = "message";

    public static String createJsonResponse (String msg) {
        JSONObject response = new JSONObject();
        try {
            JSONBuffer buffer = new JSONBuffer();
            buffer.beginObject();
            buffer.appendString(MESSAGE_STRING, msg);
            buffer.endObject();
            response = buffer.toJSONObject();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return response.toString();
    }
}
