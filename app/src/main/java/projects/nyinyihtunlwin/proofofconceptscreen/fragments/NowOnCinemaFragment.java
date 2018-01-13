package projects.nyinyihtunlwin.proofofconceptscreen.fragments;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import projects.nyinyihtunlwin.proofofconceptscreen.POC_Screen_App;
import projects.nyinyihtunlwin.proofofconceptscreen.R;
import projects.nyinyihtunlwin.proofofconceptscreen.activities.MovieDetailsActivity;
import projects.nyinyihtunlwin.proofofconceptscreen.adapters.MovieAdapter;
import projects.nyinyihtunlwin.proofofconceptscreen.components.EmptyViewPod;
import projects.nyinyihtunlwin.proofofconceptscreen.components.SmartRecyclerView;
import projects.nyinyihtunlwin.proofofconceptscreen.components.SmartVerticalScrollListener;
import projects.nyinyihtunlwin.proofofconceptscreen.data.models.MovieModel;
import projects.nyinyihtunlwin.proofofconceptscreen.data.vo.MovieVO;
import projects.nyinyihtunlwin.proofofconceptscreen.events.RestApiEvents;
import projects.nyinyihtunlwin.proofofconceptscreen.mvp.presenters.MovieListPresenter;
import projects.nyinyihtunlwin.proofofconceptscreen.mvp.views.MovieListView;
import projects.nyinyihtunlwin.proofofconceptscreen.persistence.MovieContract;


public class NowOnCinemaFragment extends BaseFragment implements LoaderManager.LoaderCallbacks<Cursor>, MovieListView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final int MOVIE_LOADER_ID = 1001;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.rv_now_on_cinema)
    SmartRecyclerView rvNowOnCinema;

    private MovieAdapter adapter;

    @BindView(R.id.vp_empty_movie)
    EmptyViewPod vpEmptyMovie;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @Inject
    MovieListPresenter mPresenter;

    @Inject
    MovieModel mMovieModel;

    public NowOnCinemaFragment() {
        // Required empty public constructor
    }

    public static NowOnCinemaFragment newInstance(String param1, String param2) {
        NowOnCinemaFragment fragment = new NowOnCinemaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        POC_Screen_App app = (POC_Screen_App) getActivity().getApplicationContext();
        app.getAppComponent().inject(this);

        mPresenter.onCreate(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_now_on_cinema, container, false);
        ButterKnife.bind(this, view);
        rvNowOnCinema.setHasFixedSize(true);
        adapter = new MovieAdapter(getContext(), mPresenter);
        rvNowOnCinema.setEmptyView(vpEmptyMovie);
        rvNowOnCinema.setAdapter(adapter);
        rvNowOnCinema.setLayoutManager(new LinearLayoutManager(container.getContext()));


        mPresenter.onCreateView();


        SmartVerticalScrollListener scrollListener = new SmartVerticalScrollListener(new SmartVerticalScrollListener.OnSmartVerticalScrollListener() {
            @Override
            public void onListEndReached() {
                mPresenter.onListEndReached(getActivity().getApplicationContext());
            }
        });

        rvNowOnCinema.addOnScrollListener(scrollListener);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.onForceRefresh(getActivity().getApplicationContext());
            }
        });

        getActivity().getSupportLoaderManager().initLoader(MOVIE_LOADER_ID, null, this);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMovieDataLoaded(RestApiEvents.MoviesDataLoadedEvent event) {
     /*   adapter.appendNewData(event.getLoadedMovies());
        swipeRefreshLayout.setRefreshing(false);*/
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onErrorInvokingAPI(RestApiEvents.ErrorInvokingAPIEvent event) {
        Snackbar.make(rvNowOnCinema, event.getErrorMsg(), Snackbar.LENGTH_INDEFINITE).show();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getActivity(),
                MovieContract.MovieEntry.CONTENT_URI,
                null,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mPresenter.onMoviesDataLoaded(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    @Override
    public void displayMoviesList(List<MovieVO> moviesList) {
        adapter.setNewData(moviesList);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showLoding() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void navigateToMovieetails(MovieVO movieVO) {
        Intent intent = MovieDetailsActivity.newIntent(getActivity().getApplicationContext());
        startActivity(intent);
    }

    @Nullable
    @Override
    public Context getContext() {
        return getActivity().getApplicationContext();
    }

}
