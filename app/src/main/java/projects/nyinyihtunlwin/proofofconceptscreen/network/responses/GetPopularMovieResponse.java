package projects.nyinyihtunlwin.proofofconceptscreen.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import projects.nyinyihtunlwin.proofofconceptscreen.data.vo.MovieVO;

/**
 * Created by Dell on 12/6/2017.
 */

public class GetPopularMovieResponse {
    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("apiVersion")
    private String apiVersion;
    @SerializedName("page")
    private String page;
    @SerializedName("popular-movies")
    private List<MovieVO> popularMovies;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<MovieVO> getPopularMovies() {
        return popularMovies;
    }
}
