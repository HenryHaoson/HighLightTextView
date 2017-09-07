package com.zhuhao.highlighttextview;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author : zhuhao
 * Date : 7/9/2017
 *
 * @Last Modified Time :7/9/2017
 * Description :
 */

public class HLTextView extends android.support.v7.widget.AppCompatTextView {

    private int defaultColor = 0xffffff;
    private int HighlightColor = 0x123456;
    private ArrayList<HighlightText> indexArrays = new ArrayList<>();

    public HLTextView(Context context) {
        this(context, null);
    }

    public HLTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public void setDefaultColor(int color) {
        defaultColor = color;
    }

    public void setHighlightColor(int highlightColor) {
        HighlightColor = highlightColor;
    }

    public void draw(Canvas canvas){
        
    }

    public void setDisplayText(String text, List<String> highlighted) {

        int start = 0, end;
        for (int i = 0; i < highlighted.size(); i++) {
            Pattern pattern = Pattern.compile(highlighted.get(i));
            Matcher m = pattern.matcher(text);

            while (m.find()) {
                HighlightText hText = new HighlightText();
                hText.start = m.start();
                hText.end = m.end();
                indexArrays.add(hText);
            }

            end = text.indexOf(highlighted.get(i), start);
            if (end != -1) {

                start = end + 1;
            }
        }

    }

    class HighlightText {
        public int start;
        public int end;
    }
}
