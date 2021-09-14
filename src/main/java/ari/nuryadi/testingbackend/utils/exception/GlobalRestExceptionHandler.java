package ari.nuryadi.testingbackend.utils.exception;

import ari.nuryadi.testingbackend.utils.response.ErrorResponse;
import ari.nuryadi.testingbackend.utils.response.StatusResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {

    public GlobalRestExceptionHandler() {
        super();
    }


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add("There's something wrong with the server, please try again later.");
        ErrorResponse error = new ErrorResponse(
                StatusResponse.ERROR_SERVER.getCode(),
                StatusResponse.ERROR_SERVER.getValue(),
                details);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<Object> handleBadRequestException(BadRequestException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());
        ErrorResponse error = new ErrorResponse(
                StatusResponse.ERROR_CREATE.getCode(),
                StatusResponse.ERROR_CREATE.getValue(),
                details);
        return new ResponseEntity(error, HttpStatus.OK);
    }

    @ExceptionHandler(RowNotFoundException.class)
    public final ResponseEntity<Object> handleEntityNotFoundException(RowNotFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());
        ErrorResponse error = new ErrorResponse(
                StatusResponse.ERROR_ENTITY_NOT_FOUND.getCode(),
                StatusResponse.ERROR_ENTITY_NOT_FOUND.getValue(),
                details);
        return new ResponseEntity(error, HttpStatus.OK);
    }

    @ExceptionHandler(RowNotFoundDetailNullException.class)
    public final ResponseEntity<Object> handleEntityNotFoundDetailNullException(RowNotFoundDetailNullException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());
        ErrorResponse error = new ErrorResponse(
                StatusResponse.ERROR_ENTITY_NOT_FOUND.getCode(),
                StatusResponse.ERROR_ENTITY_NOT_FOUND.getValue(),
                null);
        return new ResponseEntity(error, HttpStatus.OK);
    }

    @ExceptionHandler(DuplicateEntityException.class)
    public final ResponseEntity<Object> handleDuplicateEntityException(DuplicateEntityException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());
        ErrorResponse error = new ErrorResponse(
                StatusResponse.ERROR_DUPLICATE_ENTITY.getCode(),
                StatusResponse.ERROR_DUPLICATE_ENTITY.getValue(),
                details);
        return new ResponseEntity(error, HttpStatus.OK);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());
        ErrorResponse error = new ErrorResponse(
                StatusResponse.ERROR_DUPLICATE_ENTITY.getCode(),
                StatusResponse.ERROR_DUPLICATE_ENTITY.getValue(),
                details);
        return new ResponseEntity(error, HttpStatus.OK);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> details = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        ErrorResponse error = new ErrorResponse(
                StatusResponse.ERROR.getCode(),
                StatusResponse.ERROR_VALIDATION.getValue(),
                details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add("Required request body is missing, please check again.");
        ErrorResponse error = new ErrorResponse(
                StatusResponse.ERROR_EMPTY_REQUEST_BODY.getCode(),
                StatusResponse.ERROR_EMPTY_REQUEST_BODY.getValue(),
                details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
}
