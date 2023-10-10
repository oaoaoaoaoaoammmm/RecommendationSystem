package org.example.sii3.executor;

import lombok.Builder;
import org.example.sii3.utils.Request;

public interface Executor {
    void execute(Request request);
}
