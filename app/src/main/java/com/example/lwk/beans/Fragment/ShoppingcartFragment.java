package com.example.lwk.beans.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lwk.beans.R;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.tencent.qq.QQ;

/**
 * Created by LWK on 2016/11/26.
 */
public class ShoppingcartFragment extends BaseFragment implements View.OnClickListener, PlatformActionListener {

    public static final String TAG = ShoppingcartFragment.class.getSimpleName();
    private ImageView imageQQ;
    private Button login;
    private TextView newuser;
    private TextView forgetpassword;
    private EditText account;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        layout = inflater.inflate(R.layout.shoppingcart_main_fragment,container,false);

        return layout;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
    }

    private void initView() {

        imageQQ = (ImageView)layout. findViewById(R.id.shoppingcart_login_qq);
        imageQQ.setOnClickListener(this);
        login = (Button) layout. findViewById(R.id.beans_main_controller_shoppingcart_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (account.getText().toString()!=null){
                    Toast.makeText(getActivity(), "请输入账号", Toast.LENGTH_SHORT).show();
                }

            }
        });
        newuser = (TextView) layout. findViewById(R.id.beans_main_controller_shoppingcart_newuser);
        newuser.setOnClickListener(this);
        forgetpassword = (TextView) layout. findViewById(R.id.beans_main_controller_shoppingcart_forgetpassword);

        account = (EditText)layout.findViewById(R.id.beans_main_controller_shoppingcart_useredit);
        forgetpassword.setOnClickListener(this);

    }

    private void showShare() {
        ShareSDK.initSDK(getContext());
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle("标题");
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段    oks.setText("我是分享文本");
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite("ShareSDK");
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(getContext());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shoppingcart_login_qq :
                login();
                break;

            case R.id.beans_main_controller_shoppingcart_newuser :
                Intent intent = new Intent(getActivity(),NewsUser.class);
                startActivity(intent);
                break;
            case R.id.beans_main_controller_shoppingcart_forgetpassword :
                Intent intent1 = new Intent(getActivity(),ForGetPassWord.class);
                startActivity(intent1);
                break;

            case R.id.shop_main_fragment_float :
                break;


        }
    }
    private void login() {
        // 首先 初始化 SharedSDK





        ShareSDK.initSDK(getContext());
        // 获取指定的平台
        Platform platform = ShareSDK.getPlatform(getContext(), QQ.NAME);
        // 为平台操作动作添加监听
        platform.setPlatformActionListener(this);
        // 调用平台认证
        platform.authorize();
        // showUser
        platform.showUser(null);
    }


    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {

    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {

    }

    @Override
    public void onCancel(Platform platform, int i) {

    }
}