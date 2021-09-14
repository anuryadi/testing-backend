package ari.nuryadi.testingbackend.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ConstraintViolationException extends RuntimeException {
    public ConstraintViolationException() {
    }

    public ConstraintViolationException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ConstraintViolationException(final String message) {
        super(message);
    }

    public ConstraintViolationException(final Throwable cause) {
        super(cause);
    }
}
