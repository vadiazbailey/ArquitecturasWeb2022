package ArquitecturaWeb.Entregable3.controller;
import ArquitecturaWeb.Entregable3.models.*;
import ArquitecturaWeb.Entregable3.service.CarreraService;
import ArquitecturaWeb.Entregable3.service.EstudianteService;
import ArquitecturaWeb.Entregable3.service.InscripcionService;
import ArquitecturaWeb.Entregable3.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {
    @Autowired
    InscripcionService inscripcionService;
    @Autowired
    EstudianteService estudianteService;
    @Autowired
    CarreraService carreraService;
    @Autowired
    ReporteService reporteService;

    @RequestMapping(value="/inscribir", params = {"libretaUniversitaria","idCarrera"}, produces="application/json")
    public ResponseEntity<?> addInscripcion(@RequestParam Long libretaUniversitaria, @RequestParam Long idCarrera){
        Optional<Estudiante> e = estudianteService.findById(libretaUniversitaria);
        if (e.isEmpty()){
            // retorna not found si no existe el estudiante
            System.out.println("No existe el estudiante");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println(e.get().getLibretaUniversitaria());
        System.out.println(e.get().getNombre());
        Optional<Carrera> c = carreraService.findById(idCarrera);
        if(c.isEmpty()){
            // retorna not found si no existe la carrera
            System.out.println("No existe la carrera");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println(c.get().getIdCarrera());
        System.out.println(c.get().getNombre());

        InscripcionId iId = new InscripcionId();
        // set id de estudiante en InscripcionId
        iId.setLibretaUniversitaria(e.get().getLibretaUniversitaria());
        // set id de la carrera en InscripcionId
        iId.setIdCarrera(c.get().getIdCarrera());
        System.out.println(iId.getLibretaUniversitaria());
        System.out.println(iId.getIdCarrera());

        Inscripcion i = new Inscripcion();
        // setea el id de inscripcion con el id compuesto de inscripcionId
        i.setId(iId);
        // fecha actual
        Timestamp now = new Timestamp(System.currentTimeMillis());
        // setea fecha de inscripcion
        i.setFecha_inscripcion(now);
        // setea fecha egreso en null
        i.setFecha_egreso(null);
        // setea la carrera
        i.setIdCarrera(c.get());
        // setea el estudiante
        i.setLibretaUniversitaria(e.get());
        System.out.println(i.getFecha_inscripcion());
        System.out.println(i.getFecha_egreso());
        System.out.println(i.getId().getLibretaUniversitaria());
        // si se guarda la inscripcion retorna created
        if(inscripcionService.saveInscripcion(i) != null){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        // retorna bad request si no se guarda la inscripcion
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value="/getReporte", method = RequestMethod.GET, produces = "application/json")
    public List<Reporte> getReporte() {
        return reporteService.getReporte();
    }

}
