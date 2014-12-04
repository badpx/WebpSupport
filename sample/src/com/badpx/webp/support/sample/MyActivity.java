package com.badpx.webp.support.sample;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.badpx.webp.support.WebpDecoder;

public class MyActivity extends Activity implements View.OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Setup WEBP Image decoder
        WebpDecoder.setup();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ImageView imageView = (ImageView) findViewById(R.id.imageview);

        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageview:
                // Click ImageView to change a image.
                ImageView imageView = (ImageView)v;
                Drawable drawable = getResources().getDrawable(R.drawable.webp2);
                imageView.setImageDrawable(drawable);
                break;
        }
    }
}
