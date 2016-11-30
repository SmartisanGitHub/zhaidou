package com.example.lwk.beans.WanActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lwk.beans.MainActivity;
import com.example.lwk.beans.R;

public class DIYdapeiFragment extends AppCompatActivity implements View.OnClickListener {

    private ImageView mGobackImage;
    private TextView mGobackText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic);
        initView();
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
        startActivity(new Intent(this, MainActivity.class));
    }
}
