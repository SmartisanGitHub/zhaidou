package com.example.lwk.beans.LWKAdapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lwk.beans.LWKModel.ShopAll;
import com.example.lwk.beans.R;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LWK on 2016/11/28.
 */
public class ShopRecyclerAdapter extends RecyclerView.Adapter<ShopRecyclerAdapter.ViewHolder> {

    private List<ShopAll> data;
    private LayoutInflater inflater;
    private Context context;
    private RecyclerView mrecyclerView;

    public ShopRecyclerAdapter(Context context) {
        data = new ArrayList<>();
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void updateRes(List<ShopAll> data) {
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void addRes(List<ShopAll> data) {
        if (data != null) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mrecyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        mrecyclerView = null;
    }

    @Override
    public int getItemViewType(int position) {

        return data.get(position).getType();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        switch (viewType) {
            case 0:

                itemView = inflater.inflate(R.layout.shop_header, parent, false);

                break;
            case 1:
                itemView = inflater.inflate(R.layout.shop_header_fragment_item_typeone, parent, false);

                break;
            case 2:
                itemView = inflater.inflate(R.layout.shop_header_fragment_item_typezero, parent, false);

                break;
        }


        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        switch (data.get(position).getType()) {
            case 0:
                ImageView imageView;
                List<ImageView> imageData = new ArrayList<>();
                for (int i = 0; i < 3; i++) {

                    imageView = new ImageView(context);
                    x.image().bind(imageView, data.get(i).getPictureUrl());
                    imageData.add(imageView);
                }

                if (holder.points.getChildCount() != imageData.size()) {

                    for (int j = 0; j < 3; j++) {
                        View view = new View(context);
                        view.setBackgroundResource(R.mipmap.dot_enable);
                        DisplayMetrics metrics = new DisplayMetrics();
                        float width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 100, metrics);
                        float height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 200, metrics);
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) width, (int) height);

                        params.rightMargin = 10;
                        view.setLayoutParams(params);
                        holder.points.addView(view);

                    }

//                    x.image().bind(holder.icon, data.get(0).getPictureUrl());
//                    x.image().bind(holder.icon2, data.get(1).getPictureUrl());
//
//                    x.image().bind(holder.icon3, data.get(2).getPictureUrl());
////                  x.image().bind(holder.icon4, data.get(3).getPictureUrl());

                }
                holder.viewPager.setAdapter(new ShopAdapter(imageData));

                break;
            case 1:
                x.image().bind(holder.imageMiddle, data.get(position).getPictureUrl());

                break;
            case 2:
                x.image().bind(holder.imageButtom, data.get(position).getMainPic());
                holder.titleButtom.setText(data.get(position).getActivityName());
                break;


        }

    }


    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        ViewPager viewPager;
        LinearLayout points;

        ImageView imageMiddle;

        TextView titleButtom;
        ImageView imageButtom;

        public ViewHolder(View itemView) {
            super(itemView);
            viewPager = (ViewPager) itemView.findViewById(R.id.beans_shop_header_viewpager);
            points = (LinearLayout) itemView.findViewById(R.id.beans_shop_header_lv_points);

            imageMiddle = (ImageView) itemView.findViewById(R.id.shop_header_fragment_item_typeone_imagetwo);

            titleButtom = (TextView) itemView.findViewById(R.id.shop_header_fragment_item_typezero_text);
            imageButtom = (ImageView) itemView.findViewById(R.id.shop_header_fragment_item_typezero_image);
        }
    }
}
