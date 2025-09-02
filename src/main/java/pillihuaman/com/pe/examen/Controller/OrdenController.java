package pillihuaman.com.pe.examen.Controller;



import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pillihuaman.com.pe.examen.RequestResponse.dto.ReqOrdenActualizarEstado;
import pillihuaman.com.pe.examen.RequestResponse.dto.ReqOrdenCrear;
import pillihuaman.com.pe.examen.RequestResponse.dto.RespOrden;
import pillihuaman.com.pe.examen.Service.OrdenService;

@RestController
@RequestMapping("/orden")
public class OrdenController {

    private final OrdenService ordenService;

    public OrdenController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }

    @PostMapping
    public ResponseEntity<RespOrden> crearOrden(@Valid @RequestBody ReqOrdenCrear req) {
        RespOrden resp = ordenService.crearOrden(req);
        return new ResponseEntity<>(resp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespOrden> obtenerOrden(@PathVariable String id) {
        RespOrden resp = ordenService.obtenerOrdenPorId(id);
        return ResponseEntity.ok(resp);
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<RespOrden> actualizarEstado(
            @PathVariable String id,
            @Valid @RequestBody ReqOrdenActualizarEstado req) {
        RespOrden resp = ordenService.actualizarEstadoOrden(id, req);
        return ResponseEntity.ok(resp);
    }
}