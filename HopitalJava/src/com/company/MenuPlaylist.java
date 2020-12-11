package com.company;

import java.io.*;
import java.util.Scanner;

public class MenuPlaylist {
    private Scanner scan = new Scanner(System.in);
    private Playlist playlist = new Playlist();

    public String montrerMenu() {
        String choix;
        System.out.print("\nQue voulez-vous faire?"
                + "\n1 - Ajouter musique"+ "\n2 - Voir playlist"
                + "\n3 - Supprimer une musique" + "\n4 - Ecouter playlist"
                + " \n5 - Supprimer la playlist" + "\n6 - Retour au menu principal"
                + "\n7 - Quitter" +"\nChoix: ");
        choix = scan.nextLine();
        System.out.print("\n");
        return choix;
    }
    public void menuPlaylist() {
        String choix = montrerMenu();
        while(true){
            switch (choix) {
                case "1": // Ajout Musique
                    ajouterSong();
                    sauvagarderPlaylist();
                    menuPlaylist();
                    break;
                case "2": // Voir Playlist
                    voirPlaylist();
                    menuPlaylist();
                    break;
                case "3": // Supprimer une musique
                    supprimerSong();
                    sauvagarderPlaylist();
                    menuPlaylist();
                    break;
                case "4": // Lancer écoute
                    menuEcoute();
                    break;
                case "5": // Supprimer la Playlist
                    playlist.supprimerPlaylist();
                    sauvagarderPlaylist();
                    menuPlaylist();
                    break;
                case "6": // Retour menu Principal
                    MenuPrincipal.menuPricipal();
                    break;
                case "7": // Quitter
                    sauvagarderPlaylist();
                    System.out.println("A bientôt !");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nCommande non valide !\n");
                    menuPlaylist();
            }
        }
    }
    public void ajouterSong() {
        Song nouvelleChanson = new Song(null, null, null); // Création d'un objet Musique

        System.out.print("Entrez un artiste: ");
        nouvelleChanson.setArtiste(scan.nextLine());
        System.out.print("Entrez un titre: ");
        nouvelleChanson.setTitre(scan.nextLine());
        System.out.print("Entrez une durée: ");
        nouvelleChanson.setDuree(scan.nextLine());

        playlist.ajouterSong(nouvelleChanson); // Ajout de la chanson dans Playlist

    }

    public void supprimerSong() {
        if(playlist.getPlaylistSize() == 0) {
            System.out.println("Votre playlist est vide");
        }
        else {
            System.out.println("Voici votre playlist, choisissez une musique à supprimer ");
            voirPlaylist();
            System.out.print("\nTapez le numéro de la musique que vous voulez supprimer : ");
            Scanner scannerSupprimerMusique = new Scanner(System.in);
            int inputSupprimerMusique = scannerSupprimerMusique.nextInt();
            playlist.supprimerSong(inputSupprimerMusique);
        }
    }

    public void voirPlaylist() {
        if(playlist.getPlaylistSize() == 0) {
            System.out.println("Votre playlist est vide");
        }
        else {
            System.out.println("Voici votre playlist :");
            for(int i = 0; i < playlist.getPlaylistSize(); i++) {
                System.out.print(("\n" + (i+1) + ") "));
                System.out.print(""+ playlist.getArtiste(i) + " - ");
                System.out.print("\"" +playlist.getTitre(i)+ "\"" + ", ");
                System.out.print("[" + playlist.getDuree(i) + "]");
            }
            System.out.print("\n");
        }
    }
    public void menuEcoute(){
        int index;
        int choix;
        while (true){
            voirPlaylist();
            System.out.print("\nEntrez le numero de la chanson" + "\nChoix: ");
            index = scan.nextInt() -1; // index = numeroFourni - 1
            if( (index <= playlist.getPlaylistSize() - 1) && (index >= 0) ){ // Vérifier si l'index correspond a un emplacement
                System.out.print("\n");
                System.out.println("Vous écoutez " + playlist.getTitre(index)
                        + " de " + playlist.getArtiste(index)
                        + " d'une durée de "+ playlist.getDuree(index));

                while(true){

                    System.out.print("\n1- Musique suivante" + "\n2- Musique précédente"
                            + "\n3- Réécouter musique" + "\n4- Selectionner une musique"
                            + " \n5- Retour menu" + "\nChoix: ");

                    choix = scan.nextInt();

                    switch (choix){

                        case 1: // Suivant
                            if(index < (playlist.getPlaylistSize() - 1) )
                                index = index + 1; // charger musique suivante
                            else
                                index = 0; // Charger la première musique de la playlist
                            System.out.print("\n");
                            System.out.println("Vous écoutez " + playlist.getTitre(index)
                                    + " de " + playlist.getArtiste(index)
                                    + " d'une durée de "+ playlist.getDuree(index));
                            break;

                        case 2: // Précédent
                            if(index > 0) // charger musique précédent
                                index = index - 1;
                            else
                                index = playlist.getPlaylistSize() - 1; // charger la dernière chanson de la Playlist
                            System.out.print("\n");
                            System.out.println("Vous écoutez " + playlist.getTitre(index)
                                    + " de " + playlist.getArtiste(index)
                                    + " d'une durée de "+ playlist.getDuree(index));
                            break;
                        case 3: // Réécoute (raffiche  la chanson actuelle)
                            System.out.print("\n");
                            System.out.println("Vous réécoutez " + playlist.getTitre(index)
                                    + " de " + playlist.getArtiste(index)
                                    + " d'une durée de "+ playlist.getDuree(index));
                            break;
                        case 4: // Selectionner une musique (relance menuEcoute)
                            menuEcoute();
                            break;
                        case 5: // Retour MenuPlaylist
                            System.out.println("Retour au menu");
                            menuPlaylist();
                            break;
                        default:
                            System.out.println("\nCommande non valide !\n");
                    }


                }

            }else{

                System.out.println("\nLe numéro est incorrect");
            }

        }


    }



    public void sauvagarderPlaylist(){ // Ecrire dans le fichier (sauvagarder)
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("playlist.txt");
            ObjectOutputStream outObjectStream = new ObjectOutputStream(fileOutputStream);

            outObjectStream.writeObject(playlist);

            outObjectStream.flush();
            outObjectStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Aucun fichier");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void chargerPlaylist() { // Pour récupérer le fichier au lancement du programme
        try {
            FileInputStream fileInputStream = new FileInputStream("playlist.txt");

            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            playlist = (Playlist)objectInputStream.readObject();

            objectInputStream.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("Aucun Fichier");
        }
        catch(IOException e) {
            System.out.println("IO");
        }

        catch(ClassNotFoundException e) {
            System.out.println("Ce n'est pas une Playlist.");
        }
    }



}
