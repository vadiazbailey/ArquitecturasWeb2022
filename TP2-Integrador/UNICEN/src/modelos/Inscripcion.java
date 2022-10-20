package modelos;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Posee los datos de una inscripcion, fecha de inscripcion, carrera y estudiante.
 * @author vadiazbailey {@Link  https://github.com/vadiazbailey/ArquitecturaWeb2022/tree/main/TP2-Integrador}
 * @version 1.0
 */
@Entity
public class Inscripcion implements Serializable{
     /**
     * Relacion con la clase Estudiante
     */
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Estudiante estudiante;
    
    /**
     * Relacion con la clase Carrera
     */
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Carrera carrera;

   

    /**
     * Fecha de ingreso a la carrera
     */
    @Column (name = "fecha_inscripcion", nullable = false)
	private Timestamp fecha_ingreso;
	
     /**
     * Fecha de egreso de la carrera
     */
	@Column(name = "fecha_egreso", nullable = true)
	private Timestamp fecha_egreso;

    /**
     * Constructor por defecto
     */
    public Inscripcion() {
    }

    public Inscripcion(Carrera carrera, Estudiante estudiante, Timestamp fecha_ingreso, Timestamp fecha_egreso) {
        this.carrera = carrera;
        this.estudiante = estudiante;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_egreso = fecha_egreso;
    }

    /**
     * Obtiene la carrera
     * @return the carrera
     */
    public Carrera getCarrera() {
        return carrera;
    }

    /**
     * Establece la carrera
     * @param carrera the carrera to set
     */
    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    /**
     * Obtiene el estudiante
     * @return the estudiante
     */
    public Estudiante getEstudiante() {
        return estudiante;
    }

    /**
     * Establece el estudiante
     * @param estudiante the estudiante to set
     */
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    /**
     * Obtiene la fecha de ingreso
     * @return the fecha_ingreso
     */
    public Timestamp getFecha_ingreso() {
        return fecha_ingreso;
    }

    /**
     * Establece la fecha de ingreso
     * @param fecha_ingreso the fecha_ingreso to set
     */
    public void setFecha_ingreso(Timestamp fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    /**
     * Obtiene la fecha de egreso
     * @return the fecha_egreso
     */
    public Timestamp getFecha_egreso() {
        return fecha_egreso;
    }

    /**
     * Establece la fecha de egreso
     * @param fecha_egreso the fecha_egreso to set
     */
    public void setFecha_egreso(Timestamp fecha_egreso) {
        this.fecha_egreso = fecha_egreso;
    }

    /**
     * Imprime los datos de la inscripcion
     */
    @Override
    public String toString() {
        return "Inscripcion [carrera=" + carrera + ", estudiante=" + estudiante + ", fecha_ingreso=" + fecha_ingreso
                + ", fecha_egreso=" + fecha_egreso + "]";
    }

}
