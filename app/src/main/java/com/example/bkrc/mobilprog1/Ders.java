package com.example.bkrc.mobilprog1;

public class Ders {

    private String dersAdi;
    private String not;
    private String notOrtalaması;
    private String ogrenciSayisi;

    public Ders(String dersAdi, String not, String notOrtalaması, String ogrenciSayisi) {
        this.dersAdi = dersAdi;
        this.not = not;
        this.notOrtalaması = notOrtalaması;
        this.ogrenciSayisi = ogrenciSayisi;
    }

    public Ders(String dersAdi, String not) {
        this.dersAdi = dersAdi;
        this.not=not;
    }

    public String getNot() {
        return not;
    }

    public void setNot(String not) {
        this.not = not;
    }

    public String getDersAdi() {
        return dersAdi;
    }

    public void setDersAdi(String dersAdi) {
        this.dersAdi = dersAdi;
    }

    public String getNotOrtalaması() {
        return notOrtalaması;
    }

    public void setNotOrtalaması(String notOrtalaması) {
        this.notOrtalaması = notOrtalaması;
    }

    public String getOgrenciSayisi() {
        return ogrenciSayisi;
    }

    public void setOgrenciSayisi(String  ogrenciSayisi) {
        this.ogrenciSayisi = ogrenciSayisi;
    }
}
