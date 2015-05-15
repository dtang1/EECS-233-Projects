import java.util.ArrayList;
import java.lang.Integer;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
public class Reporting2{

	public static void printArray( int[] a ) {
 System.out.print("[");
 for( Object thang : a )
     System.out.print( thang + ",");
 System.out.println("]");
    }
     public static void write(String outputFileName, String print){
        File file = new File (outputFileName);
        try
        {
            PrintWriter out = new PrintWriter(outputFileName);
                out.print(print);
            
            //out.println(output);
            out.close();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File could not be found.");
        }
        
    }

    public static long median(long[] times){//find median of 3 longs
    	long a = times[0];
    	long b = times[1];
    	long c = times[2];
    	return Math.max(Math.min(a,b), Math.min(Math.max(a,b),c));
    }

	public static void main( String[] args ) {
		String stringOInts = "";
		try {  
            Scanner scanner = new Scanner(new FileInputStream(args[0]));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                stringOInts = stringOInts + line +" " ;
            }
            scanner.close();
            } catch (FileNotFoundException e) {
            	e.printStackTrace();
            }
	String[] ints = stringOInts.split( "\\s+");
	int[] realInts = new int[ints.length];
	for(int i = 0; i < ints.length; i++)
		realInts[i] = Integer.parseInt(ints[i]);
	//printArray(realInts);
	int[] tempInts = new int[realInts.length];
	long[] trio = new long[3];
	String printable = "";
	for(int i = 0; i < 9; i++){
		for (int j = 0; j < realInts.length; j++)
			tempInts[j] = realInts[j];
		long startTime = System.nanoTime();
		if(i<3)HeapSort.heapSort(tempInts);
		else if(i<6)QuickSort.quickSort(tempInts);
		else MergeSort.mergeSort(tempInts);
		trio[i%3]=System.nanoTime() - startTime;
		if(i==2)printable += "HSdxt174 = " + median(trio) + "ns; ";//Printing of medians
		if(i==5)printable += "QSdxt174 = " + median(trio) + "ns; ";
		if(i==8)printable += "HSdxt174 = " + median(trio) + "ns; ";
		String output = "";
		for (int k = 0; k < tempInts.length; k++)
			output += tempInts[k] +"\n";
		if(i==0) write("dxt174HS.txt",output);//Printing of sorted arrays in first runs
		if(i==3) write("dxt174QS.txt",output);
		if(i==6) write("dxt174MS.txt",output);
}
System.out.println(printable);
}
}