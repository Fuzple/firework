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
import android.os.SystemClock;
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
    private SQLiteDatabase db = null;      //db변수
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
        System.out.println(name);
        if (name.equals("")) {
            insert();
            select();
            Log.e(tag, "데이터베이스에 값이 존재하지 않습니다.");
        } else if(name.equals("korea")  || name.equals("english")){
            lenguageSelect(name);
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
                    update("korea");
                    lenguageSelect("korea");
                }else if(rb.getText().equals("     English"))
                {
                    update("english");
                    lenguageSelect("english");
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

    //언어 설정 메소드
    void lenguageSelect(String lenguage){
        if(lenguage.equals("korea")) {
            System.out.println("언어는: " + lenguage);
            Locale en = Locale.KOREA;
            Configuration config = new Configuration();
            config.locale = en;
            getResources().updateConfiguration(config, getResources().getDisplayMetrics());
            Log.d(tag, "언어 변경 성공~!");
        }
        else if(lenguage.equals("english")){
            System.out.println("언어는: " + lenguage);
            Locale en = Locale.US;
            Configuration config = new Configuration();
            config.locale = en;
            getResources().updateConfiguration(config, getResources().getDisplayMetrics());
            Log.d(tag, "언어 변경 성공~!");
        }
    }

    //데이터베이스 삽입문
    void insert () {
        //테이블에 값을 삽입한다.
        db.execSQL("insert into firework (lenguage,menual) values('korea','off');");
        Log.d(tag, "insert 성공~!");
    }
    //데이터베이스 검색문
    void select() {
        // firework테이블 전체를 검색한다.
        Cursor c = db.rawQuery("select * from firework", null);
        while(c.moveToNext()) {
            id = c.getInt(0);
            name = c.getString(1);
            Log.d(tag,"id:"+id+",name:"+name);
        }
    }
    //데이터베이스 수정문
    void update(String lenguage){
        // firework테이블에 id가 1인
        db.execSQL("update firework set lenguage = '" + lenguage + "' where id = 1;");
        Log.d(tag, "update 성공~!");
    }
}

