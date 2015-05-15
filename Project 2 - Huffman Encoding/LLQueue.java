public class LLQueue<T> {

    private LLNode<T> _front, _end;

    // default constructor
    // creates an empty queue
    public LLQueue() { 
        _front = _end = null;
    }

    public void enqueue( T enQVal ) {
        if ( isEmpty() ) {
            _front = _end = new LLNode<T>( enQVal, null );
        }
        else {
     _end.setNext( new LLNode<T>( enQVal, null ) );
     _end = _end.getNext();
 }
    }//O(1)


    // means of removing a thing from the collection (queue)
    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue() { 
        T foo = _front.getValue();
        _front = _front.getNext();
        if ( _front == null )
            _end = null;
        return foo;
    }//O(1)


    // means of peeking at thing at front of the collection (queue)
    public T front() { return _front.getValue(); }//O(1)


    public boolean isEmpty() { return _front == null; }//O(1)


    // print each node, separated by spaces
    public String toString() { 
        String foo = "";
        LLNode<T> tmp = _front;
        while ( tmp != null ) {
            foo += tmp.getValue() + " ";
            tmp = tmp.getNext();
        }
        return foo;
    }//O(n)


    public static void main( String[] args ) {

    }//end main

}//end class LLQueue