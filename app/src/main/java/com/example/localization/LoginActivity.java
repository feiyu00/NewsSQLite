package com.example.localization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.localization.dao.IUserDao;
import com.example.localization.dao.UserDaoImpl;
import com.example.localization.pojo.User;
import com.example.localization.utils.ToastUtil;

public class LoginActivity extends AppCompatActivity {
    private EditText mEt_userName,mEt_userPass;
    private Button mBtn_Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        mEt_userName = findViewById(R.id.uname);
        mEt_userPass = findViewById(R.id.upass);
        mBtn_Login = findViewById(R.id.login);
        mBtn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = mEt_userName.getText().toString().trim();
                String userPass = mEt_userPass.getText().toString().trim();
                if (userName.isEmpty()&&userPass.isEmpty()){
                    ToastUtil.showMsg(getApplicationContext(),"账号或者密码不能为空");
                }else if (userName.isEmpty()){
                    ToastUtil.showMsg(getApplicationContext(),"账号不能为空");
                }else if (userPass.isEmpty()){
                    ToastUtil.showMsg(getApplicationContext(),"密码不能为空");
                }else {
                    IUserDao userDao =new UserDaoImpl(getApplication());
                    User user =userDao.getUserById(userName,userPass);
                    if (user==null){
                        ToastUtil.showMsg(getApplicationContext(),"账号不存在，请注册！");
                    } else{
                     if(user.getUserName().equals(userName)&&user.getPassword().equals(userPass)){
                         Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                         intent.putExtra("user",user);
                         startActivity(intent);
                        }
                    }
                }
            }
        });
    }
}
