import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class HuffmanCompressorinputFileoutputFile {
    
    public static String input;
    public static int indChar;
    public static HuffmanNode [] counter;
    public static ArrayList<HuffmanNode> encoding;
    // I used an arraylist instead of a linked list becasue it was easier to traverse the list using indicies
    public static int bits;
    
    
    public HuffmanCompressorinputFileoutputFile(){
        input = ""; // input string
        indChar = 0; // index of last character in collections of chars
        counter = new HuffmanNode[256]; // data structure storing characters(collect frequencies); 256 is max number of characters in UTF8
        encoding = new ArrayList<HuffmanNode>(); // collection of Huffman nodes with encodings
        bits = 0; // bit counter for new file
    }
    
    public static void StringhuffmanCoder(String inputFileName, String outputFileName){
        input = scanner(inputFileName); // load inputed text file into the string "input"
        huffmanGen(); // records the frequencies of characters in counter
        huffTreeGen(); // generates a tree of Huffman nodes at the last index of counter
        huffmanEncoding();
        write(outputFileName);
    }
    
    public static void huffmanGen(){
        for(int chr = 0; chr < input.length(); chr++){
            String character = input.substring(chr, chr+1);
        //Goes through each character in input string
        //Checks to see if already recorded. If not, 
        //it is added, else the frequency is increased
            for(int i = 0; i < counter.length; i++){
                if (counter[i] == null){
                    counter[i] = new HuffmanNode(character);
                    indChar = i;
                    break;
                }
                else if (((String)(counter[i].getValue())).compareTo(character) == 0){
                    counter[i].inc();
                    break;
                }
            }
        }
        //I use MergeSort to sort the collection of chars from lowest to highest
        MergeSort.sort(0, indChar + 1, counter);
        
    }
    
    public static void huffTreeGen(){
        // merges two nodes with lowest two frequencies
        // left child is given a base encoding of 0
        // right child is given a base encoding of 1
        // resort the collection after merging of two
        // repeating the cycle inchar times generates the huffman tree at coutner[inchar]
        for (int i = 0; i < indChar; i++){
            counter[i].encode("0"); counter[i+1].encode("1");
            counter[i+1] = new HuffmanNode(counter[i], counter[i+1]);
            MergeSort.sort(i+1,indChar+1,counter);
        }
    }
    
    public static void huffmanEncoding(){
        HuffmanNode root = counter[indChar]; // root
        encoding = new ArrayList<HuffmanNode>(indChar);
        // encoding will store the HuffmanNodes with codes
        // note each node has its own code
        // I do an inorder traversal of the Huffman tree using a queue
        // When I dequeue a non-leaf node, its children inherit the node's code
        // This allows each leaf node to have all of its ancestor's code as its own
        // This means each node already knows its Huffman Encoding
        LLQueue queue = new LLQueue<HuffmanNode>();
        queue.enqueue(root);
        // Inorder traversal
        while(!queue.isEmpty()){
            String tempCode = ((HuffmanNode)queue.front()).getCode();
            if(((HuffmanNode)queue.front()).isLeaf())
            encoding.add((HuffmanNode)queue.dequeue());
            else{
                HuffmanNode tmp1 = ((HuffmanNode)queue.front()).getLeft();
                HuffmanNode tmp2 = ((HuffmanNode)queue.front()).getRight();
        //Adding parent's code to childs' codes
                tmp1.encode(tempCode);
                tmp2.encode(tempCode);
                queue.enqueue(tmp1);
                queue.enqueue(tmp2);
                queue.dequeue();
            }
        }
    }
    
    //**** Helper Methods *****

    // returns text document in form of string
    public static String scanner(String filePath){
        File file = new File(filePath);
        String theString = "";//the final string
        try {
            
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                theString = theString + line + "n" ;
            }
            scanner.close();
            //System.out.println(theString);
            
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return theString;
        
    }
    
    // finds character in encoding collection and returns appropriate code
    public static String encode(String input){
        for(int i = 0; i < encoding.size(); i++){
            if(encoding.get(i).getValue().equals(input))
            return encoding.get(i).getCode();
        }
        return "";
    }
    
    // writes final encoded string to text file
    public static void write(String outputFileName){
        File file = new File (outputFileName);
        try
        {
            PrintWriter out = new PrintWriter(outputFileName);
            // rescans text to produce output file
            // computes savings (bits)
            for(int chr = 0; chr < input.length(); chr++){
                String tmp = encode(input.substring(chr, chr+1));
                bits += tmp.length();
                out.print(tmp);
                //System.out.print(encode(input.substring(chr, chr+1),encoding));
            }
            //out.println(output);
            out.close();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File could not be found.");
        }
        
    }
    
    public static void main( String[] args ) {
        HuffmanCompressorinputFileoutputFile gettinFreqqy = new HuffmanCompressorinputFileoutputFile();
        gettinFreqqy.StringhuffmanCoder("pgymalion.txt","pgymalionEncoded.txt");
        
        System.out.println("\nHuffman encoding table:");
        for(int i = 0; i < encoding.size(); i++){
            System.out.println(encoding.get(i));
        }

        System.out.println("The encoding yields " + bits + " bits.");
        System.out.println("This is approximately " + (bits*.000125) + " kilobytes.");
        System.out.println("The original filie was 81.9 kilobytes");
        System.out.println("The amount of space saved is " + (81.9 - (bits*.000125)) + " kilobytes");

    }
}//end HuffmanCompressorinputFileoutputFile