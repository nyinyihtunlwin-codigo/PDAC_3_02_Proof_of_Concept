package projects.nyinyihtunlwin.proofofconceptscreen.events;

import android.content.ContentProvider;
import android.content.Context;

import java.util.List;

import projects.nyinyihtunlwin.proofofconceptscreen.data.vo.MovieVO;

/**
 * Created by Dell on 12/7/2017.
 */

public class RestApiEvents {

    public static class ErrorInvokingAPIEvent {
        private String errorMsg;

        public ErrorInvokingAPIEvent(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public String getErrorMsg() {
            return errorMsg;
        }
    }

    public static class MoviesDataLoadedEvent {

        private int loadedPageIndex;
        private List<MovieVO> loadedMovies;
        private Context context;

        public MoviesDataLoadedEvent(int loadedPageIndex, List<MovieVO> loadedMovies, Context context) {
            this.loadedPageIndex = loadedPageIndex;
            this.loadedMovies = loadedMovies;
            this.context = context;
        }

        public int getLoadedPageIndex() {
            return loadedPageIndex;
        }

        public List<MovieVO> getLoadedMovies() {
            return loadedMovies;
        }

        public Context getContext() {
            return context;
        }
    }
}
