package main;

import java.util.Map;
import java.util.TreeMap;

public class Reponse {

    protected Map<String, Effet> reponse;

    public Reponse() {
        this.reponse = new TreeMap<>();
    }

    public String afficheReponse(Map<String, Effet> reponses) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Effet> reponse : reponses.entrySet()) {
            result.append("Réponse ").append(reponse.getKey()).append(":");
            result.append(reponse.getValue());
        }
        return result.toString();
    }

    public void remplirReponse(String cote, Effet effet) {
        this.reponse.put(cote, effet);
    }

    @Override
    public String toString() {
        return "Reponse{" + "reponse=" + reponse + "}";
    }

}
