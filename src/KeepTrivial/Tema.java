package KeepTrivial;


import java.util.ArrayList;

public class Tema {
	
	//atributo
	private String nombre;
	private ArrayList<Pregunta> preguntas = new ArrayList<>();

	//constructor
	public Tema(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(ArrayList<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	
	public void añadirPregunta (Pregunta pregunta) {
		this.preguntas.add(pregunta);
	}
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tema: ").append(nombre).append("\n");
        for (Pregunta pregunta : preguntas) {
            sb.append(pregunta).append("\n");
        }
        return sb.toString();
    }
}
