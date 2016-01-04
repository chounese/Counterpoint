public class CounterpointTest{
	public static void main(String[] args){
		Counterpoint cp = new Counterpoint(true);
		Note e = new Note(3, 41, "E");
		Interval p1 = intervalInitHelper(cp, e, Interval.PERFECT, 1);
		Interval m2 = intervalInitHelper(cp, e, Interval.MINOR, 2);
		Interval ma2 = intervalInitHelper(cp, e, Interval.MAJOR, 2);
		Interval m3 = intervalInitHelper(cp, e, Interval.MINOR, 3);
		Interval ma3 = intervalInitHelper(cp, e, Interval.MAJOR, 3);
		Interval p4 = intervalInitHelper(cp, e, Interval.PERFECT, 4);
		Interval p5 = intervalInitHelper(cp, e, Interval.PERFECT, 5);
		Interval m6 = intervalInitHelper(cp, e, Interval.MINOR, 6);
		Interval ma6 = intervalInitHelper(cp, e, Interval.MAJOR, 6);
		Interval m7 = intervalInitHelper(cp, e, Interval.MINOR, 7);
		Interval ma7 = intervalInitHelper(cp, e, Interval.MAJOR, 7);
		Interval p8 = intervalInitHelper(cp, e, Interval.PERFECT, 8);
		cp.findNote(p1);
		cp.findNote(m2);
		cp.findNote(ma2);
		cp.findNote(m3);
		cp.findNote(ma3);
		cp.findNote(p4);
		cp.findNote(p5);
		cp.findNote(m6);
		cp.findNote(ma6);
		cp.findNote(m7);
		cp.findNote(ma7);
		cp.findNote(p8);
		System.out.println(p1);
		System.out.println(m2);
		System.out.println(ma2);
		System.out.println(m3);
		System.out.println(ma3);
		System.out.println(p4);
		System.out.println(p5);
		System.out.println(m6);
		System.out.println(ma6);
		System.out.println(m7);
		System.out.println(ma7);
		System.out.println(p8);
	}

	public static Interval intervalInitHelper(Counterpoint cp, Note note, String intervalType, int interval){
		Interval i = new Interval();
		if (cp.getDirection()){
			i.setHigherNote(note);
		}
		else{
			i.setLowerNote(note);
		}
		i.setIntervalType(intervalType);
		i.setInterval(interval);
		return i;
	}
}