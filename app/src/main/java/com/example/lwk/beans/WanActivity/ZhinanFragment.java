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
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lwk.beans.R;

/**
 * Created by Shinelon on 2016/11/29.
 */
public class ZhinanFragment extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = ZhinanFragment.class.getSimpleName();
    private WebView mWebView;
    private  String WEBURL="";
    private ImageView mGobackImage;
    private TextView mGobackText;
    private ProgressBar mProgress;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent =getIntent();
        WEBURL =intent.getStringExtra("name");
        setContentView(R.layout.magic_zhinan);
        initView();
    }


    private void initView() {
        mWebView = (WebView) findViewById(R.id.magic_include_webview);
        mGobackImage = (ImageView) findViewById(R.id.goback_img);
        mGobackText = (TextView) findViewById(R.id.goback_txt);
        mProgress = (ProgressBar) findViewById(R.id.progressBar);
        WebSettings settings = mWebView.getSettings();
        //打开JavaScript功能
        settings.setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());
        WebChromeClient client =new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                mProgress.setProgress(newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
        };
        mWebView.setWebChromeClient(client);
        mWebView.loadUrl(WEBURL);
        mGobackImage.setOnClickListener(this);
        mGobackText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        goBack();
    }
    public void goBack(){
        mWebView.goBack();
        finish();
    }
}
