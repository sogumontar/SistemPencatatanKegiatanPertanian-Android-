package uts2019.develops.stud11417010.sistempencatatankegiatanpertanian.model;

import com.google.gson.annotations.SerializedName;

public class Mahasiswa {
    @SerializedName("nama")
    private String nama;

    @SerializedName("kelas")
    private String kelas;

    @SerializedName("nim")
    private String nim;

    public String getNama() {
        return nama;
    }

    public Mahasiswa() {
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }



}
