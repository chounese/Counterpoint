public class Note{

	private int octave;
	/*
	noteValue is the #of halfSteps + (12 * octave)
	*C=1, C#=2, D=3, D#=4, E=5, F=6, F#=7, G=8, G#=9, A=10, A#=11, B=12
	*/
	private int noteValue;
	private String noteName;
	private int length;

	public static final int QUARTER_LENGTH = 1;
	public static final int HALF_LENGTH = 2;
	public static final int WHOLE_LENGTH = 4;

	/*
	@TODO implement adding to noteValue so that it spills over and increments/decrements octave
	Modify constructors to set noteName using a method call
	*/

	//No args constructor
	public Note(){
	}

	//3 Args constuctor 1st species counterpoint
	public Note(int o, int n, String name){
		octave = o;
		noteValue = n;
		noteName = name;
		length = WHOLE_LENGTH;
	}

	//4 Args constructor
	public Note(int o, int n, String name, int l){
		octave = o;
		noteValue = n;
		noteName = name;
		length = l;
	}

	//Getters and Setters
	public void setOctave(int o){
		octave = o;
	}

	public int getOctave(){
		return this.octave;
	}

	public void setNoteValue(int n){
		noteValue = n;
	}

	public void setNoteName(String s){
		noteName = s;
	}

	public int getNoteValue(){
		return this.noteValue;
	}

	public String getNoteName(){
		return this.noteName;
	}


	public void setLength(int l){
		length = l;
	}

	public int getLength(){
		return this.length;
	}

	public String toString(){
		return noteName + (" Octave is " + octave) + (" value is " + noteValue) + (" length is " + length);
	}
}