package com.company;

import java.util.Scanner;

public class Colline {

    public static void colline() {
        System.out.println("Vous êtes tout en haut d’une colline qui surplombe la ville, au loin vous voyez une ombre\n" +
                "se déplacer a grande vitesse avec un grand couteau.\n");
        System.out.println("Entrez 'n' pour aller vers le nord.");
        System.out.println("Entrez 'q' pour quitter et revenir au menu principal");

        while (true) {
            Scanner scan = new Scanner(System.in);
            String choix = scan.nextLine();
            switch (choix) {
                case "n": // Nord
                    Foret.foret();
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
