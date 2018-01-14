package projects.nyinyihtunlwin.proofofconceptscreen.network;

import org.greenrobot.eventbus.EventBus;

import projects.nyinyihtunlwin.proofofconceptscreen.events.RestApiEvents;
import projects.nyinyihtunlwin.proofofconceptscreen.network.responses.GetPopularMovieResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dell on 12/9/2017.
 */

public abstract class MovieCallback<T extends GetPopularMovieResponse> implements Callback<T> {
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        GetPopularMovieResponse movieResponse = response.body();
        if(movieResponse==null){
            RestApiEvents.ErrorInvokingAPIEvent errorEvent
                    = new RestApiEvents.ErrorInvokingAPIEvent("No data could be load for now. Please try again later.");
            EventBus.getDefault().post(errorEvent);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        RestApiEvents.ErrorInvokingAPIEvent errorEvent
                = new RestApiEvents.ErrorInvokingAPIEvent(t.getMessage());
        EventBus.getDefault().post(errorEvent);
    }
}
