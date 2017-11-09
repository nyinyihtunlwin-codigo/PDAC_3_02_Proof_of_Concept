package projects.nyinyihtunlwin.proofofconceptscreen.adapters;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import projects.nyinyihtunlwin.proofofconceptscreen.R;
import projects.nyinyihtunlwin.proofofconceptscreen.viewholders.MovieViewHolder;

/**
 * Created by Dell on 11/7/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private Context context;

    public MovieAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.tvRating.setTypeface(Typeface.createFromAsset(context.getAssets(), "MTCORSVA.TTF"));
    }

    @Override
    public int getItemCount() {
        return 16;
    }
}
