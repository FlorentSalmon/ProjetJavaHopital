package com.company;

import java.util.Scanner;

public class Vallee {
    public static void valee() {
        System.out.println("Vous êtes dans une vallée a coté d’un ruisseau. Un corps flotte là dans l’eau.\n");
        System.out.println("Direction possible :");
        System.out.println("Entrez 'n' pour aller vers le nord.\n" + "Entrez 'o' pour aller vers l'ouest.");
        System.out.println("Entrez 'q' pour quitter et revenir au menu principal");

        while (true) {
            Scanner scan = new Scanner(System.in);
            String choix = scan.nextLine();
            switch (choix) {

                case "n": // Nord
                    Route.route();
                    break;

                case "o": // Ouest
                    Colline.colline();
                    break;

                case "q": // Quitter
                    MenuPrincipal.menuPricipal();
                    break;

                default:
                    System.out.println("Commande non valide.");
            }
        }

    }
}