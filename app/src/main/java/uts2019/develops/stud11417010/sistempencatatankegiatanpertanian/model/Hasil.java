package uts2019.develops.stud11417010.sistempencatatankegiatanpertanian.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Hasil {
    @SerializedName("hasil")
    List<Mahasiswa> mahasiswas;

    public List<Mahasiswa> getMahasiswas() {
        return mahasiswas;
    }

    public void setMahasiswas(List<Mahasiswa> mahasiswas) {
        this.mahasiswas = mahasiswas;
    }

}
