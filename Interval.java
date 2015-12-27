public class Interval{

	private Note lowerNote;
	private Note higherNote;
	private String intervalType;
	private int interval;

	public static final String MAJOR = "M";
	public static final String MINOR = "m";
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
		if (direction){
			//Counterpoint is below
			//Should have higherNote here
			try{
				higherNote.getNoteValue();
				int halfSteps = intervalToHalfSteps();
			}
			catch(NullPointerException e){
				e.printStackTrace();
			}

		}
		else{
			//Counterpoint is above
		}

	}

	public int intervalToHalfSteps() throws IllegalArgumentException{
		if (intervalType.equals(MAJOR){

		}
		else if(intervalType.equals(MINOR)){

		}
		else if(intervalType.equals(AUGMENTED)){

		}
		else if(intervalType.equals(DIMINISHED)){

		}
		else{
			throw new IllegalArgumentException("Illegal Interval");
		}
	}


}