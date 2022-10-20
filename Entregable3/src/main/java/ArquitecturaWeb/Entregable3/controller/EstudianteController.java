package ArquitecturaWeb.Entregable3.controller;
import ArquitecturaWeb.Entregable3.models.Estudiante;
import ArquitecturaWeb.Entregable3.service.EstudianteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    @Autowired
    EstudianteService estudianteService;

    @PostMapping(value="/agregar", produces="application/json", consumes="application/json")
    public Estudiante addStudent(@RequestBody Estudiante e){
        return estudianteService.save(e);
    }

    @RequestMapping(value = "/{lu}", method = RequestMethod.GET, produces = "application/json")
    public Estudiante getEstudianteByLU(@PathVariable Long lu){
        return estudianteService.findByLU(lu);
    }

    @RequestMapping(value = "/genero/{genero}", method = RequestMethod.GET, produces = "application/json")
    public List<Estudiante> getEstudiantesbyGenero(@PathVariable String genero){
        return estudianteService.findByGenero(genero);
    }

    @RequestMapping(value = "/apellido", method = RequestMethod.GET, produces = "application/json")
    public List<Estudiante> getEstudiantesbyApellido(){
        return estudianteService.findAllOrdenadoApellido();
    }

    @RequestMapping(value = "/byCarreraCiudad", params={"carrera","ciudad"}, method = RequestMethod.GET, produces = "application/json")
    public List<Estudiante> getEstudiantesbyCarreraYCiudad(@RequestParam Long carrera, @RequestParam String ciudad){
        return estudianteService.findByCarreraYCiudad(carrera, ciudad);
    }
}
