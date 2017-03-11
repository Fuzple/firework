package fuzzle.Fireworksfestival;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityMapLocation extends AppCompatActivity {

    ImageView tour;
    TextView locationText;
    TextView placeNameText;

    int[] file = {R.raw.location_gwangalli_beach,R.raw.location_marine_city,R.raw.location_arpina,R.raw.location_busan_museum_of_art_bexco,
            R.raw.location_centum_city,R.raw.location_waterfront_park,R.raw.location_busan_cinema_center,R.raw.location_dongbaek_island,
            R.raw.location_gwangan_bridge,R.raw.location_hwangryeong_mt};

    int i;     //좌표값을 받아오기 위한 더블 배열
    int placePosition;
    String placeName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_location);

        tour = (ImageView)findViewById(R.id.tour);
        locationText = (TextView) findViewById(R.id.locationText);
        placeNameText = (TextView)findViewById(R.id.placeName);

        //이전 화면에서 보낸 좌표값을 받아온다.
        i = getIntent().getExtras().getInt("placeImg");
        placePosition = getIntent().getExtras().getInt("placePosition");
        placeName = getIntent().getExtras().getString("placeName");
        FileReader sub = new FileReader(this,file[placePosition]);

        tour.setImageResource(i);
        locationText.setText(sub.sb);
        placeNameText.setText("  " + placeName);
    }

//    @Override
//    protected void onDestroy() {
//        Log.d("OOMTEST", "onDestroy");
//        recycleBitmap(tour);
//
//        super.onDestroy();
//    }

//    private static void recycleBitmap(ImageView iv) {
//        Drawable d = iv.getDrawable();
//        if (d instanceof BitmapDrawable) {
//            Bitmap b = ((BitmapDrawable)d).getBitmap();
//            b.recycle();
//        } // 현재로서는 BitmapDrawable 이외의 drawable 들에 대한 직접적인 메모리 해제는 불가능하다.
//
//        d.setCallback(null);
//    }
}
