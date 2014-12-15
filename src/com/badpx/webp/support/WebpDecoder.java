package com.badpx.webp.support;

import android.os.Build;

/**
 * Created by kanedong on 14-12-4.
 */
public class WebpDecoder {
    public static void setup() {
        // Setup WEBP decoder for Android 2.x
        try {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.GINGERBREAD) {
                System.loadLibrary("webp-22");
            } else if (Build.VERSION.SDK_INT < 11/*Build.VERSION_CODES.HONEYCOMB*/) {
                System.loadLibrary("webp-23");
            } else if (Build.VERSION.SDK_INT < 17/*Build.VERSION_CODES.JELLY_BEAN_MR1*/) {
                System.loadLibrary("webp-41");
            }

            nativeInit();
        } catch (UnsatisfiedLinkError error) {
            error.printStackTrace();
        }
    }

    private native static void nativeInit();
}
