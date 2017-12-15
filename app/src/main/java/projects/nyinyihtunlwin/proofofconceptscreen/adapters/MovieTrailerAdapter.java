package projects.nyinyihtunlwin.proofofconceptscreen.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import projects.nyinyihtunlwin.proofofconceptscreen.R;
import projects.nyinyihtunlwin.proofofconceptscreen.data.vo.MovieVO;
import projects.nyinyihtunlwin.proofofconceptscreen.viewholders.MovieTrailerViewHolder;

/**
 * Created by Dell on 12/15/2017.
 */

public class MovieTrailerAdapter extends BaseRecyclerAdapter<MovieTrailerViewHolder, MovieVO> {
    public MovieTrailerAdapter(Context context) {
        super(context);
    }

    @Override
    public MovieTrailerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.view_item_movie_trailer, parent, false);
        return new MovieTrailerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieTrailerViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
