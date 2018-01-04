package projects.nyinyihtunlwin.proofofconceptscreen;

import android.app.Application;

import projects.nyinyihtunlwin.proofofconceptscreen.data.models.MovieModel;
import projects.nyinyihtunlwin.proofofconceptscreen.utils.ConfigUtils;

/**
 * Created by Dell on 11/7/2017.
 */

public class POC_Screen_App extends Application {
    public static final String LOG_TAG = "Movie";

    @Override
    public void onCreate() {
        super.onCreate();
        ConfigUtils.initConfigUtils(getApplicationContext());
    }
}
