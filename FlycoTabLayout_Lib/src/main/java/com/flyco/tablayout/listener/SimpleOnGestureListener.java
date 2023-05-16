package com.flyco.tablayout.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * GestureDetector 默认实现
 *
 * @author leo
 * @Date 2023/05/16
 * @description
 */
class SimpleOnGestureListener implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener, GestureDetector.OnContextClickListener {
    @Override
    public boolean onContextClick(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}
