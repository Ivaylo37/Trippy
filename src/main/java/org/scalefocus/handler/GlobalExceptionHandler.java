package org.scalefocus.handler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.scalefocus.exception.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@RestControllerAdvice
public class GlobalExceptionHandler {


    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, List<String>>> handleInvalidParameter(
            MethodArgumentTypeMismatchException exception) {

        log.error("Caught exception: ", exception);

        String error = "Query or template parameter unacceptable";

        Map<String, List<String>> errorsMap = formatErrorsResponse(error);
        return new ResponseEntity<>(errorsMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, List<String>>> handleInvalidFormatControllerException(
            HttpMessageNotReadableException exception) {

        log.error("Caught exception: ", exception);

        Throwable cause = exception.getCause();
        String error;
        if (cause instanceof InvalidFormatException) {
            String message = cause.getMessage();
            error = message.substring(0, message.indexOf("\n"));
        } else {
            error = "Body format unacceptable";
        }

        Map<String, List<String>> errorsMap = formatErrorsResponse(error);
        return new ResponseEntity<>(errorsMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handleControllerValidationException(
            MethodArgumentNotValidException exception) {

        log.error("Caught exception: ", exception);

        List<String> errors = exception.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
        return new ResponseEntity<>(formatErrorsResponse(errors), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BusinessAlreadyExistsException.class)
    public ResponseEntity<Map<String, List<String>>> handleBusinessAlreadyExistsException(BusinessAlreadyExistsException exception){
        log.error("Caught exception: " + exception);
        String error = exception.getMessage();
        Map<String, List<String>> errorsMap = formatErrorsResponse(error);
        return new ResponseEntity<>(errorsMap, HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(BusinessNotFoundException.class)
    public ResponseEntity<Map<String, List<String>>> handleBusinessNotFoundException(BusinessNotFoundException exception){
        log.error("Caught exception: " + exception);
        String error = exception.getMessage();
        Map<String, List<String>> errorsMap = formatErrorsResponse(error);
        return new ResponseEntity<>(errorsMap, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidCityException.class)
    public ResponseEntity<Map<String, List<String>>> handleInvalidCityException(InvalidCityException exception){
        log.error("Caught exception: " + exception);
        String error = exception.getMessage();
        Map<String, List<String>> errorsMap = formatErrorsResponse(error);
        return new ResponseEntity<>(errorsMap, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<Map<String, List<String>>> handleInvalidEmailException(InvalidEmailException exception){
        log.error("Caught exception: " + exception);
        String error = exception.getMessage();
        Map<String, List<String>> errorsMap = formatErrorsResponse(error);
        return new ResponseEntity<>(errorsMap, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(InvalidFeedbackException.class)
    public ResponseEntity<Map<String, List<String>>> handleInvalidFeedbackException(InvalidFeedbackException exception){
        log.error("Caught exception: " + exception);
        String error = exception.getMessage();
        Map<String, List<String>> errorsMap = formatErrorsResponse(error);
        return new ResponseEntity<>(errorsMap, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(InvalidNameException.class)
    public ResponseEntity<Map<String, List<String>>> handleInvalidNameException(InvalidNameException exception){
        log.error("Caught exception: " + exception);
        String error = exception.getMessage();
        Map<String, List<String>> errorsMap = formatErrorsResponse(error);
        return new ResponseEntity<>(errorsMap, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(InvalidPhoneNumberFormatException.class)
    public ResponseEntity<Map<String, List<String>>> handleInvalidPhoneNumberFormatException(InvalidPhoneNumberFormatException exception){
        log.error("Caught exception: " + exception);
        String error = exception.getMessage();
        Map<String, List<String>> errorsMap = formatErrorsResponse(error);
        return new ResponseEntity<>(errorsMap, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(InvalidRatingException.class)
    public ResponseEntity<Map<String, List<String>>> handleInvalidRatingException(InvalidRatingException exception){
        log.error("Caught exception: " + exception);
        String error = exception.getMessage();
        Map<String, List<String>> errorsMap = formatErrorsResponse(error);
        return new ResponseEntity<>(errorsMap, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(InvalidTypeException.class)
    public ResponseEntity<Map<String, List<String>>> handleInvalidTypeException(InvalidTypeException exception){
        log.error("Caught exception: " + exception);
        String error = exception.getMessage();
        Map<String, List<String>> errorsMap = formatErrorsResponse(error);
        return new ResponseEntity<>(errorsMap, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(InvalidUsernameException.class)
    public ResponseEntity<Map<String, List<String>>> handleInvalidUsernameException(InvalidUsernameException exception){
        log.error("Caught exception: " + exception);
        String error = exception.getMessage();
        Map<String, List<String>> errorsMap = formatErrorsResponse(error);
        return new ResponseEntity<>(errorsMap, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ReviewNotFoundException.class)
    public ResponseEntity<Map<String, List<String>>> handleReviewNotFoundException(ReviewNotFoundException exception){
        log.error("Caught exception: " + exception);
        String error = exception.getMessage();
        Map<String, List<String>> errorsMap = formatErrorsResponse(error);
        return new ResponseEntity<>(errorsMap, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, List<String>>> handleUserNotFoundException(UserNotFoundException exception){
        log.error("Caught exception: " + exception);
        String error = exception.getMessage();
        Map<String, List<String>> errorsMap = formatErrorsResponse(error);
        return new ResponseEntity<>(errorsMap, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, List<String>>> handleUnexpectedException(Exception exception) {
        log.error("Caught exception: ", exception);

        String error = "Something went wrong";
        Map<String, List<String>> errorsMap = formatErrorsResponse(error);
        return new ResponseEntity<>(errorsMap, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    private Map<String, List<String>> formatErrorsResponse(String... errors) {
        return formatErrorsResponse(Arrays.stream(errors).collect(Collectors.toList()));
    }

    private Map<String, List<String>> formatErrorsResponse(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>(4);
        errorResponse.put("Errors", errors);
        return errorResponse;
    }


}