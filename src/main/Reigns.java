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

        Reponse reponse = new Reponse();
        Effet effet1 = new Effet();
        reponse.remplirReponse("G", effet1);
        System.out.println(reponse.toString());
        // afficheReponse(reponse);

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

    public String afficheReponse(Map<String, Effet> reponses) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Effet> reponse : reponses.entrySet()) {
            result.append("Réponse ").append(reponse.getKey()).append(":");
            result.append(reponse.getValue());
        }
        return result.toString();
    }

    /**
     * Cette fonction initialise la banque de questions. Elle crée les questions et
     * les ajoute à la banque.
     */
    public static ArrayList<Question> initBanqueQuestions() {
        questions = new ArrayList<>();
        Question question1 = new Question(
                "Main du roi",
                "Le peuple souhaite libérer les prisonniers",
                "Oui",
                "Non");
        question1.ajouteEffetGauche(TypeJauge.ARMEE, -5);
        question1.ajouteEffetGauche(TypeJauge.PEUPLE, +5);
        question1.ajouteEffetDroite(TypeJauge.PEUPLE, -7);
        questions.add(question1);
        Question question2 = new Question(
                "Paysan",
                "Il n'y a plus rien à manger",
                "Importer de la nourriture",
                "Ne rien faire");
        question2.ajouteEffetGauche(TypeJauge.FINANCE, -5);
        question2.ajouteEffetGauche(TypeJauge.PEUPLE, +5);
        question2.ajouteEffetDroite(TypeJauge.PEUPLE, -5);
        questions.add(question2);
        Question question3 = new Question(
                "Prêtre",
                "Les dieux sont en colère",
                "Faire un sacrifice",
                "Ne rien faire");
        question3.ajouteEffetGauche(TypeJauge.CLERGE, +5);
        question3.ajouteEffetGauche(TypeJauge.PEUPLE, -3);
        question3.ajouteEffetDroite(TypeJauge.CLERGE, -5);
        questions.add(question3);
        Question question4 = new Question(
                "Main du roi",
                "Le roi Baratheon rassemble son armée",
                "Le soutenir",
                "Rester neutre");
        question4.ajouteEffetGauche(TypeJauge.ARMEE, +3);
        question4.ajouteEffetGauche(TypeJauge.FINANCE, -3);
        question4.ajouteEffetGauche(TypeJauge.CLERGE, -3);
        question4.ajouteEffetDroite(TypeJauge.PEUPLE, +3);
        questions.add(question4);
        Question question5 = new Question(
                "Paysan",
                "Abondance de récoltes cette année",
                "Taxer énormément",
                "Taxer un tout petit peu");
        question5.ajouteEffetGauche(TypeJauge.FINANCE, +10);
        question5.ajouteEffetGauche(TypeJauge.PEUPLE, -5);
        question5.ajouteEffetDroite(TypeJauge.FINANCE, +1);
        question5.ajouteEffetDroite(TypeJauge.PEUPLE, -3);
        questions.add(question5);
        return questions;
    }
}