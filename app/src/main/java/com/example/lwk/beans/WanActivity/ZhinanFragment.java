package com.example.lwk.beans.WanActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lwk.beans.Fragment.BaseFragment;
import com.example.lwk.beans.Fragment.MagicFragment;
import com.example.lwk.beans.R;

/**
 * Created by Shinelon on 2016/11/29.
 */
public class ZhinanFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = ZhinanFragment.class.getSimpleName();
    private View layout;
    private WebView mWebView;
//    http://www.zhaidou.com/design?source=android
//    http://m.zhaidou.com/decorate/guide?source=android
    private final String WEBURL="http://m.zhaidou.com/decorate/guide?source=android";
    private ImageView mGobackImage;
    private TextView mGobackText;
    private ProgressBar mProgress;
    private Fragment mFragmentShow;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.magic_zhinan,container,false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        mWebView = (WebView) layout.findViewById(R.id.magic_include_webview);
        mGobackImage = (ImageView) layout.findViewById(R.id.goback_img);
        mGobackText = (TextView) layout.findViewById(R.id.goback_txt);
        mProgress = (ProgressBar) layout.findViewById(R.id.progressBar);
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
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mFragmentShow =new ZhinanFragment();
        transaction.hide(mFragmentShow);
        mFragmentShow =new MagicFragment();
        transaction.show(mFragmentShow);
        transaction.add(R.id.beans_main_fragmentshow,mFragmentShow);
        transaction.commit();
    }
}
