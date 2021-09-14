package ari.nuryadi.testingbackend.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateEntityException extends RuntimeException {

    public DuplicateEntityException() {
    }

    public DuplicateEntityException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public DuplicateEntityException(final String message) {
        super(message);
    }

    public DuplicateEntityException(final Throwable cause) {
        super(cause);
    }
}
