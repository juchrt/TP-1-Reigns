package main;

/**
 * Représente une jauge avec un nom, une valeur et un type.
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Jauge {
    /**
     * Le type de la jauge
     */
    protected TypeJauge type;
    /**
     * Le nom de la jauge
     */
    protected String nom;
    /**
     * La valeur de la jauge
     */
    protected int valeur;

    /**
     * Crée une nouvelle jauge avec le nom et la valeur spécifiés.
     *
     * @param nom Le nom de la jauge
     * @param valeur La valeur de la jauge
     */
    public Jauge(String nom, int valeur){
        this.nom = nom;
        this.valeur = valeur;
    }

    /**
     * Retourne le nom de la jauge.
     *
     * @return le nom de la jauge
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom de la jauge.
     *
     * @param nom Le nouveau nom de la jauge
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne la valeur de la jauge.
     *
     * @return la valeur de la jauge
     */
    public int getValeur() {
        return valeur;
    }

    /**
     * Modifie la valeur de la jauge.
     *
     * @param valeur La nouvelle valeur de la jauge
     */
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    /**
     * Retourne le type de la jauge.
     *
     * @return le type de la jauge
     */
    public TypeJauge getType() {
        return type;
    }

    /**
     * Modifie le type de la jauge.
     *
     * @param type Le nouveau type de la jauge
     */
    public void setType(TypeJauge type) {
        this.type = type;
    }

    /**
     * Affiche les jauges de Clergé, Peuple, Armée et Finances du personnage.
     */
    public void AfficheJauges() {
        afficheJauge(jaugeClerge);
        afficheJauge(jaugePeuple);
        afficheJauge(jaugeArmee);
        afficheJauge(jaugeFinance);
        System.out.println();
    }

    /**
     * Affiche une jauge avec un format graphique, en utilisant des "#" pour représenter la valeur de la jauge
     * et des "_" pour représenter la valeur manquante.
     *
     * @param jauge La jauge à afficher
     */
    private void afficheJauge(Jauge jauge) {
        String resultat = "[";
        // valeur : ####
        for(int i=0;i<jauge.getValeur();i++){
            resultat += "#";
        }
        // on complète avec ____
        for(int i=0;i<50-(jauge.getValeur()>0?jauge.getValeur():0);i++){
            resultat += "_";
        }
        resultat += "] ";
        // affichage du nom
        resultat += jauge.getNom();
        System.out.println(resultat);
    }
}
