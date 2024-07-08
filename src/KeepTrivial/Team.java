package KeepTrivial;

import java.util.ArrayList;

public class Team {
	
	//atributos
	private String name;
	private ArrayList<String> cheeses;
	private int numberOfCheeses;
	
	//constructor
	public Team(String name){
		this.name = name;
		this.cheeses = new ArrayList<String>();
		this. numberOfCheeses = 0 ;
	}

   //Getters and setters
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getNumeroDeQuesitos() {
		return numberOfCheeses;
	}

	public void setNumeroDeQuesitos(int numeroDeQuesitos) {
		this.numberOfCheeses = numeroDeQuesitos;
	}

	public ArrayList<String> getCheeses() {
		return cheeses;
	}


	public void setCheeses(ArrayList<String> cheeses) {
		this.cheeses = cheeses;
	}
	
	//Métodos
	public void incrementarQuesitos() {
        this.numberOfCheeses++;
    }
	
}
