package pillihuaman.com.pe.examen.RequestResponse.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pillihuaman.com.pe.examen.RequestResponse.dto.ReqOrdenCrear;
import pillihuaman.com.pe.examen.RequestResponse.dto.RespOrden;
import pillihuaman.com.pe.examen.repository.orden.dao.Orden;

@Mapper
public interface OrdenMapper {
    OrdenMapper INSTANCE = Mappers.getMapper(OrdenMapper.class);

    @Mapping(target = "ordenId", ignore = true)
    @Mapping(target = "fecha", ignore = true)
    @Mapping(target = "estado", ignore = true)
    Orden reqCrearToOrden(ReqOrdenCrear req);

    RespOrden ordenToResp(Orden orden);
}