package ArquitecturaWeb.Entregable3.models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Posee los datos de una inscripcion, fecha de inscripcion, carrera y estudiante.
 * @author vadiazbailey {@Link  https://github.com/vadiazbailey/ArquitecturaWeb2022/tree/main/TP2-Integrador}
 * @version 1.0
 */
@Entity
@Table(name = "inscripcion")
public class Inscripcion {
    @EmbeddedId
    private InscripcionId id;

    /**
     * Fecha de ingreso a la carrera
     */
    @Column(name = "fecha_inscripcion", nullable = false)
    private Timestamp fecha_inscripcion;

    /**
     * Fecha de egreso de la carrera
     */
    @Column(name = "fecha_egreso", nullable = true)
    private Timestamp fecha_egreso;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("libretaUniversitaria")
    @JoinColumn(name = "libreta_universitaria", nullable = false)
    private Estudiante libretaUniversitaria;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("idCarrera")
    @JoinColumn(name = "id_carrera", nullable = false)
    private Carrera idCarrera;


    public Inscripcion() {
    }

    /* ------- GETTERS & SETTERS --------- */

    public InscripcionId getId() {
        return id;
    }

    public void setId(InscripcionId id) {
        this.id = id;
    }

    public Estudiante getLibretaUniversitaria() {
        return libretaUniversitaria;
    }

    public void setLibretaUniversitaria(Estudiante libretaUniversitaria) {
        this.libretaUniversitaria = libretaUniversitaria;
    }

    public Carrera getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Carrera idCarrera) {
        this.idCarrera = idCarrera;
    }

    public Timestamp getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(Timestamp fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public Timestamp getFecha_egreso() {
        return fecha_egreso;
    }

    public void setFecha_egreso(Timestamp fecha_egreso) {
        this.fecha_egreso = fecha_egreso;
    }
}




