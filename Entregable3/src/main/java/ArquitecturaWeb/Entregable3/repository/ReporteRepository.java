package ArquitecturaWeb.Entregable3.repository;

import ArquitecturaWeb.Entregable3.models.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReporteRepository extends JpaRepository<Reporte, Long> {

    @Query(value = "SELECT c.nombre as nombre_carrera, e.nombre as nombre_estudiante, e.apellido as apellido_estudiante, e.ciudad_residencia as ciudad_residencia_estudiante, e.dni as dni_estudiante, e.edad as edad_estudiante, e.genero as genero_estudiante, i.fecha_inscripcion as fecha_inscripcion_estudiante, i.fecha_egreso as fecha_egreso_estudiante " +
            "FROM inscripcion i " +
            "JOIN estudiante e " +
            "ON i.libreta_universitaria = e.libreta_universitaria " +
            "JOIN carrera c " +
            "ON i.id_carrera = c.id_carrera " +
            "WHERE i.fecha_inscripcion IS NOT NULL " +
            "ORDER BY c.nombre ASC, fecha_inscripcion ASC", nativeQuery = true)
    List<Reporte> getReporte();
}
