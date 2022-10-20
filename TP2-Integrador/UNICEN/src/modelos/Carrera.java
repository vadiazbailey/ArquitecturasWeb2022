package modelos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * Posee los datos de una carrera, su identificador, nombre y un listado de alumnos.
 * @author vadiazbailey {@Link  https://github.com/vadiazbailey/ArquitecturaWeb2022/tree/main/TP2-Integrador}
 * @version 1.0
 */

@Entity
@NamedQueries(value = {
    @NamedQuery(name = Carrera.FIND_ALL, query = "SELECT c FROM Carrera c"),
    @NamedQuery(name = Carrera.FIND_ALL_BY_NAME, query = "SELECT c FROM Carrera c ORDER BY c.nombre"),
    @NamedQuery(name = Carrera.FIND_CON_INSCRIPTOS, query = "SELECT DISTINCT i.carrera FROM Inscripcion i, Estudiante e, Carrera c WHERE c.idCarrera = i.carrera.idCarrera AND e.libretaUniversitaria = i.estudiante.libretaUniversitaria GROUP BY i.carrera.idCarrera ORDER BY COUNT(i.estudiante) DESC"),
    @NamedQuery(name = Carrera.FIND_FECHA_INGRESO, query = "SELECT YEAR(i.fecha_ingreso) FROM Inscripcion i GROUP BY YEAR(i.fecha_ingreso) ORDER BY YEAR(i.fecha_ingreso) ASC"),
    @NamedQuery(name = Carrera.FIND_FECHA_EGRESO, query = "SELECT YEAR(i.fecha_egreso) FROM Inscripcion i where fecha_egreso IS NOT NULL GROUP BY YEAR(i.fecha_egreso) ORDER BY YEAR(i.fecha_egreso) ASC"),
    @NamedQuery(name = Carrera.FIND_INGRESANTES_DE_CARRERA_POR_FECHA, query = "SELECT i.estudiante FROM Inscripcion i,  Estudiante e, Carrera c WHERE c.idCarrera = i.carrera.idCarrera AND e.libretaUniversitaria = i.estudiante.libretaUniversitaria AND c.idCarrera = :carreraId AND YEAR (i.fecha_ingreso) = :fecha"),
	@NamedQuery(name = Carrera.FIND_EGRESADOS_DE_CARRERA_POR_FECHA, query = "SELECT i.estudiante FROM Inscripcion i,  Estudiante e, Carrera c WHERE c.idCarrera = i.carrera.idCarrera AND e.libretaUniversitaria = i.estudiante.libretaUniversitaria AND c.idCarrera = :carreraId AND YEAR (i.fecha_egreso) = :fecha")
})
public class Carrera {
    public static final String FIND_ALL = "Carrera.findAll";
    public static final String FIND_ALL_BY_NAME = "Carrera.findAllByName";
    public static final String FIND_CON_INSCRIPTOS = "Carrera.findConInscriptos";
    public static final String FIND_FECHA_INGRESO = "Carrera.findFechaIngreso";
    public static final String FIND_FECHA_EGRESO = "Carrera.findFechaEgreso";
    public static final String FIND_INGRESANTES_DE_CARRERA_POR_FECHA = "Carrera.buscarInscriptosDeCarreraPorFecha";
	public static final String FIND_EGRESADOS_DE_CARRERA_POR_FECHA = "Carrera.buscarEgresadosDeCarreraPorFecha";

    /**
     * Identificador de la carrera
     */
    @Id
    private int idCarrera;

    /**
     * Nombre de la carrera
     */
    @Column (name = "nombre", nullable = false)
    private String nombre;

    /**
     * Listado de alumnos que cursan la carrera
     */
    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Inscripcion> alumnos;

    /**
     * Constructor por defecto
     */
    public Carrera() {
    }

    public Carrera(int idCarrera, String nombre) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
    }

    /**
     * Constructor con listado de alumnos
     */
    public Carrera(int idCarrera, String nombre, List<Inscripcion> alumnos) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        alumnos = new ArrayList<Inscripcion>();
    }

    /**
     * Obtiene el identificador de la carrera
     * @return the idCarrera
     */
    public int getIdCarrera() {
        return idCarrera;
    }

    /**
     * Establece el identificador de la carrera
     * @param idCarrera the idCarrera to set
     */
    public void setIdCarrera(int idCarrera) {
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
     * Obtiene el listado de alumnos que cursan la carrera
     * @return the alumnos
     */
    public List<Inscripcion> getAlumnos() {
        return alumnos;
    }

    /**
     * Establece el listado de alumnos que cursan la carrera
     * @param alumnos the alumnos to set
     */
    public void setAlumnos(List<Inscripcion> alumnos) {
        this.alumnos = alumnos;
    }

    /**
     * Genera un String con los datos de la carrera
     */
    @Override
    public String toString() {
        return "Carrera [idCarrera=" + idCarrera + ", nombre=" + nombre + "]";
    }
 
}
