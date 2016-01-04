import java.util.*;

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
		ArrayList<Interval> intervals = cp.getIntervals();
		for (int i=0; i<intervals.size(); i++){
			cp.findNote(intervals.get(i));
			System.out.println(intervals.get(i));
		}
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
		cp.addInterval(i);
		return i;
	}
}