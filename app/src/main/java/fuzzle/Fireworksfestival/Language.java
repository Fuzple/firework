package fuzzle.Fireworksfestival;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Locale;

public class Language extends AppCompatActivity {
    RadioGroup radioGroup;

    //데이터 베이스 변수
    private MySQLiteOpenHelper helper;
    String dbName = "firework.db";
    int dbVersion = 1; // 데이터베이스 버전
    private SQLiteDatabase db;      //db변수
    String tag = "SQLite"; // Log 에 사용할 tag
    String name = "";   //쿼리 결과값을 저장할 변수
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        //데이터베이스를 시작한다.
        helper = new MySQLiteOpenHelper(this,dbName,null,dbVersion);
        try {
            db = helper.getWritableDatabase();
        }catch (SQLiteException e){         //데이터베이스가 없을 경우
            e.printStackTrace();
            Log.e(tag,"데이터베이스를 찾지 못하였습니다.");
            finish();
        }

        select();

        if (name.equals("")) {
            Log.e(tag, "데이터베이스를 찾지 못하였습니다.");
        } else if(name.equals("korea")){
//                insert();
            Intent intent =  new Intent(getApplicationContext(),ActivityMain.class);
            startActivity(intent);
            Log.e(tag, "검색 완료");
            finish();

        }

        radioGroup = (RadioGroup)findViewById(R.id.radiogroup);
        Button language_btn = (Button)findViewById(R.id.language_btn);
        language_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = radioGroup.getCheckedRadioButtonId();

                RadioButton rb = (RadioButton)findViewById(id);

                if(rb.getText().equals("     한국어"))
                {
                    Locale en = Locale.KOREA;
                    Configuration config = new Configuration();
                    config.locale = en;
                    getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                }else if(rb.getText().equals("     English"))
                {
                    Locale en = Locale.US;
                    Configuration config = new Configuration();
                    config.locale = en;
                    getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                }

                Intent intent = new Intent(getApplicationContext(), ActivityMain.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public boolean onKeyDown(int keyCode, KeyEvent event)    {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0)        {
            Intent intent = new Intent(getApplicationContext(),ActivityMain.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    void insert () {
        db.execSQL("insert into mytable (lenguage,menual) values('null','null');");
        Log.d(tag, "insert 성공~!");
    }
    void select() {
        Cursor c = db.rawQuery("select * from firework", null);
        while(c.moveToNext()) {
            id = c.getInt(0);
            name = c.getString(1);
            Log.d(tag,"id:"+id+",name:"+name);
        }
    }
}

