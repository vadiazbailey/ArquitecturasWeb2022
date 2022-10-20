package ArquitecturaWeb.Entregable3.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ArquitecturaWeb.Entregable3.models.Estudiante;
import ArquitecturaWeb.Entregable3.repository.EstudianteRepository;

@Service
public class EstudianteService {
    @Autowired
    EstudianteRepository estudianteRepository;

    public Estudiante save(Estudiante e){
         return estudianteRepository.save(e);
    }

    public List<Estudiante> findAll(){
        return estudianteRepository.findAll();
    }

    public Optional<Estudiante> findById(Long libretaUniversitaria){
        return estudianteRepository.findById(libretaUniversitaria);
    }

    public Estudiante findByLU(Long libreta_universitaria){
        return estudianteRepository.findByLU(libreta_universitaria);
    }

    public List<Estudiante> findByGenero(String genero){
        return estudianteRepository.findByGenero(genero);
    }

    public List<Estudiante> findAllOrdenadoApellido(){
        return estudianteRepository.findAllOrdenadoApellido();
    }

    public List<Estudiante> findByCarreraYCiudad(Long carrera, String ciudad){
        return estudianteRepository.findByCarreraYCiudad(carrera, ciudad);
    }

}
