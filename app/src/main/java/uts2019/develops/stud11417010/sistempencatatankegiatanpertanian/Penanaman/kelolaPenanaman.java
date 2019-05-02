package uts2019.develops.stud11417010.sistempencatatankegiatanpertanian.Penanaman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import uts2019.develops.stud11417010.sistempencatatankegiatanpertanian.R;
public class kelolaPenanaman extends AppCompatActivity {

    private RecyclerView rv;
    private penanamanAdapter pa;
    private ArrayList<model>pArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_penanaman);
        addData();

        rv=findViewById(R.id.recycler_view);
        pa=new penanamanAdapter(pArr);
        RecyclerView.LayoutManager lm=new LinearLayoutManager(kelolaPenanaman.this);
        rv.setLayoutManager(lm);
        rv.setAdapter(pa);
    }
    public void addData(){
        pArr=new ArrayList<>();
        pArr.add(new model("hendra","D4Ti","11417010"));
        pArr.add(new model("benyamin", "D4Ti","11417001"));
        pArr.add(new model("hendra","D4Ti","11417010"));
        pArr.add(new model("benyamin", "D4Ti","11417001"));
        pArr.add(new model("hendra","D4Ti","11417010"));
        pArr.add(new model("benyamin", "D4Ti","11417001"));
        pArr.add(new model("hendra","D4Ti","11417010"));
        pArr.add(new model("benyamin", "D4Ti","11417001"));
        pArr.add(new model("hendra","D4Ti","11417010"));
        pArr.add(new model("benyamin", "D4Ti","11417001"));
        pArr.add(new model("hendra","D4Ti","11417010"));
        pArr.add(new model("benyamin", "D4Ti","11417001"));
        pArr.add(new model("hendra","D4Ti","11417010"));
        pArr.add(new model("benyamin", "D4Ti","11417001"));
        pArr.add(new model("hendra","D4Ti","11417010"));
        pArr.add(new model("benyamin", "D4Ti","11417001"));
        pArr.add(new model("hendra","D4Ti","11417010"));
        pArr.add(new model("benyamin", "D4Ti","11417001"));
        pArr.add(new model("hendra","D4Ti","11417010"));
        pArr.add(new model("benyamin", "D4Ti","11417001"));
        pArr.add(new model("hendra","D4Ti","11417010"));
        pArr.add(new model("benyamin", "D4Ti","11417001"));
        pArr.add(new model("hendra","D4Ti","11417010"));
        pArr.add(new model("benyamin", "D4Ti","11417001"));
    }
}
