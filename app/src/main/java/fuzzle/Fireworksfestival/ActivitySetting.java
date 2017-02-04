package fuzzle.Fireworksfestival;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Locale;

public class ActivitySetting extends AppCompatActivity {

    //데이터 베이스 변수
    private MySQLiteOpenHelper helper;
    String dbName = "firework.db";
    int dbVersion = 1; // 데이터베이스 버전
    private SQLiteDatabase db;      //db변수
    String tag = "SQLite"; // Log 에 사용할 tag
    String name = "";   //쿼리 결과값을 저장할 변수
    int id;

    RadioGroup setting_Language;
    Button setting_Select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        //데이터베이스를 시작한다.
        helper = new MySQLiteOpenHelper(this,dbName,null,dbVersion);
        try {
            db = helper.getWritableDatabase();
        }catch (SQLiteException e){         //데이터베이스가 없을 경우
            e.printStackTrace();
            Log.e(tag,"데이터베이스를 찾지 못하였습니다.");
            finish();
        }

        setting_Language = (RadioGroup)findViewById(R.id.settint_Language);
        setting_Select = (Button)findViewById(R.id.setting_Select);
        setting_Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = setting_Language.getCheckedRadioButtonId();

                RadioButton rb_language = (RadioButton)findViewById(id);

                if(rb_language.getText().equals(" 한국어"))
                {
                    update("korea");
                    lenguageSelect("korea");
                }else if(rb_language.getText().equals(" English"))
                {
                    update("english");
                    lenguageSelect("english");
                }
                Intent intent = new Intent(getApplicationContext(),ActivityMain.class);
                startActivity(intent);
                finish();
            }
        });
    }
    //언어 설정 메소드
    void lenguageSelect(String lenguage){
        if(lenguage == "korea") {
            System.out.println("언어는: "+lenguage);
            Locale en = Locale.KOREA;
            Configuration config = new Configuration();
            config.locale = en;
            getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        }
        else if(lenguage == "english"){
            System.out.println("언어는: "+lenguage);
            Locale en = Locale.US;
            Configuration config = new Configuration();
            config.locale = en;
            getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        }
    }

    //데이터베이스 수정문
    void update(String lenguage){
        // firework테이블에 id가 1인
        db.execSQL("update firework set lenguage = '" + lenguage + "' where id = 1;");
        Log.d(tag, "update 성공~!");
    }
}