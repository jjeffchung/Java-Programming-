package labE;

//John Chung King Sow

//Implement a new kind of queue that only accepts a single copy of an object in the queue (no duplicates allowed) 


public class NoDupsDePrioritizeArrayQueue<T> extends ArrayQueue<T> implements NoDupsDePrioritizeQueueInterface<T> {

	private int frontIndex;

	private int backIndex;

	public NoDupsDePrioritizeArrayQueue() {

		super();

	}

	public NoDupsDePrioritizeArrayQueue(int initialCapacity) {

		super(initialCapacity);

	}

	/**

	 * Adds an entry to the back of the queue after checking to

	 * make sure queue does not already contain the item.

	 * @param newEntry The object to be added.

	 */

	@Override

	public void enqueue(T newEntry) {

		if (getIndex(newEntry) < 0) {

			super.enqueue(newEntry);

			assert newEntry == queue[backIndex];

		}

	}



	public void moveToBack(T entry) {

		int entryIndex = getIndex(entry);



		if (entryIndex < 0) 

			super.enqueue(entry);

		else {

			for (int i = entryIndex; 
					i != backIndex % queue.length; i = (++i) % queue.length) {

				T temp = queue[(i + 1) % queue.length];

				queue[(i + 1) % queue.length] = queue[i];

				queue[i] = temp;

			}

		}

		assert entry == queue[backIndex];

	}



	public void display() {

		System.out.print("FRONT");

		for (int i = frontIndex; i != backIndex; 

				i = (i + 1) % queue.length) {

			System.out.print(" " + queue[i]);

		}

		System.out.println(" " + queue[backIndex] + " BACK");

	}



	// Returns the index position of item in queue or -1 if item is not found

	private int getIndex(T item) {

		for (int i = frontIndex; i != backIndex; 

				i = (++i) % queue.length) {

			if (item.equals(queue[i])) {

				return i;

			}

		}

		if (item.equals(queue[backIndex])) {

			return backIndex;

		}

		return -1;

	}

}
