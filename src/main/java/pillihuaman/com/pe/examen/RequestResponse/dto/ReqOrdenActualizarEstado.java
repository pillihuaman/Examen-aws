package pillihuaman.com.pe.examen.RequestResponse.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReqOrdenActualizarEstado {
    @NotBlank(message = "El estado no puede estar vacío")
    private String estado;
}