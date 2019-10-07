package com.intuit.demo.util;

import com.unboundid.util.json.JSONBuffer;
import com.unboundid.util.json.JSONException;
import com.unboundid.util.json.JSONObject;

/**
 * Converts a string to JSON format.
 * @author Urvashi Heda
 */
public class JsonUtils {
    private static final String MESSAGE_STRING = "message";

    /**
     * Converts a string to JSON format.
     * @param message the message to be converted
     * @return the JSON string
     */
    public static String createJsonResponse (String message) {
        JSONObject response = new JSONObject();
        try {
            JSONBuffer buffer = new JSONBuffer();
            buffer.beginObject();
            buffer.appendString(MESSAGE_STRING, message);
            buffer.endObject();
            response = buffer.toJSONObject();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return response.toString();
    }
}
