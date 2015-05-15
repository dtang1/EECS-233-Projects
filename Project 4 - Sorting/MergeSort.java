public class MergeSort {

public static void mergeSort(int[] arr) {
	int[] temp = new int[arr.length];
	sort(arr, temp, 0, arr.length - 1);
}

public static void sort(int[] arr, int[] temp, int start, int end){
	//mergesort from bottom up, merges pairs at a time, for non power of 2 arrays
	int width = 1;
	int write = 0;
	while (width < end){
		for(int i = 0; i < end; i+=2*width){
			//note for non power of 2 arrays, possibility of middle, leftStart, and leftEnd to be set to size of array
			int middle = Math.min(i+width-1,arr.length-1);
			int leftStart = Math.min(middle+1,arr.length-1);
			int leftEnd = Math.min(leftStart + width - 1, arr.length-1);
			if(write == 0){
				//alternates merging into arr and temp array
				merge(arr,temp,i,middle,leftStart,leftEnd);
			}
			else{
				merge(temp,arr,i,middle,leftStart,leftEnd);
			}
		}
		width *= 2;
		write = (write + 1) % 1;
	}
	if (write == 0){//if last merge was into temp, copy temp into arr
		for (int i = 0; i < arr.length; i++)
			arr[i] = temp[i];
	}
}

public static void merge(int[] arr, int[] temp, int leftStart, int leftEnd, int rightStart, int rightEnd) {
	int i = leftStart; // index into left subarray
	int j = rightStart; // index into right subarray
	int k = leftStart; // index into temp
	while (i <= leftEnd && j <= rightEnd) {
		if (arr[i] < arr[j])
			temp[k++] = arr[i++];
		else
			temp[k++] = arr[j++];
	}
	while (i <= leftEnd && k < arr.length)
		temp[k++] = arr[i++];
	while (j <= rightEnd)
		temp[k++] = arr[j++];
	for (i = leftStart; i <= rightEnd; i++)
		arr[i] = temp[i];
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
 
 mergeSort(z);
 System.out.println("\narray z after heapSort(z):");
 printArray(z);
 System.out.println("Should be [1,2,3,4,5,6,7,8,9]");    }

}