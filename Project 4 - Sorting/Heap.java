public class Heap {
public int[] contents;
private int numItems;

public Heap(int[] arr) {
	contents = new int[arr.length];
	numItems = 0;
	for (int i = 0; i < arr.length; i++){
		insert(arr[i]);
	}

}

public static void printArray( int[] a ) {
 System.out.print("[");
 for( Object thang : a )
     System.out.print( thang + ",");
 System.out.println("]");
    }

private void siftDown(int i) {
	int siftee = contents[i];
	int parent = i;
	int child = 2 * parent + 1;
	while (child < numItems) {
		// If the right child is bigger, compare with it.
		if (child < numItems - 1 && contents[child] < contents[child + 1])
			child = child + 1;
		if (siftee >= contents[child])
			break; // we’re done
		// Move child up and move down one level in the tree.
		contents[parent] = contents[child];
		parent = child;
		child = 2 * parent + 1;
	}
	contents[parent] = siftee;
}

public void siftUp(int i){
	int siftee = contents[i];
	int child = i;
	int parent = (child - 1) / 2;
	while (parent >= 0){
		if (child == 0 || siftee <= contents[parent])
			break;
		contents[child] = contents[parent];
		child = parent;
		parent = (child - 1) / 2;
	}
	contents[child] = siftee;

}

public int remove() {
	int toRemove = contents[0];
	contents[0] = contents[numItems - 1];
	numItems--;
	siftDown(0);
	return toRemove;
}

public void insert(int item) {
	contents[numItems] = item;
	siftUp(numItems);
	numItems++;
	}

 public static void main( String [] args ) {
 	int[] z = {};
Heap heapser = new Heap(z);
printArray(heapser.contents);
heapser.insert(1);
printArray(heapser.contents);
heapser.insert(2);
printArray(heapser.contents);
heapser.insert(1);
printArray(heapser.contents);
 }
}
