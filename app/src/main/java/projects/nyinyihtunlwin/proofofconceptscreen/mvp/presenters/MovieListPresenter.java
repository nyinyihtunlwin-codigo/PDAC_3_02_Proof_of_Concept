package projects.nyinyihtunlwin.proofofconceptscreen.mvp.presenters;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import projects.nyinyihtunlwin.proofofconceptscreen.POC_Screen_App;
import projects.nyinyihtunlwin.proofofconceptscreen.data.models.MovieModel;
import projects.nyinyihtunlwin.proofofconceptscreen.data.vo.MovieVO;
import projects.nyinyihtunlwin.proofofconceptscreen.deligates.MovieItemDeligate;
import projects.nyinyihtunlwin.proofofconceptscreen.mvp.views.MovieListView;

/**
 * Created by Dell on 1/11/2018.
 */

public class MovieListPresenter extends BasePresenter<MovieListView> implements MovieItemDeligate{

    @Inject
    MovieModel mMovieModel;

    public MovieListPresenter(){}

    @Override
    public void onAttach(MovieListView mView) {
        super.onAttach(mView);
        POC_Screen_App app = (POC_Screen_App) mView.getContext();
        app.getAppComponent().inject(this);
    }


    @Override
    public void onStart() {
        List<MovieVO> movieList = mMovieModel.getMovies();
        if (!movieList.isEmpty()) {
            mView.displayMoviesList(movieList);
        } else {
            mView.showLoding();
        }
    }

    @Override
    public void onStop() {

    }

    public void onListEndReached(Context context) {
        mMovieModel.loadMoreMovies(context);
    }

    public void onForceRefresh(Context context) {
        mMovieModel.forceRefreshMovies(context);
    }

    public void onMoviesDataLoaded(Cursor data) {
        if (data != null && data.moveToFirst()) {
            List<MovieVO> movieList = new ArrayList<>();
            do {
                MovieVO newsVO = MovieVO.parseFromCursor(data);
                movieList.add(newsVO);
            } while (data.moveToNext());
            mView.displayMoviesList(movieList);
        }
    }

    @Override
    public void onItemTap(MovieVO movieVO) {
        mView.navigateToMovieetails(movieVO);
    }

    @Override
    public void onImageTap() {

    }

    @Override
    public void onMovieOverviewTap() {

    }
}
