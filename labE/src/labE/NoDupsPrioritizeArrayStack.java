package labE;

//John Chung King Sow

//Implement a new kind of stack that only accepts a single copy of an object in the stack (no duplicates allowed) 

public class NoDupsPrioritizeArrayStack<T> extends ArrayStack<T> implements NoDupsPrioritizeStackInterface<T>{

	public NoDupsPrioritizeArrayStack() {

		super();

	}

	public NoDupsPrioritizeArrayStack(int initialCapacity) {

		super(initialCapacity);

	}

	/**

	 * @param newEntry The object to be added to the stack.

	 */

	@Override

	public void push(T newEntry) {

		if (getIndex(newEntry) < 0) 
			super.push(newEntry);

	}


	 /** Prioritizes the entry/element in the stack 

	 * @param entry The object to be prioritized.

	 */

	public void moveToTop(T entry) {

		int itemIndex = getIndex(entry);

		if (itemIndex < 0) //If invoked with an element not in the stack 

			super.push(entry);

		else { //If invoked with an element currently in the stack 

			for (int i = itemIndex; i < topIndex; i++) { 

				T temp = stack[i + 1];

				stack[i + 1] = stack[i];

				stack[i] = temp;

			}

			assert entry == stack[topIndex];

		}

	}


	public void display() {

		System.out.print("BOTTOM");

		for (int i = 0; i <= topIndex; i++) {

			System.out.print(" " + stack[i]);

		}

		System.out.println("TOP");

	}



	/**

	 * Finds the index of the given item in the stack array .

	 * @param item Object to get the index of.

	 * @return The index of the item or -1 if not found.

	 */

	private int getIndex(T item) {

		for (int i = topIndex; i >= 0; i--) {

			if (stack[i].equals(item)) {

				return i;

			}

		}

		return -1;

	}

}
