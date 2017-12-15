package projects.nyinyihtunlwin.proofofconceptscreen.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import projects.nyinyihtunlwin.proofofconceptscreen.R;
import projects.nyinyihtunlwin.proofofconceptscreen.adapters.MovieTrailerAdapter;
import projects.nyinyihtunlwin.proofofconceptscreen.components.EmptyViewPod;
import projects.nyinyihtunlwin.proofofconceptscreen.components.SmartHorizontalScrollListener;
import projects.nyinyihtunlwin.proofofconceptscreen.components.SmartRecyclerView;

public class MovieDetailsActivity extends BaseActivity {

    @BindView(R.id.rv_movie_trailers)
    SmartRecyclerView rvMovieTrailers;

    @BindView(R.id.vp_empty_movie)
    EmptyViewPod vpEmptyMovie;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MovieDetailsActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        ButterKnife.bind(this, this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        MovieTrailerAdapter movieTrailerAdapter = new MovieTrailerAdapter(getApplicationContext());
        rvMovieTrailers.setHasFixedSize(true);
        rvMovieTrailers.setEmptyView(vpEmptyMovie);
        rvMovieTrailers.setAdapter(movieTrailerAdapter);
        rvMovieTrailers.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        SmartHorizontalScrollListener scrollListener = new SmartHorizontalScrollListener(new SmartHorizontalScrollListener.OnSmartHorizontalScrollListener() {
            @Override
            public void onListEndReached() {
                Snackbar.make(rvMovieTrailers, "No more trailers available.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        rvMovieTrailers.addOnScrollListener(scrollListener);
    }
}
