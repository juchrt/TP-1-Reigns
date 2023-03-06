package main;

import java.util.HashMap;
import java.util.Map;

public class Effet {
    public Map<TypeJauge,Integer> effets;
    public String message;

    public Effet(String message) {
        this.effets = new HashMap<>();
        this.message = message;
    }

    public void remplirEffets(TypeJauge jauge, Integer effetSurJauge) {
        this.effets.put(jauge, effetSurJauge);
    }

    /**
     * Retourne une chaîne de caractères représentant les effets d'une jauge.
     *
     * @return la chaîne de caractères représentant les effets de la jauge
     */
    public String afficherEffets() {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<TypeJauge,Integer> effet : this.effets.entrySet()) {
            result.append("Jauge ").append(effet.getKey()).append(":");
            if (effet.getValue() > 0) {
                result.append("+");
            }
            result.append(effet.getValue());
            result.append("; ");
        }

        return result.toString();
    }

    public Map<TypeJauge, Integer> getEffet() {
        return effets;
    }

    public void setEffet(Map<TypeJauge, Integer> effet) {
        this.effets = effet;
    }

    /**
     * Applique les effets associés au choix gauche sur un personnage donné.
     *
     * @param personnage le personnage sur lequel les effets doivent être appliqués
     */
    /*public void appliqueEffetsGauche(Personnage personnage){
        this.appliqueEffets(effetJaugeGauche, personnage);
    }*/

    /**
     * Applique les effets associés au choix droit sur un personnage donné.
     *
     * @param personnage le personnage sur lequel les effets doivent être appliqués
     */
    /*public void appliqueEffetsDroite(Personnage personnage){
        this.appliqueEffets(effetJaugeDroite, personnage);
    }*/

    /**
     * Applique les effets d'une jauge sur un personnage donné.
     *
     * @param effets les effets de jauge à appliquer
     * @param personnage le personnage sur lequel les effets doivent être appliqués
     */
    private void appliqueEffets(Map<TypeJauge,Integer> effets,
                                Personnage personnage){
        for(Map.Entry<TypeJauge,Integer> effet : effets.entrySet()){
            switch(effet.getKey()){
                case ARMEE:
                    personnage.getJaugeArmee().setValeur(
                            personnage.getJaugeArmee().getValeur()
                                    +effet.getValue());
                    break;
                case CLERGE:
                    personnage.getJaugeClerge().setValeur(
                            personnage.getJaugeClerge().getValeur()
                                    +effet.getValue());
                    break;
                case FINANCE:
                    personnage.getJaugeFinance().setValeur(
                            personnage.getJaugeFinance().getValeur()
                                    +effet.getValue());
                    break;
                case PEUPLE:
                    personnage.getJaugePeuple().setValeur(
                            personnage.getJaugePeuple().getValeur()
                                    +effet.getValue());
                    break;
            }
        }
    }

    /**
     * Ajoute un effet à la jauge associée au choix gauche.
     *
     * @param jauge la jauge à laquelle l'effet doit être ajouté
     * @param valeur la valeur de l'effet à ajouter
     */
    /*public void ajouteEffetGauche(TypeJauge jauge,
                                  int valeur){
        effetJaugeGauche.put(jauge,valeur);
    }*/

    /**
     * Ajoute un effet à la jauge associée au choix droit.
     *
     * @param jauge la jauge à laquelle l'effet doit être ajouté
     * @param valeur la valeur de l'effet à ajouter
     */
    /*public void ajouteEffetDroite(TypeJauge jauge,
                                  int valeur){
        effetJaugeDroite.put(jauge,valeur);
    }*/

    /*
     * Retourne une chaîne de caractères représentant les effets d'une jauge.
     */
    public String afficherReponsesEtEffets() {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, Effet> reponse : this.reponses.entrySet()) {
            result.append("\nEffet " + reponse.getKey() + ": " + reponse.getValue().afficherEffets());
        }

        return result.toString();
    }
}
