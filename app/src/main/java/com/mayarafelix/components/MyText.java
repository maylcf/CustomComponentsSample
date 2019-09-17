package com.mayarafelix.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class MyText extends AppCompatTextView {

    private String title;
    private boolean style;

    public MyText(Context context) {
        super(context);
        setMyTextTitle();
    }

    public MyText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyText);
        int count = typedArray.getIndexCount();

        try {
            for (int i = 0; i < count; i++) {
                int attr = typedArray.getIndex(i);

                if (attr == R.styleable.MyText_title) {
                    title = typedArray.getString(attr);
                    setMyTextTitle();
                } else if (attr == R.styleable.MyText_style) {
                    style = typedArray.getBoolean(attr, false);
                    setMyTextStyle();
                }
            }
        } finally {
            typedArray.recycle();
        }

    }

    public MyText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setMyTextTitle();
    }

    private void setMyTextTitle() {
        if (title != null) {
            setText(title);
        }
    }

    private void setMyTextStyle() {
        if (style) {
            setTextColor(Color.MAGENTA);
            setTextSize(20f);
        }
    }
}
