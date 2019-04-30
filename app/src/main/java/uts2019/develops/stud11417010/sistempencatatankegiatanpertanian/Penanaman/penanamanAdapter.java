package uts2019.develops.stud11417010.sistempencatatankegiatanpertanian.Penanaman;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import uts2019.develops.stud11417010.sistempencatatankegiatanpertanian.R;

public class penanamanAdapter extends RecyclerView.Adapter<penanamanAdapter.penanamanViewHolder> {

    private ArrayList<model> dataList;

    public penanamanAdapter(ArrayList<model> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public penanamanAdapter.penanamanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View v = li.inflate(R.layout.activity_kelola_penanaman, parent, false);
        return new penanamanViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull penanamanAdapter.penanamanViewHolder penanamanviewHolder, int i) {
        penanamanviewHolder.nama.setText(dataList.get(i).getNama());
        penanamanviewHolder.kelas.setText(dataList.get(i).getKelas());
        penanamanviewHolder.nim.setText(dataList.get(i).getNim());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class penanamanViewHolder extends RecyclerView.ViewHolder {
        private TextView nama, kelas, nim;

        public penanamanViewHolder(View itemView) {
            super(itemView);
            nama = (TextView) itemView.findViewById(R.id.nama);
            kelas = (TextView) itemView.findViewById(R.id.kelas);
            nim = (TextView) itemView.findViewById(R.id.nim);
        }

    }
}
