package com.company;

import java.io.Serializable;
import java.util.ArrayList;



public class Playlist implements Serializable {
    private ArrayList<Song> playlist;

    public Playlist() {
        playlist = new ArrayList<Song>();
    }

    public void ajouterSong (Song song) {
        playlist.add(song);
    }

    public int getPlaylistSize() {
        return playlist.size();
    }


    // Get avec Index

    public String getArtiste(int index) {
        return playlist.get(index).getArtiste();
    }
    public String getTitre(int index) {
        return playlist.get(index).getTitre();
    }
    public String getDuree(int index) {
        return playlist.get(index).getDuree();
    }



    public void supprimerPlaylist() {
        if(playlist.size() == 0) { // Si la playlist est vide
            System.out.print("La Playlist est vide!\n");

        } else {
            playlist.clear(); // Supprimer la playlist
            System.out.print("La Playlist à été supprimée!.\n");
        }
    }

    public void supprimerSong(int index) { // Supprime musique par l'index

        playlist.remove(index-1);
        System.out.println("La musique numéro " + index + " a bien été supprimée de votre playlist");
    }
}
