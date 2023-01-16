package com.facets.app.exceptions;

import com.facets.app.models.FacetsResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;


@ControllerAdvice
@RestController
@Slf4j
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ NodeAlreadyRegisteredException.class})
    public final ResponseEntity<FacetsResponseEntity<String>> handleNodeAlreadyPresentException(Exception ex, WebRequest request) {
        log.error("exception occurred ", ex);

        return  ResponseEntity.status(400).contentType(MediaType.APPLICATION_JSON).body(new FacetsResponseEntity<String>("Validation exception occurred please check your input data", List.of(new FacetsResponseEntity.ApiError(2001,"Virtual node is already present"))));
    }

    @ExceptionHandler({ConnectionGroupValidationException.class})
    public final ResponseEntity<FacetsResponseEntity<String>> handleConnectionGroupAlreadyPresentExceptions(Exception ex, WebRequest request) {
        log.error("exception occurred ", ex);

        return  ResponseEntity.status(400).contentType(MediaType.APPLICATION_JSON).body(new FacetsResponseEntity<String>("Validation exception occurred please check your input data",List.of(new FacetsResponseEntity.ApiError(2002,"Connection Group already present"))));
    }


    @ExceptionHandler({InvalidNodeException.class})
    public final ResponseEntity<FacetsResponseEntity<String>> handleInvalidNodeExceptions(Exception ex, WebRequest request) {
        log.error("exception occurred ", ex);

        return  ResponseEntity.status(400).contentType(MediaType.APPLICATION_JSON).body(new FacetsResponseEntity<String>("Validation exception occurred please check your input data",List.of(new FacetsResponseEntity.ApiError(2002,"Node is not present"))));
    }


}
