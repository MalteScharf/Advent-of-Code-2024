package Day2;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day2 {
   /* public static void main(String[] args) throws IOException {
        Day2 day2 = new Day2();
        ArrayList<ArrayList<Integer>> list = day2.loadFile();
        int numberOfSafeReports = day2.countSafeReports(list);
        int numberOfSafeReportsDampened = day2.countSafeReports(list);

        System.out.println("SafeReports: " + numberOfSafeReports);

   }*/

    public ArrayList<ArrayList<Integer>> loadFile() throws IOException {

        String filepath = "/home/malte/Documents/Programming Projects/Advent of Code 2024/src/Day2/Day2Test.txt";
        ArrayList<ArrayList<Integer>> list3 = new ArrayList<>(1);
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                ArrayList<Integer> list1 = new ArrayList<>();
                int lineLength = line.split("\\s+").length;
                for (int i = 0; i < lineLength; i++) {

                    int value = Integer.parseInt(line.split("\\s+")[i]);
                    list1.add(value);
                }
                list3.add(list1);
                lineNumber++;
            }


        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Datei: " + filepath);
            throw e;
        }
        return list3;

    }

    public int countSafeReports(ArrayList<ArrayList<Integer>> list) {
        int numberOfSaveReports = 0;


        for (int i = 0; i < list.size(); i++) {
            if (this.checkIncreasing(list.get(i))==true || this.checkDecreasing(list.get(i))==true) numberOfSaveReports++;

        }
        return numberOfSaveReports;
    }


    public boolean checkIncreasing(ArrayList<Integer> list) {
        boolean safe = false;
        int size = list.size()-1;
        for (int i = 0; i < size; i++) {
            int difference = list.get(i + 1) -list.get(i);
            if (1 <= difference && difference <= 3) safe = true;
            else {
                safe = false;
                break;
            }
        }
        return safe;
    }

    public boolean checkDecreasing(ArrayList<Integer> list) {
        boolean safe = false;
        int size = list.size()-1;
        for (int i = 0; i < size; i++) {
            int difference = list.get(i + 1) -list.get(i);
            if (-1 >= difference && difference >= -3) safe = true;
            else {
                safe = false;
                break;
            }
        }
        return safe;
    }

}
