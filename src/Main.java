/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
/**
 *
 * @author leannekim. Dec 12, 2019.
 */

/* This class converts an english file to morse code. */
public class Main {
    public static void main(String[] args){
        File english = new File("english.txt");
        File morse = new File("morse.txt");
        String line;
        
        char[] engChar = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                  'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
                  'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
                  ',', '.', '?' };

        String[] morseChar = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", 
                ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----", "--..--", ".-.-.-", "..--.." };

        try {
            FileReader in = new FileReader(english);
            BufferedReader readFile = new BufferedReader(in);
            
            FileWriter out = new FileWriter(morse);
            BufferedWriter writeFile = new BufferedWriter(out);
            
            String str = "";    // temporary morse code String
           
            /* reads english.txt file line by line and converts them to morse code. */
            while ((line = readFile.readLine()) != null){
                line = line.toLowerCase();
                char[] chars = line.toCharArray();  // convert current line to character array.
                
                for (int i = 0; i < chars.length; i++){         // length of current line
                    for (int j = 0; j < engChar.length; j++){   // length of engChar
                        /* adds morseChar[j] value to str. */
                        if (engChar[j] == chars[i]){
                            str += morseChar[j] + " ";  // add current character's morse code to str.
                        }
                    }
                }
                writeFile.write(str);   // write str to file
                writeFile.newLine();    // move to next line
                str = "";               // reset str as an empty string.
            }
            in.close();
            readFile.close();
            writeFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist or cannot be found.");
            System.err.println("FileNotFoundException" + e.getMessage());
        } catch (IOException e){
            System.out.println("Problem reading file.");
            System.err.println("IOException" + e.getMessage());
        }
    }
}
