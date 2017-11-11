package com.tsitsi.jmtvehiclelicenserenewal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by tsits on 11/03/17.
 */

public class UsersDataSource {
    private Context mContext;
    private UsersSqlLiteHelper mUsersSqlLiteHelper;
    long userID;

    public UsersDataSource(Context context){
        mContext = context;
        mUsersSqlLiteHelper = new UsersSqlLiteHelper(context);
        //SQLiteDatabase database = mUsersSqlLiteHelper.getReadableDatabase();
        //database.close();
    }

    private SQLiteDatabase open(){
        return mUsersSqlLiteHelper.getWritableDatabase();
    }

    private void close(SQLiteDatabase database){
        database.close();
    }

    public MainActivity.User read(){
        return null;
    }

    public void readUser(){
        SQLiteDatabase database = open();

        Cursor cursor = database.query(
                UsersSqlLiteHelper.USERS_TABLE,
                new String[] {UsersSqlLiteHelper.COLUMN_USER_NAME, BaseColumns._ID, UsersSqlLiteHelper.COLUMN_USER_SURNAME, UsersSqlLiteHelper.COLUMN_USER_VEHICLE_BOOK_NUM, UsersSqlLiteHelper.COLUMN_USER_VEHICLE_REG_NUM, UsersSqlLiteHelper.COLUMN_USER_PAYMENT_MONTHS, UsersSqlLiteHelper.COLUMN_USER_ADDRESS},
                null,
                null,
                null,
                null,
                null);
        if(cursor.moveToFirst()){
            do{
                MainActivity.UserData[0] = getStringFromColumnName(cursor, UsersSqlLiteHelper.COLUMN_USER_NAME);
                MainActivity.UserData[1] = getStringFromColumnName(cursor, UsersSqlLiteHelper.COLUMN_USER_SURNAME);
                MainActivity.UserData[2]= getStringFromColumnName(cursor, UsersSqlLiteHelper.COLUMN_USER_VEHICLE_BOOK_NUM);
                MainActivity.UserData[3] = getStringFromColumnName(cursor, UsersSqlLiteHelper.COLUMN_USER_VEHICLE_REG_NUM);
                MainActivity.UserData[4] = getStringFromColumnName(cursor, UsersSqlLiteHelper.COLUMN_USER_PAYMENT_MONTHS);
                MainActivity.UserData[5] = getStringFromColumnName(cursor, UsersSqlLiteHelper.COLUMN_USER_ADDRESS);
            }while(cursor.moveToNext());
        }

        cursor.close();
        close(database);
    }

    private int getIntFromColumnName(Cursor cursor, String ColumnName){
        int columnIndex = cursor.getColumnIndex(ColumnName);
        return cursor.getInt(columnIndex);
    }

    private String getStringFromColumnName(Cursor cursor, String columnName){
        int columnIndex = cursor.getColumnIndex(columnName);
        return cursor.getString(columnIndex);
    }


    public void create(MainActivity.User user){
        SQLiteDatabase database = open();
        database.beginTransaction();

        ContentValues userValues = new ContentValues();
        userValues.put(UsersSqlLiteHelper.COLUMN_USER_NAME, user.getName());
        userValues.put(UsersSqlLiteHelper.COLUMN_USER_SURNAME, user.getSurname());
        userValues.put(UsersSqlLiteHelper.COLUMN_USER_VEHICLE_BOOK_NUM, user.getVehicle_book_num());
        userValues.put(UsersSqlLiteHelper.COLUMN_USER_VEHICLE_REG_NUM, user.getVehicle_reg_num());
        userValues.put(UsersSqlLiteHelper.COLUMN_USER_PAYMENT_MONTHS, user.getPayment_duration());
        userValues.put(UsersSqlLiteHelper.COLUMN_USER_ADDRESS, user.getAddress());
        userID = database.insert(UsersSqlLiteHelper.USERS_TABLE, null, userValues);

        database.setTransactionSuccessful();
        database.endTransaction();
        close(database);
    }


}
