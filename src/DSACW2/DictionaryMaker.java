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

        TreeMap<Integer, String> t = new TreeMap<Integer, String>();//Stores list of words with the numbers

        for (String s : dict) {

            if (!t.containsValue(s)) {

                t.put(1, s);

            } else {

                t.put(+1, t.get(s));
            }

            System.out.println(t);
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
        ArrayList<String> in = readWordsFromCSV("C:\\Users\\Jarde\\Documents\\CompEng 1920\\DATA STRCUTURES\\TextFiles\\lotr.csv");
        DictionaryMaker df = new DictionaryMaker(in);
        //DO STUFF TO df HERE in countFrequencies
        df.FormDictionary();
        System.out.println(df);
        // System.out.println(in);
        // df.saveToFile();

    }

}

