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
    private static ArrayList<Question> questions;

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
        Partie partie = new Partie(initBanqueQuestions());

        // début du jeu
        partie.initialiserPartie();

        // tirage des questions
        partie.toursDeJeu();

        // fin du jeu
        partie.finDePartie();
    }

    /**
     * Cette fonction initialise la banque de questions. Elle crée les questions et
     * les ajoute à la banque.
     */
    public static ArrayList<Question> initBanqueQuestions() {
        questions = new ArrayList<>();

        Reponse reponse1 = new Reponse();
        Effet effet1 = new Effet("Oui");
        Effet effet2 = new Effet("Non");
        Effet effet3 = new Effet("Je ne sais pas");

        effet1.remplirEffets(TypeJauge.CLERGE, 5);
        effet1.remplirEffets(TypeJauge.PEUPLE, 5);
        effet2.remplirEffets(TypeJauge.PEUPLE, -1);
        effet3.remplirEffets(TypeJauge.CLERGE, 6);

        reponse1.remplirReponse("G", effet1);
        reponse1.remplirReponse("D", effet2);
        reponse1.remplirReponse("H", effet3);


        // remplir questions
        Question question1 = new Question(
                "Main du roi",
                "Le peuple souhaite libérer les prisonniers",
                reponse1);
        questions.add(question1);

        Question question2 = new Question(
                "Paysan",
                "Il n'y a plus rien à manger",
                reponse1);
        questions.add(question2);

        Question question3 = new Question(
                "Prêtre",
                "Les dieux sont en colère",
                reponse1);
        questions.add(question3);

        Question question4 = new Question(
                "Main du roi",
                "Le roi Baratheon rassemble son armée",
                reponse1);
        questions.add(question4);

        Question question5 = new Question(
                "Paysan",
                "Abondance de récoltes cette année",
                reponse1);
        questions.add(question5);

        return questions;
    }
}