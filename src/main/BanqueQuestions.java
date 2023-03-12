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
