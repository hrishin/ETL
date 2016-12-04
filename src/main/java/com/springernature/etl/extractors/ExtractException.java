package com.springernature.etl.extractors;

/**
 * Created by hrishikeshshinde on 03/12/16.
 */
public class ExtractException extends RuntimeException{

    public ExtractException() {

    }

    public ExtractException(String message) {
        super(message);
    }

    public ExtractException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExtractException(Throwable cause) {
        super(cause);
    }

    public ExtractException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String toString() {
        return "ExtractException{}";
    }
}
