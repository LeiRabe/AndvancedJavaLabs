package tp01.q3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.lang.reflect.Method;

import org.junit.Test;

/**
 * Un test technique pour vérifier des propriétés intéressantes des annotations.
 */
public class TestAnnotation {
    
    /**
     * L'annotation est ici portée par le proxy, non par
     * la classe d'implémentation.
     * @throws Exception
     */
    @Test
    public void testHeritage() throws Exception {
        Class<Date3> clazz = Date3.class;
        Method setter = clazz.getMethod("setMois", Integer.TYPE);
        Intervalle intervalleAnnotation = setter.getAnnotation(Intervalle.class);
        assertNull(intervalleAnnotation);        
    }
}
