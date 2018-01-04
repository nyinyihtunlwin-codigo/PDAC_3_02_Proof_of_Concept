package projects.nyinyihtunlwin.proofofconceptscreen.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Dell on 1/4/2018.
 */

public class ConfigUtils {

    private static final String KEY_PAGE_INDEX = "KEY_PAGE_INDEX";

    private static ConfigUtils sObjInstance;
    private SharedPreferences mSharedPreferences;

    private ConfigUtils(Context context) {
        mSharedPreferences = context.getSharedPreferences("ConfigUtils", Context.MODE_PRIVATE);
    }

    public static void initConfigUtils(Context context) {
        if (sObjInstance == null) {
            sObjInstance = new ConfigUtils(context);
        }
    }

    public static ConfigUtils getObjInstance() {
        return sObjInstance;
    }

    public void savePageIndex(int index) {
        mSharedPreferences.edit().putInt(KEY_PAGE_INDEX, index).apply();
    }

    public int loadPageIndex() {
        return mSharedPreferences.getInt(KEY_PAGE_INDEX, 1);
    }
}
