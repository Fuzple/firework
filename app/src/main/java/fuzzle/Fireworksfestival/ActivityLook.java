package fuzzle.Fireworksfestival;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityLook extends AppCompatActivity {
    int[] file = {R.raw.place,R.raw.place1,R.raw.place5};
    //인텐트로 받은 데이터
    int getdata;
    int placeImg;
    String topText;
    ImageView temp,look_moire;
    TextView txt, loot_topText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look);

        //이전 엑티비티에서 값을 받아온다.
        Intent intent = getIntent();
        getdata = intent.getExtras().getInt("data");                //파일을 불러올 위치의 포지션값
        placeImg = intent.getExtras().getInt("placeImg");          //이미지 파일의 주소
        topText = intent.getExtras().getString("topText");

        temp = (ImageView)findViewById(R.id.temp);
        look_moire = (ImageView)findViewById(R.id.look_moire);
        loot_topText = (TextView)findViewById(R.id.look_topText);

        temp.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), placeImg)));
        look_moire.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(),R.drawable.look_moire)));

        loot_topText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.look_text_icon,0,0,0);
        loot_topText.setText(topText);

        if(file.length > getdata) {
            FileReader sub = new FileReader(this, file[getdata]);
            txt = (TextView) findViewById(R.id.txtPlace);
            txt.setText(sub.sb);
        }else{
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        Log.d("OOMTEST", "onDestroy");      //
        recycleBitmap(temp);
        recycleBitmap(look_moire);

        super.onDestroy();
    }

    private static void recycleBitmap(ImageView iv) {
        Drawable d = iv.getDrawable();
        if (d instanceof BitmapDrawable) {
            Bitmap b = ((BitmapDrawable)d).getBitmap();
            b.recycle();
        } // 현재로서는 BitmapDrawable 이외의 drawable 들에 대한 직접적인 메모리 해제는 불가능하다.

        d.setCallback(null);
    }
}
