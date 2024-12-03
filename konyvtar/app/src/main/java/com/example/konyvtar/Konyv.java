package com.example.konyvtar;

public class Konyv {
    private String cim;
    private String szerzo;
    private int oldal;

    public Konyv(String cim, String szerzo, int oldal) {
        this.cim = cim;
        this.szerzo = szerzo;
        this.oldal = oldal;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getSzerzo() {
        return szerzo;
    }

    public void setSzerzo(String szerzo) {
        this.szerzo = szerzo;
    }

    public int getOldal() {
        return oldal;
    }

    public void setOldal(int oldal) {
        this.oldal = oldal;
    }
}
