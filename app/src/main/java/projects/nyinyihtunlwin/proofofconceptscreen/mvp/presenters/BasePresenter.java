package projects.nyinyihtunlwin.proofofconceptscreen.mvp.presenters;

/**
 * Created by Dell on 1/11/2018.
 */

public abstract class BasePresenter<T> {

    T mView;

    public void onCreate() {
    }

    public void onCreateView() {
    }

    public void onAttach(T mView) {
        this.mView = mView;
    }

    public void onDetach() {
    }

    public abstract void onStart();

    public void onResume() {
    }

    public void onPause() {
    }

    public abstract void onStop();

    public void onDestroy() {
    }

}
