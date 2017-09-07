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
        arrayList.add("is not simply just");
        arrayList.add("between people");
        HLTextView textView= (HLTextView) findViewById(R.id.textView);
        textView.setDisplayText("It’s well known that the clash between Design and Develo" +
                "pment is not simply just a clash between people who do different stuff- it’s a cl" +
                "ash between two ways of solving problems within given contraints.HIt’s well known that the clash between Design and Develo" +
                "pment is not simply just a clash between people who do different stuff- it’s a cl" +
                "ash between two ways of solving problems within given contraints.",arrayList);
    }
}
