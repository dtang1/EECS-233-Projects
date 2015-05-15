// Derek Tang
// EECS 233 Spring 2015
// Project 1
// NumLinkedList Class

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NumLinkedList<T> implements NumList<T>{ 

    private LLNode<T> _head;
    private int _size;

    public NumLinkedList() {
        _head = null;
        _size = 0;
    }

    // return number of elements in list
    // O(1): Worst case is constant run time, only returning global var
    public int size() { return _size; }

  
    // return value at index
    // O(n): Worst case is linear if you are looking for the last element, each element must be run through
    public T lookup( int index ) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
         return getNode(index).getValue();
    }

    // insert new node
    // O(n): Worst case is linear if you need to insert at the second to last index 
    public void insert( int index, T newValue ) {
        if ( index < 0 )  
            throw new IndexOutOfBoundsException(); 
        if (size() == 0)
            _head = new LLNode<T>(newValue, null);
        else if ( index == 0){
            LLNode<T> tmp = new LLNode<T>(newValue, _head);
            _head = tmp;
        }
        else if (index >= size()){
            getNode(_size - 1).setNext(new LLNode<T>(newValue,null));
        }
        else{
            LLNode<T> tmp = getNode(index - 1);
            LLNode<T> tmpr = tmp.getNext();
            tmp.setNext(new LLNode<T>(newValue, tmpr));
        }
        _size++;
    }

    // remove the T at specified index
    // O(n): Worst case is linear if you need to remove the last elment, forcing each element to be run through
    public void remove( int index ) {
        if (index >= size() || index < 0)  
            throw new IndexOutOfBoundsException(); 
        if ( index == 0 ) 
            _head = _head.getNext();
        else {
            LLNode<T> tmpr = getNode(index - 1);
            LLNode<T> tmp = tmpr.getNext();
            tmpr.setNext( tmp.getNext() );
        }
        _size--;
    }

    // designates MyIterator class as iterator
    public Iterator<T> iterator() { 
        return new MyIterator();
    }

    // ***************** helper fxns ****************

    // returns node at given index
    // helper fxn for remove() and insert()
    // O(n): Worst case is linear if index==size
    public LLNode<T> getNode(int index){
        LLNode<T> tmp = _head;
        for( int i = 0; i < index; i++ ) 
            tmp = tmp.getNext();
        return tmp;
    }

    public String toString() {
        String foo = "HEAD-> ";
        LLNode<T> tmp = _head;
        while( tmp != null ) {
            foo += tmp.getValue() + " <-> ";
            tmp = tmp.getNext();
        }
        return foo;
    }

    // ************* MyIterator implementation ***************
    // *******************************************************
    private class MyIterator implements Iterator{
    private LLNode<T> _curr;
    private boolean _ok;

    public MyIterator(){
        _curr = new LLNode<T>(null,_head);
        _ok = false;
    }
    
    public boolean hasNext(){
        if(_curr == null)
            return false;
        else
            return _curr.getNext() != null;
        }

    public T next() {
        _curr = _curr.getNext();
        if(_curr == null)
            throw new NoSuchElementException();
        _ok = true;
        return _curr.getValue();
    }
    }//end class MyIterator

}//end class LList<T>