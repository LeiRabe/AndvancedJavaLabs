package tp01.q3;

import java.lang.reflect.Proxy;

/**
 * Note: classe helper. Utiliser les méthodes statiques.
 */
public class CheckProxyFactory {

    private CheckProxyFactory() {}
    /**
     * Construit un proxy doté de la capacité de vérifier l'annotation "Intervalle"
     * à partir d'un objet Java et de la classe qu'il implémente.
     * 
     * @param <T>
     * @param clazz
     * @param cible
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T creerProxy(Class<T> clazz, T cible) {
        ClassLoader currentClassLoader = Thread.currentThread().getContextClassLoader();
        Class<?> classes[] = { clazz };
        throw new RuntimeException("à écrire !");
    }
}
