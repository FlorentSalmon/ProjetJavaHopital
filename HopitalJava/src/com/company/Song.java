package com.company;

import java.io.Serializable;

public class Song  implements Serializable {
    private String artiste;
    private String titre;
    private String duree;

    public Song(String artiste, String titre, String duree) {
        this.artiste = artiste;
        this.titre = titre;
        this.duree = duree;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getArtiste() {
        return artiste;
    }

    public String getTitre() {
        return titre;
    }

    public String getDuree() {
        return duree;
    }
}
