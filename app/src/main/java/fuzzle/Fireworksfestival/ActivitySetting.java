package fuzzle.Fireworksfestival;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Locale;

public class ActivitySetting extends AppCompatActivity {

    RadioGroup setting_Language;
    Button setting_Select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        setting_Language = (RadioGroup)findViewById(R.id.settint_Language);
        setting_Select = (Button)findViewById(R.id.setting_Select);
        setting_Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = setting_Language.getCheckedRadioButtonId();

                RadioButton rb_language = (RadioButton)findViewById(id);

                if(rb_language.getText().equals(" 한국어"))
                {
                    Locale en = Locale.KOREA;
                    Configuration config = new Configuration();
                    config.locale = en;
                    getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                }else if(rb_language.getText().equals(" English"))
                {
                    Locale en = Locale.US;
                    Configuration config = new Configuration();
                    config.locale = en;
                    getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                }

                Intent intent = new Intent(getApplicationContext(),ActivityMain.class);
                startActivity(intent);
            }
        });
    }
}