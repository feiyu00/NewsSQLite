package com.example.localization.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.localization.db.UserDatabaseHelper;
import com.example.localization.utils.Constants;

public class UserProvider extends ContentProvider {
    private static final int USER_MATCH_CODE = 1;
    private UserDatabaseHelper mUserDatabaseHelper = null;
    private static UriMatcher mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        mUriMatcher.addURI("com.example.localization",null,USER_MATCH_CODE);
    }
    //创建
    @Override
    public boolean onCreate() {
        
        mUserDatabaseHelper = new UserDatabaseHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        int result=mUriMatcher.match(uri);
        //匹配规则
        if (result == USER_MATCH_CODE) {
            SQLiteDatabase db = mUserDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query(Constants.TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder);
            return cursor;
        }else {
            //不匹配规则
            throw  new IllegalArgumentException("参数错误");
        }

    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
