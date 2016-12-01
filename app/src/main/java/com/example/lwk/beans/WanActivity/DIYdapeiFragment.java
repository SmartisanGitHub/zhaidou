package com.example.lwk.beans.WanActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lwk.beans.R;

public class DIYdapeiFragment extends AppCompatActivity implements View.OnClickListener {

    private ImageView mGobackImage;
    private TextView mGobackText;
    private String ut;
    private  String id="";
    private   String PHOTOURL="http://m.zhaidou.com/pics/";
    private WebView mWeb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        ut=intent.getStringExtra("name");
        id =intent.getStringExtra("id");
        if ("photo".equals(ut)) {
            setContentView(R.layout.activity_photos);
            initView2();
        }else if("color".equals(ut)){
            setContentView(R.layout.activity_photos);
            PHOTOURL=id;
            initView2();
        }else {
            setContentView(R.layout.activity_magic);
            initView();
        }

    }

    private void initView2() {
        mWeb = (WebView) findViewById(R.id.magic_photo_webview);
        WebSettings settings = mWeb.getSettings();
        //打开JavaScript功能
        settings.setJavaScriptEnabled(true);
        mWeb.setWebViewClient(new WebViewClient());
        WebChromeClient client =new WebChromeClient(){

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
        };
        mWeb.setWebChromeClient(client);
        mWeb.loadUrl(PHOTOURL+id);
    }

    private void initView() {

        mGobackImage = (ImageView) findViewById(R.id.goback_img);
        mGobackText = (TextView) findViewById(R.id.goback_txt);
        mGobackImage.setOnClickListener(this);
        mGobackText.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        goBack();
    }

    private void goBack() {
        finish();
    }

    public void goFinish(View view) {
        finish();
    }
}
