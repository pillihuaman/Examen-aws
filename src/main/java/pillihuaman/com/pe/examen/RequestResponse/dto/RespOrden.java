package pillihuaman.com.pe.examen.RequestResponse.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespOrden {
    private String ordenId;
    private String clienteId;
    private String fecha;
    private double montoTotal;
    private String estado;
}