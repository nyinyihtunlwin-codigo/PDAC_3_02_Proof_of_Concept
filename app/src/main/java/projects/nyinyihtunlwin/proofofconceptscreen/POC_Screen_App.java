package projects.nyinyihtunlwin.proofofconceptscreen;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

import projects.nyinyihtunlwin.proofofconceptscreen.dagger.AppComponent;
import projects.nyinyihtunlwin.proofofconceptscreen.dagger.AppModule;
import projects.nyinyihtunlwin.proofofconceptscreen.dagger.DaggerAppComponent;
import projects.nyinyihtunlwin.proofofconceptscreen.data.models.MovieModel;
import projects.nyinyihtunlwin.proofofconceptscreen.utils.ConfigUtils;

/**
 * Created by Dell on 11/7/2017.
 */

public class POC_Screen_App extends Application {
    public static final String LOG_TAG = "Movie";

    private AppComponent mAppComponent;

    @Inject
    Context mContext;

    @Inject
    MovieModel mMovieModel;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = initDagger();
        mAppComponent.inject(this);
        mMovieModel.startLoadingPopularMovies(getApplicationContext());

        Log.e(LOG_TAG, mContext + "");
    }

    public AppComponent initDagger() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
