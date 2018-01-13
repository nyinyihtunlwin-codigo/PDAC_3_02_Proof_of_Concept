package projects.nyinyihtunlwin.proofofconceptscreen.mvp.views;

import android.content.Context;

import java.util.List;

import projects.nyinyihtunlwin.proofofconceptscreen.data.vo.MovieVO;

/**
 * Created by Dell on 1/11/2018.
 */

public interface MovieListView {

    void displayMoviesList(List<MovieVO> moviesList);

    void showLoding();

    void navigateToMovieetails(MovieVO movieVO);

    Context getContext();


}
