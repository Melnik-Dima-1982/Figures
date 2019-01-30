package com.melnik.projectExceptions;

public class FileNotFoundException extends Exception {

    public FileNotFoundException() {
        super("File wasn't founded");
    }
}
