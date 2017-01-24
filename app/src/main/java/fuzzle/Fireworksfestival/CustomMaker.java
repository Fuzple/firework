package fuzzle.Fireworksfestival;

import android.graphics.drawable.BitmapDrawable;

/**
    CostomMaker
    임은석
 */

public class CustomMaker {

        private String mLabel;
        private int mIcon;
        private Double mLatitude;
        private Double mLongitude;
        private String string;

        public CustomMaker(String label, int icon, Double latitude, Double longitude,String another_label)
        {
            this.mLabel = label;
            this.mLatitude = latitude;
            this.mLongitude = longitude;
            this.mIcon = icon;
            this.string = another_label;
        }

        public String getmLabel()
        {
            return mLabel;
        }

        public void setmLabel(String mLabel)
        {
            this.mLabel = mLabel;
        }

        public String getString()
        {
            return string;
        }
        public void setString(String string)
        {
            this.string = string;
        }

        public int getmIcon()
        {
            return mIcon;
        }

        public void setmIcon(int icon)
        {
            this.mIcon = icon;
        }

        public Double getmLatitude()
        {
            return mLatitude;
        }

        public void setmLatitude(Double mLatitude)
        {
            this.mLatitude = mLatitude;
        }

        public Double getmLongitude()
        {
            return mLongitude;
        }

        public void setmLongitude(Double mLongitude)
        {
            this.mLongitude = mLongitude;
        }



}
