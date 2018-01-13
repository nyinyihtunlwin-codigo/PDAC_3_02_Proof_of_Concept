package projects.nyinyihtunlwin.proofofconceptscreen.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import projects.nyinyihtunlwin.proofofconceptscreen.POC_Screen_App;
import projects.nyinyihtunlwin.proofofconceptscreen.data.models.MovieModel;
import projects.nyinyihtunlwin.proofofconceptscreen.mvp.presenters.MovieListPresenter;
import projects.nyinyihtunlwin.proofofconceptscreen.network.MovieDataAgent;
import projects.nyinyihtunlwin.proofofconceptscreen.network.MovieDataAgentImpl;
import projects.nyinyihtunlwin.proofofconceptscreen.persistence.MovieProvider;
import projects.nyinyihtunlwin.proofofconceptscreen.utils.ConfigUtils;

/**
 * Created by Dell on 1/11/2018.
 */

@Module
public class AppModule {

    POC_Screen_App mApp;

    public AppModule(POC_Screen_App app) {
        this.mApp = app;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return mApp.getApplicationContext();
    }

    @Provides
    @Singleton
    public MovieDataAgent provideMMNewsDataAgent() {
        return new MovieDataAgentImpl();
    }

    @Provides
    @Singleton
    public MovieModel provideMovieModel(Context context) {
        return new MovieModel(context);
    }

    @Provides
    @Singleton
    public MovieListPresenter provideMovieListPresenter() {
        return new MovieListPresenter();
    }

    @Provides
    @Singleton
    public ConfigUtils provideConfigUtils(Context context) {
        return new ConfigUtils(context);
    }
}
