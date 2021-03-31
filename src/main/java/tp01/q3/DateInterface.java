package tp01.q3;

/**
 * Une interface représentant une date.
 * ATTENTION, le but est simplement d'implémenter des vérifications basiques. 
 * Pas de vérifier par exemple que le mois choisi a le bon nombre de jours, ce qui nous emmènerait trop loin.
 */
public interface DateInterface {
    
    int getAnnee();
    int getMois();
    int getJour();

    void setAnnee(int annee);

    @Intervalle(min = 1, max=12)
    void setMois(int mois);

    @Intervalle(min = 1, max=31)
    void setJour(int jour);

}
