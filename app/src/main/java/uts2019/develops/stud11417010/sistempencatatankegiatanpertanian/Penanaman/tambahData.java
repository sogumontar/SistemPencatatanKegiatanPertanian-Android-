package uts2019.develops.stud11417010.sistempencatatankegiatanpertanian.Penanaman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uts2019.develops.stud11417010.sistempencatatankegiatanpertanian.*;
import uts2019.develops.stud11417010.sistempencatatankegiatanpertanian.API.Client;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;

public class tambahData extends AppCompatActivity {

    String nama="ss";
    String kelas="asd";
    String nim="11417010";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);

    }

    public void tambahdat(View v) {
        Call<ResponseBody> cal = Client
                .getInstance()
                .getApi()
                .createuser(nama,kelas,nim);
        cal.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String s=null;
                try {
                    s=response.body().string();
                    Toast.makeText(tambahData.this,s, Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(tambahData.this,"asdssss", Toast.LENGTH_LONG).show();
            }


            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(tambahData.this,t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
    public void lihatData(){

    }

}
