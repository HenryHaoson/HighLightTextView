package com.zhuhao.highlighttextview;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

/**
 * Author : zhuhao
 * Date : 7/9/2017
 *
 * @Last Modified Time :7/917
 * Description :
 */

public class HighLightTextView extends View {
    private int defaultColor = 0xffffff;
    private int HighlightColor = 0x123456;


    public HighLightTextView(Context context) {
        this(context, null);
    }

    public HighLightTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HighLightTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }



    public void setDefaultColor(int color) {
        defaultColor = color;
    }

    public void setHighlightColor(int highlightColor) {
        HighlightColor = highlightColor;
    }

    public void setDisplayText(String text, List<String> highlighted){

    }

    public void setText(){

    }

}
