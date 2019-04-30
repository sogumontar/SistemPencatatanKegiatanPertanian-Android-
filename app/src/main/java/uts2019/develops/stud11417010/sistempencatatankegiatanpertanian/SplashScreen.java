package uts2019.develops.stud11417010.sistempencatatankegiatanpertanian;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import uts2019.develops.stud11417010.sistempencatatankegiatanpertanian.Penanaman.*;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, kelolaPenanaman.class);
                startActivity(i);
                finish();
            }
        },3000);
    }
}
