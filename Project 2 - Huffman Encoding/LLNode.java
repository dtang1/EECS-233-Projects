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

  }//end main
  
}//end class LLNode