package modelos;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class RegistroInscripcion {

	private Carrera carrera;
	private LinkedHashMap<Integer, List<Estudiante>> ingresantes;
	private LinkedHashMap<Integer, List<Estudiante>> egresados;

	public RegistroInscripcion(Carrera carrera, LinkedHashMap<Integer, List<Estudiante>> ingresantes,
			LinkedHashMap<Integer, List<Estudiante>> egresados) {
		super();
		this.carrera = carrera;
		this.ingresantes = ingresantes;
		this.egresados = egresados;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public List<Estudiante> getAniosIngreso(int anio) {
		return this.ingresantes.get(anio);
	}

	public List<Estudiante> getAniosEgreso(int anio) {
		return this.egresados.get(anio);
	}

	public Set<Integer> getAniosEgreso() {
		return this.egresados.keySet();
	}

	public Set<Integer> getAniosIngreso() {
		return this.egresados.keySet();
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		String data = "";
		for (Integer key : this.ingresantes.keySet()) {
			data += "Año: " + key + " \n";
			data += "Ingresantes: " + this.ingresantes.get(key).toString() + " \n";
		}
		for (Integer key : this.egresados.keySet()) {
			data += "Año: " + key + " \n";
			data += "Egresados: " + this.egresados.get(key).toString() + " \n";
		}

		return "Carrera: " + carrera.getNombre() + " \n" + data;
	}

}
