package com.vistagram.helperlibrary.customUi;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by Android on 12/8/2017.
 */

public class DroidTextView extends AppCompatTextView {


    public DroidTextView(Context context) {
        super(context);
        setType(context);
    }

    public DroidTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setType(context);
    }

    public DroidTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setType(context);
    }

    private void setType(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/iranian-sans-light.ttf");
        setTypeface(typeface);
    }

}
