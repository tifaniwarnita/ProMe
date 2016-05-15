package com.tifaniwarnita.prome;

import android.graphics.Bitmap;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Tifani on 5/15/2016.
 */
public class PromoList {
    private static ArrayList<Promo> promoList = new ArrayList<>();

    public static void addPromo(Promo promo) {
        promoList.add(promo);
    }

    public static ArrayList<Promo> getPromoList() {
        return promoList;
    }
}
