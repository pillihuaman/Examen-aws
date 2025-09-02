package pillihuaman.com.pe.examen.RequestResponse.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ReqOrdenCrear {
    @NotNull(message = "clienteId no puede ser nulo")
    private String clienteId;
    @Positive(message = "montoTotal debe ser mayor a 0")
    private double montoTotal;
}