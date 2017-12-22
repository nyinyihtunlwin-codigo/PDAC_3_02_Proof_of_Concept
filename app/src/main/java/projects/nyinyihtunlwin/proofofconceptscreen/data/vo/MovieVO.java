package projects.nyinyihtunlwin.proofofconceptscreen.data.vo;

import android.content.ContentValues;
import android.database.Cursor;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import projects.nyinyihtunlwin.proofofconceptscreen.persistence.MovieContract;

/**
 * Created by Dell on 12/6/2017.
 */

public class MovieVO {
    @SerializedName("vote_count")
    private int voteCount;
    @SerializedName("id")
    private String movieId;
    @SerializedName("video")
    private boolean video;
    @SerializedName("vote_average")
    private float voteAverage;
    @SerializedName("title")
    private String title;
    @SerializedName("popularity")
    private float popularity;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("genre_ids")
    private ArrayList<Integer> genreIds;
    @SerializedName("backdrop_path")
    private String backDropPath;
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("overview")
    private String overview;
    @SerializedName("release_date")
    private String releasedDate;

    public int getVoteCount() {
        return voteCount;
    }

    public String getMovieId() {
        return movieId;
    }

    public boolean isVideo() {
        return video;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public float getPopularity() {
        return popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public ArrayList<Integer> getGenreIds() {
        return genreIds;
    }

    public String getBackDropPath() {
        return backDropPath;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleasedDate() {
        return releasedDate;
    }

    public ContentValues parseToContentValues() {

        ContentValues contentValues = new ContentValues();
        contentValues.put(MovieContract.MovieEntry.COLUMN_MOVIE_ID, movieId);
        contentValues.put(MovieContract.MovieEntry.COLUMN_VOTE_COUNT, movieId);
        contentValues.put(MovieContract.MovieEntry.COLUMN_VOTE_AVERAGE, movieId);
        contentValues.put(MovieContract.MovieEntry.COLUMN_VIDEO, movieId);
        contentValues.put(MovieContract.MovieEntry.COLUMN_ORIGINAL_TITLE, movieId);
        contentValues.put(MovieContract.MovieEntry.COLUMN_TITLE, movieId);
        contentValues.put(MovieContract.MovieEntry.COLUMN_POPULARITY, movieId);
        contentValues.put(MovieContract.MovieEntry.COLUMN_POSTER_PATH, movieId);
        contentValues.put(MovieContract.MovieEntry.COLUMN_ORIGINAL_LANGUAGE, movieId);
        contentValues.put(MovieContract.MovieEntry.COLUMN_BACKDROP_PATH, movieId);
        contentValues.put(MovieContract.MovieEntry.COLUMN_OVERVIEW, movieId);
        contentValues.put(MovieContract.MovieEntry.COLUMN_RELEASE_DATE, movieId);
        contentValues.put(MovieContract.MovieEntry.COLUMN_ADULT, movieId);
        return contentValues;
    }

    public static MovieVO parseFromCursor(Cursor cursor) {
        MovieVO movie = new MovieVO();
        movie.movieId = cursor.getString(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_MOVIE_ID));
        movie.voteCount = cursor.getInt(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_VOTE_COUNT));
        //  movie.video=cursor.getBlob(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_VIDEO));
        movie.voteAverage = cursor.getInt(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_VOTE_AVERAGE));
        movie.title = cursor.getString(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_TITLE));
        movie.popularity = cursor.getInt(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_POPULARITY));
        movie.posterPath = cursor.getString(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_POSTER_PATH));
        movie.originalLanguage = cursor.getString(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_ORIGINAL_LANGUAGE));
        movie.originalTitle = cursor.getString(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_ORIGINAL_TITLE));
        movie.backDropPath = cursor.getString(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_BACKDROP_PATH));
        //     movie.adult=cursor.getInt(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_ADULT));
        movie.overview = cursor.getString(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_OVERVIEW));
        movie.releasedDate = cursor.getString(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_RELEASE_DATE));
        return movie;
    }
}
