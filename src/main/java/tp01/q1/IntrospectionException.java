package tp01.q1;

/**
 * Exceptions levées par le système d'introspection.
 */
public class IntrospectionException extends RuntimeException { 

    private static final long serialVersionUID = -8657931718320714494L;

    public IntrospectionException() {
    }

    public IntrospectionException(String message) {
        super(message);
    }   

    public IntrospectionException(Exception e) {
        super(e);
    }   

}
