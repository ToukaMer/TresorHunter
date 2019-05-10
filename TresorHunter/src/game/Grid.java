package game;

import java.util.ArrayList;

import data.Case;
import data.Constants;
import data.Empty;
import data.Persona;
import data.Trap;
import data.Tresor;

public class Grid {
	private Case[][] cases;
	private Persona persona;
	private ArrayList<Trap> traps;
	private ArrayList<Tresor> tresors;
	private Empty empty;

	public Grid() {
		initializeGrid();
	}

	public Case[][] getCases() {
		return cases;
	}

	public void setCases(Case[][] cases) {
		this.cases = cases;
	}
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public ArrayList<Trap> getTraps() {
		return traps;
	}

	public void setTraps(ArrayList<Trap> traps) {
		this.traps = traps;
	}

	public ArrayList<Tresor> getTresors() {
		return tresors;
	}

	public void setTresors(ArrayList<Tresor> tresors) {
		this.tresors = tresors;
	}

	public Empty getEmpty() {
		return empty;
	}

	public void setEmpty(Empty empty) {
		this.empty = empty;
	}

	public void initializeCases() {
		cases = new Case[Constants.GRID_HEIGHT][Constants.GRID_LENGTH];
		empty = new Empty();
		for(int i=0;i<Constants.GRID_HEIGHT;i++) {
			for(int j=0;j<Constants.GRID_LENGTH;j++) {
				cases[i][j] = empty;
			}
		}
	}
	
	public void initializePersona() {
		persona = new Persona();
		cases[Constants.DEPARTURE_LONGITUDE][Constants.DEPARTURE_LATITUDE] = persona;
	}
	
	public void initializeTraps() {
		int randomLongitude;
		int randomLatitude;
		int index;
		traps = new ArrayList<>();
		for(index=0;index<Constants.TRAP_AMOUNT;index++) {
			randomLongitude = (int)(Math.random() * (Constants.GRID_HEIGHT - 1))+1;
			randomLatitude = (int)(Math.random() * (Constants.GRID_LENGTH - 1))+1;
			Trap trap = new Trap(randomLatitude,randomLongitude);
			cases[randomLongitude][randomLatitude] = trap;
			traps.add(trap);
		}
	}
	
	public void initializeTresors() {
		int randomLongitude;
		int randomLatitude;
		int index;
		tresors = new ArrayList<>();
		for(index=0;index<Constants.TRESOR_AMOUNT;index++) {
			randomLongitude = (int)(Math.random() * (Constants.GRID_HEIGHT - 1))+1;
			randomLatitude = (int)(Math.random() * (Constants.GRID_LENGTH - 1))+1;
			Tresor tresor = new Tresor(randomLatitude,randomLongitude);
			cases[randomLongitude][randomLatitude] = tresor;
			tresors.add(tresor);
		}
	}
	
	public void initializeGrid() {
		initializeCases();
		initializePersona();
		initializeTraps();
		initializeTresors();
	}
	
	public void displayGrid() {
		for(int i=0;i<Constants.GRID_HEIGHT;i++) {
			System.out.print("|");
			for(int j=0;j<Constants.GRID_LENGTH;j++) {
				System.out.print(cases[i][j]);
				System.out.print("|");
			}
			System.out.println("\n");
		}
	}
	
}
