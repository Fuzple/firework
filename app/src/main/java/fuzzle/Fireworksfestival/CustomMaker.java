package fuzzle.Fireworksfestival;

import android.graphics.drawable.BitmapDrawable;

/**
    CostomMaker
    임은석
 */

public class CustomMaker {

        private String title;
        private int Icon;
        private int placeinfo;
        private Double Latitude;
        private Double Longitude;
        private String price;

        public CustomMaker(String title, int icon, Double latitude, Double longitude,String price,int placeInfo)
        {
            this.title = title;
            this.Latitude = latitude;
            this.Longitude = longitude;
            this.Icon = icon;
            this.price = price;
            this.placeinfo = placeInfo;

        }

        public String gettitle()
        {
            return title;
        }

        public void settitle(String title)
        {
            this.title = title;
        }

        public String getprice()
        {
            return price;
        }

        public void setprice(String price)
        {
            this.price = price;
        }

        public int getIcon()
        {
            return Icon;
        }

        public void setIcon(int icon)
        {
            this.Icon = icon;
        }

        public Double getLatitude()
        {
            return Latitude;
        }

        public void setLatitude(Double mLatitude)
        {
            this.Latitude = mLatitude;
        }

        public Double getLongitude()
        {
            return Longitude;
        }

        public void setLongitude(Double mLongitude)
        {
            this.Longitude = mLongitude;
        }

        public int getplaceInfo(){
            return placeinfo;
        }
        public void setPlaceinfo(int placeinfo){
            this.placeinfo = placeinfo;
        }
}
