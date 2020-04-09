package com.example.localization.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.localization.db.UserDatabaseHelper;
import com.example.localization.pojo.User;
import com.example.localization.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    private final UserDatabaseHelper mHelper;
    private String TAG = "Dao";

    public UserDaoImpl(Context context) {
        //创建数据库
        mHelper = new UserDatabaseHelper(context);
    }

    @Override
    public long addUser(User user) {
        SQLiteDatabase db = mHelper.getWritableDatabase();
/*        String sql = "insert into " + Constants.TABLE_NAME+ "(_id,name,age,salary,phone,adress) values(?,?,?,?,?,?)";
        db.execSQL(sql,new Object[]{1,"BillGates",60,1, 110, "USA"});*/
        //谷歌api 操作
        ContentValues values = new ContentValues();
        user2Values(user, values);
        long result = db.insert(Constants.TABLE_NAME, null, values);
        db.close();
        //不返回-1就ok
        return result;
    }

    @Override
    public int delUserById(int id) {
        SQLiteDatabase db = mHelper.getWritableDatabase();
        /*String sql = "delete from " + Constants.TABLE_NAME + " where age = 60";
        db.execSQL(sql);*/
        //删除全部
        int result = db.delete(Constants.TABLE_NAME, null, null);
        Log.d(TAG, "delete_result ===" + result);
        db.close();
        //返回删了多少
        return result;
    }

    @Override
    public int updateUser(User user) {
        SQLiteDatabase db = mHelper.getWritableDatabase();
  /*      String sql = "update " + Constants.TABLE_NAME + " set salary =2 where age =60";
        db.execSQL(sql);*/
        //谷歌api
        ContentValues values = new ContentValues();
        user2Values(user, values);
        int result = db.update(Constants.TABLE_NAME, values, Constants.FIELD_ID, new String[]{user.get_id()+""});
        db.close();
        return result ;
    }

    @Override
    public User getUserById(String userName,String userPass) {
        SQLiteDatabase db = mHelper.getWritableDatabase();
        String sql = "select * from " + Constants.TABLE_NAME +" where " +Constants.FIELD_USER_NAME+" = ? and "+Constants.FIELD_PASSWORD+" = ?";
        Cursor cursor = db.rawQuery(sql,new String[]{userName,userPass});
        User user = null;
        //是否有下一个  isFirst是否是第一个，move第几个 moveToLast最后一个
        //查一个用if，多个用while
        if (cursor.moveToFirst()) {
            user = cursor2User(cursor);
        }
        db.close();
        return user;
    }

    @Override
    public List<User> listAllUser() {
        SQLiteDatabase db = mHelper.getWritableDatabase();
        //第一个表名 ,不分组，不排序，不要限制条件
        Cursor cursor = db.query(Constants.TABLE_NAME, null, null, null, null, null, null);
        //查一个用if，多个用while
        List<User> users = new ArrayList<>();
        while (cursor.moveToNext()) {
           User user = cursor2User(cursor);
           users.add(user);
        }
        db.close();
        return users;
    }
    private void user2Values(User user, ContentValues values) {
        values.put(Constants.FIELD_USER_NAME, user.getUserName());
        values.put(Constants.FIELD_PASSWORD, user.getPassword());
        values.put(Constants.FIELD_SEX, user.getSex());
        values.put(Constants.FIELD_AGE, user.getAge());
    }
    private User cursor2User(Cursor cursor) {
        User user =new User();
        int userId = cursor.getInt(cursor.getColumnIndex(Constants.FIELD_ID));
        String userName = cursor.getString(cursor.getColumnIndex(Constants.FIELD_USER_NAME));
        String userPassword = cursor.getString(cursor.getColumnIndex(Constants.FIELD_PASSWORD));
        String userSex = cursor.getString(cursor.getColumnIndex(Constants.FIELD_SEX));
        int userAge = cursor.getInt(cursor.getColumnIndex(Constants.FIELD_AGE));
        user.set_id(userId);
        user.setUserName(userName);
        user.setPassword(userPassword);
        user.setSex(userSex);
        user.setAge(userAge);
        return user;
    }
}
