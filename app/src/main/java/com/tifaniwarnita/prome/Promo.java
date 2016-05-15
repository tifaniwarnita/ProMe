package com.tifaniwarnita.prome;

import android.graphics.Bitmap;

/**
 * Created by Tifani on 5/15/2016.
 */
public class Promo {
    private String title;
    private String period;
    private String category;
    private Bitmap bitmap;

    public Promo(String title, String period, String category, Bitmap bitmap) {
        this.title = title;
        this.period = period;
        this.category = category;
        this.bitmap = bitmap;
    }

    public String getTitle() {
        return title;
    }

    public String getPeriod() {
        return period;
    }

    public String getCategory() {
        return category;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }
}
