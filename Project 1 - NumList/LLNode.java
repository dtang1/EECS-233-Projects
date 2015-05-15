// Derek Tang
// EECS 233 Spring 2015
// Project 1

public class LLNode<T> {
  
  private T _value;
  private LLNode<T> _nextNode;
  
  // constructor
  public LLNode( T value, LLNode next ) { 
    _value = value;
    _nextNode = next;
  }
  
  // accessor methods
  public T getValue() { 
    return _value;
  }
  
  public LLNode getNext() { 
    return _nextNode;
  }
  
  // mutator methods
  public T setValue( T newValue ) { 
    T temp = _value;
    _value = newValue;
    return temp;
  }
  
  public LLNode<T> setNext( LLNode<T> newNext ) { 
    LLNode<T> temp = _nextNode;
    _nextNode = newNext;
    return temp;
  }
  
  // overwrite toString
  public String toString() { 
      return _value.toString();
  }
  
  
  public static void main( String[] args ) {
    /*
    LLNode CoolJ = null;
    CoolJ = new LLNode(3,CoolJ);
    CoolJ = new LLNode(4,CoolJ);
    CoolJ = new LLNode(5,CoolJ);
    while(CoolJ != null){
      System.out.println(CoolJ.getValue() + " ");
      CoolJ = CoolJ.getNext();
    }
    */
  }//end main
  
}//end class LLNode