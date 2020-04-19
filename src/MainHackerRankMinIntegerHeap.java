import java.util.Arrays;

/**
 * Min Heap implementation following
 * https://www.youtube.com/watch?v=t0Cq6tVNRBA&list=PLI1t_8YX-Apv-UiRlnZwqqrRT8D1RhriX&index=10
 * 
 * 
 * 
 * @author fabiano
 *
 */
public class MainHackerRankMinIntegerHeap {
	public static void main(String[] args) {
		MinHeap heap = new MinHeap();
		heap.add(2);
		heap.add(4);
		heap.add(8);
		heap.add(9);
		heap.add(7);
		heap.add(10);
		heap.add(9);
		heap.add(15);
		heap.add(20);
		heap.add(13);
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
	}
}

class MinHeap {
	private int capacity = 10;
	private int size = 0;
	private int[] items = new int[capacity];

	/**
	 * returns index of left child given a parent index
	 * 
	 * @param parentIndex
	 * @return
	 */
	private int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}

	/**
	 * returns index of right child given a parent index
	 * 
	 * @param parentIndex
	 * @return
	 */
	private int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}

	/**
	 * returns index of parent given a childIndex
	 * 
	 * @param childIndex
	 * @return
	 */
	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	/**
	 * checks if index has left child
	 * 
	 * @param index
	 * @return
	 */
	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}

	/**
	 * checks if index has right child
	 * 
	 * @param index
	 * @return
	 */
	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}

	/**
	 * checks if index has parent
	 * 
	 * @param index
	 * @return
	 */
	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	/**
	 * returns left child value
	 * 
	 * @param index
	 * @return
	 */
	private int leftChild(int index) {
		return items[getLeftChildIndex(index)];
	}

	/**
	 * returns right child value
	 * 
	 * @param index
	 * @return
	 */
	private int rightChild(int index) {
		return items[getRightChildIndex(index)];
	}

	/**
	 * returns parent value
	 * 
	 * @param index
	 * @return
	 */
	private int parent(int index) {
		return items[getParentIndex(index)];
	}

	/**
	 * swap elements in the heap
	 * 
	 * @param indexOne
	 * @param indexTwo
	 */
	private void swap(int indexOne, int indexTwo) {
		int temp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = temp;
	}

	/**
	 * checks if array needs extra capacity, in that creates new array with double
	 * of that size and copy the existing elements over.
	 */
	private void ensureExtraCapacity() {
		if (size == capacity) {
			capacity *= 2;
			items = Arrays.copyOf(items, capacity);
		}
	}

	/**
	 * returns the minimum element (top of the heap)
	 * 
	 * @return
	 */
	public int peek() {
		if (size == 0)
			throw new IllegalStateException();
		return items[0];
	}

	/**
	 * removes the minimum element (root of the heap) and then rearrange it as
	 * necessary
	 * 
	 * @return
	 */
	public int poll() {
		if (size == 0)
			throw new IllegalStateException();
		int item = items[0];
		// replaces root element with last element (probably the biggest value)
		items[0] = items[size - 1];
		size--;
		// change the root with its child as necessary
		heapifyDown();
		return item;
	}
	private void heapifyDown() {
		// get the root, which is the recent biggest element
		int index = 0;
		// check only left child, because if no left child ofc no right child!
		while (hasLeftChild(index)) {
			// get index of the left child
			int smallerChildIndex = getLeftChildIndex(index);
			// in case it also has right child, then we should get the smallest of them
			if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
				smallerChildIndex = getRightChildIndex(index);
			}
			// if the current node is actually smaller than smallest child, the rule is ok, do nothing
			if (items[index] < items[smallerChildIndex]) {
				break;
			} else {
				// in case it does not follow the order, then swap it down and keep going
				swap(index, smallerChildIndex);
				index = smallerChildIndex;
			}
		}
	}
	/**
	 * adds new element to heap and then rearranges it as necessary
	 * 
	 * @param item
	 */
	public void add(int item) {
		ensureExtraCapacity();
		items[size] = item;
		size++;
		// change the children with its parent as necessary
		heapifyUp();
	}

	/**
	 * because we added a new element to the end of the heap, this element may not
	 * be following the order (may be smaller than parent) so we need to rearrange
	 */
	private void heapifyUp() {
		// gets most recent element added
		int index = size - 1;
		// while it has parent and it's parent is BIGGER than it, should swaps 
		while (hasParent(index) && parent(index) > items[index]) {
			swap(getParentIndex(index), index);
			// refresh index to new swapped value
			index = getParentIndex(index);
		}
	}
}
