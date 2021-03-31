package tp01.q1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Createur<T> {

    private Class<T> clazz;

    public Createur(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T creer() {
        try {
            // à compléter
            throw new RuntimeException("à écrire !");
        } catch (Exception e) {
            // On encapsule n'importe quelle exception dans une IntrospectionException.
            throw new IntrospectionException(e);
        }
    }

    /**
     * Fixe la valeur d'un champ de l'objet, en connaissant le nom de la propriété,
     * et la valeur à lui donner Appelle le "setter" correspondant.
     * 
     * @param objet        : l'objet à modifier
     * @param nomPropriete : le nom de la propriété (commence normalement par une
     *                     minuscule) ;
     * @param valeur       : la valeur à donner.
     */
    public void setProprieteTexte(T objet, String nomPropriete, String valeur) {
        // à compléter
        throw new RuntimeException("à écrire !");
    }

    /**
     * Fixe la valeur d'un champ de l'objet, en connaissant le nom de la propriété,
     * et la valeur à lui donner Appelle le "setter" correspondant.
     * 
     * @param objet        : l'objet à modifier
     * @param nomPropriete : le nom de la propriété (commence normalement par une
     *                     minuscule) ;
     * @param valeur       : la valeur à donner.
     */
    public <V> void setPropriete(T objet, String nomPropriete, V valeur, Class<? super V> clazzPropriete) {
        throw new RuntimeException("à écrire !");
    }

}
