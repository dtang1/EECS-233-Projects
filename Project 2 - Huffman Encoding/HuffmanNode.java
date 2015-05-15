public class HuffmanNode implements Comparable{

    private int _frequency; // frequency
    private Object _value; // same as inChar
    private HuffmanNode _left; // left child pointer
    private HuffmanNode _right; // right child pointer
    private String _code;

    public HuffmanNode( Object obj, int frequency ) {
        _value = obj;
        _frequency = frequency;
        _right = null;
        _left = null;
        _code = "";
    }

    public HuffmanNode(HuffmanNode left, HuffmanNode right){
        _right = right;
        _left = left;
        _code = "";
        _value = null;
        _frequency = right.getFrequency() + left.getFrequency();
    }

    public HuffmanNode( Object obj ) {
        this( obj, 1 ); 
    }

    // mutator methods
    public void inc(){ _frequency++; }

    public void encode(String code) { _code = code + _code; }

    // accessor methods
    public Object getValue() { return _value; }

    public int getFrequency() { return _frequency; }

    public String getCode() { return _code; }

    public HuffmanNode getRight() { return _right; }

    public HuffmanNode getLeft() { return _left; }

    public boolean isLeaf() { return (_left == null && _right == null);}

    //override compareTo(), to adhere to Comparable requirements
    public int compareTo( Object rightSide ){
        if ( ! (rightSide instanceof HuffmanNode ) )
            throw new IllegalArgumentException();
	return getFrequency() - ( (HuffmanNode)rightSide ).getFrequency();
    }

    public String toString() {
        //return "Char: " + _value + "\tFreq: " + _frequency + "\tCode: " + _code;
        return _value + " : " + _frequency + " : " + _code + "\n";
    }


}//end HuffmanNode
