package br.unicamp.mc851.evisita.config.interceptor;

import br.unicamp.mc851.evisita.config.exception.EVisitaException;
import br.unicamp.mc851.evisita.config.exception.EVisitaSchema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class EVisitaInterceptor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EVisitaException.class)
    public ResponseEntity<?> handle(EVisitaException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new EVisitaSchema(e.getMessage(), e.getField(), e.getHint()));
    }
}
