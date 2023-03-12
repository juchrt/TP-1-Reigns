package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Partie {

    private static Personnage joueur;
    private static ArrayList<Question> questions;
    private static int nbTours;
    private static Jauges jauges;

    /**
     * Crée une nouvelle partie avec le personnage et les questions spécifiés.
     * 
     * @param joueur    Le personnage joué
     * @param questions La banque de questions
     */
    public Partie(ArrayList<Question> questions) {
        this.joueur = Personnage.initJoueur();
        this.questions = questions;
        this.nbTours = 0;
        this.jauges = new Jauges();
    }

    public static void initialiserPartie() {
        // initialiser joueur
        System.out.println(joueur.getGenre().longRegne()
                + joueur.getNom());

        //initialiser jauges
        jauges.initJauges();
        jauges.afficheJauges();
    }

    /**
     * Cette fonction permet de gérer les tours de jeu donc de piocher une question aléatoire,
     * de gérer les réponses et de mettre à jour les jauges.
     */
    public void toursDeJeu() {
        while (!this.finDuJeu()) {
            nbTours++;
            Question question = getQuestionAleatoire();
            reponseQuestion(question);
            jauges.afficheJauges();
        }
    }

    /**
     * Cette fonction affiche le nombre de tours que la personnage a joué
     */
    public static void finDePartie() {
        System.out.println(
                joueur.getNom()
                        + " a perdu ! Son règne a duré "
                        + nbTours
                        + " tours");
    }

    /**
     * Cette fonction permet de tirer une question aléatoire dans la banque de
     * questions.
     * 
     * @return Une question aléatoire
     */
    private static Question getQuestionAleatoire() {
        int numQuestion = (int) (Math.random() * questions.size());
        return questions.get(numQuestion);
    }

    /**
     * Cette fonction permet de gérer la réponse à une question donnée. Elle affiche
     * la question, demande à
     * l'utilisateur d'entrer une réponse (soit "G" soit "D") et en fonction de la
     * réponse, elle appelle la méthode
     * appropriée pour appliquer les conséquences sur les jauges du personnage.
     * 
     * @param question La question à laquelle il faut répondre
     */
    private static void reponseQuestion(Question question) {
        question.afficheQuestion();

        // récupère la réponse
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listeChoix = question.reponses.listerChoix();

        String reponseUtilisateur = "";
        while (!listeChoix.contains(reponseUtilisateur)) {
            System.out.println("Entrez la réponse " + question.reponses.afficherChoix());
            System.out.flush();
            reponseUtilisateur = scanner.nextLine();
        }

        //applique les effets
        Effet effetReponseUser = question.reponses.reponses.get(reponseUtilisateur);
        effetReponseUser.appliqueEffets(jauges);
    }



    /**
     * Vérifie si le jeu est fini en vérifiant si une des jauges est à 0 ou 50.
     *
     * @return true si le jeu est fini, false sinon
     */
    public boolean finDuJeu() {
        if (jauges.verifyJaugesLife()) {
            return false;
        } else {
            return true;
        }
    }

}
