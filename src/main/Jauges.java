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
     * Initialise les jauges du personnage.
     */
    public void initJauges() {
        for (TypeJauge type : TypeJauge.values()) {
            jauges.put(type, 15 + (int) (Math.random() * (35 - 15)));
        }
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

    //TODO: docs
    public void updateJauges(TypeJauge key, Integer value){
        Integer lastValue = jauges.get(key);
        Integer updatedValue = lastValue + value;

        jauges.put(key, updatedValue);
    }

    /**
     * Vérifie que les jauges sont comprises entre 0 et 50.
     */
    public boolean verifyJaugesLife(){
        for (Map.Entry<TypeJauge,Integer> jauge : this.jauges.entrySet()){
            if (jauge.getValue() < 0 | jauge.getValue() > 50){
                return false;
            }
        }
        return true;
    }
}
