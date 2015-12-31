import java.util.*;

public class Counterpoint{
	private HashMap<String, Integer> indexer = new HashMap<>();
	private String[] noteArray = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
	//True then cp is below false then above
	private boolean direction;

	//No args constructor
	public Counterpoint(){}

	//1 arg constructor
	public Counterpoint(boolean d){
		direction = d;
	}

	public boolean getDirection(){
		return this.direction;
	}

	public HashMap<String, Integer> getIndexer(){
		return this.indexer;
	}

	public String[] getNoteArray(){
		return this.noteArray;
	}


	public Note findNote(Interval i){
		try{
			//Find number of halfSteps to move
			int halfSteps = intervalToHalfSteps(i);

			//Direction == true then the cantus firmus is above
			//Direction == false then the cantus firmus is below
			if (direction){
				//Counterpoint is below
				//higherNote should != null here
				Note highNote = i.getHigherNote();
				int noteValue = highNote.getNoteValue();
				//Need to handle the below case--reverse the interval-->subtract the #of halfsteps
				int newNoteValue = noteValue - halfSteps;
				int noteNameIndex = newNoteValue % 12;
				String noteName = noteArray[noteNameIndex];
				int octave = newNoteValue / 12;
				Note lowNote = new Note(octave, newNoteValue, noteName);
				i.setLowerNote(lowNote);
				return lowNote;

			}
			else{
				//Counterpoint is above
				Note lowNote = i.getLowerNote();
				int noteValue = lowNote.getNoteValue();
				//Need to handle the above case-->add the #of halfsteps
				int newNoteValue = noteValue + halfSteps;
				int noteNameIndex = newNoteValue % 12;
				String noteName = noteArray[noteNameIndex];
				int octave = newNoteValue / 12;
				Note highNote = new Note(octave, newNoteValue, noteName);
				i.setHigherNote(highNote);
				return highNote;
			}
		}	
		catch(NullPointerException e){
			System.out.println("Interval or Higher Note is null");
			e.printStackTrace();
		}
		catch(IllegalArgumentException e){
			System.out.println("Invalid interval " + i.getIntervalType()+i.getInterval());
			e.printStackTrace();
		}
		return null; //@TODO There has to be a better way to do this.
	}

	public int intervalToHalfSteps(Interval i) throws IllegalArgumentException, NullPointerException{
		//Reference check http://www.musictheory.net/lessons/31
		int halfSteps;
		String intervalType = i.getIntervalType();
		int interval = i.getInterval();
		if (intervalType.equals(Interval.MAJOR)){
			if (interval == 2 || interval == 3){
				halfSteps = (interval-1) * 2;
				return halfSteps;
			}
			else if (interval == 6 || interval == 7){
				halfSteps = (interval-2) * 2 + 1;
				return halfSteps;
			}
		}
		else if (intervalType.equals(Interval.MINOR)){
			if (interval == 2 || interval == 3){
				halfSteps = (interval-1) * 2 - 1;
				return halfSteps;
			}
			else if (interval == 6 || interval == 7){
				halfSteps = (interval-2) * 2;
				return halfSteps;
			}
		}
		else if (intervalType.equals(Interval.AUGMENTED)){
			if (interval == 1 || interval == 2 || interval == 3){
				halfSteps = (interval-1) * 2 +1;
				return halfSteps;
			}
			else if (interval == 6 || interval == 7){
				halfSteps = (interval-1) * 2 + 2;
				return halfSteps;
			}
			else if (interval == 4 || interval == 5){
				halfSteps = (interval-1) * 2;
				return halfSteps;
			}
			else if (interval == 8){
				halfSteps = (interval-1) * 2 -1;
				return halfSteps;
			}
		}
		else if (intervalType.equals(Interval.DIMINISHED)){
			if (interval == 2 || interval == 3 || interval == 4 || interval == 5){
				halfSteps = (interval-2) * 2;
				return halfSteps;
			}
			else if (interval == 6 || interval == 7 || interval == 8){
				halfSteps = (interval-2) * 2 - 1;
				return halfSteps;
			}
		}
		else if (intervalType.equals(Interval.PERFECT)){
			if (interval == 1){
				halfSteps = 0;
				return halfSteps;
			}
			else if (interval == 4 || interval == 5){
				halfSteps = (interval-1) * 2 - 1;
				return halfSteps;
			}
			else if (interval == 8){
				halfSteps = 12;
				return halfSteps;
			}
		}
		//If code falls through if/elses then it must be illegal
		throw new IllegalArgumentException("Illegal Interval");
		
	}


}