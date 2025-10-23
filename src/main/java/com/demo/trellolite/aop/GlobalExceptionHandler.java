package com.demo.trellolite.aop;

import com.demo.trellolite.exceptions.ResourceNotFoundException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Resource Not Found
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ProblemDetail handleResourceNotFound(ResourceNotFoundException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND,
                ex.getMessage()
        );
        problem.setTitle("Resource Not Found");
        problem.setProperty("timestamp", Instant.now());
        return problem;
    }

    // Mapping Errors
    @ExceptionHandler(MappingException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ProblemDetail handleMappingException(MappingException ex) {
        log.error("Mapping error occurred", ex); // Log for debugging

        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "An error occurred while processing data"
        );
        problem.setTitle("Data Mapping Error");
        problem.setProperty("timestamp", Instant.now());
        return problem;
    }

    // Authentication Errors
    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ProblemDetail handleBadCredentials(BadCredentialsException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.UNAUTHORIZED,
                "Authentication failed"
        );
        problem.setTitle("Invalid Credentials");
        problem.setProperty("description", "The username or password is incorrect");
        problem.setProperty("timestamp", Instant.now());
        return problem;
    }

    // Account Status Errors
    @ExceptionHandler(AccountStatusException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ProblemDetail handleAccountStatus(AccountStatusException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.FORBIDDEN,
                ex.getMessage()
        );
        problem.setTitle("Account Status Error");
        problem.setProperty("description", "The account is locked or disabled");
        problem.setProperty("timestamp", Instant.now());
        return problem;
    }

    // Access Denied
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ProblemDetail handleAccessDenied(AccessDeniedException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.FORBIDDEN,
                "Access denied"
        );
        problem.setTitle("Access Denied");
        problem.setProperty("description", "You are not authorized to access this resource");
        problem.setProperty("timestamp", Instant.now());
        return problem;
    }

    // JWT Signature Error
    @ExceptionHandler(SignatureException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ProblemDetail handleSignatureException(SignatureException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.FORBIDDEN,
                "Invalid token signature"
        );
        problem.setTitle("Invalid JWT Signature");
        problem.setProperty("description", "The JWT signature is invalid");
        problem.setProperty("timestamp", Instant.now());
        return problem;
    }

    // JWT Expired
    @ExceptionHandler(ExpiredJwtException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ProblemDetail handleExpiredJwt(ExpiredJwtException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.FORBIDDEN,
                "Token has expired"
        );
        problem.setTitle("Expired JWT Token");
        problem.setProperty("description", "The JWT token has expired");
        problem.setProperty("timestamp", Instant.now());
        return problem;
    }

    // Validation Errors (Optional - if using @Valid)
//    @ExceptionHandler(IllegalArgumentException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ProblemDetail handleIllegalArgument(IllegalArgumentException ex) {
//        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
//                HttpStatus.BAD_REQUEST,
//                ex.getMessage()
//        );
//        problem.setTitle("Invalid Request");
//        problem.setProperty("timestamp", Instant.now());
//        return problem;
//    }

    // Catch-all for unexpected exceptions
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ProblemDetail handleGenericException(Exception ex) {
        // Log the full exception with stack trace for debugging
        log.error("Unexpected error occurred", ex);

        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "An unexpected error occurred"
        );
        problem.setTitle("Internal Server Error");
        problem.setProperty("timestamp", Instant.now());

        // In development, you might want to include more details
        // if (isDevelopmentMode) {
        //     problem.setProperty("error", ex.getMessage());
        // }

        return problem;
    }


}