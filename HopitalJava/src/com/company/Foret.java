package com.company;

import java.util.Scanner;

public class Foret {
    public static void foret() {
        System.out.println("Vous êtes dans la foret noire. Vous entendez des hurlements stridents.\n");
        System.out.println("Entrez 's' pour aller vers le sud.");
        System.out.println("Entrez 'q' pour quitter et revenir au menu principal");
        while (true) {
            Scanner scan = new Scanner(System.in);
            String choix = scan.nextLine();
            switch (choix) {
                case "s": // Sud
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
