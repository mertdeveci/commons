package com.application.exceptions;

import com.application.exceptions.types.AlreadyExistsBusinessException;
import com.application.exceptions.types.BadRequestBusinessException;
import com.application.exceptions.types.NotFoundBusinessException;
import lombok.RequiredArgsConstructor;

import java.util.function.Supplier;

@RequiredArgsConstructor
public enum Exceptions implements ExceptionUtils {
    BAD_REQUEST("business.global.bad.request.exception"){
        @Override
        public Supplier<BusinessException> throwException(){
            throw new BadRequestBusinessException(getDefaultErrorMessage());
        }

        @Override
        public Supplier<BusinessException> throwException(String errorCode){
            throw new BadRequestBusinessException(errorCode);
        }
    },
    NOT_FOUND("business.global.not.found.exception"){
        @Override
        public Supplier<BusinessException> throwException(){
            throw new NotFoundBusinessException(getDefaultErrorMessage());
        }

        @Override
        public Supplier<BusinessException> throwException(String errorCode){
            throw new NotFoundBusinessException(errorCode);
        }
    },
    ALREADY_EXISTS("business.global.already.exists"){
        @Override
        public Supplier<BusinessException> throwException(){
            throw new AlreadyExistsBusinessException(getDefaultErrorMessage());
        }

        @Override
        public Supplier<BusinessException> throwException(String errorCode){
            throw new AlreadyExistsBusinessException(errorCode);
        }
    };

    private final String defaultErrorMessage;

    public String getDefaultErrorMessage() {
        return defaultErrorMessage;
    }
}
