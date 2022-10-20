package ArquitecturaWeb.Entregable3.controller;
import ArquitecturaWeb.Entregable3.models.Carrera;
import ArquitecturaWeb.Entregable3.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carreras")
public class CarreraController {
    @Autowired
    private CarreraService carreraService;

    @RequestMapping("/all")
    public List<Carrera> getAllCarrerasInscriptosOrdenadas() {
        return carreraService.findAllCarrerasOrdenadas();
    }

}
