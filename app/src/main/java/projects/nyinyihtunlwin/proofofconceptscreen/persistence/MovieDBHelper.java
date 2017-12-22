package projects.nyinyihtunlwin.proofofconceptscreen.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import projects.nyinyihtunlwin.proofofconceptscreen.persistence.MovieContract.MovieEntry;
import projects.nyinyihtunlwin.proofofconceptscreen.persistence.MovieContract.GenreEntry;
import projects.nyinyihtunlwin.proofofconceptscreen.persistence.MovieContract.MovieGenreEntry;

/**
 * Created by Dell on 12/15/2017.
 */

public class MovieDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "movies.db";


    private static final String SQL_CREATE_MOVIE_TABLE = "CREATE TABLE " + MovieEntry.TABLE_NAME + " (" +
            MovieEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            MovieEntry.COLUMN_MOVIE_ID + " VARCHAR(256), " +
            MovieEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
            MovieEntry.COLUMN_ORIGINAL_TITLE + " TEXT NOT NULL, " +
            MovieEntry.COLUMN_VOTE_COUNT + " INTEGER, " +
            MovieEntry.COLUMN_VIDEO + " INTEGER DEFAULT 0, " +
            MovieEntry.COLUMN_VOTE_AVERAGE + " REAL, " +
            MovieEntry.COLUMN_POPULARITY + " REAL, " +
            MovieEntry.COLUMN_POSTER_PATH + " TEXT NOT NULL, " +
            MovieEntry.COLUMN_ORIGINAL_LANGUAGE + " TEXT NOT NULL, " +
            MovieEntry.COLUMN_BACKDROP_PATH + " TEXT NOT NULL, " +
            MovieEntry.COLUMN_ADULT + " INTEGER DEFAULT 0, " +
            MovieEntry.COLUMN_OVERVIEW + " TEXT NOT NULL, " +
            MovieEntry.COLUMN_RELEASE_DATE + " TEXT NOT NULL, " +
            " UNIQUE (" + MovieEntry.COLUMN_TITLE + ") ON CONFLICT IGNORE" +
            " );";
    private static final String SQL_CREATE_GENRE_TABLE = "CREATE TABLE " + GenreEntry.TABLE_NAME + " (" +
            GenreEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            GenreEntry.COLUMN_GENRE_ID + " VARCHAR(256), " +
            " UNIQUE (" + GenreEntry.COLUMN_GENRE_ID + ") ON CONFLICT IGNORE" +
            " );";

    private static final String SQL_CREATE_MOVIE_GENRE_TABLE = "CREATE TABLE " + MovieGenreEntry.TABLE_NAME + " (" +
            MovieGenreEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            MovieGenreEntry.COLUMN_MOVIE_ID + " VARCHAR(256), " +
            MovieGenreEntry.COLUMN_GENRE_ID + " VARCHAR(256), " +
            " UNIQUE (" + MovieGenreEntry.COLUMN_MOVIE_ID + ", " +
            MovieGenreEntry.COLUMN_GENRE_ID
            + ") ON CONFLICT REPLACE" +
            ");";

    public MovieDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_MOVIE_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_GENRE_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_MOVIE_GENRE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MovieGenreEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + GenreEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MovieEntry.TABLE_NAME);

        onCreate(sqLiteDatabase);
    }
}
