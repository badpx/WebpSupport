package com.badpx.webp.support.sample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.badpx.webp.support.WebpDecoder;

import java.io.IOException;
import java.io.InputStream;

public class MyActivity extends Activity implements View.OnClickListener {

    public static final String TAG = "WEBP-TEST";
    private ImageView mImageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Setup WEBP Image decoder
        WebpDecoder.setup();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mImageView = (ImageView) findViewById(R.id.imageview);

        mImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageview:
                performance();
                break;
        }
    }

    private void performance() {
        int count = 10;
        String pic = "02.webp";
        try {
            Bitmap bmp = null;
            long total = 0;
            for (int i = 0; i < count; ++i) {
                long begin = SystemClock.uptimeMillis();
                InputStream is = getAssets().open(pic);
                bmp = BitmapFactory.decodeStream(is);
                long end = SystemClock.uptimeMillis();
                total += end - begin;
                is.close();
            }

            if (null != bmp) {
                mImageView.setImageBitmap(bmp);
            }
            String result =
                    String.format("Decode %s %d times, each decode average cost %dms", pic, count, total / count);
            Log.d(TAG, result);
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
