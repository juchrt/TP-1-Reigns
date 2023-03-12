package main;

import java.util.HashMap;
import java.util.Map;

public class Effet {
    public Map<TypeJauge,Integer> effets;
    public String message;

    /**
     * Construit un nouvel effet avec les informations données
     *
     * @param message Le message à afficher
     */
    public Effet(String message) {
        this.effets = new HashMap<>();
        this.message = message;
    }

    /**
     * Remplit la map des effets d'une jauge avec les informations données
     * 
     * @param jauge La jauge à modifier
     * @param effetSurJauge L'effet sur la jauge
     */
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
     * Applique les effets d'une jauge sur un personnage donné.
     * 
     * @param jauges Les jauges du personnage
     */
    public void appliqueEffets(Jauges jauges){
        for(Map.Entry<TypeJauge,Integer> effet : effets.entrySet()){
            TypeJauge jaugeToUpdate = effet.getKey();
            Integer effectToApply = effet.getValue();

            jauges.updateJauges(jaugeToUpdate, effectToApply);
        }
    }
}
