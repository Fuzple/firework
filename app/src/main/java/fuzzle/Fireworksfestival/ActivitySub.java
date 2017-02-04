package fuzzle.Fireworksfestival;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

public class ActivitySub extends AppCompatActivity{

    private ViewPager mViewPager;
    TabLayout tabLayout;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    int i;
    public int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        i=getIntent().getExtras().getInt("btnId");

        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),this);

        // Set up the ViewPager with the sections adapter.
        if (null == mViewPager) {
            mViewPager = (ViewPager) findViewById(R.id.container);
        }

        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.sub_btn_fire).setText(R.string.sub_fire);
        tabLayout.getTabAt(1).setIcon(R.drawable.sub_btn_look).setText(R.string.sub_look);
        tabLayout.getTabAt(2).setIcon(R.drawable.sub_btn_location).setText(R.string.sub_location);
        tabLayout.getTabAt(3).setIcon(R.drawable.sub_btn_traffic).setText(R.string.sub_traffic);
        tabLayout.getTabAt(i).select();

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // Set TabSelectedListener
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        Context mContext;
        public SectionsPagerAdapter(FragmentManager fm,Context context) {
            super(fm);
            mContext = context;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position){
                case 0:
                    return new FragmentFire();
                case 1:
                    return new FragmentLook();
                case 2:
                    return new FragmentLocation();
                case 3:
                    return new FragmentTraffic();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

//    @Override
//    public void onBackPressed() {
//        switch (i) {
//            case 0:
//                finish();
//                break;
//            case 1:
//                new FragmentLook().onBackPressed();
//                break;
//        }
//    }
}


