package com.company;

import java.util.Scanner;

public class Building {
    public static void building() {
            System.out.println("Vous êtes a l’intérieur d’un building en brique, un petit refuge pour les bêtes. Un homme\n" +
                    "git là au milieu d’une marre de sang.\n");
            System.out.println("Entrez 'o' pour aller vers l'ouest.");
            System.out.println("Entrez 'q' pour quitter et revenir au menu principal");
        while (true) {
            Scanner scan = new Scanner(System.in);
            String choix = scan.nextLine();
            switch (choix) {
                case "o": // Ouest
                    Route.route();
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
