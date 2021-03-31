package tp01.q1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Afficheur générique, capable d'afficher un objet à partir de ses méthodes.
 * (en fait d'affichage, on retourne une string, c'est plus simple à tester)
 */
public class Afficheur {
    /**
     * Affiche un objet quelconque par introspection.
     * 
     * @param o
     * @return String description de l'objet
     */
    public String afficher(Object o) {
        try {
            //extends dans le paramètre générique 
            //Class<? extends Object> clazz = o.getClass();
            Class<?> clazz = o.getClass();
            ArrayList<String> listeAAfficher = new ArrayList<>();
            for (Method m : clazz.getMethods()) {
                if (m.getName().startsWith("get") && m.getParameterCount() == 0 
                && ! m.getName().equals("getClass")) {
                    String nomPropriete = IntrospectionHelper.extraireNomDePropriete("get", m.getName());
                    listeAAfficher.add(nomPropriete + " : " + m.invoke(o));
                }
            }
            Collections.sort(listeAAfficher);
            System.out.println("Dans la classe Afficheur: " + String.join(" ; ", listeAAfficher));
            return String.join(" ; ", listeAAfficher);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

}
//Helps: 
// https://stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java/4343547#4343547
