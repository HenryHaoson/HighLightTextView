package com.zhuhao.highlighttextview;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
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
    private int highlightColor = 0x123456;
    private ArrayList<HighlightText> indexArrays = new ArrayList<>();

    public HLTextView(Context context) {
        this(context, null);
    }

    public HLTextView(Context context, AttributeSet attrs) {
        super(context, attrs);


    }

    public void setDefaultColor(int color) {
        defaultColor = color;
    }

    public void setHighlightColor(int highlightColor) {
        this.highlightColor = highlightColor;
    }



    public void setDisplayText(String text, List<String> highlighted) {
        SpannableString ss=new SpannableString(text);

        for (int i = 0; i < highlighted.size(); i++) {
            Pattern pattern = Pattern.compile(highlighted.get(i));
            Matcher m = pattern.matcher(text);

            while (m.find()) {
                HighlightText hText = new HighlightText();
                hText.start = m.start();
                hText.end = m.end();
                indexArrays.add(hText);
            }
        }

        operateHighlight(text);

    }

    
    public void operateHighlight(String text){
        SpannableString ss=new SpannableString(text);
        for (HighlightText highlightText:indexArrays) {
            ss.setSpan(new ForegroundColorSpan(highlightColor),highlightText.start,highlightText.end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        this.setText(ss);
    }

    class HighlightText {
        public int start;
        public int end;
    }
}
