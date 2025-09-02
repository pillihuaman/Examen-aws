package pillihuaman.com.pe.examen.Service;


import pillihuaman.com.pe.examen.RequestResponse.dto.ReqOrdenActualizarEstado;
import pillihuaman.com.pe.examen.RequestResponse.dto.ReqOrdenCrear;
import pillihuaman.com.pe.examen.RequestResponse.dto.RespOrden;

public interface OrdenService {
    RespOrden crearOrden(ReqOrdenCrear req);
    RespOrden obtenerOrdenPorId(String id);
    RespOrden actualizarEstadoOrden(String id, ReqOrdenActualizarEstado req);
}