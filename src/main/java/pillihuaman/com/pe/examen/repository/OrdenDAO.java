package pillihuaman.com.pe.examen.repository;


import pillihuaman.com.pe.examen.repository.orden.dao.Orden;

import java.util.Optional;

public interface OrdenDAO {
    Orden save(Orden orden);
    Optional<Orden> findById(String id);
    Orden update(Orden orden);
}