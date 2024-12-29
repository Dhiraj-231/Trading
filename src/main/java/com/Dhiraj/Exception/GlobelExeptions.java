package com.Dhiraj.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobelExeptions {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorDetails> userExceptionHandler(UserException ue, WebRequest req){
        ErrorDetails errorDetails=new ErrorDetails(ue.getMessage(),req.getDescription(false), LocalDateTime.now());
      return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDetails> handleRunTimeException(RuntimeException ex,WebRequest request){
        ErrorDetails errorDetails=new ErrorDetails(ex.getMessage(),request.getDescription(false),LocalDateTime.now());
        return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleOtherExceptions(Exception ex,WebRequest request){
        ErrorDetails errorDetails=new ErrorDetails(ex.getMessage(),request.getDescription(false),LocalDateTime.now());
        return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(OrderException.class)
    public ResponseEntity<ErrorDetails> orderExceptionHandler(OrderException oe,WebRequest request){
        ErrorDetails errorDetails=new ErrorDetails(oe.getMessage(),request.getDescription(false),LocalDateTime.now());
        return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(WalletException.class)
    public ResponseEntity<ErrorDetails> walletExceptionHandler(WalletException we,WebRequest request){
        ErrorDetails errorDetails=new ErrorDetails(we.getMessage(),request.getDescription(false),LocalDateTime.now());
        return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
    }

}
