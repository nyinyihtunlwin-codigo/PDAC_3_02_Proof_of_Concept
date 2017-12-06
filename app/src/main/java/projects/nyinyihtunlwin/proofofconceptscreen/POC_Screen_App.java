package projects.nyinyihtunlwin.proofofconceptscreen;

import android.app.Application;

import projects.nyinyihtunlwin.proofofconceptscreen.data.models.MovieModel;

/**
 * Created by Dell on 11/7/2017.
 */

public class POC_Screen_App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MovieModel.getInstance().startLoadingPopularMovies();
    }
}
