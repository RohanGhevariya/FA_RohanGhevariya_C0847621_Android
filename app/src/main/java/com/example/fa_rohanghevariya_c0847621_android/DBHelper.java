package com.example.fa_rohanghevariya_c0847621_android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "PlacesDB";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "myFavPlaces";
    private static final String ID_COL = "Place_id";
    private static final String NAME_COL = "place_name";
    public static final String LAT="lat";
    public static final String Lang="lang";
    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }



    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public DBHelper(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + LAT + " TEXT,"
                + Lang + " TEXT)";


        db.execSQL(query);
    }
    public void addNewPlace(String Name, String lat,String lang) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, Name);
        values.put(LAT, lat);
        values.put(Lang, lang);


        db.insert(TABLE_NAME, null, values);


        db.close();
    }
    public ArrayList<Places> readProducts() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorPlaces = db.rawQuery("SELECT * FROM myPlaces ",null);

        // on below line we are creating a new array list.
        ArrayList<Places> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorPlaces.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new Places(cursorPlaces.getString(1),
                        cursorPlaces.getString(2),
                        cursorPlaces.getString(3)));

            } while (cursorPlaces.moveToNext());
            // moving our cursor to next.
        }

        cursorPlaces.close();
        return courseModalArrayList;
    }
    // method for deleting
    public void deletePlaces(String placeName) {


        SQLiteDatabase db = this.getWritableDatabase();


        db.delete(TABLE_NAME, "place_name=?", new String[]{placeName});
        db.close();
    }
    //update
    public void updatePlace(String originalPlaceName,String placeName, String lat,String lang) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME_COL, placeName);
        values.put(LAT, lat);
        values.put(Lang, lang);



        db.update(TABLE_NAME, values, "place_name=?", new String[]{originalPlaceName});
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
