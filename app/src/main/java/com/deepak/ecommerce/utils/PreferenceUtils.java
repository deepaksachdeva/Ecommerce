package com.deepak.ecommerce.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.deepak.ecommerce.R;

/**
 * Class to manage Preference utility methods
 * Created by mohit.sharma on 07-07-2016.
 *
 * @version 2.0
 */
public class PreferenceUtils {

    /**
     * Private Constructor to hide the implicit public one
     */
    private PreferenceUtils() {
        // No initialization required
    }

    /**
     * Set Application preference for type string
     *
     * @param mContext calling application context
     * @param key      preference key
     * @param value    string preference value
     * @return success or failure flag
     */
    public static boolean setAppPreference(Context mContext, String key, String value) {
        SharedPreferences prefs = mContext.getSharedPreferences(mContext.getString(R.string.app_name), 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    /**
     * Set Application preference for type int
     *
     * @param mContext calling application context
     * @param key      preference key
     * @param value    int preference value
     * @return success or failure flag
     */
    public static boolean setAppPreference(Context mContext, String key, int value) {
        SharedPreferences prefs = mContext.getSharedPreferences(mContext.getString(R.string.app_name), 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    /**
     * Set Application preference for type boolean
     *
     * @param mContext calling application context
     * @param key      preference key
     * @param value    boolean preference value
     * @return success or failure flag
     */
    public static boolean setAppPreference(Context mContext, String key, boolean value) {
        SharedPreferences prefs = mContext.getSharedPreferences(mContext.getString(R.string.app_name), 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    /**
     * Get Application preference of type string
     *
     * @param mContext calling application context
     * @param key      preference key
     * @param defValue default preference value
     * @return preference value as string
     */
    public static String getAppStringPreference(Context mContext, String key, String defValue) {
        SharedPreferences prefs = mContext.getSharedPreferences(mContext.getString(R.string.app_name), 0);
        return prefs.getString(key, defValue);
    }

    /**
     * Get Application preference of type integer
     *
     * @param mContext calling application context
     * @param key      preference key
     * @param defValue default preference value
     * @return preference value as int
     */
    public static int getAppIntPreference(Context mContext, String key, int defValue) {
        SharedPreferences prefs = mContext.getSharedPreferences(mContext.getString(R.string.app_name), 0);
        return prefs.getInt(key, defValue);
    }

    /**
     * Get Application preference of type long
     *
     * @param mContext calling application context
     * @param key      preference key
     * @param defValue default preference value
     * @return preference value as long
     */
    public static long getAppLongPreference(Context mContext, String key, long defValue) {
        SharedPreferences prefs = mContext.getSharedPreferences(mContext.getString(R.string.app_name), 0);
        return prefs.getLong(key, defValue);
    }

    /**
     * Get Application preference of type boolean
     *
     * @param mContext calling application context
     * @param key      preference key
     * @param defValue default preference value
     * @return preference value as boolean
     */
    public static boolean getAppBooleanPreference(Context mContext, String key, boolean defValue) {
        SharedPreferences prefs = mContext.getSharedPreferences(mContext.getString(R.string.app_name), 0);
        return prefs.getBoolean(key, defValue);
    }

    /**
     * Get Application preference of type float
     *
     * @param mContext calling application context
     * @param key      preference key
     * @param defValue default preference value
     * @return preference value as float
     */
    public static float getAppFloatPreference(Context mContext, String key, float defValue) {
        SharedPreferences prefs = mContext.getSharedPreferences(mContext.getString(R.string.app_name), 0);
        return prefs.getFloat(key, defValue);
    }

    /**
     * Removes a particular preference from the App
     *
     * @param mContext calling application context
     * @param key      preference key
     * @return success or failure flag
     */
    public static boolean removeAppPreference(Context mContext, String key) {
        SharedPreferences prefs = mContext.getSharedPreferences(mContext.getString(R.string.app_name), 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.remove(key);
        return editor.commit();
    }

    /**
     * Removes all the preferences from the App
     *
     * @param mContext calling application context
     * @return success or failure flag
     */
    public static boolean clearAppPreference(Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences(mContext.getString(R.string.app_name), 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        return editor.commit();
    }
}
