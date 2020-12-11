package com.company;

import java.util.Scanner;

public class MenuPrincipal {

    public static void menuPricipal(){
        Scanner scan = new Scanner(System.in);
        String choix;
        System.out.println("|-------------------------------------|");
        System.out.println("|BIENVENUE DANS LE TERMINAL DE LOISIR!|");
        System.out.println("|-------------------------------------|");
        System.out.println(" ");
        System.out.println("Tapez 'jeu' pour accéder au jeu 'COLOSSAL CAVE'.");
        System.out.println("Tapez 'musique' pour accéder au lecteur MP3.");
        System.out.println("Tapez 'quitter' pour quitter.");

        while(true){
            choix = scan.nextLine();
            switch(choix){
                case "jeu":
                    ClearConsole();
                    MenuJeu.afficherMenuJeu();
                    break;
                case "musique":
                    ClearConsole();
                    MenuPlaylist menuPlaylist = new MenuPlaylist();
                    menuPlaylist.chargerPlaylist();
                    menuPlaylist.menuPlaylist();
                    break;
                case "quitter":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Commande invalide");
            }
        }
    }
    public static void ClearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

    }

}
