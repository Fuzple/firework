package fuzzle.Fireworksfestival;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toast.makeText(getApplicationContext(), "게임은 아직 준비중입니다.", Toast.LENGTH_SHORT).show();
    }
}
