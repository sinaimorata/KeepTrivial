package KeepTrivial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MainKeepTrivial {

	public static void main(String[] args) {
		//Genero lista con todos los temas
		ArrayList<String> listaTrivial = new ArrayList<String>();
		listaTrivial.add("Historia");
		listaTrivial.add("Historia de Keep Coding");
		listaTrivial.add("Inteligencia Artificial");
		listaTrivial.add("Redes");
		listaTrivial.add("Tecnología");
		
		
		ArrayList<Tema> temas = getQuestions();
		 Scanner scanner = new Scanner(System.in);
        //for (Tema tema : temas) {
         //   System.out.println(tema);
        //}
        System.out.print("Indique el nombre del equipo1: ");
        String nombreEquipo1 = scanner.nextLine();
        Team equipo1 = new Team (nombreEquipo1);
        
       
        System.out.print("Indique el nombre del equipo2: ");
        String nombreEquipo2 = scanner.nextLine();
        Team equipo2 = new Team (nombreEquipo2);
        
        ArrayList<Team> equipos = new ArrayList <> ();
        equipos.add(equipo1);
        equipos.add(equipo2);
        //saco equipo y arranco con él
        Team equipoElegido= seleccionarEquipoAleatorio(equipos);
        comienzaJuego(equipoElegido,listaTrivial,temas,equipos);
        
	}
	
	//elegir turno entre los dos equipos de la lista
	public static Team seleccionarEquipoAleatorio(ArrayList<Team> equipos) {

		Random random = new Random();
		int index = random.nextInt(equipos.size());
		return equipos.get(index);
	}
	
	//elegir tema entre los posibles d la lista
	public static String seleccionarTemaAleatorio(ArrayList<String> temas) {

		Random random = new Random();
		int index = random.nextInt(temas.size());
		return temas.get(index);
	}
	
	//elegir una pregunta entre las posibles de un tema
	public static Pregunta seleccionarPreguntaAleatoria(Tema tema) {
        Random random = new Random();
        ArrayList<Pregunta> preguntas = tema.getPreguntas();
        int index = random.nextInt(preguntas.size());
        return preguntas.get(index);
    }
	//commparo mi lista de quesitos con la lista que contiene todos los temas. Me devuelve
	//la diferencia.
	public static ArrayList<String> getElementsNotInSecondList(ArrayList<String> listaPrincipal, ArrayList<String> miLista) {

		ArrayList<String> diferencia = new ArrayList<>(listaPrincipal);
	    diferencia.removeAll(miLista);
	    return diferencia;
	}

	public static void comienzaJuego (Team equipo,ArrayList<String> listaTrivial,ArrayList<Tema> temas,ArrayList<Team> equipos) {
		//Informamos del equipo que le toca jugar
		System.out.println("Es el turno del equipo: " +equipo.getName());
		
		
		//Se compara miLista de quesitos con la listaPrincipal
		ArrayList<String> temasPorJugar = getElementsNotInSecondList(listaTrivial,equipo.getCheeses());
		
		 // Verificar que hay temas por jugar
        if (temasPorJugar.isEmpty()) {
            System.out.println("No hay más temas por jugar.");
            return;
        }
		
		
		//Se elige aleatoriamente un tema de la lista de temas por jugar
		String temaElegido = seleccionarTemaAleatorio(temasPorJugar);
		
		//Informamos del tema sobre el que va a ser cuestionado
		System.out.println("Vuestro tema es: " +temaElegido);
		
		// Encuentra el tema en la lista de temas
        Tema temaSeleccionado = null;
        for (Tema tema : temas) {
            if (tema.getNombre().equals(temaElegido)) {
                temaSeleccionado = tema;
                
                // Selecciona una pregunta aleatoria del tema
                Pregunta preguntaAleatoria = seleccionarPreguntaAleatoria(temaSeleccionado);
                System.out.println(preguntaAleatoria.toString());

                Scanner scanner = new Scanner(System.in);
                System.out.print("Indique su respuesta: ");
                String respuesta = scanner.nextLine();
                int numeroRespuesta = Integer.parseInt(respuesta);

                while (numeroRespuesta<1 || numeroRespuesta>4) {
                	System.out.println("Por favor, ingrese un número entre 1 y 4.");
                	System.out.print("Indique su respuesta: ");
                	respuesta = scanner.nextLine();
                	numeroRespuesta = Integer.parseInt(respuesta);
                }
                 //comprobar si la respuesta es correcta             
                if (numeroRespuesta == preguntaAleatoria.getSolucion()) {
                	System.out.println("Felicidades,respuesta correcta");
                	equipo.getCheeses().add(temaElegido);
                	equipo.incrementarQuesitos();
                	
                	//comprobar si tiene todos los quesitos
                	if(equipo.getNumeroDeQuesitos() == 5) {
                		System.out.println("Bien, habeis ganado la partida");
                		return;
                	}else {
                		//mostrar lista de quesitos acertados
                		mostrarAciertos(equipo);
                		//cambiar turno
                		Team nuevoEquipo = cambiarEquipo(equipos,equipo);
                		comienzaJuego(nuevoEquipo,listaTrivial,temas,equipos);
                		
                	}
                	    	
                	
                }else {
                	//En caso de haber fallado la pregunta
                	System.out.println("Lo siento, erroooor. Perdeis turno");
                	mostrarAciertos(equipo);
                	
                	//cambiar turno
                	Team nuevoEquipo = cambiarEquipo(equipos,equipo);
            		comienzaJuego(nuevoEquipo,listaTrivial,temas,equipos);
                }

            }
        }
	}
	//funcion para cambiar turno
	public static Team cambiarEquipo(ArrayList<Team> equipos, Team equipoActual) {
		if(equipoActual.getName().equals(equipos.get(0).getName())) {
			return equipos.get(1);
		}else {
			return equipos.get(0);
		}

	}

	public static void mostrarAciertos(Team equipo) {
		System.out.println("Los temas acertados son: "+ equipo.getNumeroDeQuesitos());
		for(String quesito: equipo.getCheeses()) {
			System.out.println(quesito);
		}
	}


	public static void title(String text) {
		int length = text.length();
		printHashtagLine(length + 4); // Bordes

        System.out.println("# " + text + " #");

        printHashtagLine(length + 4);
	}
	public static void printHashtagLine(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("#");
        }
        System.out.println();
    }
	
	
	private static ArrayList<Tema> getQuestions() {
		ArrayList<Tema> list = new ArrayList<>();
		
		 File folder = new File("questions");
	        if (!folder.exists()) {
	            title("Error al cargar el fichero");
	        } else {
	        	File[] filesList = folder.listFiles();

	            for (File file : filesList) {
	                if (file.isFile() && file.getName().endsWith(".txt")) {
	                    var topicName = file.getName().substring(0, file.getName().length() - 4);
	                    // TODO create topic
	                    Tema tema = new Tema (topicName);
	                    
	                    // Read the question
	                    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	                        String line;
	                        List<String> block = new ArrayList<>();

	                        while ((line = br.readLine()) != null) {
                        		block.add(line);

	                            if (block.size() == 6) { // número de lineas que componen una pregunta
	                                var question = block.get(0);
	                                var answer1 = block.get(1);
	                                var answer2 = block.get(2);
	                                var answer3 = block.get(3);
	                                var answer4 = block.get(4);
	                                var rightOption = Integer.parseInt(block.get(5));
	                                
	                                // TODO create question
	                                Pregunta pregunta = new Pregunta (question,answer1,answer2,answer3,answer4,rightOption);
	                                tema.añadirPregunta(pregunta);
	                                block.clear();
	                            }
	                        }
	                        // TODO Add to list
	                        list.add(tema);
	                        
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                  
	                }
	            }
	        }
	        
		return list;
	}
	
}
