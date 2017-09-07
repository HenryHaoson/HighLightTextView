package com.zhuhao.highlighttextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("well known");
        arrayList.add("is not simply just a clash");
        arrayList.add("between\u00A0people");
        HLTextView textView= (HLTextView) findViewById(R.id.textView);
        textView.setDisplayText("HIt’s well known that the clash between Design and\u00A0Develo" +
                "pment is not simply just a clash between\u00A0people who do different stuff- it’s a cl" +
                "ash between two ways of solving problems within given contraints.",arrayList);
    }
}
