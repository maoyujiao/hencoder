package com.aiyuba.hencoder.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.TypedValue;

import com.aiyuba.hencoder.R;

/**
 * Created by maoyujiao on 2019/9/24.
 */

public class Util {
    public static int dp2px(int dp){
        return (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }

    public static Bitmap getBitmap(Context context,int radius){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_head,options);
        options.inJustDecodeBounds = false;
        options.inDensity = options.outWidth;
        options.inTargetDensity = radius;
        return BitmapFactory.decodeResource(context.getResources(),R.mipmap.ic_head,options);
    }
}
