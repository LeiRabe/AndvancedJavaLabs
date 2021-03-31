package tp01.q3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Cette annotation permet de préciser un intervalle de valeurs que doit respecter
 * une propriété entière. Elle se place sur le setter.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Intervalle {
    int min();
    int max();
}
