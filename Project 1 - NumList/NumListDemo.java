// Derek Tang
// EECS 233 Spring 2015
// Project 1
// Demonstration of NumLists

import java.util.Iterator;

public class NumListDemo{

//Iterates through NumList, summing each element and returns the average
//O(n): Worst Case(always) is linear run time because method has to run through each element once
public static double meanSequence(NumList<Double> lst){
double avg = 0;
//All NumLists have an implemented iterator using .iterator()
Iterator<Double> itr = lst.iterator();
 while( itr.hasNext() ) {
 	double tmp = itr.next();
     avg += tmp;
     System.out.println(tmp);
    }
    return avg/lst.size();
}

public static void main(String[] args){
	NumList<Double> numAL = new NumArrayList<Double>(2);
	System.out.println("Part I: NumArrayList\nNumArrayList after declaration: " + numAL);
	numAL.insert(2,1.4);
	numAL.insert(1,18.2);
	numAL.insert(2,.3333);
	numAL.insert(3,47.3);
	numAL.insert(26,1.0);
	numAL.insert(3,4.0);
	System.out.println("NumArrayList after insertions: " + numAL);
	System.out.println("Calculating mean of sequence: " + meanSequence(numAL));
	numAL.remove(0);
	numAL.remove(0);
	numAL.remove(0);
	System.out.println("NumArrayList after removals(Demonstrates size management): " + numAL);

	NumList<Double> numLL = new NumLinkedList<Double>();
	System.out.println("\nPart II: NumLinkedList\nNumLinkedList after declaration: " + numLL);
	numLL.insert(2,1.4);
	numLL.insert(1,18.2);
	numLL.insert(2,.3333);
	numLL.insert(3,47.3);
	numLL.insert(26,1.0);
	numLL.insert(3,4.0);
	System.out.println("NumLinkedList after insertions: " + numLL);
	System.out.println("Calculating mean of sequence: " + meanSequence(numLL));
	numLL.remove(0);
	numLL.remove(0);
	numLL.remove(0);
	System.out.println("NumLinkedList after removals: " + numLL);
}

}