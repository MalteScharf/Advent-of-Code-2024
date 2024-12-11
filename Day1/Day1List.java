package Day1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.abs;

public class Day1List {

    public static void main(String[] args) throws IOException {
        Day1List day1 = new Day1List();
        ArrayList<ArrayList<Integer>> list = day1.loadFile();
        day1.orderLists(list);
        int difference = day1.calculatediffernce(list);
        System.out.println("Difference: " + difference);

        int similarity = day1.calculateSimilartiy(list);
        System.out.println("Similarity: " + similarity);


    }
    public ArrayList<ArrayList<Integer>> loadFile() throws IOException {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        //int[] list2 = new int[1];
        String filepath = "/home/malte/Documents/Programming Projects/Advent of Code 2024/src/Day1/Day1Input.txt";
        ArrayList<ArrayList<Integer>> list3;
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                list1.add(Integer.parseInt(line.split("\\s+")[0]));
                list2.add(Integer.parseInt(line.split("\\s+")[1]));

            }
            list3 = new ArrayList<>(2);
            list3.add(list1);
            list3.add(list2);

        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Datei: " + filepath);
            throw e;
        }
        return list3;

    }

    public ArrayList<ArrayList<Integer>> orderLists(ArrayList<ArrayList<Integer>> list){
        Collections.sort(list.get(0));
        Collections.sort(list.get(1));
        return list;
    }

    public int calculatediffernce(ArrayList<ArrayList<Integer>> list){
        int difference = 0;
        for (int i=0;i<list.get(0).size(); i++){
            difference += abs(list.get(0).get(i) - list.get(1).get(i));

        }
        return difference;
    }

    public int calculateSimilartiy(ArrayList<ArrayList<Integer>> list){
        int similarity = 0;
        for (int i =0;i<list.get(0).size();i++){
            int occurrences = Collections.frequency(list.get(1),list.get(0).get(i));
            similarity += occurrences * list.get(0).get(i);
        }


        return similarity;
    }
}
