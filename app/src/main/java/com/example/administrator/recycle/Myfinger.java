package com.example.administrator.recycle;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * Created by Administrator on 2018\1\28 0028.
 */

public class Myfinger extends AppCompatActivity {
    MyViewGroup myViewGroup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        MyView myView = (MyView) findViewById(R.id.mytext);
        myViewGroup  = (MyViewGroup) findViewById(R.id.myc);
//        ((View)myView.getParent()).scrollTo(0,-500);
        myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("gggg","点击测试");
                myViewGroup.smoothScrollTo(0,-800);
            }
        });

    }


}
