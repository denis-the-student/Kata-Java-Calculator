class CalcException extends RuntimeException {
    CalcException(String message) {
        super(message);
    }
    CalcException(String message, Throwable cause) {
        super(message, cause);
    }
}
