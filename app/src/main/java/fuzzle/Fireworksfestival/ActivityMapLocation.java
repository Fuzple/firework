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
            R.raw.location_gwangan_bridge,R.raw.location_hwangryeong_mt,R.raw.location_busan_station,R.raw.location_busan_harbor_bridge,
            R.raw.location_un_memorial_cemetery,R.raw.location_busan_museum,R.raw.location_yonghoman,R.raw.location_haeundae_beach,
            R.raw.location_peace_park,R.raw.location_gwangbokro,R.raw.location_songjeong_station,R.raw.location_east_busan_tourism,
            R.raw.location_fisheries_science_museum,R.raw.location_haedong_yonggungsa,R.raw.location_songjeong_beach,R.raw.location_dalmaji_gil_road,R.raw.location_oryukdo_island};

    int i;     //좌표값을 받아오기 위한 더블 배열
    int placePosition;
    String placeName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_location);

        tour = (ImageView) findViewById(R.id.tour);
        locationText = (TextView) findViewById(R.id.locationText);
        placeNameText = (TextView) findViewById(R.id.placeName);

        //이전 화면에서 보낸 좌표값을 받아온다.
        i = getIntent().getExtras().getInt("placeImg");
        placePosition = getIntent().getExtras().getInt("placePosition");
        placeName = getIntent().getExtras().getString("placeName");
        FileReader sub = new FileReader(this, file[placePosition]);

        tour.setImageResource(i);
        locationText.setText(sub.sb);
        placeNameText.setText("  " + placeName);
    }
}
