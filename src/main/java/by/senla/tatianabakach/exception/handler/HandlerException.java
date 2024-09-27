package by.senla.tatianabakach.exception.handler;

import by.senla.tatianabakach.exception.DtoValidationException;
import by.senla.tatianabakach.exception.EntityNotFoundException;
import by.senla.tatianabakach.exception.SaveEntityException;
import by.senla.tatianabakach.exception.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

import static java.time.LocalDateTime.now;
import static java.util.Objects.nonNull;

@RestControllerAdvice
public class HandlerException {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(final EntityNotFoundException e){
        final ExceptionDTO response = ExceptionDTO.builder()
                .error("EntityNotFoundException")
                .message(e.getEntityClass() + " not found")
                .status(HttpStatus.NOT_FOUND)
                .timestamp(now())
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SaveEntityException.class)
    public ResponseEntity<Object> handleSaveEntityException(final SaveEntityException e){
        final ExceptionDTO response = ExceptionDTO.builder()
                .error("SaveEntityException")
                .message(e.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .timestamp(now())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DtoValidationException.class)
    public ExceptionDTO handleLibraryValidateException(final DtoValidationException e) {
        final ExceptionDTO response = new ExceptionDTO();
        final BindingResult bindingResult = e.getBindingResult();
        if (nonNull(bindingResult) && bindingResult.hasFieldErrors()) {
            response.setMessage(Objects.requireNonNull(bindingResult.getFieldError()).getField() + " - "
                    + bindingResult.getFieldError().getRejectedValue() + ", error - "
                    + bindingResult.getFieldError().getDefaultMessage());
        }
        response.setError(e.getClass().getSimpleName());
        response.setStatus(HttpStatus.BAD_REQUEST);
        response.setTimestamp(now());
        return response;
    }
}
