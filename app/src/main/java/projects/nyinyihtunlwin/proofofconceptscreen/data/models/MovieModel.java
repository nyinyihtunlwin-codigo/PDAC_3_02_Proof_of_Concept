package projects.nyinyihtunlwin.proofofconceptscreen.data.models;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import projects.nyinyihtunlwin.proofofconceptscreen.POC_Screen_App;
import projects.nyinyihtunlwin.proofofconceptscreen.data.vo.MovieVO;
import projects.nyinyihtunlwin.proofofconceptscreen.events.RestApiEvents;
import projects.nyinyihtunlwin.proofofconceptscreen.network.MovieDataAgentImpl;
import projects.nyinyihtunlwin.proofofconceptscreen.persistence.MovieContract;
import projects.nyinyihtunlwin.proofofconceptscreen.utils.AppConstants;

/**
 * Created by Dell on 12/6/2017.
 */

public class MovieModel {

    private static MovieModel objectInstance;
    private int moviePageIndex = 1;

    private List<MovieVO> mMovies;

    private MovieModel() {
        EventBus.getDefault().register(this);
        mMovies = new ArrayList<>();
    }

    public static MovieModel getInstance() {
        if (objectInstance == null) {
            objectInstance = new MovieModel();
        }
        return objectInstance;
    }

    public void startLoadingPopularMovies(Context context) {
        MovieDataAgentImpl.getObjectInstance().loadPopularMovies(moviePageIndex, AppConstants.ACCESS_TOKEN, context);
    }

    public void loadMoreMovies(Context context) {
        MovieDataAgentImpl.getObjectInstance().loadPopularMovies(moviePageIndex, AppConstants.ACCESS_TOKEN, context);
    }


    public void forceRefreshMovies(Context context) {
        mMovies = new ArrayList<>();
        moviePageIndex = 1;
        startLoadingPopularMovies(context);
    }

    public List<MovieVO> getMovies() {
        return mMovies;
    }

    @Subscribe
    public void onMoviesDataLoaded(RestApiEvents.MoviesDataLoadedEvent event) {
        mMovies.addAll(event.getLoadedMovies());
        moviePageIndex = event.getLoadedPageIndex() + 1;

        //TODO Logic to save the data in Persistence Layer
        ContentValues[] movieCVS = new ContentValues[event.getLoadedMovies().size()];
        for (int index = 0; index < movieCVS.length; index++) {
            movieCVS[index] = event.getLoadedMovies().get(index).parseToContentValues();
        }

        int insertedRowCount = event.getContext().getContentResolver().bulkInsert(MovieContract.MovieEntry.CONTENT_URI, movieCVS);
        Log.d(POC_Screen_App.LOG_TAG, "Inserted row : " + insertedRowCount);
    }
}
