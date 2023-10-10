package org.example.sii3.validator.impl;

import lombok.Builder;
import org.example.sii3.validator.InputValidator;

import java.util.List;

/**
 * Здесь происходит валидация запроса, удаление не нужных слов, символов
 * @author danya
 */

@Builder
public class InputValidatorImpl implements InputValidator {

    private final List<String> badWords;

    public InputValidatorImpl(List<String> badWords) {
        this.badWords = badWords;
    }

    @Override
    public void signsHandle(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ',' || sb.charAt(i) == '?' || sb.charAt(i) == '!') {
                sb.delete(i, i + 1);
            }
        }
    }

    @Override
    public void badWordHandle(StringBuilder sb) {
        for (String badWord: badWords) {
            int index = sb.indexOf(badWord);
            if (index != -1) {
                sb.delete(index, index + badWord.length() - 1);
            }
        }
    }
}
