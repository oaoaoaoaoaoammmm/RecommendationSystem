package org.example.sii3.Interpretator;

import org.example.sii3.utils.Request;

public interface Interpretator {
    Request interpret(String request) throws RuntimeException;
}
