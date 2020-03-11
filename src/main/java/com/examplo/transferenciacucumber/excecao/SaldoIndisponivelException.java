package com.examplo.transferenciacucumber.excecao;

public class SaldoIndisponivelException  extends Exception{

    public SaldoIndisponivelException() {
    }

    public SaldoIndisponivelException(String message) {
        super(message);
    }

    public SaldoIndisponivelException(String message, Throwable cause) {
        super(message, cause);
    }

    public SaldoIndisponivelException(Throwable cause) {
        super(cause);
    }

    public SaldoIndisponivelException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
