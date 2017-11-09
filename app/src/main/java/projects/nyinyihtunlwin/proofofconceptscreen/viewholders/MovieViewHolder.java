package projects.nyinyihtunlwin.proofofconceptscreen.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import projects.nyinyihtunlwin.proofofconceptscreen.R;

/**
 * Created by Dell on 11/7/2017.
 */

public class MovieViewHolder extends RecyclerView.ViewHolder {

    public TextView tvRating;

    public MovieViewHolder(View itemView) {
        super(itemView);
        tvRating = itemView.findViewById(R.id.tv_rate);
    }
}

