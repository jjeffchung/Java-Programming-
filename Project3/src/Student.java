//Shaoliang Lin and John Chung 


public class Student {
	private String name;
	private String id;
	private boolean tuition;
	
	public Student (String initialName, String initialId,
			boolean initialTuition) {
		name = initialName;
		id = initialId;
		tuition = initialTuition;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public boolean getTuition() {
		return tuition;
	}
	public void setName(String newName) {
		name = newName;
	}
	public void setId(String newId) {
		id = newId;
	}
	public void setTuition(boolean newTuition) {
		tuition = newTuition;
	}
	public String toString() {
		return name + " : " + id + "\nTuition is paid?" + " : " + tuition;
	}
}







