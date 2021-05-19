package br.unicamp.mc851.evisita.config.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EVisitaException extends Exception {
    private String message;
    private String field;
    private String hint;

    public EVisitaException() {
        super();
    }
}
