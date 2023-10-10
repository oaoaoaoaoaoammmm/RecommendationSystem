package org.example.sii3.usecase.impl;

import lombok.Builder;
import lombok.extern.java.Log;
import org.example.sii3.Interpretator.Interpretator;
import org.example.sii3.executor.Executor;
import org.example.sii3.requestscanner.RequestScanner;
import org.example.sii3.usecase.UseCase;
import org.example.sii3.utils.Request;

/**
 * Здесь в цикле происходят ожидания ввода пользователя, и отправление запроса дальше по цепочке
 * @author danya
 */

@Log
@Builder
public class UseCaseImpl implements UseCase {

    private final RequestScanner requestScanner;
    private final Interpretator interpretator;
    private final Executor executor;

    public UseCaseImpl(
            RequestScanner requestScanner,
            Interpretator interpretator,
            Executor executor
    ) {
        this.requestScanner = requestScanner;
        this.interpretator = interpretator;
        this.executor = executor;
    }

    @Override
    public void start() {
        boolean stopFlag = false;
        System.out.println("введите - стоп, для остановки приложения");
        while (!stopFlag) {
            try {
                String str = requestScanner.scanRequest();
                if (!str.equals("стоп")) {
                    Request request = interpretator.interpret(str);
                    executor.execute(request);
                } else {
                    stopFlag = true;
                }
            } catch (RuntimeException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
