package uts2019.develops.stud11417010.sistempencatatankegiatanpertanian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

import uts2019.develops.stud11417010.sistempencatatankegiatanpertanian.Penanaman.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void pindah(View v){
        Intent i=new Intent(MainActivity.this,kelolaPenanaman.class);
        startActivity(i);
        finish();
    }
    public void tambah(View v){
        Intent i=new Intent(MainActivity.this,tambahData.class);
        startActivity(i);
        finish();
    }
}
