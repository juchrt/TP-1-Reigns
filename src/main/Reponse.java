package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Reponse {

    protected Map<String, Effet> reponses;

    public Reponse() {
        this.reponses = new HashMap<>();
    }

    public void remplirReponse(String choix, Effet effet) {
        this.reponses.put(choix, effet);
    }

    public String afficherReponses() {
        StringBuilder result = new StringBuilder();

        result.append(" [");

        for (Map.Entry<String, Effet> reponse : this.reponses.entrySet()) {
            result.append(reponse.getKey() + ": " + reponse.getValue().message + ", ");
        }

        int indexLastComa = result.lastIndexOf(", ");
        result.delete(indexLastComa, indexLastComa + 2);

        result.append("]");

        return result.toString();
    }


    public String afficherChoix(){
        StringBuilder les_choix = new StringBuilder();
        les_choix.append("(");
        for (String choix : this.listerChoix()){
            les_choix.append(choix + ", ");
        }
        les_choix.delete(les_choix.lastIndexOf(", "), les_choix.lastIndexOf(", ") + 2);
        les_choix.append(")");
        return les_choix.toString();
    }

    public ArrayList<String> listerChoix(){
        ArrayList<String> listeChoix = new ArrayList();
        for (Map.Entry<String, Effet> reponse : this.reponses.entrySet()) {
            listeChoix.add(reponse.getKey());
        }
        return listeChoix;
    }



    @Override
    public String toString() {
        return "Reponse{" + "reponse=" + reponses + "}";
    }

}
