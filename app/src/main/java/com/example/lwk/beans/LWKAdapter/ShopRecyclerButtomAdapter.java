package com.example.lwk.beans.LWKAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lwk.beans.LWKModel.ShopAll;
import com.example.lwk.beans.R;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LWK on 2016/11/28.
 */
public class ShopRecyclerButtomAdapter extends RecyclerView.Adapter<ShopRecyclerButtomAdapter.ViewHolder> {

    private List<ShopAll> data;

    private LayoutInflater inflater;
    public ShopRecyclerButtomAdapter (Context context,List<ShopAll> data){
        inflater = LayoutInflater.from(context);
        if (data!=null) {
            this.data=data;
        }else{
            this.data = new ArrayList<>();
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.shop_header_fragment_item_typezero,parent,false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.title.setText(data.get(position).getActivityName());
        x.image().bind(holder.image,data.get(position).getMainPic());
    }



    @Override
    public int getItemCount() {
        return data!=null?data.size():0;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;


        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.shop_header_fragment_item_typezero_image);
            title = (TextView)itemView.findViewById(R.id.shop_header_fragment_item_typezero_text);

        }
    }
}
