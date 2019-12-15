package com.teamscam.localhub.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.teamscam.localhub.R;

import java.util.List;

public class MyRecyclerViewAdapter extends ArrayAdapter<UserTask>
{
    private List<UserTask> mData;
    private Context context;
    private LayoutInflater layoutInflater;
    private int layoutResource;

    public static class ViewHolder
    {
        TextView homeTextViewRecyclerView1;
        TextView homeTextViewRecyclerView2;
        ImageView homeImageViewRecyclerView;
        ViewHolder (View view)
        {
            this.homeTextViewRecyclerView1=view.findViewById(R.id.homeTextViewRecyclerView1);
            this.homeImageViewRecyclerView=view.findViewById(R.id.homeImageView);
        }
    }

    // data is passed into the constructor
    public MyRecyclerViewAdapter(Context context, int resource, List<UserTask> data)
    {
        super(context, R.layout.recylerview_row);
        this.mData = data;
        this.context=context;
        this.layoutInflater=LayoutInflater.from(context);
        this.layoutResource=resource;
    }

    @Override
    public int getCount()
    {
        return mData.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, ViewGroup parent)
    {
        View view=layoutInflater.inflate(layoutResource,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        UserTask data=mData.get(position);
        String Temp1=data.HomeTitle;
        viewHolder.homeTextViewRecyclerView1.setText(Temp1);
        viewHolder.homeImageViewRecyclerView.setImageResource(data.HomeImageId);
        view.setTag(viewHolder);
        return view;
    }
}
