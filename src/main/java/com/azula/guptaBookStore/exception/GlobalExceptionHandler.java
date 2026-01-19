package com.azula.guptaBookStore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 1️⃣ Book Not Found
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBookNotFound(BookNotFoundException e){
        ErrorResponse error=new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Resource Not Found",
                e.getMessage()
        );
        return new  ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    // 2️⃣ Duplicate ISBN
    @ExceptionHandler(DuplicateIsbnException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateIsbn(DuplicateIsbnException e){
        ErrorResponse error=new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                "Resource already exists",
                e.getMessage()
        );
        return new  ResponseEntity<>(error,HttpStatus.CONFLICT);
    }

    // 3️⃣ Invalid Price
    @ExceptionHandler(InvalidPriceException.class)
    public ResponseEntity<ErrorResponse> handleInvalidPrice(InvalidPriceException e){
        ErrorResponse error=new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Resource can't be zero",
                e.getMessage()
        );
        return new  ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    // 4️⃣ Negative Stock
    @ExceptionHandler(NegativeStockException.class)
    public ResponseEntity<ErrorResponse> handleNegativeStock(InvalidPriceException e){
        ErrorResponse error=new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Resource can't be negative",
                e.getMessage()
        );
        return new  ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    // 5️⃣ Validation Errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(
            MethodArgumentNotValidException ex) {

        String message = ex.getBindingResult()
                .getFieldError()
                .getDefaultMessage();

        ErrorResponse error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Validation Failed",
                message
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // 6️⃣ Illegal Arguments (Bad Request)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException ex) {

        ErrorResponse error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                ex.getMessage()
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // 7️⃣ Fallback (Any Other Exception)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {

        ex.printStackTrace(); // TEMPORARY

        ErrorResponse error = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                "Something went wrong"
        );

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
