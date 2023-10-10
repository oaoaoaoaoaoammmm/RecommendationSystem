package org.example.sii3;

import org.example.sii3.Interpretator.impl.InterpretatorImpl;
import org.example.sii3.executor.impl.ExecutorImpl;
import org.example.sii3.knowledgebase.impl.KnowledgeBaseImpl;
import org.example.sii3.requestscanner.impl.RequestScannerImpl;
import org.example.sii3.usecase.UseCase;
import org.example.sii3.usecase.impl.UseCaseImpl;
import org.example.sii3.validator.impl.InputValidatorImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Точка инициализации всего приложения
 * @author danya
 */

public class EntryPoint {
    private final UseCase useCase = UseCaseImpl.builder()
            .requestScanner(RequestScannerImpl.builder()
                    .scanner(new Scanner(System.in))
                    .validator(InputValidatorImpl.builder()
                            .badWords(List.of(" для ", " на ", " за "))
                            .build()
                    )
                    .build()
            )
            .executor(ExecutorImpl.builder()
                    .knowledgeBase(KnowledgeBaseImpl.builder()
                            .heroes(new HashMap<>())
                            .build()
                    )
                    .build()
            )
            .interpretator(InterpretatorImpl.builder()
                    .requestTypes(
                            Map.of(
                                    "WHO_COUNTERPICK", "кто контрит",
                                    "WHAT_COUNTERPICK", "что контрит",
                                    "BEST_ROLE", "лучшая роль",
                                    "WHAT_BUY", "что купить"
                            )
                    )
                    .build()
            )
            .build();

    public void activateApplication() {
        useCase.start();
    }
}
