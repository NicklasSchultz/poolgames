package com.developergmail.schultz.nicklas.poolgames;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Created by nicklasschultz on 06/09/16.
 */
public class PreferencesManager {

    private static final String PREF_NAME = "com.developergmail.schultz.nicklas.poolgames.PREF_NAME";
    public static final String PLAYERS = "com.example.app.KEY_VALUE";

    private static PreferencesManager sInstance;
    private final SharedPreferences mPref;

    private PreferencesManager(Context context) {
        mPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized void initializeInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PreferencesManager(context);
        }
    }

    public static synchronized PreferencesManager getInstance() {
        if (sInstance == null) {
            throw new IllegalStateException(PreferencesManager.class.getSimpleName() +
                    " is not initialized, call initializeInstance(..) method first.");
        }
        return sInstance;
    }

    public void setValue(String key, String value) {
        mPref.edit()
                .putString(key, value)
                .commit();
    }

    public JsonObject getValue(String key) {
        JsonParser jsonParser = new JsonParser();
        String jsonString = mPref.getString(key, "{}");
        Log.d("HEJ", jsonString);
        Object json = jsonParser.parse(jsonString);
        JsonObject obj = (JsonObject) json;
        return obj;
    }

    public void remove(String key) {
        mPref.edit()
                .remove(key)
                .commit();
    }

    public boolean clear() {
        return mPref.edit()
                .clear()
                .commit();
    }
}
