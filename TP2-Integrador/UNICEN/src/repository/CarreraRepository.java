package repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelos.Carrera;
import modelos.Estudiante;
import modelos.RegistroInscripcion;


/*
 * Repositorio de la clase Carrera
 * 
 *@author beltranpenia
 *@version 1.0
 */
public class CarreraRepository implements JPARepository<Carrera> {

    private EntityManager em = null;

    /*
     * Constructor de la clase
     */
    public CarreraRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Carrera c) {
     if(!em.contains(c)){
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }
    else{
        em.merge(c);
        }
    }
        
    /*
    * Obtiene todas las carreras
    */
    public List<Carrera> getAll(){
        TypedQuery<Carrera> tq = em.createNamedQuery(Carrera.FIND_ALL, Carrera.class);
        return tq.getResultList();
    }

    public List<Carrera> getAllByName(){
        TypedQuery<Carrera> tq = em.createNamedQuery(Carrera.FIND_ALL_BY_NAME, Carrera.class);
        return tq.getResultList();
    }

    /*
    * Obtiene las carreras que contengan inscriptos
    */
    public List<Carrera> getCarrerasConInscriptos(){
        TypedQuery<Carrera> tq = em.createNamedQuery(Carrera.FIND_CON_INSCRIPTOS, Carrera.class);
        return tq.getResultList();
    }

    public List<RegistroInscripcion> getReporteCarreras() {
		TypedQuery<Integer> tqIngreso = em.createNamedQuery(Carrera.FIND_FECHA_INGRESO, Integer.class);
		TypedQuery<Integer> tqEgreso = em.createNamedQuery(Carrera.FIND_FECHA_EGRESO, Integer.class);
		List<Integer> fechasIngreso = tqIngreso.getResultList();
		List<Integer> fechasEgreso = tqEgreso.getResultList();
		List<Carrera> carreras = this.getAllByName();
		ArrayList<RegistroInscripcion> resultado = new ArrayList<RegistroInscripcion>();

		for (Carrera c : carreras){						
			LinkedHashMap<Integer, List<Estudiante>> inscriptos = new LinkedHashMap<Integer, List<Estudiante>>();
			LinkedHashMap<Integer, List<Estudiante>> egresados = new LinkedHashMap<Integer, List<Estudiante>>();

			for (Integer fi : fechasIngreso) {
				TypedQuery<Estudiante> tq1 = em.createNamedQuery(Carrera.FIND_INGRESANTES_DE_CARRERA_POR_FECHA, Estudiante.class)
						.setParameter("carreraId", c.getIdCarrera()).setParameter("fecha", fi);
				List<Estudiante> estudiantesInscriptos = tq1.getResultList();
				if(!estudiantesInscriptos.isEmpty()) {	
					inscriptos.put(fi, estudiantesInscriptos);
				}
			}   
			for(Integer fe : fechasEgreso){
				TypedQuery<Estudiante> tq2 = em.createNamedQuery(Carrera.FIND_EGRESADOS_DE_CARRERA_POR_FECHA, Estudiante.class)
						.setParameter("carreraId", c.getIdCarrera()).setParameter("fecha", fe);
				List<Estudiante> estudiantesEgresados = tq2.getResultList();
				if(!estudiantesEgresados.isEmpty()) {	
					egresados.put(fe, estudiantesEgresados);
				}
			}
			resultado.add(new RegistroInscripcion(c, inscriptos, egresados));
		}
		return resultado;
	}

}
    
