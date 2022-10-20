package ArquitecturaWeb.Entregable3.repository;
import ArquitecturaWeb.Entregable3.models.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long> {

    @Query("SELECT DISTINCT c " +
            "FROM Inscripcion i, Estudiante e, Carrera c "+
            "WHERE c.idCarrera = i.idCarrera " +
            "AND e.libretaUniversitaria = i.libretaUniversitaria "+
            "GROUP BY i.idCarrera "+
            "ORDER BY COUNT(i.libretaUniversitaria) DESC" )
    List<Carrera> findAllCarrerasOrdenadas();

}