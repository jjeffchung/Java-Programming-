//Shaoliang Lin and John Chung 

public class CourseALDriver {


	public static void main(String[] args) {
		Student a = new Student("Joe", "w12345", true);
		Student b = new Student("Jose", "w123456", true);
		Student c = new Student("Paul", "w1234567", true);
		Student d = new Student("Julia", "w12345678", true);
		Student e = new Student("Jimmy", "w123456789", true);
		Student f = new Student("Joelle", "w123450", true);
		CourseAL math = new CourseAL("math", 5);
		System.out.println(math);
		math.printRoster();
		math.addStudent(a);
		math.addStudent(b);
		math.addStudent(c);
		math.addStudent(d);
		math.addStudent(e);
		math.printRoster();
		math.addStudent(f);
		math.printRoster();
		math.dropStudent(c);
		math.printRoster();
		math.addStudent(f);
		math.printRoster();
	}

}
