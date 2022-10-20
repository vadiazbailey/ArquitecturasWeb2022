package ArquitecturaWeb.Entregable3.models;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class InscripcionId implements Serializable {

    @Column(name = "id_carrera")
    private Long idCarrera;

    @Column(name = "libreta_universitaria")
    private Long libretaUniversitaria;

    public Long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }

    public Long getLibretaUniversitaria() {
        return libretaUniversitaria;
    }

    public void setLibretaUniversitaria(Long libretaUniversitaria) {
        this.libretaUniversitaria = libretaUniversitaria;
    }

    public InscripcionId() {
    }

    public InscripcionId(Long idCarrera, Long libretaUniversitaria) {
        this.idCarrera = idCarrera;
        this.libretaUniversitaria = libretaUniversitaria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InscripcionId that = (InscripcionId) o;

        if(idCarrera != that.idCarrera) return false;
        if(libretaUniversitaria != that.libretaUniversitaria) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = (int)(this.libretaUniversitaria ^ (this.libretaUniversitaria >>> 32));
        result = 31 * result + (int)(this.idCarrera ^ (this.idCarrera >>> 32));
        return result;
    }
}
