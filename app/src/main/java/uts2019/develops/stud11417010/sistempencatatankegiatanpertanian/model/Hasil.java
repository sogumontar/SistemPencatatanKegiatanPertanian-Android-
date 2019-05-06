package uts2019.develops.stud11417010.sistempencatatankegiatanpertanian.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Hasil {
    @SerializedName("hasil")
    List<uts2019.develops.stud11417010.sistempencatatankegiatanpertanian.model.Mahasiswa> mahasiswas;

    public List<uts2019.develops.stud11417010.sistempencatatankegiatanpertanian.model.Mahasiswa> getMahasiswas() {
        return mahasiswas;
    }

    public void setMahasiswas(List<uts2019.develops.stud11417010.sistempencatatankegiatanpertanian.model.Mahasiswa> mahasiswas) {
        this.mahasiswas = mahasiswas;
    }

}
