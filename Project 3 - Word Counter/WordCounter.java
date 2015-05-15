//Derek Tang
//EECS 233 Project 3
//Class WordCounter
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class WordCounter {
    
    //instance vars
    public static String input;//string holding all inputs
    public static HashTable table;//hashtable recording frequencies of words
    public static String output;//final output string that gets printed into txt file

    public WordCounter(){
        input = ""; // input string
        table = new HashTable<String>();
    }

    //main function that initiates reading, counting, printing
    public static String wordCount(String inputFileName, String outputFileName){
        input = scanner(inputFileName); // load inputed text file into the string "input"   
        count(); // records the frequencies of characters in table
        write(outputFileName);//writes output string to filename 'outputFileName'
        //returns requested output information: total words, table size, and average size of buckets
        return "\n\nOK; Total words: " + table.tableSize() + ", Hash table size: " + table.size() + ", Hash table slots filled: "+ table.occupancy() + ", Average length of collision lists: " + table.findAve();
    }
    
    //completes hashtable
    public static void count(){
        input.replace("\n", "");//removes new lines
        input = input.toLowerCase();//makes everything lowercase to avoid doubling counting from cases
        String [] words = input.split( "\\P{Alpha}+" );//slits into string into array of strings
        for( String word : words ){//adds each word in array into table
            System.out.print(word+" ");
            table.add(word);
        }
            output = table.toString();//sets the output equal to the table's toString function
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
                theString = theString + line +" " ;
            }
            scanner.close();
            //System.out.println(theString);
            
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return theString;
        
    }
    
    
    // writes final encoded string to text file
    
    public static void write(String outputFileName){
        File file = new File (outputFileName);
        try
        {
            PrintWriter out = new PrintWriter(outputFileName);
                out.print(output);
            
            //out.println(output);
            out.close();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File could not be found.");
        }
        
    }
    
    public static void main( String[] args ) {
        WordCounter wordFreq = new WordCounter();
        //System.out.println(wordFreq.wordCount("toy.txt","toyWordFreq.txt"));
        System.out.println(wordFreq.wordCount("pgymalion.txt","pgymalionWordFreq.txt"));

    }
}//end WordCounter.java