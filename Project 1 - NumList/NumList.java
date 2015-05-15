// Derek Tang
// EECS 233 Spring 2015
// simplified NumList interface
// requires implementation of iterator

import java.util.Iterator;

public interface NumList<Item>{
    public int size();
    public void insert( int index, Item x );
    public void remove(int index);
    public Item lookup( int i);
    public Iterator iterator();
   
}