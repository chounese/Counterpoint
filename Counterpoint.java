import java.util.*;

public class Counterpoint{
	private HashMap<String, Integer> indexer = new HashMap<>();
	private String[] noteArray = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
	//True then cp is below false then above
	private boolean cfAbove;

	//No args constructor
	public Counterpoint(){}

	//1 arg constructor
	public Counterpoint(boolean above){
		cfAbove = above;
	}

	public boolean getPosition(){
		return this.cfAbove;
	}

	public HashMap<String, Integer> getIndexer(){
		return this.indexer;
	}

	public String[] getNoteArray(){
		return this.noteArray;
	}



}