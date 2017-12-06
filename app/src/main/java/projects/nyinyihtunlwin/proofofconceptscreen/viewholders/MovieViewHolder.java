package projects.nyinyihtunlwin.proofofconceptscreen.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import projects.nyinyihtunlwin.proofofconceptscreen.R;
import projects.nyinyihtunlwin.proofofconceptscreen.data.vo.MovieVO;

/**
 * Created by Dell on 11/7/2017.
 */

public class MovieViewHolder extends BaseViewHolder<MovieVO> {


    public MovieViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void setData(MovieVO mData) {

    }

    @Override
    public void onClick(View view) {

    }
}

