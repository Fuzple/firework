package fuzzle.Fireworksfestival;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class ActivityMain extends AppCompatActivity {

    private MySQLiteOpenHelper helper;
    String dbName = "st_file.db";
    int dbVersion = 1; // 데이터베이스 버전
    private SQLiteDatabase db;      //db변수
    String tag = "SQLite"; // Log 에 사용할 tag

    String name = "";   //쿼리 결과값을 저장할 변수
    int id;

    Button btn_fire, btn_look, btn_location, btn_traffic,btn_Setting,btn_gamestart;
    ImageView main_background;
    Boolean coach = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_background = (ImageView) findViewById(R.id.main_background);

        btn_gamestart = (Button) findViewById(R.id.btn_Gamestart);
        btn_Setting = (Button)findViewById(R.id.btn_Setting);
        btn_fire = (Button) findViewById(R.id.btn_Fire);
        btn_look = (Button) findViewById(R.id.btn_Look);
        btn_location = (Button) findViewById(R.id.btn_Location);
        btn_traffic = (Button) findViewById(R.id.btn_Traffic);

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
        //데이터베이스를 검색해서 "Mark"값이 있으면 코치마크를 실행하지 않고, 없으면 코치마크 실행후
        // 데이터베이스에 Mark 값을 추가한다.
        //코치마크를 첫 실행에만 나오게 하기 위해 사용했음.
        try {
            if (name.equals("Mark")) {
                Log.e(tag, "데이터베이스를 찾지 못하였습니다.");
            } else if(name.equals("")){
                coachmark();
//                insert();
            }
        }catch (NullPointerException e){
            e.printStackTrace();
            Log.e(tag,"데이터베이스가 없습니다.");
        }

        btn_gamestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select (); // select 문 - 조회
            }
        });

        btn_fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMain.this
                        , ActivitySub.class);
                intent.putExtra("btnId", 0);
                startActivityForResult(intent,0);
            }
        });
        btn_look.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMain.this, ActivitySub.class);
                intent.putExtra("btnId", 1);
                startActivityForResult(intent,0);
            }
        });
        btn_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMain.this, ActivitySub.class);
                intent.putExtra("btnId", 2);
                startActivityForResult(intent,0);
            }
        }
        );
        btn_traffic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMain.this, ActivitySub.class);
                intent.putExtra("btnId",3);
                startActivityForResult(intent,0);
            }
        });
        btn_Setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMain.this, ActivitySetting.class);
                startActivity(intent);
            }
        });

    }
    void delete() {
        db.execSQL("delete from mytable");
        Log.d(tag, "delete 완료");
    }

    void select() {
        Cursor c = db.rawQuery("select * from mytable;", null);
        while(c.moveToNext()) {
            id = c.getInt(0);
            name = c.getString(1);
            Log.d(tag,"id:"+id+",name:"+name);
        }
    }

    void insert () {
        db.execSQL("insert into mytable (name) values('Mark');");
        Log.d(tag, "insert 성공~!");
    }

    public void coachmark(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        dialog.setContentView(R.layout.activity_gray);
        dialog.setCanceledOnTouchOutside(true);
        //for dismissing anywhere you touch
        View masterView = dialog.findViewById(R.id.coach_mark_master_view);
        masterView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        //레이아웃 크기 조절
        ViewGroup.LayoutParams params = dialog.getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;

        dialog.show();
        dialog.getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
        //조절 끝
    }

    public boolean onKeyDown(int keyCode, KeyEvent event)    {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0)        {
            // 팝업을 띄움
            AlertDialog dialog;
            dialog = new AlertDialog.Builder(this).setTitle("종료확인")//.setIcon(R.drawable.warning)
                    .setMessage("종료하시겠습니까?")
                    .setPositiveButton("예", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // TODO Auto-generated method stub
                            //dialog.dismiss();
                            finish();
                        }
                    })
                    .setNegativeButton("아니요", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            // TODO Auto-generated method stub
                            dialog.cancel();
                        }
                    })
                    .show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
