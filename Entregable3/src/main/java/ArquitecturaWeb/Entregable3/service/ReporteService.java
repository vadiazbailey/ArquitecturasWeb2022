package ArquitecturaWeb.Entregable3.service;

import ArquitecturaWeb.Entregable3.models.Reporte;
import ArquitecturaWeb.Entregable3.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteService {
    @Autowired
    ReporteRepository reporteRepository;

    public List<Reporte> getReporte(){
        return reporteRepository.getReporte();
    }
}
