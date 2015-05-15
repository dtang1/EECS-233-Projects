// Derek Tang
// EECS 233 Spring 2015
// Project 1
// NumArrayList Class

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NumArrayList<T> implements NumList<T>{
  
  private T[] _data;
  private int _size;
  private int _max;
  
  //default constructor
  //initializes 10-item array
  public NumArrayList() { 
    _data = (T[]) new Object[10];
    _size = 0; 
    _max = 0;
  }
  
  //overloaded constructor
  //allows caller to specify size
  public NumArrayList( int initSize ) { 
    _data = (T[]) new Object[initSize];
    _size = 0;
    _max = 0;
  }
  
  //return number of meaningful items in _data
  //O(1): Worst case is constant, returns global var
  public int size(){
    return _size;
  }
  
  //accessor method -- return value at specified index
  //0(1): Worst case is constant, returns index of array
  public T lookup( int index ) { 
    if(index >= _size)
     return null;
    else
      return _data[index];
  }
  
  //inserts an item at Index
  //shifts existing elements to the right
  //O(n): Worst case is linear if inserting in idex[0], needs to push everything to right
  public void insert(int index, T newVal) {
    if (size() >= _data.length)
      expand();
    if(index >= size())
      _data[_size] = newVal;
    else{
    for(int i = _size; i > index; i--)
      _data[i] = _data[i - 1];
    _data[index] = newVal;
  }
    _size++;
    _max++;
  }
  
  //removes the item at index
  //shifts elements left to fill in newly-emptied slot
  //O(n): Worst case if removing first element, have to push everything to left
  public void remove( int index ) { 
    if(index >= _size || index < 0)
     System.out.println("Index Out of Bounds");
    else {
    //T temp = _data[index];
    for( int i = index; i < _size - 1; i++ ) {
      _data[i] = _data[i+1];
    }
    _data[_size-1] = null;
    _size--;
    //maintains size of datastructure. If size is less than half of max, resize to 3/2 size
    if(_size<=_max/2){
      T[] shrink = (T[])new Object[_size * 3 / 2];
      for (int i = 0; i < _size; i++)
        shrink[i] = _data[i];
      _data = shrink;
    }
    //return temp;
    }
  }

  public Iterator<T> iterator() { 
    return new MyIterator();
    }

  // ***************** helper fxns ****************
  
  //double capacity of this instance of NumArrayList 
  //O(n): Worst case(always) is linear. Need to copy each element to new array
  private void expand() { 
      T[] growth = (T[])new Object[_data.length * 2];
    for (int i = 0; i < _data.length; i++)
      growth[i] = _data[i];
    _data = growth;
  }

  //output array in [a,b,c] format
  //eg, for int[] a = {1,2,3} ...
  //toString() -> "[1,2,3]"
  public String toString() { 
    return printArray(_data);
  }

  public static String printArray(Object[] a){
    String ans = "[";
    for (int i = 0; i < a.length; i++){
      if (i == a.length - 1)
        ans += a[i];
      else
        ans += a[i] + ",";
    }
    ans += "]";
    return ans;
  }

  // ************* MyIterator implementation ***************
  // *******************************************************
 

  private class MyIterator implements Iterator{
    private Object[] numList;
    private int _curr;
    private boolean _ok;
    
    public MyIterator(){
      numList = _data;
      _curr = -1;
      _ok = false;
    }
    
    public boolean hasNext(){
      if(_curr >= _size-1 || (_curr != -1 && _data[_curr] == null))
        return false;
      else
        return _data[_curr+1] != null;
    }

    public T next() {
      _curr++;
      if(_curr >= _size)
        throw new NoSuchElementException();
      _ok = true;
      return _data[_curr];
    }
  }//end class MyIterator


}//end class NumArrayList

