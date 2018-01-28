package com.example.administrator.recycle;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2018\1\28 0028.
 */

public class MyView extends TextView{
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                Log.i("MyView","onTouchEvent下");
//                return true;
//
//            case MotionEvent.ACTION_MOVE:
//                Log.i("MyView","onTouchEvent动");
//                break;
//            case MotionEvent.ACTION_UP:
//                Log.i("MyView","onTouchEvent上");
//                break;
//        }
//        return super.onTouchEvent(event);
//    }
}
