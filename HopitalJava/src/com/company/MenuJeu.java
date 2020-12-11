package com.company;

import java.util.Scanner;

public class MenuJeu {
    public static void afficherMenuJeu(){
        boolean inTheMenu = true;
        System.out.println("|-------------------------------------|");
        System.out.println("      BIENVENUE SUR COLOSSAL CAVE     ");
        System.out.println("|-------------------------------------|");
        System.out.println("Tapez 'Entrer' pour commencer la partie.");
        System.out.println("Tapez 'Retour' pour retourner au menu principal.");
        System.out.println("Tapez 'Quitter' pour quitter.");


        while(inTheMenu){
            Scanner myScan = new Scanner(System.in);
            String userInput = myScan.nextLine();

            switch(userInput){
                case "Entrer", "entrer":
                    ClearConsole();
                    Route.route();
                    break;

                case "Retour", "retour":
                    ClearConsole();
                    MenuPrincipal.menuPricipal();

                    break;

                case "Quitter", "quitter":
                    System.out.println("Le logiciel va se fermer");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Je ne comprends pas");
            }
        }
    }
    public static void ClearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

    }
}

