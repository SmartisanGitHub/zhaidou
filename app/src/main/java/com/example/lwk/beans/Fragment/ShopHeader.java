//package com.example.lwk.beans.Fragment;
//
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.SystemClock;
//import android.support.annotation.Nullable;
//import android.support.v4.view.ViewPager;
//import android.util.DisplayMetrics;
//import android.util.TypedValue;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import com.example.lwk.beans.LWKAdapter.ShopAdapter;
//import com.example.lwk.beans.LWKModel.BigShop;
//import com.example.lwk.beans.LWKModel.ShopAll;
//import com.example.lwk.beans.LWKModel.ShopMiddle;
//import com.example.lwk.beans.R;
//import com.example.lwk.beans.url;
//import com.google.gson.Gson;
//import com.rock.teachlibrary.ImageLoader;
//import com.rock.teachlibrary.http.HttpUtil;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
///**
// * Created by LWK on 2016/11/26.
// */
//public class ShopHeader extends BaseFragment{
//
//    public static final String TAG = ShopHeader.class.getSimpleName();
//    private ViewPager topImage;
//    private LinearLayout topDot;
//    private TextView title;
//    private ImageView icon;
//    private TextView title2;
//    private TextView title3;
//    private TextView title4;
//    private ImageView icon2;
//    private ImageView icon3;
//    private ImageView icon4;
//
//
//    //存放要显示在ViewPager对象中的所有的ImageView对象
//    private List<ImageView> images;
//    //记录当前在ViewPager中显示的ImageView对象的前一个ImageView的索引
//    private int prePosition = 0;
//    private ShopAdapter shopAdapter;
//    private Handler handler = new Handler() {
//        public void handleMessage(android.os.Message msg) {
//            if (msg.what == 0x200) {
//                // viewpager要切换到下一张图片
//                int currentIndex = topImage.getCurrentItem();
//                currentIndex++;
//                topImage.setCurrentItem(currentIndex % images.size());
//            }
//        };
//    };
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        layout = inflater.inflate(R.layout.shop_header,container,false);
//        return layout;
//    }
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        initView();
//        getImagesId();
//        setDots();
//        topDot.getChildAt(0).setBackgroundResource(R.mipmap.dot_enable);
//        shopAdapter = new ShopAdapter(null);
//        topImage.setAdapter(shopAdapter);
//        topImage.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//                //设置一个点的背景图
//                topDot.getChildAt(prePosition).setBackgroundResource(R.mipmap.dot_normal);
//
//                //设置当前点的背景图
//                topDot.getChildAt(position).setBackgroundResource(R.mipmap.dot_enable);
//                //把当前点位置作为下一次变化的前一个点的位置
//                prePosition = position;
//
//
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//
//
//    }
//
//
//
//    private void setDots() {
//        for (int i = 0; i <=2 ; i++) {
//            //设置小圆点
//            View view = new View(getActivity());
//            view.setBackgroundResource(R.mipmap.dot_normal);
//            DisplayMetrics displayMetrics = new DisplayMetrics();
//            float width= TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX,100,displayMetrics);
//            float height= TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX,200,displayMetrics);
//
//            LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams((int)width,(int)height);
//            layoutParams.leftMargin=5;
//            view.setLayoutParams(layoutParams);
//            topDot.addView(view);
//
//        }
//    }
//
//    private void getImagesId() {
//        Date dt= new Date();
//        Long time= dt.getTime();
//        images = new ArrayList<ImageView>();
//        HttpUtil.getStringAsync(url.SHOP_HEADER+time, new HttpUtil.RequestCallback() {
//            @Override
//            public void prepare() {
//
//            }
//
//            @Override
//            public void fail() {
//
//            }
//
//            @Override
//            public void success(String result) {
//
//                Date dt= new Date();
//                Long time= dt.getTime();
//
//                Gson gson = new Gson();
//
//                ShopMiddle shopMiddle = gson.fromJson(result,ShopMiddle.class);
//                List<Shop> shop = bigShop.getData();
//                List<ShopAll> shopImages = shop.get(0).getProgramPOList();
//                List<ShopAll> shopImages2 = shop.get(2).getProgramPOList();
//
//                for (int i = 0; i < shopImages.size(); i++) {
//                    ImageView imageView = new ImageView(getActivity());
//                    ImageLoader.display(imageView,shopImages.get(i).getPictureUrl());
//                    images.add(imageView);
//
//                }
//                ImageLoader.display(icon,shopImages2.get(0).getPictureUrl());
//                ImageLoader.display(icon2,shopImages2.get(1).getPictureUrl());
//                ImageLoader.display(icon3,shopImages2.get(2).getPictureUrl());
//                ImageLoader.display(icon4,shopImages2.get(3).getPictureUrl());
//
//                title.setText(shopImages2.get(0).getName());
//                title2.setText(shopImages2.get(1).getName());
//                title3.setText(shopImages2.get(2).getName());
//                title4.setText(shopImages2.get(3).getName());
//                shopAdapter.updataRes(images);
//
//
//            }
//
//            @Override
//            public void finish() {
//
//            }
//        });
//
//        // 启动一个线程进行轮播操作
//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                while (true) {
//                    SystemClock.sleep(3000);
//
//                    handler.sendEmptyMessage(0x200);
//                }
//            }
//        }).start();
//
//
//    }
//
//
//    private void initView() {
//        topImage = (ViewPager)layout.findViewById(R.id.beans_shop_header_viewpager);
//
//        topDot = (LinearLayout)layout.findViewById(R.id.beans_shop_header_lv_points);
//
//        title = (TextView) layout.findViewById(R.id.shop_header_lv_four_title1);
//        title2 = (TextView) layout.findViewById(R.id.shop_header_lv_four_title2);
//        title3 = (TextView) layout.findViewById(R.id.shop_header_lv_four_title3);
//        title4 = (TextView) layout.findViewById(R.id.shop_header_lv_four_title4);
//        icon = (ImageView) layout.findViewById(R.id.shop_header_lv_four_image1);
//        icon2 = (ImageView) layout.findViewById(R.id.shop_header_lv_four_image2);
//        icon3 = (ImageView) layout.findViewById(R.id.shop_header_lv_four_image3);
//        icon4= (ImageView) layout.findViewById(R.id.shop_header_lv_four_image4);
//
//
//
//
//
//
//
//
//
//
//    }
//
//
//}
