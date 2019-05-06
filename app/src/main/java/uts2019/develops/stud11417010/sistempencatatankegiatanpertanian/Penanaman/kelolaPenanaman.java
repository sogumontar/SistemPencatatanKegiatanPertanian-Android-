package uts2019.develops.stud11417010.sistempencatatankegiatanpertanian.Penanaman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uts2019.develops.stud11417010.sistempencatatankegiatanpertanian.API.Client;
import uts2019.develops.stud11417010.sistempencatatankegiatanpertanian.Model.Hasil;
import uts2019.develops.stud11417010.sistempencatatankegiatanpertanian.R;
import uts2019.develops.stud11417010.sistempencatatankegiatanpertanian.model.Mahasiswa;

public class kelolaPenanaman extends AppCompatActivity {

    private RecyclerView rv;
    private penanamanAdapter pa;
    private List<Mahasiswa> pArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_penanaman);
        Call<Hasil> cal = Client
                .getInstance()
                .getApi()
                .getUser();

        cal.enqueue(new Callback<Hasil>() {
            @Override
            public void onResponse(Call<Hasil> call, Response<Hasil> response) {
                pArr = response.body().getMahasiswas();
                Log.i("mahasis", ""+pArr.size());
                rv=findViewById(R.id.recycler_view);
                pa=new penanamanAdapter(pArr);
                RecyclerView.LayoutManager lm=new LinearLayoutManager(kelolaPenanaman.this);
                rv.setLayoutManager(lm);
                rv.setAdapter(pa);
                Toast.makeText(kelolaPenanaman.this,"Hasil : "+pArr.size(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Hasil> call, Throwable t) {
                Toast.makeText(kelolaPenanaman.this,t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

//        addData();


    }
//    public void addData(){
//        pArr=new ArrayList<>();
//        pArr.add(new model("hendra","D4Ti","11417010"));
//        pArr.add(new model("benyamin", "D4Ti","11417001"));
//        pArr.add(new model("hendra","D4Ti","11417010"));
//        pArr.add(new model("benyamin", "D4Ti","11417001"));
//        pArr.add(new model("hendra","D4Ti","11417010"));
//        pArr.add(new model("benyamin", "D4Ti","11417001"));
//        pArr.add(new model("hendra","D4Ti","11417010"));
//        pArr.add(new model("benyamin", "D4Ti","11417001"));
//        pArr.add(new model("hendra","D4Ti","11417010"));
//        pArr.add(new model("benyamin", "D4Ti","11417001"));
//        pArr.add(new model("hendra","D4Ti","11417010"));
//        pArr.add(new model("benyamin", "D4Ti","11417001"));
//        pArr.add(new model("hendra","D4Ti","11417010"));
//        pArr.add(new model("benyamin", "D4Ti","11417001"));
//        pArr.add(new model("hendra","D4Ti","11417010"));
//        pArr.add(new model("benyamin", "D4Ti","11417001"));
//        pArr.add(new model("hendra","D4Ti","11417010"));
//        pArr.add(new model("benyamin", "D4Ti","11417001"));
//        pArr.add(new model("hendra","D4Ti","11417010"));
//        pArr.add(new model("benyamin", "D4Ti","11417001"));
//        pArr.add(new model("hendra","D4Ti","11417010"));
//        pArr.add(new model("benyamin", "D4Ti","11417001"));
//        pArr.add(new model("hendra","D4Ti","11417010"));
//        pArr.add(new model("benyamin", "D4Ti","11417001"));
//    }
}
