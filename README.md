# HighLightTextView

![效果图.png](http://upload-images.jianshu.io/upload_images/3351492-79a8fb56db105970.png)

```java
  ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("well known");
        arrayList.add("is not simply just");
        arrayList.add("between people");
        HLTextView textView= (HLTextView) findViewById(R.id.textView);
        textView.setDefaultColor(Color.BLACK);
        textView.setHighlightColor(Color.RED);
        textView.setDisplayText("It’s well known that the clash between Design and Develo" +
                "pment is not simply just a clash between people who do different stuff- it’s a cl" +
                "ash between two ways of solving problems within given contraints.HIt’s well known that the clash between Design and Develo" +
                "pment is not simply just a clash between people who do different stuff- it’s a cl" +
                "ash between two ways of solving problems within given contraints.",arrayList);
```

### HLTextView
```java
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
        setTextColor(defaultColor);
    }

    public void setHighlightColor(int highlightColor) {
        this.highlightColor = highlightColor;
    }


    //
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

        operateHighlight(operateNbsp(text));

    }

    /**
     * 操作text,替换词组中的空格为\u00A0
     * @param text
     * @return 返回处理好的text
     */
    public String operateNbsp(String text){
        Log.e("nbsp",text);

        StringBuilder builder=new StringBuilder(text);
        for (HighlightText highlightText:indexArrays) {
            String sub=text.substring(highlightText.start,highlightText.end);
            Log.e("nbsp",sub);
            String sub1=sub.replace(" ","\u00A0");

            Log.e("nbsp",sub1);
            text=text.replace(sub,sub1);
        }
        Log.e("nbsp",text);
        return text;
    }

    /**
     * 设置词组高亮，然后setText。
     * @param text
     */
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

```
