public class Interval{

	private Note lowerNote;
	private Note higherNote;
	private String intervalType;
	private int interval;

	public static final String MAJOR = "M";
	public static final String MINOR = "m";
	public static final String PERFECT = "P";
	public static final String DIMINISHED = "D";
	public static final String AUGMENTED = "A";

	/*@TODO
	Finish the interval converter--find halfsteps
	finish the note finder
	*/

	//No args constructor
	public Interval(){}


	public void setLowerNote(Note n){
		lowerNote = n;
	}

	public Note getLowerNote(){
		return lowerNote;
	}

	public void setHigherNote(Note n){
		higherNote = n;
	}

	public Note getHigherNote(){
		return this.higherNote;
	}

	public void setIntervalType(String s){
		intervalType = s;
	}

	public String getIntervalType(){
		return this.intervalType;
	}

	public void setInterval(int i){
		interval = i;
	}

	public int getInterval(){
		return this.interval;
	}

	public Note findNote(boolean direction){
		//Find number of halfSteps to move
		int halfSteps = intervalToHalfSteps();

		//Direction == true then the cantus firmus is above
		//Direction == false then the cantus firmus is below
		if (direction){
			//Counterpoint is below
			//higherNote should != null here
			try{
				int noteValue = higherNote.getNoteValue();
			}
			catch(NullPointerException e){
				System.out.println("Higher Note is null");
				e.printStackTrace();
			}
			catch(IllegalArgumentException e){
				System.out.println("Invalid interval " + intervalType+interval);
				e.printStackTrace();
			}

		}
		else{
			//Counterpoint is above
		}

	}

	public int intervalToHalfSteps() throws IllegalArgumentException{
		//Reference check http://www.musictheory.net/lessons/31
		int halfSteps=0;
		if (intervalType.equals(MAJOR)){
			if (interval == 2 || interval == 3){
				halfSteps = (interval-1) * 2;
				return halfSteps;
			}
			else if (interval == 6 || interval == 7){
				halfSteps = (interval-2) * 2 + 1;
				return halfSteps;
			}
		}
		else if (intervalType.equals(MINOR)){
			if (interval == 2 || interval == 3){
				halfSteps = (interval-1) * 2 - 1;
				return halfSteps;
			}
			else if (interval == 6 || interval == 7){
				halfSteps = (interval-2) * 2;
				return halfSteps;
			}
		}
		else if (intervalType.equals(AUGMENTED)){
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
		else if (intervalType.equals(DIMINISHED)){
			if (interval == 2 || interval == 3 || interval == 4 || interval == 5){
				halfSteps = (interval-2) * 2;
				return halfSteps;
			}
			else if (interval == 6 || interval == 7 || interval == 8){
				halfSteps = (interval-2) * 2 - 1;
				return halfSteps;
			}
		}
		else if (intervalType.equals(PERFECT)){
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