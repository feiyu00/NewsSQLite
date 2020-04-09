package com.example.localization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.localization.adapter.LsitAdapter;
import com.example.localization.dao.IUserDao;
import com.example.localization.dao.UserDaoImpl;
import com.example.localization.db.UserDatabaseHelper;
import com.example.localization.pojo.News;
import com.example.localization.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView showlv;
    List<News> mDatas;
    List<News> mAllDatas;
    ListAdapter mAdapter;
    TextView mTv_loginUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        showlv = findViewById(R.id.layout_list);
        mTv_loginUserName = findViewById(R.id.login);
        mDatas = new ArrayList<>();
        mAllDatas = new ArrayList<>();
        mAllDatas.add(new News("新闻1","新闻内容1"));
        mAllDatas.add(new News("新闻2","新闻内容2"));
        mAllDatas.add(new News("新闻3","新闻内容3"));
        mAllDatas.add(new News("新闻4","新闻内容4"));
        mAllDatas.add(new News("新闻5","新闻内容5"));
        mAllDatas.add(new News("新闻6","新闻内容6"));
        mAllDatas.add(new News("新闻7","新闻内容7"));
        mAllDatas.add(new News("新闻8","新闻内容8"));
        mDatas.addAll(mAllDatas);
        mAdapter = new LsitAdapter(this,mDatas);
        showlv.setAdapter(mAdapter);
        showlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News news = mDatas.get(position);
                Intent intent = new Intent(MainActivity.this,ContentActivity.class);
                intent.putExtra("news",news);
                startActivity(intent);
            }
        });
        mTv_loginUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTv_loginUserName.getText().toString().trim().equals("登陆")) {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                }

            }
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle==null){
        }else {
            User user = (User) bundle.getSerializable("user");
            if (user == null){

            }else {
                mTv_loginUserName.setText(user.getUserName());
            }
        }
    }
}