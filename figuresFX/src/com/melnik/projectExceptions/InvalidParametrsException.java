package com.melnik.projectExceptions;

public class InvalidParametrsException extends Exception {

    public InvalidParametrsException() {
        super("The specified parameter is incorrect");
    }
}
