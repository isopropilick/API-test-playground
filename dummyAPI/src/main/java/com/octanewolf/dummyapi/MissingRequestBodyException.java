package com.octanewolf.dummyapi;

public class MissingRequestBodyException extends RuntimeException {
    public MissingRequestBodyException() {
        super("Request body is missing. Please provide the content for the file.");
    }
}
