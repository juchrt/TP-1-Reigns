package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;

/**
 * La classe Reigns représente le programme principal du jeu Reigns
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Reigns {

    /**
     * la banque de questions
     */
    private static BanqueQuestions questions;

    /**
     * La méthode main lance le jeu Reigns. Il initialise les questions, le
     * personnage,
     * affiche les jauges du personnage et lance une boucle de jeu qui se termine
     * lorsque le personnage perd.
     * Il affiche également le nombre de tours de jeu que le personnage a joué.
     *
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args) {

        System.out.println("Bienvenue sur Reigns");
        System.out.println("Création de la partie et du personnage...");
        Partie partie = new Partie(BanqueQuestions.initBanqueQuestions());

        // début du jeu
        partie.initialiserPartie();

        // tirage des questions
        partie.toursDeJeu();

        // fin du jeu
        partie.finDePartie();
    }
}