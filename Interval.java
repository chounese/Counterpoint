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

	public String toString(){
		return (intervalType + interval) + ": " + lowerNote + "-->" + higherNote;
	}

}