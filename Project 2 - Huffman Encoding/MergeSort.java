public class MergeSort {

    public static void printArray( Object[] a ) {
 System.out.print("[");
 for( Object thang : a )
     System.out.print( thang + ",");
 System.out.println("]");
    }

    private static void merge( int lo, int brk, int hi, Comparable[] x ) {
 int totRegSize = hi - lo; //store size of subregion containing 2 adj, rel sorted regions
 Comparable[] temp = new Comparable[ totRegSize ]; //create aux array to hold merged data

 int subReg1Pos = lo;
 int subReg2Pos = brk;

 for( int i = 0; i < totRegSize; i++ ) {
     if ( subReg1Pos == brk ) //done w subReg1?
  temp[i] = x[subReg2Pos++];
     else if ( subReg2Pos == hi ) //done w subReg2?
  temp[i] = x[subReg1Pos++];
     else if ( x[subReg1Pos].compareTo( x[subReg2Pos] ) < 0 ) // x[sR1P] < x[sR2P]
  temp[i] = x[subReg1Pos++];
     else // x[sR2P] < x[sR1P]
  temp[i] = x[subReg2Pos++];
 }

 //now copy temp array into corresponding slots of primary array
        for( int i = 0; i < totRegSize; i++ ) {
     x[lo + i] = temp[i];
 }

    }//end merge()


    public static void mergeSort( Comparable[] x ) {
      sort(0, x.length, x);
    }

    
    public static void sort( int lo, int hi, Comparable[] x ) {
     int numItems = hi - lo;
     if(numItems <= 1)
       return;
     int mid = (hi + lo) / 2;
     sort(lo, mid, x);
     sort(mid, hi, x);
     merge(lo, mid, hi, x);
      }


    public static void main( String [] args ) {
    }

}//end class MergeSort

