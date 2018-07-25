//Shaoliang Lin and John Chung 

import java.util.*;

public class CourseAL {

	private String name;
	private int max;
	ArrayList<Student> roster;

	public CourseAL(String initialName, int initialMax) {
		name = initialName;
		max = initialMax;
		roster = new ArrayList<Student>();
	}

	public String getName() {
		return name;
	}

	public int getMax() {
		return max;
	}

	public void setName(String newName) {
		name = newName;
	}

	public void setMax(int newMax) {
		if (newMax <= 0 && newMax > 50) {
			System.out.println("Max cannot be 0 or less than 0 and not greater than 50.");
		} else {
			max = newMax;
		}
	}

	public String toString() {
		return name + " can hold " + max + " students.";
	}

	public boolean addStudent(Student s) {
		if (roster.size() < max && s.getTuition()) {
			roster.add(s);
			return true;
		} else {
			System.out
					.println("The course is full! Cannot add anymore student!");
			return false;
		}
	}

	public boolean dropStudent(Student s) {
		for (int i = 0; i < max; i++) {
			if (s.getName().equals(roster.get(i).getName())) {
				roster.remove(i);
				return true;
			}
		}
		return false;
	}

	public void printRoster() {
		if (roster == null) {
			System.out.println("The roster does not have any sudent yet.");
		} else {
			System.out.println(roster);
		}
	}

}
