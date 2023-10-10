package org.example.sii3.Interpretator.impl;

import lombok.Builder;
import org.example.sii3.Interpretator.Interpretator;
import org.example.sii3.utils.Request;
import org.example.sii3.utils.RequestType;

import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Здесь происходит интерпретация запроса, перевод к виду понятному выполнителю
 * @author danya
 */

@Builder
public class InterpretatorImpl implements Interpretator {

    private final Map<String, String> requestTypes;

    public InterpretatorImpl(Map<String, String> requestTypes) {
        this.requestTypes = requestTypes;
    }

    @Override
    public Request interpret(String str) throws RuntimeException {

        RequestType typeForCurrentReq = null;
        for (String type : requestTypes.keySet()) {
            if (str.contains(requestTypes.get(type))) {
                typeForCurrentReq = RequestType.valueOf(type);
                break;
            }
        }

        if (typeForCurrentReq == null) {
            throw new NoSuchElementException("Такой тип запросов не поддерживается");
        }

        StringBuilder stringBuilder = new StringBuilder(str);
        String a = requestTypes.get(typeForCurrentReq.toString());
        stringBuilder.delete(stringBuilder.indexOf(a), a.length() + 1);

        String[] params = stringBuilder.toString().split(" ");

        if (params.length == 2) {
            return Request.builder()
                    .reqType(typeForCurrentReq)
                    .firstParam(params[0])
                    .secondParam(params[1])
                    .build();
        } else if (params.length == 1) {
            return Request.builder()
                    .reqType(typeForCurrentReq)
                    .firstParam(params[0])
                    .secondParam(null)
                    .build();
        } else {
            throw new RuntimeException("Такой тип запросов не поддерживается");
        }
    }
}
