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
     * Applique les effets d'une jauge sur un personnage donné.
     *
     * @param effets les effets de jauge à appliquer
     * @param personnage le personnage sur lequel les effets doivent être appliqués
     */
    private void appliqueEffets(Map<TypeJauge,Integer> effets,
                                Personnage personnage){
        /*for(Map.Entry<TypeJauge,Integer> effet : effets.entrySet()){
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
        }*/
    }
}
