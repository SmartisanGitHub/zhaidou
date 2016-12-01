package com.example.lwk.beans.WanActivity;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lwk.beans.R;
import com.example.lwk.beans.WanModel.SofPhomoel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.picasso.transformations.MaskTransformation;

/**
 * Created by Shinelon on 2016/11/30.
 */
public class SoftListAdapter extends BaseAdapter implements View.OnClickListener {


    private LayoutInflater inflater;
    private List<SofPhomoel.Data> data;
    private OnItemClick listener;
    public  SoftListAdapter(Context context, List<SofPhomoel.Data> list){
        inflater=LayoutInflater.from(context);
        if (list == null) {
            data =new ArrayList<>();
        }else {
            data= list;
        }
    }
    public void updateRes(List<SofPhomoel.Data> list){
        if (list != null) {
            data.clear();
            data.addAll(list);
            notifyDataSetChanged();
        }
    }
    public void addRes(List<SofPhomoel.Data> list){
        data.addAll(list);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return data!=null?data.size():0;
    }

    @Override
    public SofPhomoel.Data getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.magic_photos_item,parent,false);
        ViewHolder holder =null;
        if (convertView != null) {
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textViewch.setText(getItem(position).getStyleName());
        holder.titleen.setText(getItem(position).getEnName());
        Picasso.with(holder.imageView.getContext()).load(getItem(position).getMainPic())
                .transform(new MaskTransformation(holder.imageView.getContext(),R.drawable.background)).into(holder.imageView);
        holder.imageView.setTag(Integer.valueOf(position));
        holder.imageView.setOnClickListener(this);
        return convertView;
    }

    @Override
    public void onClick(View v) {
        if (data != null) {
            listener.onClick((Integer) v.getTag());
        }
    }

    public class ViewHolder{

        ImageView imageView;
        TextView textViewch;
        TextView titleen;
        View itemView;

        public  ViewHolder(View itemView){
            this.itemView=itemView;
            imageView= (ImageView) itemView.findViewById(R.id.item_image);
            textViewch= (TextView) itemView.findViewById(R.id.title_ch);
            titleen = (TextView) itemView.findViewById(R.id.title_en);
        }

    }
    public void setOnIteemClick(OnItemClick listener){
        this.listener=listener;
    }
    public interface OnItemClick{
        public void onClick(int position);
    }
}
