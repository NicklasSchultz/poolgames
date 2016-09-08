package com.developergmail.schultz.nicklas.poolgames.helpers;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by nicklasschultz on 08/09/16.
 */
public class StringHelper {

    public static SpannableString getLargeText(String s) {
        SpannableString styledString = new SpannableString(s);
        styledString.setSpan(new RelativeSizeSpan(1.5f), 0 ,s.length(), 0);
        return styledString;
    }

    public static SpannableString getToastText(String s, Context c) {
        Log.d("NICKLAS", "getToastText ");
        SpannableString styledString = new SpannableString(s);
        styledString.setSpan(new RelativeSizeSpan(1.5f), 0 ,s.length(), 0);
        final Context context = c;
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Log.d("NICKLAS", "ONLCIKC ");
                Toast.makeText(context, "Sinking the white ball", Toast.LENGTH_LONG).show();
            }
        };

        //styledString.setSpan(new ForegroundColorSpan(Color.BLUE), 0, s.length(), 0);
        styledString.setSpan(clickableSpan, 0 ,s.length(), 0);
        return styledString;
    }

    public static SpannableString getColoredText(String s, int color) {
        SpannableString styledString = new SpannableString(s);
        styledString.setSpan(new ForegroundColorSpan(color), 0, s.length(), 0);
        return styledString;
    }
}
