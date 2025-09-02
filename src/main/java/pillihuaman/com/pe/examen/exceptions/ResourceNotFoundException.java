package pillihuaman.com.pe.examen.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepción personalizada para representar la no existencia de un recurso.
 * Por ejemplo, buscar una cotización por un ID que no existe.
 *
 * La anotación @ResponseStatus(HttpStatus.NOT_FOUND) le indica a Spring
 * que devuelva un código de estado HTTP 404, que es el estándar para este caso.
 */
@ResponseStatus(HttpStatus.NOT_FOUND) // HTTP 404 Not Found
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}