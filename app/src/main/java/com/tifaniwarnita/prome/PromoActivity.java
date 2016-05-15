package com.tifaniwarnita.prome;

import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class PromoActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    public static String ADDED;
    public static boolean isAdded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo);

        TextView title = (TextView) findViewById(R.id.header_title_promo);
        TextView title_place = (TextView) findViewById(R.id.header_title_promo_places);
        Typeface face = Typeface.createFromAsset(getAssets(),
                "NHaasGroteskDSPro-15UltTh.otf");
        title.setTypeface(face);
        title_place.setTypeface(face);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                isAdded = false;
            } else {
                isAdded = true;
            }
        }

        final ArrayList<TextView> headerList = new ArrayList<>();
        TextView header1 = (TextView) findViewById(R.id.header_1);
        TextView header2 = (TextView) findViewById(R.id.header_2);
        TextView header3 = (TextView) findViewById(R.id.header_3);
        TextView header4 = (TextView) findViewById(R.id.header_4);
        header1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(0, true);
            }
        });
        header2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(1, true);
            }
        });
        header3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(2, true);
            }
        });
        header4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(3, true);
            }
        });

        headerList.add(header1);
        headerList.add(header2);
        headerList.add(header3);
        headerList.add(header4);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                for(TextView header : headerList) {
                    header.setBackgroundResource(R.drawable.border);
                }
                headerList.get(position).setBackgroundResource(R.drawable.border_black);
            }
        });

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private static final int[] promoAll = {
                R.layout.promo_totok_kesehatan_makmur,
                R.layout.promo_the_goods_dept_raffle,
                R.layout.promo_starbucks,
                R.layout.promo_fish_n_co
        };

        private static final int[] promoFood = {
                R.layout.promo_starbucks,
                R.layout.promo_fish_n_co
        };

        private static final int[] promoFashion = {
                R.layout.promo_the_goods_dept_raffle,
        };

        private static final int[] promoOthers = {
                R.layout.promo_totok_kesehatan_makmur
        };

        private ArrayList<Promo> all = new ArrayList<>();
        private ArrayList<Promo> food = new ArrayList<>();
        private ArrayList<Promo> fashion = new ArrayList<>();
        private ArrayList<Promo> others = new ArrayList<>();

        public PlaceholderFragment() {
            for (Promo promo : PromoList.getPromoList()) {
                if (promo.getCategory().equalsIgnoreCase("FOOD"))
                    food.add(promo);
                else if (promo.getCategory().equalsIgnoreCase("FASHION"))
                    fashion.add(promo);
                else if (promo.getCategory().equalsIgnoreCase("OTHERS"))
                    others.add(promo);
                all.add(promo);
            }
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_promo, container, false);
            GridView gridView = (GridView) rootView.findViewById(R.id.grid_view);

            int section = getArguments().getInt(ARG_SECTION_NUMBER);
            switch (section) {
                case 1:
                    gridView.setAdapter(new PlacesAdapter(getContext(), promoAll, all));
                    break;
                case 2:
                    gridView.setAdapter(new PlacesAdapter(getContext(), promoFood, food));
                    break;
                case 3:
                    gridView.setAdapter(new PlacesAdapter(getContext(), promoFashion, fashion));
                    break;
                case 4:
                    gridView.setAdapter(new PlacesAdapter(getContext(), promoOthers, others));
                    break;
            }
            //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "ALL";
                case 1:
                    return "FOOD";
                case 2:
                    return "FASHION";
                case 3:
                    return "OTHERS";
            }
            return null;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
