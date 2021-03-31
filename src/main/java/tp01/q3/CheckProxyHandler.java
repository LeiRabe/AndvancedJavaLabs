package tp01.q3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Le handler pour le proxy qui vérifie que les appels de setter respectent bien les valeurs min et max.
 */
class CheckProxyHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        throw new RuntimeException("à écrire !");
    }
    
}
