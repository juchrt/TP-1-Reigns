package main;

import java.util.HashMap;
import java.util.Map;

/**
 * Représente une jauge avec un nom, une valeur et un type.
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Jauges {

    public static Map<TypeJauge, Integer> jauges;

    /**
     * Crée une nouvelle jauge avec le nom et la valeur spécifiés.
     */
    public Jauges() {
        this.jauges = new HashMap<>();
    }

    /**
     * Affiche les jauges de Clergé, Peuple, Armée et Finances du personnage.
     */
    public void afficheJauges() {
        for (Map.Entry<TypeJauge, Integer> entry : jauges.entrySet()) {
            String resultat = "[";
            for (int i = 0; i < 50; i++){
                if (i < entry.getValue()){
                    resultat += "#";
                }else{
                    resultat += "_";
                }
            }
            resultat += "] ";
            System.out.println(resultat + entry.getKey() + " (" + entry.getValue() + "/50)");
        }
    }

    /**
     * Affiche une jauge avec un format graphique, en utilisant des "#" pour
     * représenter la valeur de la jauge
     * et des "_" pour représenter la valeur manquante.
     *
     */
    private void afficheJauge() {
        /*String resultat = "[";
        // valeur : ####
        for (int i = 0; i < jauge.getValeur(); i++) {
            resultat += "#";
        }
        // on complète avec ____
        for (int i = 0; i < 50 - (jauge.getValeur() > 0 ? jauge.getValeur() : 0); i++) {
            resultat += "_";
        }
        resultat += "] ";
        // affichage du nom
        resultat += jauge.getNom();*/
        System.out.println("Jauges");
    }

    public void initJauges() {
        for (TypeJauge type : TypeJauge.values()) {
            jauges.put(type, 15 + (int) (Math.random() * (35 - 15)));
        }
    }

    public boolean verifyJaugesLife(){
        for (Map.Entry<TypeJauge,Integer> jauge : this.jauges.entrySet()){
            if (jauge.getValue() < 0 | jauge.getValue() > 50){
                return false;
            }
        }
        return true;
    }
}
