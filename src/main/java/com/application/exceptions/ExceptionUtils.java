package com.application.exceptions;

import java.util.function.Supplier;

public interface ExceptionUtils {
    Supplier<BusinessException> throwException();
    Supplier<BusinessException> throwException(String errorCode);
}
