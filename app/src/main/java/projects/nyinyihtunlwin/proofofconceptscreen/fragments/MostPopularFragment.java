package projects.nyinyihtunlwin.proofofconceptscreen.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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


public class MostPopularFragment extends BaseFragment implements MovieListView{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.rv_most_popular)
    SmartRecyclerView rvMostPopular;

    MovieAdapter adapter;

    @BindView(R.id.vp_empty_movie)
    EmptyViewPod vpEmptyMovie;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    public MostPopularFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static MostPopularFragment newInstance(String param1, String param2) {
        MostPopularFragment fragment = new MostPopularFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_most_popular, container, false);
        ButterKnife.bind(this, view);
        rvMostPopular.setHasFixedSize(true);
     //   adapter = new MovieAdapter(getContext(), mPresenter);
        rvMostPopular.setEmptyView(vpEmptyMovie);
    //    rvMostPopular.setAdapter(adapter);
        rvMostPopular.setLayoutManager(new LinearLayoutManager(container.getContext()));

        SmartVerticalScrollListener scrollListener = new SmartVerticalScrollListener(new SmartVerticalScrollListener.OnSmartVerticalScrollListener() {
            @Override
            public void onListEndReached() {
            //    MovieModel.getInstance().loadMoreMovies(getContext());
            }
        });

        rvMostPopular.addOnScrollListener(scrollListener);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
            //    MovieModel.getInstance().forceRefreshMovies(getContext());
            }
        });

        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
     /*   List<MovieVO> newsList = MovieModel.getInstance().getMovies();
        if (!newsList.isEmpty()) {
            adapter.setNewData(newsList);
        } else {
            swipeRefreshLayout.setRefreshing(true);
        }*/
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMovieDataLoaded(RestApiEvents.MoviesDataLoadedEvent event) {
/*        adapter.appendNewData(event.getLoadedMovies());
        swipeRefreshLayout.setRefreshing(false);*/
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onErrorInvokingAPI(RestApiEvents.ErrorInvokingAPIEvent event) {
        Snackbar.make(rvMostPopular, event.getErrorMsg(), Snackbar.LENGTH_INDEFINITE).show();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
     //   MovieModel.getInstance().startLoadingPopularMovies(getContext());
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void displayMoviesList(List<MovieVO> moviesList) {

    }

    @Override
    public void showLoding() {

    }

    @Override
    public void navigateToMovieetails(MovieVO movieVO) {

    }
}
