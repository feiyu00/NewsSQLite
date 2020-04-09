package com.example.localization.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.localization.R;
import com.example.localization.pojo.News;

import java.util.List;

public class LsitAdapter extends BaseAdapter {
    Context content;
    List<News> mDatas;

    public LsitAdapter(Context content, List<News> datas) {
        this.content = content;
        mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView==null) {
            convertView = LayoutInflater.from(content).inflate(R.layout.list_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        News news =mDatas.get(position);
        holder.mTv_title.setText(news.getNewsTitle());
        return convertView;
    }
    class  ViewHolder{
        TextView mTv_title;
        public ViewHolder(View v) {
            mTv_title = v.findViewById(R.id.item_title);
        }
    }
}
