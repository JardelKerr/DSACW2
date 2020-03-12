package DSACW2;

import java.util.*;
import java.io.*;
import java.io.IOException;
import java.util.concurrent.*;

public class DictionaryMaker {

    ArrayList<String> dict;


    public DictionaryMaker(ArrayList<String> d) {

        this.dict = d;

    }


    public static ArrayList<String> readWordsFromCSV(String file) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(file));
        sc.useDelimiter(" |,");
        ArrayList<String> words = new ArrayList<>();
        String str;
        while (sc.hasNext()) {
            str = sc.next();
            str = str.trim();
            str = str.toLowerCase();
            words.add(str);
        }
        return words;
    }

    public static void saveCollectionToFile(Collection<?> c, String file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for (Object w : c) {
            printWriter.println(w.toString());
        }
        printWriter.close();
    }


    public void FormDictionary() throws FileNotFoundException {

        TreeMap<Integer, String> words = new TreeMap<Integer, String>();// Stores a key and a String value

        for (String s : dict) { //Goes through each word in the file

            if (words.containsKey(s)) {//If the String value is not in the Treemap

               // words.put(words.get(s) + 1, s);

            } else {

                words.put(1, s);//Add value in Treemap

                //Increments key if String value is in Treemap already
            }

            System.out.println(words);
        }
    }

    public void saveToFile() {


    }

    @Override
    public String toString() {

        String s = "";
        for (int i = 0; i < dict.size(); i++) {
            s += dict.get(i) + ", ";
        }
        return s;


    }

    public static void main(String[] args) throws Exception {
        ArrayList<String> in = readWordsFromCSV("C:\\Users\\cnu15zwu\\Documents\\DSACW2\\TextFiles\\lotr.csv");
        DictionaryMaker df = new DictionaryMaker(in);
        //DO STUFF TO df HERE in countFrequencies
        df.FormDictionary();
        System.out.println(df);
        // System.out.println(in);
        // df.saveToFile();

    }

}

