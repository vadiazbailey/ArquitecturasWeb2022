package modelos;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * Posee los datos de un estudiante, sus datos, con su identificador (libreta universitaria), nombre, apellido, 
 * edad y un listado de inscripciones a las carreras.
 * @author vadiazbailey {@Link  https://github.com/vadiazbailey/ArquitecturaWeb2022/tree/main/TP2-Integrador}
 * @version 1.0
 */
@Entity
@NamedQueries(value = {
    @NamedQuery(name = Estudiante.FIND_BY_LU, query = "SELECT e FROM Estudiante e WHERE e.libretaUniversitaria = :lu"),
    @NamedQuery(name = Estudiante.ORDER_BY_LASTNAME, query = "SELECT e FROM Estudiante e ORDER BY e.apellido"),
    @NamedQuery(name = Estudiante.FIND_BY_GENDER, query = "SELECT e FROM Estudiante e WHERE e.genero = :genero"),
    @NamedQuery(name = Estudiante.FIND_BY_CARREER_CITY, query = "SELECT i.estudiante FROM Inscripcion i, Estudiante e, Carrera c WHERE c.idCarrera = i.carrera.idCarrera AND e.libretaUniversitaria = i.estudiante.libretaUniversitaria AND c.idCarrera = :carrera AND i.estudiante.ciudadResidencia = :ciudad"),
})

public class Estudiante {
    public static final String FIND_BY_LU = "Estudiante.findByLU";
    public static final String FIND_BY_GENDER = "Estudiante.findByGender"; //Busca por genero
    public static final String ORDER_BY_LASTNAME = "Estudiante.orderByLastName";
    public static final String FIND_BY_CARREER_CITY = "Estudiante.findByCarrerAndCity";
    /**
     * Identificador del estudiante
     * Consideramos como identificador unico la libreta universitaria, ya que los dni a veces pueden coincidir
     */
    @Id
    private int libretaUniversitaria;

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
    @Column (name = "direccion", nullable = false)
    private String ciudadResidencia;

    /**
     * Listado de inscripciones del estudiante
     */
    @OneToMany (mappedBy = "estudiante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Inscripcion> inscripciones;

     /**
     * Constructor por defecto
     */
    public Estudiante() {
    }

    public Estudiante(int libretaUniversitaria, 
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
     * Constructor con listado de inscripciones
     */
    public Estudiante(int libretaUniversitaria, 
                      String nombre, 
                      String apellido,
                      int edad,
                      String genero,
                      int dni,
                      String ciudadResidencia, 
                      List<Inscripcion> inscripciones) {
        this.libretaUniversitaria = libretaUniversitaria;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.dni = dni;
        this.ciudadResidencia = ciudadResidencia;
        inscripciones = new ArrayList<Inscripcion>();
    }

    /**
     * Obtiene el identificador del estudiante
     * @return identificador del estudiante
     */
    public int getLibretaUniversitaria() {
        return libretaUniversitaria;
    }

    /**
     * Establece el identificador del estudiante
     * @param libretaUniversitaria del estudiante
     */
    public void setLibretaUniversitaria(int libretaUniversitaria) {
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
     * Obtiene el listado de inscripciones del estudiante
     * @return listado de inscripciones del estudiante
     */
    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    /**
     * Establece el listado de inscripciones del estudiante
     * @param inscripciones del estudiante
     */
    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
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

}
