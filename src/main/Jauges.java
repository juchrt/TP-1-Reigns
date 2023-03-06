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
     *
     * @param nom    Le nom de la jauge
     * @param valeur La valeur de la jauge
     */
    public Jauges() {
        this.jauges = new HashMap<>();
    }

    /**
     * Affiche les jauges de Clergé, Peuple, Armée et Finances du personnage.
     */
    public void AfficheJauges() {
        for (Map.Entry<TypeJauge, Integer> entry : jauges.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    /**
     * Affiche une jauge avec un format graphique, en utilisant des "#" pour
     * représenter la valeur de la jauge
     * et des "_" pour représenter la valeur manquante.
     *
     * @param jauge La jauge à afficher
     */
    private void afficheJauge(Jauge jauge) {
        String resultat = "[";
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
        resultat += jauge.getNom();
        System.out.println(resultat);
    }

    public void initJauges() {

        for (TypeJauge type : TypeJauge.values()) {
            jauges.put(type, 15 + (int) (Math.random() * (35 - 15)));
        }
    }
}
