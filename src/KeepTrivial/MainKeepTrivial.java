package KeepTrivial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainKeepTrivial {

	public static void main(String[] args) {
		ArrayList<Tema> temas = getQuestions();
        for (Tema tema : temas) {
            System.out.println(tema);
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
