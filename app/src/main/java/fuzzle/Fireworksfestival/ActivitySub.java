package fuzzle.Fireworksfestival;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActivitySub extends AppCompatActivity {

    private ViewPager mViewPager;
    TabLayout tabLayout;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    int i;

    FragmentLook fragmentlook = new FragmentLook();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.id.language_background, options);
        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;
        String imageType = options.outMimeType;

//        ImageView sub_background = (ImageView)findViewById(R.id.SubBg);
//        sub_background.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.sub_background)));

       // sub_background.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.sub_background, 100, 100));

        i=getIntent().getExtras().getInt("btnId");

        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),this);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
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

//    public boolean onKeyDown(int keyCode, KeyEvent event)    {
//        if(keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0)        {
//            // 팝업을 띄움
//            if(fragmentlook.i ==  0) {
////                fragmentlook.lookFrame2.setVisibility(View.INVISIBLE);
////                fragmentlook.lookFrame1.setVisibility(View.VISIBLE);
//                System.out.println("성공");
//            }
//            else{
//                System.out.println("실일필");
//                System.out.println(fragmentlook.i);
//            }
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }


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

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        recycleView(findViewById(R.id.SubBg));
//    }
//
//    private void recycleView(View view) {
//        if(view != null) {
//            Drawable bg = view.getBackground();
//            if(bg != null) {
//                bg.setCallback(null);
//                ((BitmapDrawable)bg).getBitmap().recycle();
//                view.setBackgroundDrawable(null);
//            }
//        }
//    }
//    public boolean onKeyDown(int keyCode, KeyEvent event)    {
//        if(keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0)        {
//            Intent intent = new Intent(getApplicationContext(),ActivityMain.class);
//            startActivity(intent);
//            finish();
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
}


