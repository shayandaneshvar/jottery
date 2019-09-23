package ir.shayandaneshvar.jottery.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super();
    }

    public NotFoundException(String s) {
        super(s);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
