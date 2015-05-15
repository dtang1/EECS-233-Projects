//Derek Tang
//EECS 233 Project 3
//Class LLNode
public class LLNode<T> {
  
  //instance vars
  private T _value;//holds value or string of node
  private int _frequency;//records frequency of node or word
  
  // constructor
  //initialized to passed values of 'value' and 'freq'
  public LLNode( T value, int freq ) { 
    _value = value;
    _frequency = freq;
  }
  
  // accessor methods

  //returns value or string
  public T getValue() { 
    return _value;
  }

  //reuturns frequency
  public int getFreq(){
    return _frequency;
  }
  
  // mutator methods
  public T setValue( T newValue ) { 
    T temp = _value;
    _value = newValue;
    return temp;
  }

  //set frequency to given value 'freq'
  public void setFreq(int freq){
    _frequency = freq;
  }

  //increments frequncy by 1
  public void addFreq(){
    _frequency++;
  }

  
  // overwrite toString
  public String toString() { 
      return _value.toString();
  }
  
  
  public static void main( String[] args ) {

  }//end main
  
}//end class LLNode