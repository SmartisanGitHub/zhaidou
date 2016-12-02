package com.example.lwk.beans.LWKAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lwk.beans.LWKModel.ShopAll;
import com.example.lwk.beans.R;

import org.xutils.x;

import java.util.List;

/**
 * Created by LWK on 2016/11/29.
 */
public class ShopRecyclerImageAdapter extends RecyclerView.Adapter<ShopRecyclerImageAdapter.ViewHolder> {

    private List<ShopAll> data;
    private LayoutInflater inflater;

    public ShopRecyclerImageAdapter(Context context,List<ShopAll> data) {

        inflater = LayoutInflater.from(context);

            this.data = data;

    }

    @Override
    public ShopRecyclerImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.shop_header_fragment_item_typeone, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        x.image().bind(holder.image2,data.get(position).getPictureUrl());

    }



    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
//        ImageView image;
        ImageView image2;


        public ViewHolder(View itemView) {
            super(itemView);
//            image = (ImageView) itemView.findViewById(R.id.shop_header_fragment_item_typeone_imageone);
            image2 = (ImageView) itemView.findViewById(R.id.shop_header_fragment_item_typeone_imagetwo);

        }
    }

}
