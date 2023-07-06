package sg.edu.rp.c346.id22013272.song;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    //Start version with 1
    //increment by 1 whenever db schema changes
    private static final int DATABASE_VER = 1;
    //filename of the database
    private static final String DATABASE_NAME = "song.db";
    private static final String TABLE_SONG = "song";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "song title";
    private static final String COLUMN_NAME = "singer's name";
    private static final String COLUMN_YEAR = "Year";
    private static final String COLUMN_STAR= "Star";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSql = "CREATE TABLE" + TABLE_SONG + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_TITLE + " TEXT," + COLUMN_NAME + " TEXT," + COLUMN_YEAR + " INTEGER,"+COLUMN_STAR+" INTEGER)";
        db.execSQL(createTableSql);
        Log.i("info", "created tables");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_SONG);
        //Create table(s) again
        onCreate(db);

    }
    public void insertTask(String title, String name,String year){

        // Get an instance of the database for writing
        SQLiteDatabase db = this.getWritableDatabase();
        // We use ContentValues object to store the values for
        //  the db operation
        ContentValues values = new ContentValues();
        // Store the column name as key and the description as value
        values.put(COLUMN_TITLE, title);
        // Store the column name as key and the date as value
        values.put(COLUMN_NAME,name);
        values.put(COLUMN_YEAR,year);
        // Insert the row into the TABLE_TASK
        db.insert(TABLE_SONG, null, values);
        // Close the database connection
        db.close();
    }

    public ArrayList<String> getSongContent() {
        // Create an ArrayList that holds String objects
        ArrayList<String> songs = new ArrayList<String>();
        // Get the instance of database to read
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_ID, COLUMN_TITLE, COLUMN_NAME, COLUMN_YEAR};
        // Run the query and get back the Cursor object
        Cursor cursor = db.query(TABLE_SONG, columns, null, null, null, null, null, null);

        // moveToFirst() moves to first row, null if no records
        if (cursor.moveToFirst()) {
            // Loop while moveToNext() points to next row
            //  and returns true; moveToNext() returns false
            //  when no more next row to move to
            do {
                // Add the task content to the ArrayList object
                //  getString(0) retrieves first column data
                //  getString(1) return second column data
                //  getInt(0) if data is an integer value
                songs.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        // Close connection
        cursor.close();
        db.close();

        return songs;
    }

    public ArrayList<song> getSongs() {
        ArrayList<song> tasks = new ArrayList<song>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_ID, COLUMN_TITLE, COLUMN_NAME, COLUMN_YEAR};
        Cursor cursor = db.query(TABLE_SONG, columns, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String name = cursor.getString(2);
                String year = cursor.getString(3);
                song obj = new song(id, title, name, year);
                tasks.add(obj);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return tasks;
    }
}