package com.melnik.projectExceptions;

public class NullLinkException extends Exception {

    public NullLinkException() {
        super("Link is null");
    }
}
