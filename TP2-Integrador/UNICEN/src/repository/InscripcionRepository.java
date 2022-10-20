package repository;

import javax.persistence.EntityManager;

import modelos.Inscripcion;

public class InscripcionRepository implements JPARepository<Inscripcion> {
    private EntityManager em;

    /*
     * Constructor de la clase
     */
    public InscripcionRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    /*
     * Guarda una inscripcion en la base de datos
     */
    public void save(Inscripcion i) {
        if (!em.contains(i)) {
            em.getTransaction().begin();
            em.persist(i);
            em.getTransaction().commit();
        } else {
            em.merge(i);
        }
    }

}
