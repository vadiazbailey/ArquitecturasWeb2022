package ArquitecturaWeb.Entregable3.models;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "vista_reporte")
public class Reporte {

   /* @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numero_reporte")
    private Long nroReporte;*/


    @Column(name = "nombre_carrera")
    private String nombreCarrera;
    @Column(name = "nombre_estudiante")
    private String nombreEstudiante;
    @Column(name = "apellido_estudiante")
    private String apellidoEstudiante;
    @Id
    @Column(name = "fecha_inscripcion_estudiante")

    private Timestamp fechaInscripcionEstudiante;
    @Column(name = "edad_estudiante")
    private String edadEstudiante;
    @Column(name = "fecha_egreso_estudiante")
    private Timestamp fechaEgresoEstudiante;
    @Column(name = "genero_estudiante")
    private String generoEstudiante;
    @Column(name = "ciudad_residencia_estudiante")
    private String ciudadResidenciaEstudiante;
    @Column(name = "dni_estudiante")
    private int dniEstudiante;

    public Reporte() {
    }



    /******* GETTERS & SETTERS ********/

    public Timestamp getFechaInscripcionEstudiante() {
        return fechaInscripcionEstudiante;
    }

    public void setFechaInscripcionEstudiante(Timestamp fechaInscripcionEstudiante) {
        this.fechaInscripcionEstudiante = fechaInscripcionEstudiante;
    }

    public Timestamp getFechaEgresoEstudiante() {
        return fechaEgresoEstudiante;
    }

    public void setFechaEgresoEstudiante(Timestamp fechaEgresoEstudiante) {
        this.fechaEgresoEstudiante = fechaEgresoEstudiante;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getApellidoEstudiante() {
        return apellidoEstudiante;
    }

    public void setApellidoEstudiante(String apellidoEstudiante) {
        this.apellidoEstudiante = apellidoEstudiante;
    }


    public String getEdadEstudiante() {
        return edadEstudiante;
    }

    public void setEdadEstudiante(String edadEstudiante) {
        this.edadEstudiante = edadEstudiante;
    }

    public String getGeneroEstudiante() {
        return generoEstudiante;
    }

    public void setGeneroEstudiante(String generoEstudiante) {
        this.generoEstudiante = generoEstudiante;
    }

    public String getCiudadResidenciaEstudiante() {
        return ciudadResidenciaEstudiante;
    }

    public void setCiudadResidenciaEstudiante(String ciudadResidenciaEstudiante) {
        this.ciudadResidenciaEstudiante = ciudadResidenciaEstudiante;
    }

    public int getDniEstudiante() {
        return dniEstudiante;
    }

    public void setDniEstudiante(int dniEstudiante) {
        this.dniEstudiante = dniEstudiante;
    }

    @Override
    public String toString() {
        return "Reporte{" +
                "nombreCarrera='" + nombreCarrera + '\'' +
                ", nombreEstudiante='" + nombreEstudiante + '\'' +
                ", apellidoEstudiante='" + apellidoEstudiante + '\'' +
                ", fechaInscripcionEstudiante=" + fechaInscripcionEstudiante +
                ", edadEstudiante='" + edadEstudiante + '\'' +
                ", fechaEgresoEstudiante=" + fechaEgresoEstudiante +
                ", generoEstudiante='" + generoEstudiante + '\'' +
                ", ciudadResidenciaEstudiante='" + ciudadResidenciaEstudiante + '\'' +
                ", dniEstudiante=" + dniEstudiante +
                '}';
    }
}
