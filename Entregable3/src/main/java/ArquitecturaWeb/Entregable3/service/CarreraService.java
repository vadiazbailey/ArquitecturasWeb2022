package ArquitecturaWeb.Entregable3.service;
import ArquitecturaWeb.Entregable3.models.Carrera;
import ArquitecturaWeb.Entregable3.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarreraService {
    @Autowired
    CarreraRepository carreraRepository;

    public Carrera save(Carrera c){
        return carreraRepository.save(c);
    }

    public Optional<Carrera> findById(Long idCarrera){
        return carreraRepository.findById(idCarrera);
    }

    public List<Carrera> findAllCarrerasOrdenadas(){
        return carreraRepository.findAllCarrerasOrdenadas();
    }
}
