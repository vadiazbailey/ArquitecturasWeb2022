package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelos.Estudiante;

public class EstudianteRepository implements JPARepository<Estudiante> {
    private EntityManager em;

    /*
     * Constructor de la clase
     */
    public EstudianteRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    /*
     * Guarda un estudiante en la base de datos
     */
    public void save(Estudiante e) {
        if (!em.contains(e)) {
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        } else {
            em.merge(e);
        }
    }

    /**
     * Obtiene un estudiante por su libretaUniversitaria
     * 2. d) recuperar un estudiante, en base a su número de libreta universitaria.
     */
    public Estudiante getEstudianteByLibretaUniversitaria(int libretaUniversitaria) {
        return em.find(Estudiante.class, em);
    }

    /**
     * Obtiene todos los estudiantes por un determinado genero
     * 
     * @param gender
     * @return retorna una lista de estudiantes de un genero
     */
    public List<Estudiante> getByGender(String gender) {
        TypedQuery<Estudiante> tq = this.em.createNamedQuery(Estudiante.FIND_BY_GENDER, Estudiante.class)
                .setParameter("genero", gender);
        return tq.getResultList();
    }

    public List<Estudiante> getAll() {
        TypedQuery<Estudiante> tq = this.em.createNamedQuery(Estudiante.ORDER_BY_LASTNAME, Estudiante.class);
        return tq.getResultList();
    }

    public List<Estudiante> getById(int id) {
        TypedQuery<Estudiante> tq = this.em.createNamedQuery(Estudiante.FIND_BY_LU, Estudiante.class).setParameter("lu", id);
        return tq.getResultList();
    }

    public List<Estudiante> getByCarrerAndCity(int idCarrera, String ciudad) {
        TypedQuery<Estudiante> tq = this.em.createNamedQuery(Estudiante.FIND_BY_CARREER_CITY, Estudiante.class)
                .setParameter("carrera", idCarrera).setParameter("ciudad", ciudad);
        return tq.getResultList();
    }

}