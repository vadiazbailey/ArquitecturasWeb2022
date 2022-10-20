package ArquitecturaWeb.Entregable3.models;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "carrera")
public class Carrera {
    /**
     * Identificador de la carrera
     */
    @Id
    @Column(name = "id_carrera", nullable = false)
    private Long idCarrera;


    /**
     * Nombre de la carrera
     */
    @Column(name = "nombre", nullable = false)
    private String nombre;

    /**
     * Listado de alumnos que cursan la carrera
     */
    @OneToMany(mappedBy = "idCarrera", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Set<Inscripcion> inscripcionId;

    /**
     * Constructor por defecto
     */
    public Carrera() {
    }


    public Long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }

    /**
     * Obtiene el nombre de la carrera
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la carrera
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Genera un String con los datos de la carrera
     */
    @Override
    public String toString() {
        return "Carrera [idCarrera=" + idCarrera + ", nombre=" + nombre + "]";
    }

    public Set<Inscripcion> getInscripcionId() {
        return inscripcionId;
    }

    public void setInscripcionId(Set<Inscripcion> inscripcionId) {
        this.inscripcionId = inscripcionId;
    }
}
