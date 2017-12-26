package fuzzle.Fireworksfestival;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import android.view.WindowManager;
import android.util.DisplayMetrics;

import com.bumptech.glide.Glide;

public class ActivityTraffic extends AppCompatActivity {
    TextView txtTour;
    ImageView imgTour,trafficBackImg;
    int trafficPosition;
    int[] file = {R.raw.traffic_subway,R.raw.traffic_bus,R.drawable.traffic_tour1,R.drawable.traffic_tour2};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic);

        Intent intent = getIntent();
        trafficPosition = getIntent().getExtras().getInt("trafficPosition");
        imgTour = (ImageView)findViewById(R.id.imgTour);
        trafficBackImg = (ImageView)findViewById(R.id.trafficBackImg);
        txtTour = (TextView)findViewById(R.id.txtTour);

        Glide.with(this).load(R.drawable.sub_background).centerCrop().crossFade().into(trafficBackImg);

        if(trafficPosition <= 1) {
            FileReader sub = new FileReader(this, file[trafficPosition]);
            txtTour.setText(sub.sb);
//            imgTour.setImageResource(R.drawable.traffic_map);
            Glide.with(this).load(R.drawable.traffic_map).centerCrop().crossFade().into(imgTour);
        }
        else if(trafficPosition >= 2){
            txtTour.setText("");

            DisplayMetrics metrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) getApplicationContext()
                    .getSystemService(Context.WINDOW_SERVICE);
            windowManager.getDefaultDisplay().getMetrics(metrics);
            LayoutParams params = (LayoutParams) imgTour.getLayoutParams();
            params.width = metrics.widthPixels;
            params.height = metrics.heightPixels;

            imgTour.setLayoutParams(params);
//            imgTour.setImageResource(file[trafficPosition]);
            Glide.with(this).load(file[trafficPosition]).centerCrop().crossFade().into(imgTour);
        }
    }
}