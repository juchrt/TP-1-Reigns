package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Partie {

    private static Personnage joueur;
    private static ArrayList<Question> questions;
    private static int nbTours;

    public Partie(ArrayList<Question> questions) {
        this.joueur = Reigns.initPersonnage();
        this.questions = questions;
        this.nbTours = 0;
    }

    public static void initialiserPartie(){
        System.out.println(joueur.getGenre().longRegne()
                +" "+joueur.getNom());

        joueur.AfficheJauges();
    }

    public static void toursDeJeu(){
        while(!joueur.finDuJeu()){
            nbTours++;
            Question question = getQuestionAleatoire();
            reponseQuestion(question);
            joueur.AfficheJauges();
        }
    }

    public static void finDePartie(){
        System.out.println(
                joueur.getNom()
                        + " a perdu ! Son règne a duré "
                        + nbTours
                        + " tours");
    }

    /**
     * Cette fonction permet de tirer une question aléatoire dans la banque de questions.
     * @return Une question aléatoire
     */
    private static Question getQuestionAleatoire(){
        int numQuestion = (int) (Math.random()*questions.size());
        return questions.get(numQuestion);
    }

    /**
     * Cette fonction permet de gérer la réponse à une question donnée. Elle affiche la question, demande à
     * l'utilisateur d'entrer une réponse (soit "G" soit "D") et en fonction de la réponse, elle appelle la méthode
     * appropriée pour appliquer les conséquences sur les jauges du personnage.
     * @param question La question à laquelle il faut répondre
     */
    private static void reponseQuestion(Question question){
        question.afficheQuestion();
        // récupère la réponse
        Scanner scanner = new Scanner(System.in);
        String reponse = "";
        while(!reponse.equals("G") && !reponse.equals("D")){
            System.out.println("Entrez la réponse (G ou D)");
            System.out.flush();
            reponse = scanner.nextLine();
        }
        // applique les malus
        if(reponse.equals("G")){
            question.appliqueEffetsGauche(joueur);
        }else{
            question.appliqueEffetsDroite(joueur);
        }
    }

}
