package projects.nyinyihtunlwin.proofofconceptscreen.deligates;

import projects.nyinyihtunlwin.proofofconceptscreen.data.vo.MovieVO;

/**
 * Created by Dell on 12/15/2017.
 */

public interface MovieItemDeligate {
    void onItemTap(MovieVO movieVO);

    void onImageTap();

    void onMovieOverviewTap();
}
