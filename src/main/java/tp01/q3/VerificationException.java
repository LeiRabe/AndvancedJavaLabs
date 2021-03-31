package tp01.q3;

public class VerificationException extends RuntimeException {

    private static final long serialVersionUID = -2199248604078257337L;

    public VerificationException() {        
    }

    public VerificationException(String message) {
        super(message);
    }
}
