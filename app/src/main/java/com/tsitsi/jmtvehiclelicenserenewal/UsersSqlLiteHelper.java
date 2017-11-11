package com.tsitsi.jmtvehiclelicenserenewal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by tsits on 11/03/17.
 */

public class UsersSqlLiteHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "users.db";
    private static final int DB_VERSION = 1;
    public static final String USERS_TABLE = "USERS";
    public static final String COLUMN_USER_NAME = "NAME";
    public static final String COLUMN_USER_SURNAME = "SURNAME";
    public static final String COLUMN_USER_VEHICLE_REG_NUM = "VEHICLE_REG_NUM";
    public static final String COLUMN_USER_VEHICLE_BOOK_NUM = "VEHICLE_BOOK_NUM";
    public static final String COLUMN_USER_PAYMENT_MONTHS= "PAYMENT_MONTHS";
    public static final String COLUMN_USER_ADDRESS = "ADDRESS";
    private static String CREATE_USERS =
            "CREATE TABLE " + USERS_TABLE + "(" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT," + COLUMN_USER_SURNAME + " TEXT," +
                     COLUMN_USER_VEHICLE_BOOK_NUM + " TEXT," + COLUMN_USER_VEHICLE_REG_NUM + " TEXT," + COLUMN_USER_PAYMENT_MONTHS + " TEXT," +
                     COLUMN_USER_ADDRESS + " TEXT)";

    public UsersSqlLiteHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
