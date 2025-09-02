package pillihuaman.com.pe.examen.Service.Implement;

import org.springframework.stereotype.Service;
import pillihuaman.com.pe.examen.RequestResponse.dto.ReqOrdenActualizarEstado;
import pillihuaman.com.pe.examen.RequestResponse.dto.ReqOrdenCrear;
import pillihuaman.com.pe.examen.RequestResponse.dto.RespOrden;
import pillihuaman.com.pe.examen.RequestResponse.dto.mapper.OrdenMapper;
import pillihuaman.com.pe.examen.Service.OrdenService;
import pillihuaman.com.pe.examen.repository.OrdenDAO;
import pillihuaman.com.pe.examen.repository.orden.dao.Orden;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Service
public class OrdenServiceImpl implements OrdenService {

    private static final Set<String> ESTADOS_VALIDOS = Set.of("ENVIADO", "ENTREGADO", "CANCELADO");
    private final OrdenDAO ordenDAO;
    private final OrdenMapper mapper = OrdenMapper.INSTANCE;

    public OrdenServiceImpl(OrdenDAO ordenDAO) {
        this.ordenDAO = ordenDAO;
    }

    @Override
    public RespOrden crearOrden(ReqOrdenCrear req) {
        Orden nuevaOrden = mapper.reqCrearToOrden(req);
        nuevaOrden.setOrdenId(UUID.randomUUID().toString());
        nuevaOrden.setEstado("PENDIENTE");
        nuevaOrden.setFecha(Instant.now().toString());

        Orden ordenGuardada = ordenDAO.save(nuevaOrden);
        return mapper.ordenToResp(ordenGuardada);
    }

    @Override
    public RespOrden obtenerOrdenPorId(String id) {
        Orden orden = ordenDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada con ID: " + id)); // Idealmente una excepción custom
        return mapper.ordenToResp(orden);
    }

    @Override
    public RespOrden actualizarEstadoOrden(String id, ReqOrdenActualizarEstado req) {
        String nuevoEstado = req.getEstado().toUpperCase();
        if (!ESTADOS_VALIDOS.contains(nuevoEstado)) {
            throw new IllegalArgumentException("Estado no válido. Valores permitidos: " + ESTADOS_VALIDOS);
        }

        Orden ordenExistente = ordenDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada con ID: " + id));

        ordenExistente.setEstado(nuevoEstado);
        Orden ordenActualizada = ordenDAO.update(ordenExistente);
        return mapper.ordenToResp(ordenActualizada);
    }
}