package com.badpx.webp.support;

import android.os.Build;

/**
 * Created by kanedong on 14-12-4.
 */
public class WebpDecoder {
    public static void setup() {
        // Setup WEBP decoder for Android 2.x
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.GINGERBREAD) {
            try {
                System.loadLibrary("webp-22");
                nativeInit();
            } catch (UnsatisfiedLinkError error) {
                error.printStackTrace();
            }
        } else if (Build.VERSION.SDK_INT < 11/*Build.VERSION_CODES.HONEYCOMB*/) {
            try {
                System.loadLibrary("webp-23");
                nativeInit();
            } catch (UnsatisfiedLinkError error) {
                error.printStackTrace();
            }
        }
    }

    private native static void nativeInit();
}
