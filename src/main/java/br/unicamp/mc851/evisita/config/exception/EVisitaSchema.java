package br.unicamp.mc851.evisita.config.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class EVisitaSchema {
    private final String message;
    private final String field;
    private final String hint;
}
