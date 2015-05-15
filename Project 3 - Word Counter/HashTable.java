//Derek Tang
//EECS 233 Project 3
//class HashTable

import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Math;

public class HashTable<T>{
  
  //instance vars
  public ArrayList<LinkedList<LLNode<T>>> _table; //Arraylist as basic hashtable structure
  private int _cap; //The maximum capacity, or size of the Arraylist
  private int _slots; //The number of hash slots used at a given time
  private int count; //The number of total unique nodes, words, at a given time 
  
  //initialize HashTable
  public HashTable() { 
    _table = new ArrayList<LinkedList<LLNode<T>>>(1024);//Initial hashtable capacity of 1024(2^10)
    _cap = 1024;
    _slots = 0;//0 initial slots filled
    count = 0;//0 initial words in table
    for ( int i = 0; i < _cap; i++)
      _table.add(new LinkedList<LLNode<T>>());//places empty LinkedList at each index of table
  }
  
  //Adding a new word with value 'addVa'
  //returns true if successfully added, false otherwise
  public boolean add( T addVa){
    return add(addVa,1);//pass into overloaded add method with the inital frequency of 1
  }

  //Adding or updating word with value 'addVa'
  //returns true if successfully added, false otherwise
  public boolean add( T addVa, int freq ) {
    if (full())//check to see if table needs to be resized
      resize();//if sufficiently full, resize the table
    int i = Math.abs(addVa.hashCode())%_cap;//hash string to find index, note hashCode may give negative hashing hence the abs
    LinkedList<LLNode<T>> yo = _table.get(i);
    if(yo.isEmpty())
      _slots++;//update _slots if new slot is needed for adding
    if ( contains(addVa)){//if the word is already in the table
      for(int p = 0; p < yo.size(); p++){//run through each node of LList at hashed index
      LLNode<T> tmp = yo.get(p);
      if(tmp.getValue().equals(addVa)){
        tmp.addFreq();//update frequency
        return false;
      }
      }
    }
    else{
      if(freq > 1)//if adding existing node, update new frequency
        yo.add(new LLNode<T>(addVa,freq));
      else//add completely new element to table
        yo.add(new LLNode<T>(addVa,1));
      count++;
    }
    return true;

  }
  
  //Updates capacity to twice the prexisting capacity
  //Rehashes all previous nodes into updated table
  public void resize(){
    ArrayList<LinkedList<LLNode<T>>> tmp = _table;//store old tabe
    _cap = 2*_cap;//update global vars
    _slots = 0;
    count = 0;
    _table = new ArrayList<LinkedList<LLNode<T>>>(_cap);//create new table of twice the capacity
    for ( int i = 0; i < _cap; i++)//iterates through each node in old table and rehashes into updated table
      _table.add(new LinkedList<LLNode<T>>());
    for (int i = 0; i < _cap/2; i++){
      LinkedList<LLNode<T>> tmper = tmp.get(i);
      for(int p = 0; p<tmper.size();p++){
        add(tmper.get(p).getValue(),tmper.get(p).getFreq());//passes node's string and frequency
      }
    }
  }
  
  //Returns true if the table already has the word 'q', false if it is new
  //Iterates through LinkedList with q's hashed index
  public boolean contains( T q ) { 
    int i = Math.abs(q.hashCode()) % _cap;
    LinkedList<LLNode<T>> tmp = _table.get(i);
    for(int p = 0; p < tmp.size(); p++){
      if (tmp.get(p).getValue().equals(q))
        return true;
    }
    return false;
  }
  
  //removes node with a value of 'remVal'
  //returns true if removal is succesful, false if it does not exist in the table
  public boolean remove( T remVal ) { 
    if(!contains(remVal))
      return false;
    int i = Math.abs(remVal.hashCode()) % _cap;
    LinkedList<LLNode<T>> tmp = _table.get(i);//iterates through LList at hashed index
    for (int p = 0; p < tmp.size(); p++){
      if(tmp.get(p).getValue().equals(remVal)){
        tmp.remove(p);
        break;
      }
    }
    return true;
  }
  
  //Computes and returns average bucket size
  //average is equal to the total number of unique words divided by the number of hashed slots
  public double findAve() { 
    double tmp = (double)count;
    return tmp/_slots;
  }
  
  //returns number of hashed slots
  public int occupancy(){
    return _slots;
  }
  //returns size or capacity of table
  public int size() { 
    return _cap;
  }

  //returns the number unique words in table
  public int tableSize(){
    return count;
  }
  
  //check if table is sufficiently full for resizing
  //returns true if the number of hashed slots is greater than or equal to 3/4 the capacity
  public boolean full(){
    return (_slots >= 3 * _cap / 4);
  }
  
  
  //======== MISC SUPPORT FXNS ======= 
  
  //toString funtion, returns string in proper format
  public String toString() { 
    
    String retStr = "";//"{";
    
    for(int i = 0; i < _cap; i++){
      LinkedList<LLNode<T>> tmp = _table.get(i);
      for(int p = 0; p < tmp.size(); p++){
        retStr += "(" + tmp.get(p).getValue() +" " + tmp.get(p).getFreq() + ")\n";
      }
    }
    
    return retStr;
  }
  //====================================
  
  public static void main( String[] args ) { 
    /*HashTable<String> daStory = new HashTable<String>();
    daStory.add("yo");
    System.out.println(daStory+" "+daStory.size());
    daStory.add("yo");
    System.out.println(daStory+" "+daStory.size());
    daStory.add("yoo");
    System.out.println(daStory+" "+daStory.size());
    daStory.add("yooo");
    System.out.println(daStory+" "+daStory.size());
    daStory.add("yoo");
    System.out.println(daStory+" "+daStory.size());
    daStory.add("yo");
    System.out.println(daStory+" "+daStory.size());
    daStory.add("yo");
    System.out.println(daStory+" "+daStory.size());
    daStory.add("yoooo");
    System.out.println(daStory+" "+daStory.size());
    daStory.add("yooooo");
    System.out.println(daStory+" "+daStory.size());
    daStory.add("yoooooo");
    System.out.println(daStory+" "+daStory.size());
    daStory.add("yo");
    System.out.println(daStory+" "+daStory.size());
    daStory.add("yo");
    System.out.println(daStory+" "+daStory.size());*/
  }//end main
  
}//end class HashSet