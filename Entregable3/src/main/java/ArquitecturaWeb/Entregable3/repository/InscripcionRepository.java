package ArquitecturaWeb.Entregable3.repository;
import ArquitecturaWeb.Entregable3.models.Inscripcion;
import ArquitecturaWeb.Entregable3.models.InscripcionId;
import ArquitecturaWeb.Entregable3.models.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, InscripcionId> {

}
