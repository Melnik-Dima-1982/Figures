package com.melnik.projectExceptions;

public class UnknownTypeFigureException extends Exception {
    public UnknownTypeFigureException() {
        super("Unknow figure type");
    }
}
