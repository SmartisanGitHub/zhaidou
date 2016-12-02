package com.example.lwk.beans.LWKAdapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lwk.beans.Fragment.HomeFragment;
import com.example.lwk.beans.LWKModel.HomeList;
import com.example.lwk.beans.R;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */
public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private static final String TAG = HomeAdapter.class.getSimpleName();
    private List<HomeList> data;
    private LayoutInflater inflater;
    public static final int IS_HEADER = 0;
    public static final int IS_ITEM = 1;
    private Boolean loading;
    private SendImageMessage message;
    private OnItemClickListener listener;
    private RecyclerView mRecycerView;
    public void setListener(SendImageMessage message) {
        this.message = message;

    }
public void setitemListener(OnItemClickListener listener){
    this.listener=listener;
}

    public HomeAdapter(Context context) {
        data = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecycerView=recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        mRecycerView=null;
    }

    public void updateRes(List<HomeList> data) {
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    ;

    public void addRes(List<HomeList> data) {
        if (data != null) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }

    }

    @Override
    public void onClick(View v) {
        int childAdapterPosition = mRecycerView.getChildAdapterPosition(v);
        if (message!=null) {
            listener.onItemClick(childAdapterPosition);
        }
    }


    public class HeaderHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ImageView imageView0;
        ImageView imageView1;
        ImageView imageView2;

        public HeaderHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.home_header_image);
            imageView0 = (ImageView) itemView.findViewById(R.id.home_header_image0);
            imageView1 = (ImageView) itemView.findViewById(R.id.home_header_image1);
            imageView2 = (ImageView) itemView.findViewById(R.id.home_header_image2);
        }
    }



    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView caseName;
        TextView mainDesc;
        TextView comment;

        public ItemViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.home_item_mainPic);
            caseName = (TextView) itemView.findViewById(R.id.home_item_caseName);
            mainDesc = (TextView) itemView.findViewById(R.id.home_item_mainDesc);
            comment = (TextView) itemView.findViewById(R.id.home_item_comment);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return IS_HEADER;
        } else {
            return IS_ITEM;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == IS_HEADER) {
            return new HeaderHolder(inflater.inflate(R.layout.home_header, parent, false));
        } else {
            return new ItemViewHolder(inflater.inflate(R.layout.home_item, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderHolder) {
            x.image().bind(((HeaderHolder) holder).imageView, data.get(position).getHea_Image());
            x.image().bind(((HeaderHolder) holder).imageView0, data.get(position).getHea_Image0());
            x.image().bind(((HeaderHolder) holder).imageView1, data.get(position).getHea_Image1());
            x.image().bind(((HeaderHolder) holder).imageView2, data.get(position).getHea_Image2());

        } else if (holder instanceof ItemViewHolder) {
            ((ItemViewHolder) holder).caseName.setText(data.get(position).getCaseName());
            ((ItemViewHolder) holder).mainDesc.setText(data.get(position).getMainDesc());
            ((ItemViewHolder) holder).comment.setText("评论" + data.get(position).getComment());
            x.image().bind(((ItemViewHolder) holder).imageView, data.get(position).getItem_Image());
            loading = ((ItemViewHolder) holder).mainDesc.getText() != null;
            message.sendload(loading);
        }

        holder.itemView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
       // Log.e(TAG, "getItemCount: "+data.size() );
        return data != null ? data.size()  : 0;
    }
    public String GetId(int position){
        return data.get(position).getId();
    }
    public interface SendImageMessage {
        void sendload(Boolean load);
    }
    public interface OnItemClickListener{
        void onItemClick(int position);

    }

}
