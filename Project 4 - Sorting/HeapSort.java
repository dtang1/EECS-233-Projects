public class HeapSort {

public static void heapSort(int[] arr) {
	Heap heap = new Heap(arr);
	int counter = arr.length - 1;
	while (counter >= 0) {
		int top = heap.remove();
		arr[counter] = top;
		counter--;
	}
}

public static void printArray( int[] a ) {
 System.out.print("[");
 for( Object thang : a )
     System.out.print( thang + ",");
 System.out.println("]");
    }

 public static void main( String [] args ) {
 System.out.println("\n*** now testing on z... ***");
 int[] z = {6,9,7,8,2,5,1,3,4};
 System.out.println("array z initialized to:");
 printArray(z);
 
 heapSort(z);
 System.out.println("\narray z after heapSort(z):");
 printArray(z);
 System.out.println("Should be [1,2,3,4,5,6,7,8,9]");
    }

}

