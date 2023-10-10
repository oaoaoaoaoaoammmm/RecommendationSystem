package org.example.sii3.requestscanner.impl;

import lombok.Builder;
import org.example.sii3.requestscanner.RequestScanner;
import org.example.sii3.validator.InputValidator;

import java.util.Scanner;

/**
 * Здесь происходит сканирование ввода пользователя и передача строки валидотору
 * @author danya
 */

@Builder
public class RequestScannerImpl implements RequestScanner {

    private final Scanner scanner;
    private final InputValidator validator;

    public RequestScannerImpl(
            Scanner scanner,
            InputValidator validator
    ) {
        this.scanner = scanner;
        this.validator = validator;
    }

    @Override
    public String scanRequest() {
        StringBuilder request = new StringBuilder(scanner.nextLine());
        validator.signsHandle(request);
        validator.badWordHandle(request);
        return request.toString();
    }
}
