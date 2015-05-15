import java.util.Random;
import java.util.ArrayList;
import java.lang.Math;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Reporting1{

	public static ArrayList<Long> timeWell = new ArrayList<Long>();
	public static int timeKeeper = 0;

	public int[] genSortedArray(int size){
		int[] tmp = new int[size];
		for(int i = 0; i < size; i++)
			tmp[i] = i+1;
		return tmp;
	}

	public int[] genReverseArray(int size){
	int[] tmp = new int[size];
		for(int i = 0; i < size; i++)
			tmp[i] = size - i;
		return tmp;
	}

	public int[]genRandomArray(int size){
		int[] tmp = new int[size];
		Random rand = new Random();
		if(rand.nextInt(2) == 0)//randomize random
			for(int i = 0; i < size; i++)
				tmp[i] = rand.nextInt(size) + 1;
		else
			for(int i = 0; i < size; i++)
				tmp[i] = (int) Math.ceil(Math.random()*size);
		return tmp;
	}

	public static long median(long a, long b, long c){
    	return Math.max(Math.min(a,b), Math.min(Math.max(a,b),c));
    }

	public void test(int size,int sorty){//test sorts, keep time and push to ArrayList timeWell
		int[] sorted = genSortedArray(size);
		for(int i = 0; i < 3; i++){
			long startTime = System.nanoTime(); 
			if(sorty == 0)   
				MergeSort.mergeSort(sorted);
			else if (sorty == 1)
				QuickSort.quickSort(sorted);
			else
				HeapSort.heapSort(sorted);
			timeWell.add(System.nanoTime() - startTime);
			timeKeeper++;
		}
		int[] reverse = genReverseArray(size);
		for(int i = 0; i < 3; i++){
			long startTime = System.nanoTime();    
			if(sorty == 0)   
				MergeSort.mergeSort(reverse);
			else if (sorty == 1)
				QuickSort.quickSort(reverse);
			else
				HeapSort.heapSort(reverse);
			timeWell.add(System.nanoTime() - startTime);
			timeKeeper++;
		}
		int[] random = genRandomArray(size);
		for(int i = 0; i < 10; i++){
			long startTime = System.nanoTime();    
			if(sorty == 0)   
				MergeSort.mergeSort(random);
			else if (sorty == 1)
				QuickSort.quickSort(random);
			else
				HeapSort.heapSort(random);
			timeWell.add(System.nanoTime() - startTime);
			timeKeeper++;
		}
	}


	public void test(){
		System.out.println("Beginning 1000 Test");
		test(1000,0);
		System.out.println("MergeSort");
		test(1000,1);
		System.out.println("QuickSort");
		test(1000,2);
		System.out.println("HeapSort");
		System.out.println("Beginning 10000 Test");
		test(10000,0);
		System.out.println("MergeSort");
		test(10000,1);
		System.out.println("QuickSort");
		test(10000,2);
		System.out.println("HeapSort");
		System.out.println("Beginning 100000 Test");
		test(100000,0);
		System.out.println("MergeSort");
		test(100000,1);
		System.out.println("QuickSort");
		test(100000,2);
		System.out.println("HeapSort");
		System.out.println("Beginning 1000000 Test");
		test(1000000,0);
		System.out.println("MergeSort");
		test(1000000,1);
		System.out.println("QuickSort");
		test(1000000,2);
		System.out.println("HeapSort");
	}

	public static String createExcel(){//adding times(ns) in Excel Format
		String temp = "Array Size: 1000\nSorted\nMergeSort";
		for(int i = 0; i < 3; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nQuickSort";
		for(int i = 3; i < 6; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nHeapSort";
		for(int i = 6; i < 9; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nReversed\nMergeSort";
		for(int i = 9; i < 12; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nQuickSort";
		for(int i = 12; i < 15; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nHeapSort";
		for(int i = 15; i < 18; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nRandom\nMergeSort";
		for(int i = 18; i < 28; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nQuickSort";
		for(int i = 28; i < 38; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nHeapSort";
		for(int i = 38; i < 48; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nArray Size: 10000\nSorted\nMergeSort";
		for(int i = 48; i < 51; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nQuickSort";
		for(int i = 51; i < 54; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nHeapSort";
		for(int i = 54; i < 57; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nReversed\nMergeSort";
		for(int i = 57; i < 60; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nQuickSort";
		for(int i = 60; i < 63; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nHeapSort";
		for(int i = 63; i < 66; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nRandom\nMergeSort";
		for(int i = 66; i < 76; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nQuickSort";
		for(int i = 76; i < 86; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nHeapSort";
		for(int i = 86; i < 96; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nArray Size: 100000\nSorted\nMergeSort";
		for(int i = 96; i < 99; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nQuickSort";
		for(int i = 99; i < 102; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nHeapSort";
		for(int i = 102; i < 105; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nReversed\nMergeSort";
		for(int i = 105; i < 108; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nQuickSort";
		for(int i = 108; i < 111; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nHeapSort";
		for(int i = 111; i < 114; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nRandom\nMergeSort";
		for(int i = 114; i < 124; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nQuickSort";
		for(int i = 124; i < 134; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nHeapSort";
		for(int i = 134; i < 144; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nArray Size: 1000000\nSorted\nMergeSort";
		for(int i = 144; i < 147; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nQuickSort";
		for(int i = 147; i < 150; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nHeapSort";
		for(int i = 150; i < 153; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nReversed\nMergeSort";
		for(int i = 153; i < 156; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nQuickSort";
		for(int i = 156; i < 159; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nHeapSort";
		for(int i = 159; i < 162; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nRandom\nMergeSort";
		for(int i = 162; i < 172; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nQuickSort";
		for(int i = 172; i < 182; i++)
			temp += "\t"+ timeWell.get(i);
		temp += "\nHeapSort";
		for(int i = 182; i < 192; i++)
			temp += "\t"+ timeWell.get(i);
		return temp;

}

	public static void printArray( ArrayList<Long> a ) {
 System.out.print("[");
 for(int i = 0; i < timeKeeper; i++)
 	System.out.print(a.get(i)+",");
 System.out.println("]");
    }

    public static void write(String outputFileName){
        File file = new File (outputFileName);
        try
        {
            PrintWriter out = new PrintWriter(outputFileName);
                out.print(createExcel());
            
            //out.println(output);
            out.close();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File could not be found.");
        }
        
    }

	 public static void main( String [] args ) {
	 	Reporting1 aqoieu = new Reporting1();
	 	aqoieu.test();
	 	aqoieu.printArray(aqoieu.timeWell);
	 	aqoieu.write("Stats.xls");
	 	System.out.println("See States.xls for results");
	 }

}