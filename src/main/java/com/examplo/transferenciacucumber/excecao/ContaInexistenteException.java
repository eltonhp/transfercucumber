package com.examplo.transferenciacucumber.excecao;

public class ContaInexistenteException extends Exception {
    public ContaInexistenteException() {
    }

    public ContaInexistenteException(String message) {
        super(message);
    }

    public ContaInexistenteException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContaInexistenteException(Throwable cause) {
        super(cause);
    }

    public ContaInexistenteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
