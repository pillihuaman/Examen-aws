package pillihuaman.com.pe.examen.RequestResponse.dto.mapper;

import javax.annotation.processing.Generated;
import pillihuaman.com.pe.examen.RequestResponse.dto.ReqOrdenCrear;
import pillihuaman.com.pe.examen.RequestResponse.dto.RespOrden;
import pillihuaman.com.pe.examen.repository.orden.dao.Orden;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-02T12:03:56-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Amazon.com Inc.)"
)
public class OrdenMapperImpl implements OrdenMapper {

    @Override
    public Orden reqCrearToOrden(ReqOrdenCrear req) {
        if ( req == null ) {
            return null;
        }

        Orden orden = new Orden();

        orden.setClienteId( req.getClienteId() );
        orden.setMontoTotal( req.getMontoTotal() );

        return orden;
    }

    @Override
    public RespOrden ordenToResp(Orden orden) {
        if ( orden == null ) {
            return null;
        }

        RespOrden.RespOrdenBuilder respOrden = RespOrden.builder();

        respOrden.ordenId( orden.getOrdenId() );
        respOrden.clienteId( orden.getClienteId() );
        respOrden.fecha( orden.getFecha() );
        respOrden.montoTotal( orden.getMontoTotal() );
        respOrden.estado( orden.getEstado() );

        return respOrden.build();
    }
}
