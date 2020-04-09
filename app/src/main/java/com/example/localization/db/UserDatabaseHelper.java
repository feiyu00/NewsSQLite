package com.example.localization.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.localization.utils.Constants;

public class UserDatabaseHelper extends SQLiteOpenHelper {
    private String TAG = "DatabaseHelper";

    /**
     * @param context 上下文
     * @ name  数据库名称
     * @ factory   游标工厂
     * @ version 版本号
     */
    public UserDatabaseHelper(@Nullable Context context) {
        //null为默认的
        super(context, Constants.DATABASE_NAME, null, Constants.VERSION_CODE);
    }

    /**
     * 第一次创建数据库的时候被调用
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建时回调
        Log.d(TAG, "创建数据库...");
        //创建字段
        //sql create table table_name(_id integer,name varchar,age integer ,salary integer)
        String sql = "create table " + Constants.TABLE_NAME +
                "("+ Constants.FIELD_ID+" integer primary key autoincrement,"
                   + Constants.FIELD_USER_NAME+" varchar(30),"
                   + Constants.FIELD_PASSWORD+ " varchar(30),"
                   + Constants.FIELD_SEX+" varchar(5),"
                   + Constants.FIELD_AGE+" integer)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //升级数据库时的回调

        //添加字段
        //sql :alter table table_name add phone integer
        //当前数据库版本号为1必须改为大于1下面代码才会执行，在Constants更改
        Log.d(TAG, "升级数据库...");
        String sql;
        switch (oldVersion){
            case 1:
                //添加address和这个phone字段
                sql = "alter table "+Constants.TABLE_NAME+" add phone integer";
                db.execSQL(sql);
                break;
            case 2:
                sql = "alter table "+Constants.TABLE_NAME+" add adress varchar";
                db.execSQL(sql);
                break;
            case 3:
                sql = "alter table "+Constants.TABLE_NAME+" add adre varchar";
                db.execSQL(sql);
                break;
        }
    }
}
