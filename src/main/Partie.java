package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Partie {

    private static Personnage joueur;
    private static ArrayList<Question> questions;
    private static int nbTours;

    public Partie(ArrayList<Question> questions) {
        this.joueur = initJoueur();
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
        ArrayList<String> listeChoix = question.reponses.listerChoix();

        String reponseUtilisateur = "";
        while(!listeChoix.contains(reponseUtilisateur)){
            System.out.println("Entrez la réponse " + question.reponses.afficherChoix());
            System.out.flush();
            reponseUtilisateur = scanner.nextLine();
        }


        // applique les malus
        /*if(reponse.equals("G")){
            question.appliqueEffetsGauche(joueur);
        }else{
            question.appliqueEffetsDroite(joueur);
        }*/
    }

    /**
     * Cette fonction permet d'initialiser le personnage joué. Elle demande à l'utilisateur de saisir le nom du personnage
     * et le genre (Roi ou Reine). Elle crée ensuite le personnage.
     */
    public Personnage initJoueur(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom du personnage: ");
        System.out.flush();
        String nom = scanner.nextLine();
        System.out.println(
                "Faut-il vous appeler Roi ou Reine ? (1 pour Roi, 2 pour Reine)");
        int genre = scanner.nextInt();
        Genre roiReine;
        if(genre==1){
            roiReine = Genre.ROI;
        }else{
            roiReine = Genre.REINE;
        }

        this.joueur = new Personnage(nom,roiReine);
        return this.joueur;
    }

    /**
     * Vérifie si le jeu est fini en vérifiant si une des jauges est à 0 ou 50.
     *
     * @return true si le jeu est fini, false sinon
     */
    public boolean finDuJeu(){
        if(jaugeClerge.getValeur()<=0
                || jaugeClerge.getValeur()>=50
                || jaugePeuple.getValeur()<=0
                || jaugePeuple.getValeur()>=50
                || jaugeArmee.getValeur()<=0
                || jaugeArmee.getValeur()>=50
                || jaugeFinance.getValeur()<=0
                || jaugeFinance.getValeur()>=50){
            return true;
        }else{
            return false;
        }
    }

}
