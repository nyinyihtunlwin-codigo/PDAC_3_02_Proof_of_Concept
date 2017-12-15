package projects.nyinyihtunlwin.proofofconceptscreen.adapters;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import projects.nyinyihtunlwin.proofofconceptscreen.R;
import projects.nyinyihtunlwin.proofofconceptscreen.data.vo.MovieVO;
import projects.nyinyihtunlwin.proofofconceptscreen.deligates.MovieItemDeligate;
import projects.nyinyihtunlwin.proofofconceptscreen.viewholders.MovieViewHolder;

/**
 * Created by Dell on 11/7/2017.
 */

public class MovieAdapter extends BaseRecyclerAdapter<MovieViewHolder, MovieVO> {

    private MovieItemDeligate movieItemDeligate;

    public MovieAdapter(Context context, MovieItemDeligate movieItemDeligate) {
        super(context);
        this.movieItemDeligate = movieItemDeligate;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.view_item_movie, parent, false);
        return new MovieViewHolder(view,movieItemDeligate);
    }
}
