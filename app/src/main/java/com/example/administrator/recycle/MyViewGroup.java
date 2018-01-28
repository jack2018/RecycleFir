package com.example.administrator.recycle;

import android.content.Context;
import android.support.annotation.Px;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.Scroller;

/**
 * Created by Administrator on 2018\1\28 0028.
 */

public class MyViewGroup extends ViewGroup{
    Scroller scroller;
    public MyViewGroup(Context context) {
        super(context);
        scroller = new Scroller(context,new BounceInterpolator());
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        scroller = new Scroller(context,new BounceInterpolator());
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        scroller = new Scroller(context,new BounceInterpolator());
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int height = 0;
        int count = getChildCount();
        View child;
        Log.e("ri", count + "");
        for(int i = 0 ;i < count;i++) {
            child = getChildAt(i);
            child.layout(0, height, child.getMeasuredWidth(),height +  child.getMeasuredHeight());
            height += child.getMeasuredHeight();

        }
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);

        MarginLayoutParams params = null;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);

        //开始处理wrap_content,如果一个子元素都没有，就设置为0
        if (getChildCount() == 0) {
            setMeasuredDimension(0,0);
        } else if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            //ViewGroup，宽，高都是wrap_content，根据我们的需求，宽度是子控件的宽度，高度则是所有子控件的总和
            View childOne = getChildAt(0);
            params = (MarginLayoutParams) childOne.getLayoutParams();
            int childWidth = childOne.getMeasuredWidth();
            int childHeight = childOne.getMeasuredHeight();
            setMeasuredDimension(childWidth + params.leftMargin + params.rightMargin,
                    childHeight * getChildCount() + params.topMargin + params.bottomMargin);

        } else if (widthMode == MeasureSpec.AT_MOST) {
            //ViewGroup的宽度为wrap_content,则高度不需要管，宽度还是自控件的宽度
            View childOne = getChildAt(0);
            params = (MarginLayoutParams) childOne.getLayoutParams();
            int childWidth = childOne.getMeasuredWidth();
            setMeasuredDimension(childWidth + params.leftMargin + params.rightMargin,heightSize);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            //ViewGroup的高度为wrap_content,则宽度不需要管，高度为子View的高度和
            View childOne = getChildAt(0);
            params = (MarginLayoutParams) childOne.getLayoutParams();
            int childHeight = childOne.getMeasuredHeight();
            setMeasuredDimension(widthSize, childHeight * getChildCount() + params.topMargin + params.bottomMargin);
        }
    }

float downpoint=0;
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                downpoint =  event.getX();
                Log.i("asdas","下");
//                return true;
                  break;
            case MotionEvent.ACTION_MOVE:
                float dis = event.getX() -downpoint;
                if(Math.abs(dis)>50){
//                    return true;
                }
                Log.i("asdas","动");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("asdas","上");
                break;
        }
        return super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i("asdas","onTouchEvent下");
                return true;

            case MotionEvent.ACTION_MOVE:
                Log.i("asdas","onTouchEvent动");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("asdas","onTouchEvent上");
                break;
        }
        return super.onTouchEvent(event);
    }

    //调用此方法滚动到目标位置
    public void smoothScrollTo(int fx, int fy) {
        int dx = fx - scroller.getFinalX();
        int dy = fy - scroller.getFinalY();
        smoothScrollBy(dx, dy);
    }

    //调用此方法设置滚动的相对偏移
    public void smoothScrollBy(int dx, int dy) {

        //设置mScroller的滚动偏移量
        scroller.startScroll(scroller.getFinalX(), scroller.getFinalY(), dx, dy,4000);
        invalidate();//这里必须调用invalidate()才能保证computeScroll()会被调用，否则不一定会刷新界面，看不到滚动效果
    }
    @Override
    public void computeScroll() {

        //先判断mScroller滚动是否完成
        if (scroller.computeScrollOffset()) {

            //这里调用View的scrollTo()完成实际的滚动
            scrollTo(scroller.getCurrX(), scroller.getCurrY());

            //必须调用该方法，否则不一定能看到滚动效果
            postInvalidate();
        }
        super.computeScroll();
    }
}
