package projects.nyinyihtunlwin.proofofconceptscreen.network;

import projects.nyinyihtunlwin.proofofconceptscreen.network.responses.GetPopularMovieResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Dell on 12/6/2017.
 */

public interface MovieAPI {

    @FormUrlEncoded
    @POST("v1/getPopularMovies.php")
    Call<GetPopularMovieResponse> loadPopularMovies(
            @Field("page") int page
            , @Field("access_token") String accessToken);
}
