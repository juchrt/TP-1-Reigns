package main;

import java.util.ArrayList;

public class BanqueQuestions {

    /**
     * la banque de questions
     */
    private static ArrayList<Question> questions;
    
     /**
     * Cette fonction initialise la banque de questions. Elle crée les questions et
     * les ajoute à la banque.
     * 
     * @return la banque de questions
     */
    public static ArrayList<Question> initBanqueQuestions() {
        questions = new ArrayList<>();

        // ---- Première question de la Main du Roi ----
        // Initialiser et remplir les effets
        Effet effetGauche1 = new Effet("Oui");
        Effet effetDroite1 = new Effet("Non");

        effetGauche1.remplirEffets(TypeJauge.ARMEE, -5);
        effetGauche1.remplirEffets(TypeJauge.PEUPLE, 5);
        effetDroite1.remplirEffets(TypeJauge.PEUPLE, -7);

        // Initialiser et remplir les réponses avec les effets
        Reponse reponseMainDuRoi1 = new Reponse();

        reponseMainDuRoi1.remplirReponse("G", effetGauche1);
        reponseMainDuRoi1.remplirReponse("D", effetDroite1);

        // Créer la question
        Question mainDuRoi1 = new Question(
                "Main du roi",
                "Le peuple souhaite libérer les prisonniers",
                reponseMainDuRoi1);
        questions.add(mainDuRoi1);

        // ---- Première question du Paysan ----
        // Initialiser et remplir les effets
        Effet effetGauche2 = new Effet("Importer de la nourriture");
        Effet effetDroite2 = new Effet("Ne rien faire");

        effetGauche2.remplirEffets(TypeJauge.FINANCE, -5);
        effetGauche2.remplirEffets(TypeJauge.PEUPLE, 5);
        effetDroite2.remplirEffets(TypeJauge.PEUPLE, -5);

        // Initialiser et remplir les réponses avec les effets
        Reponse reponsePaysan1 = new Reponse();

        reponsePaysan1.remplirReponse("G", effetGauche2);
        reponsePaysan1.remplirReponse("D", effetDroite2);

        // Créer la question
        Question Paysan1 = new Question(
                "Paysan",
                "Il n'y a plus rien à manger",
                reponsePaysan1);
        questions.add(Paysan1);

        // ---- Première question du Prêtre ----
        // Initialiser et remplir les effets
        Effet effetGauche3 = new Effet("Faire un sacrifice");
        Effet effetDroite3 = new Effet("Ne rien faire");

        effetGauche3.remplirEffets(TypeJauge.CLERGE, 5);
        effetGauche3.remplirEffets(TypeJauge.PEUPLE, -3);
        effetDroite3.remplirEffets(TypeJauge.CLERGE, -5);

        // Initialiser et remplir les réponses avec les effets
        Reponse reponsePretre1 = new Reponse();

        reponsePretre1.remplirReponse("G", effetGauche3);
        reponsePretre1.remplirReponse("D", effetDroite3);

        // Créer la question
        Question pretre1 = new Question(
                "Prêtre",
                "Les dieux sont en colère",
                reponsePretre1);
        questions.add(pretre1);




        // ---- Deuxième question de la Main du Roi ----
        // Initialiser et remplir les effets
        Effet effetGauche4 = new Effet("Le soutenir");
        Effet effetDroite4 = new Effet("Rester neutre");

        effetGauche4.remplirEffets(TypeJauge.ARMEE, 3);
        effetGauche4.remplirEffets(TypeJauge.FINANCE, -3);
        effetGauche4.remplirEffets(TypeJauge.CLERGE, -3);
        effetDroite4.remplirEffets(TypeJauge.PEUPLE, 3);

        // Initialiser et remplir les réponses avec les effets
        Reponse reponseMainDuRoi2 = new Reponse();

        reponseMainDuRoi2.remplirReponse("G", effetGauche4);
        reponseMainDuRoi2.remplirReponse("D", effetDroite4);

        // Créer la question
        Question mainDuRoi2 = new Question(
                "Main du Roi",
                "Le roi Baratheon rassemble son armée",
                reponseMainDuRoi2);
        questions.add(mainDuRoi2);




        // ---- Deuxième question du Paysan ----
        // Initialiser et remplir les effets
        Effet effetGauche5 = new Effet("Taxer énormément");
        Effet effetDroite5 = new Effet("Taxer un tout petit peu");

        effetGauche5.remplirEffets(TypeJauge.FINANCE, 10);
        effetGauche5.remplirEffets(TypeJauge.PEUPLE, -5);
        effetDroite5.remplirEffets(TypeJauge.FINANCE, 1);
        effetDroite5.remplirEffets(TypeJauge.PEUPLE, -3);

        // Initialiser et remplir les réponses avec les effets
        Reponse reponsepaysan2 = new Reponse();

        reponsepaysan2.remplirReponse("G", effetGauche5);
        reponsepaysan2.remplirReponse("D", effetDroite5);

        // Créer la question
        Question paysan2 = new Question(
                "Paysan",
                "Abondance de récoltes cette année",
                reponsepaysan2);
        questions.add(paysan2);

        return questions;
    }
}
