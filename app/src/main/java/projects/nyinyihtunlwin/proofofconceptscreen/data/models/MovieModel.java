package projects.nyinyihtunlwin.proofofconceptscreen.data.models;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import projects.nyinyihtunlwin.proofofconceptscreen.data.vo.MovieVO;
import projects.nyinyihtunlwin.proofofconceptscreen.events.RestApiEvents;
import projects.nyinyihtunlwin.proofofconceptscreen.network.MovieDataAgentImpl;
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

    public void startLoadingPopularMovies() {
        MovieDataAgentImpl.getObjectInstance().loadPopularMovies(moviePageIndex, AppConstants.ACCESS_TOKEN);
    }

    public void loadMoreMovies() {
        MovieDataAgentImpl.getObjectInstance().loadPopularMovies(moviePageIndex, AppConstants.ACCESS_TOKEN);
    }


    public void forceRefreshMovies() {
        mMovies=new ArrayList<>();
        moviePageIndex = 1;
        startLoadingPopularMovies();
    }

    public List<MovieVO> getMovies() {
        return mMovies;
    }

    @Subscribe
    public void onMoviesDataLoaded(RestApiEvents.MoviesDataLoadedEvent event) {
        mMovies.addAll(event.getLoadedMovies());
        moviePageIndex = event.getLoadedPageIndex() + 1;
    }
}
