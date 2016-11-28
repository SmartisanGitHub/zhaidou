package com.example.lwk.beans.LWKAdapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LWK on 2016/11/28.
 */
public class ShopAdapter extends PagerAdapter{

    private List<ImageView> images;
    public ShopAdapter (List<ImageView> images) {
        if (images == null) {
            this.images = new ArrayList<>();
        } else {
            this.images = images;
        }
    }
        public void updataRes(List<ImageView>images){

            if (images!=null) {
                this.images.clear();
                this.images.addAll(images);
                this.notifyDataSetChanged();


            }

    }

    //当要显示的图片可以进行缓存的时候，会调用这个方法进行显示图片的初始化
    //我们将要显示的ImageView加入到ViewGroup中，再把这个要显示的ImageView对象返回即可
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        if (images!=null&&images.size()>position) {
            container.addView(images.get(position));
            return  images.get(position);
        }
        return null;
    }

    //如果滑动的图片超出了缓存的范围，就会调用这个方法，将图片销毁

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        if (images!=null&&images.size()>position) {
            container.removeView(images.get(position));
        }
    }

    @Override
    public int getCount() {
        return images!=null?images.size():0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view ==object;
    }
}










