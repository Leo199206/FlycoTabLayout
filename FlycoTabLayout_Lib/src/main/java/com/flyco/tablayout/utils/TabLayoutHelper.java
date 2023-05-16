package com.flyco.tablayout.utils;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.function.Function;

/**
 * @author leo
 * @Date 2023/05/16
 * @description
 */
public class TabLayoutHelper {

    /**
     * 设置[GestureDetector]处理Tab item双击和单击事件
     *
     * @param listenerGet        OnTabSelectListener?
     * @param currentPositionGet Function0<Int>
     * @param updatePositionFunc Function1<Int, Int>
     * @receiver View
     */
    @SuppressLint("ClickableViewAccessibility")
    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void setGestureDetector(android.view.View view, Function<Integer,
            OnTabSelectListener> listenerGet, Function<Object, Integer> currentPositionGet,
                                          Function<Integer, Object> updatePositionFunc) {
        GestureDetector gestureDetector = createGestureDetector(view, listenerGet,
                currentPositionGet, updatePositionFunc);
        view.setOnTouchListener((View v, MotionEvent event) -> {
            gestureDetector.onTouchEvent(event);
            return true;
        });
    }


    /**
     * 构建[GestureDetector]
     *
     * @param listenerGet        OnTabSelectListener?
     * @param currentPositionGet Function0<Int>
     * @param updatePositionFunc Function1<Int, Int>
     * @return GestureDetector
     * @receiver View
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    private static GestureDetector createGestureDetector(android.view.View view, Function<Integer
            , OnTabSelectListener> listenerGet, Function<Object, Integer> currentPositionGet,
                                                         Function<Integer, Object> updatePositionFunc) {
        return new GestureDetector(view.getContext(),
                new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                int position = (int) view.getTag();
                OnTabSelectListener listener = listenerGet.apply(position);
                if (currentPositionGet.apply(position) != position) {
                    updatePositionFunc.apply(position);
                    if (listener != null) {
                        listener.onTabSelect(position);
                    }
                } else {
                    if (listener != null) {
                        listener.onTabReselect(position);
                    }
                }
                return super.onSingleTapConfirmed(e);
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                int position = (int) view.getTag();
                OnTabSelectListener listener = listenerGet.apply(position);
                if (listener != null) {
                    listener.onTabDoubleClick(position);
                }
                return super.onDoubleTap(e);
            }
        });
    }
}
