package tp01.q1;


public class IntrospectionHelper {
    // "truc" technique : la classe IntrospectionHelper 
    // est faite pour qu'on appelle ses méthodes statiques. Ici, on empêche
    // de créer des instances d'IntrospectionHelper
    private IntrospectionHelper() {}

    /**
     * Extrait le nom d'une propriété à partir d'un getter ou d'un setter.
     * 
     * Par exemple, si on l'appelle avec comme paramètres "get", et "getNom", 
     * retournera "nom".
     * @param prefixe : la partie conventionnelle ("get", "set" ou "is") au
     *                   début du nom de la méthode.
     * @param nomMethode : le nom de la méthode.
     * @return le nom de la propriété manipulée par la méthode, en java. Si la méthode 
     *         a exactement le nom du préfixe, retourne "".
     * @throws IllegalArgumentException si le préfixe n'est pas correct
     */
    public static String extraireNomDePropriete(String prefixe, String nomMethode) {
        if (! nomMethode.startsWith(prefixe))
            throw new IllegalArgumentException("couple "+prefixe+ " et "+ nomMethode + " incorrect");
        String nom = nomMethode.substring(prefixe.length());
        if (nom.length() > 0) {
            return Character.toLowerCase(nom.charAt(0)) + nom.substring(1);
        } else {
            return "";
        }
    }


    /**
     * Construit le nom d'une méthode pour accéder à une propriété.
     * @param prefixe le préfixe (typiquement "get", "set" ou "is")
     * @param propriete le nom de la propriété, commençant normalement par une minuscule, exemple "prenom"
     * @return le nom de la méthode, par exemple "getPrenom"
     */
    public static String construireNomMethode(String prefixe, String propriete) {
        if (propriete.length() > 0) {
            return prefixe + Character.toUpperCase(propriete.charAt(0)) + propriete.substring(1);
        } else {
            return prefixe;
        }
    }
}
