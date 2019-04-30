package uts2019.develops.stud11417010.sistempencatatankegiatanpertanian.Penanaman;

public class model {
    private String nama,kelas,nim;

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public String getKelas() {
        return kelas;
    }

    public String getNim() {
        return nim;
    }

    public model(String nama, String kelas, String nim){
        this.nama=nama;
        this.kelas=kelas;
        this.nim=nim;
    }
}
