package com.example.jpa.core.exception;

import com.example.jpa.api.service.dto.MessageDTO;
import com.example.jpa.core.utils.ExceptionUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<MessageDTO.Error> errorHandler(Exception e) {
        return responseEntity(GlobalErrorCode.SERVER_ERROR, e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<MessageDTO.Error> responseEntity(GlobalErrorCode errorCode, Exception e, HttpStatus status) {

        e.printStackTrace();

        MessageDTO.Error message = MessageDTO.Error.builder()
                .status(status.value())
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .data(ExceptionUtil.getPrintStackTrace(e))
                .build();

        return new ResponseEntity<>(message, status);
    }

}
