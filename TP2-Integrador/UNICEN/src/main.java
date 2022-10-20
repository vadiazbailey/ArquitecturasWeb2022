/**
 * Los ejercicios 2 y 3 se resolvieron mediante el uso de createNamedQuery
 * 
 * Paquetes:
 * interfaces: contiene la interfaz que implementan los repositorios Carrera, Estudiante e Inscripcion
 * main: contiene el codigo en el que se instancian las clases
 * modelo: contiene las clases java mapeadas a sql   
 *  Repositorio: Contiene las clases del patrón repository
 *  
 */

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelos.Carrera;
import modelos.Estudiante;
import modelos.Inscripcion;
import modelos.RegistroInscripcion;
import repository.CarreraRepository;
import repository.EstudianteRepository;
import repository.InscripcionRepository;

public class main {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Entregable2");
		EntityManager em = emf.createEntityManager();
		
		EstudianteRepository studentRepo = new EstudianteRepository(em);
		CarreraRepository carrerRepo = new CarreraRepository(em);
		InscripcionRepository inscriptionRepo = new InscripcionRepository(em);
		
		// 2A) Dar de alta un estudiante
		System.out.println("\n 2.A) Dar de alta un estudiante");
		Estudiante beltran = new Estudiante(1, "Beltran", "Peña", 22, "m", 41969641, "Rauch");
		Estudiante ayelen = new Estudiante(2, "Ayelen", "Diaz Bailey", 29, "f", 37926567, "Necochea");
		Estudiante ezequiel = new Estudiante(3, "Ezequiel", "Fernandez", 22, "m", 45233301, "Tandil");
		Estudiante martin = new Estudiante(4, "Martin", "Lopardo", 30, "m", 37031217, "Azul");
		Estudiante peque = new Estudiante(5, "Ailin", "Kravos", 23, "f", 41394188, "Tandil");
		studentRepo.save(peque);
		studentRepo.save(beltran);
		studentRepo.save(ayelen);
		studentRepo.save(ezequiel);
		studentRepo.save(martin);

		// Se crean y cargan las carreras a la base de datos.
		Carrera tudai = new Carrera(1, "TUDAI");
		Carrera contador = new Carrera(2, "Contador Publico");
		Carrera sistemas = new Carrera(3, "Ingenieria en Sistemas");
		carrerRepo.save(tudai);
		carrerRepo.save(contador);
		carrerRepo.save(sistemas);

		System.out.println("------------------------------------------------------------------------------------");

		// 2B) Matricular un estudiante en una carrera
		System.out.println("\n 2.B) Matricular un estudiante en una carrera");
		Date date1 = new Date("2012/02/06");
		Date date2 = new Date("2018/08/09");
		Date date3 = new Date("2020/08/09");
		Inscripcion i1 = new Inscripcion(tudai, martin, new Timestamp(date3.getTime()), null);
		Inscripcion i2 = new Inscripcion(sistemas, beltran, new Timestamp(date2.getTime()), null);
		Inscripcion i3 = new Inscripcion(contador, ayelen, new Timestamp(date1.getTime()), new Timestamp(date3.getTime()));
		Inscripcion i4 = new Inscripcion(tudai, ezequiel, new Timestamp(date1.getTime()), null);
		Inscripcion i5 = new Inscripcion(tudai, ayelen, new Timestamp(date3.getTime()), null);
		inscriptionRepo.save(i1);
		inscriptionRepo.save(i2);
		inscriptionRepo.save(i3);
		inscriptionRepo.save(i4);
		inscriptionRepo.save(i5);

		System.out.println("------------------------------------------------------------------------------------");

		// 2C) Recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
		// Se ordena por apellido A-Z
		em.getTransaction().begin();
		System.out.println("\n 2.C) Listado completo de estudiantes ordenado por apellido:");
		System.out.println(studentRepo.getAll());
		em.getTransaction().commit();

		System.out.println("------------------------------------------------------------------------------------");

		// 2D) Recuperar un estudiante, en base a su número de libreta universitaria
		em.getTransaction().begin();
		System.out.println("\n 2.D) Estudiante cuyo numero de libreta es 2:");
		System.out.println(studentRepo.getById(2));
		em.getTransaction().commit();

		System.out.println("------------------------------------------------------------------------------------");

		// 2E) Recuperar todos los estudiantes, en base a su género.
		em.getTransaction().begin();
		System.out.println("\n 2.E) Estudiantes cuyo genero es masculino:");
		System.out.println(studentRepo.getByGender("m"));
		em.getTransaction().commit();

		System.out.println("------------------------------------------------------------------------------------");

		// 2F) Recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
		em.getTransaction().begin();
		System.out.println("\n 2.F) Carreras con estudiantes inscriptos ordenadas por cantidad de inscriptos:");
		System.out.println(carrerRepo.getCarrerasConInscriptos());
		em.getTransaction().commit();

		System.out.println("------------------------------------------------------------------------------------");

		// 2G) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
		em.getTransaction().begin();
		System.out.println("\n 2.G) Estudiantes de la carrera de sistemas que viven en Rauch:");
		System.out.println(studentRepo.getByCarrerAndCity(3, "Rauch"));
		em.getTransaction().commit();

		System.out.println("------------------------------------------------------------------------------------");

		// 3. Generar un reporte de las carreras, que para cada carrera incluya información de los inscriptos y egresados por año.
		// Se deben ordenar las carreras alfabéticamente, y presentar los años de manera cronológica.
		Iterator<RegistroInscripcion> carreras = carrerRepo.getReporteCarreras().iterator();
		System.out.println("3. Carreras ordenadas por nombre ASC, con info de ingresantes y egresados ordenadas de forma cronológica");
		while(carreras.hasNext()){
			System.out.println(carreras.next());
		}
		em.close();
		emf.close();
    }
}
