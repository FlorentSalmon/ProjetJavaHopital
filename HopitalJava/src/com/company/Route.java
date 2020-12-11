package com.company;

import java.util.Scanner;

public class Route {

    public static void route(){
        System.out.println("Vous êtes au bout de la route devant un petit immeuble en brique. Un petit ruisseau coule\n" +
                "a côté du building en bas d’une rigole.\n");
        System.out.println("Direction possible :");
        System.out.println("Entrez 'n' pour aller vers le nord.\n"+ "Entrez 's' pour aller vers le sud.\n" +
                "Entrez 'o' pour aller vers l'ouest.\n" + "Entrez 'e' pour aller vers l'est.\n");
        System.out.println("Entrez 'q' pour quitter et revenir au menu principal");

        while (true) {
            Scanner scan = new Scanner(System.in);
            String choix = scan.nextLine();
            switch (choix) {
                case "s": // Sud
                    Vallee.valee();
                    break;

                case "n": //  Nord
                    Foret.foret();
                    break;

                case "o": // Ouest
                    Colline.colline();
                    break;

                case "e": // Est
                    Building.building();
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
