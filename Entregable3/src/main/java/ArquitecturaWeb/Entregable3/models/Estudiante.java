package ArquitecturaWeb.Entregable3.models;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "estudiante")
public class Estudiante {
    /**
     * Identificador del estudiante
     * Consideramos como identificador unico la libreta universitaria, ya que los dni a veces pueden coincidir
     */
    @Id
    @Column(name = "libreta_universitaria", nullable = false)
    private Long libretaUniversitaria;

    /**
     * Listado de inscripciones del estudiante
     */
    @OneToMany(mappedBy = "libretaUniversitaria",cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Set<Inscripcion> inscripcionId;

    /**
     * Nombre del estudiante
     */
    @Column (name = "nombre", nullable = false)
    private String nombre;

    /**
     * Apellido del estudiante
     */
    @Column (name = "apellido", nullable = false)
    private String apellido;

    /**
     * Edad del estudiante
     */
    @Column (name = "edad", nullable = false)
    private int edad;

    /**
     * Listado de inscripciones del estudiante
     */
    @Column (name = "genero", nullable = false)
    private String genero;

    /**
     * Listado de inscripciones del estudiante
     */
    @Column (name = "dni", nullable = false)
    private int dni;

    /**
     * Listado de inscripciones del estudiante
     */
    @Column (name = "ciudadResidencia", nullable = false)
    private String ciudadResidencia;


    /**
     * Constructor por defecto
     */
    public Estudiante() {
    }

    public Estudiante(Long libretaUniversitaria,
                      String nombre,
                      String apellido,
                      int edad,
                      String genero,
                      int dni,
                      String ciudadResidencia) {
        this.libretaUniversitaria = libretaUniversitaria;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.dni = dni;
        this.ciudadResidencia = ciudadResidencia;
    }

    /**
     * Obtiene el identificador del estudiante
     * @return identificador del estudiante
     */
    public Long getLibretaUniversitaria() {
        return libretaUniversitaria;
    }

    /**
     * Establece el identificador del estudiante
     * @param libretaUniversitaria del estudiante
     */
    public void setLibretaUniversitaria(Long libretaUniversitaria) {
        this.libretaUniversitaria = libretaUniversitaria;
    }

    /**
     * Obtiene el nombre del estudiante
     * @return nombre del estudiante
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del estudiante
     * @param nombre del estudiante
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del estudiante
     * @return apellido del estudiante
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del estudiante
     * @param apellido del estudiante
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene la edad del estudiante
     * @return edad del estudiante
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del estudiante
     * @param edad del estudiante
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene el genero del estudiante
     * @return genero del estudiante
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el genero del estudiante
     * @param genero del estudiante
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene el dni del estudiante
     * @return dni del estudiante
     */
    public int getDni() {
        return dni;
    }

    /**
     * Establece el dni del estudiante
     * @param dni del estudiante
     */
    public void setDni(int dni) {
        this.dni = dni;
    }

    /**
     * Obtiene la ciudad de residencia del estudiante
     * @return ciudad de residencia del estudiante
     */
    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    /**
     * Establece la ciudad de residencia del estudiante
     * @param ciudadResidencia del estudiante
     */
    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    /**
     * Imprime los datos del estudiante
     */
    @Override
    public String toString() {
        return "Estudiante [libretaUniversitaria=" + libretaUniversitaria + ", nombre=" + nombre + ", apellido="
                + apellido + ", edad=" + edad + ", genero=" + genero + ", dni=" + dni + ", ciudadResidencia="
                + ciudadResidencia + "]";
    }

    public Set<Inscripcion> getInscripcionId() {
        return inscripcionId;
    }

    public void setInscripcionId(Set<Inscripcion> inscripcionId) {
        this.inscripcionId = inscripcionId;
    }
}
