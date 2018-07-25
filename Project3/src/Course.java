//Shaoliang Lin and John Chung 
import java.util.*;

public class Course {
	private String name;
	private int max;
	Student[] roster;

	public Course(String initialName, int initialMax) {
		name = initialName;
		max = initialMax;
		roster = new Student[max];
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
			System.out.println("Max can't be 0 or more than 50");
		} else {
			max = newMax;
		}
	}

	public String toString() {
		return name + " can hold " + max + " students.";
	}

	public boolean addStudent(Student s) {
		if (roster[max - 1] == null && s.getTuition()) {
			for (int i = 0; i < max; i++) {
				if (roster[i] == null) {
					roster[i] = s;
					i = max;
				}
			}
			return true;
		} else {
			System.out.println("The course is full! Can't add anymore student!");
			return false;
		}
	}

	public boolean dropStudent(Student s) {
		for (int i = 0; i < max; i++) {
			if (s.getName().equals(roster[i].getName())) {
				roster[i] = null;
				for (int j = 0; j < max - 1; j++) {
					if (roster[j] == null && roster[j + 1] != null) {
						Student temp = roster[j];
						roster[j] = roster[j + 1];
						roster[j + 1] = temp;
					}
				}
				i = max;
				return true;
			}
		}
		return false;
	}

	public void printRoster() {
		if (roster[0] == null) {
			System.out.println("don't have sudent yet.");
		} else {
			for (int i = 0; i < max; i++) {
				if(roster[i] == null) {
					System.out.println("Still have "  +  (max - i) +  " spot available.");
					i = max;
				} else {
					System.out.println(i + 1 + " " + roster[i].getName());
				}
			}
		}

	}
}
