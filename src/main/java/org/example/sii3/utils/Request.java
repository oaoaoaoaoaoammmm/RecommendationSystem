package org.example.sii3.utils;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


/**
 * Запрос, котоырй понятен выполнителю
 * @author danya
 */

@ToString
@Getter
@Builder
public class Request {
    private RequestType reqType;
    private String firstParam;
    private String secondParam;
}
