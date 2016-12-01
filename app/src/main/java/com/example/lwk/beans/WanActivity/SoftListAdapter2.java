package com.example.lwk.beans.WanActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lwk.beans.R;
import com.example.lwk.beans.WanModel.ColorModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shinelon on 2016/12/1.
 */
public class SoftListAdapter2 extends BaseAdapter implements View.OnClickListener {
    private LayoutInflater inflater;
    private List <ColorModel.Data.PostsPOList> data;
    private OnItemClick listener;
    public  SoftListAdapter2(Context context, List<ColorModel.Data.PostsPOList> list){
        inflater=LayoutInflater.from(context);
        if (list == null) {
            data =new ArrayList<>();
        }else {
            data= list;
        }
    }
    public void updateRes(List<ColorModel.Data.PostsPOList> list){
        if (list != null) {
            data.clear();
            data.addAll(list);
            notifyDataSetChanged();
        }
    }
    public void addRes(List<ColorModel.Data.PostsPOList> list){
        data.addAll(list);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return data!=null?data.size():0;
    }

    @Override
    public ColorModel.Data.PostsPOList getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.color_item,parent,false);
        ViewHolder holder =null;
        if (convertView != null) {
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textViewch.setText(getItem(position).getTitle());
//        holder.title.setText(getItem(position).getViews());
        String string =getItem(position).getImageUrl();
        String a =string.substring(0,50);
        String b=string.substring(50,string.length());

        Picasso.with(holder.imageView.getContext()).load(a+java.net.URLEncoder.encode(b))
                .into(holder.imageView);
        holder.imageView.setTag(getItem(position).getUrl());
        holder.imageView.setOnClickListener(this);
        return convertView;
    }

    @Override
    public void onClick(View v) {
        if (data != null) {
            listener.onClick2(String.valueOf(v.getTag()));
        }
    }

    public class ViewHolder{

        ImageView imageView;
        TextView textViewch;
        TextView title;
        View itemView;

        public  ViewHolder(View itemView){
            this.itemView=itemView;
            title = (TextView) itemView.findViewById(R.id.num);
            imageView= (ImageView) itemView.findViewById(R.id.image_max);
            textViewch= (TextView) itemView.findViewById(R.id.iamge_title);
        }

    }
    public void setOnIteemClick(OnItemClick listener){
        this.listener=listener;
    }
    public interface OnItemClick{
        public void onClick2(String tag);
    }
}
