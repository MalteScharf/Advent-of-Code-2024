package Day3;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day3 {
    public static void main(String[] args){
        Day3 day3 = new Day3();
        String pathname = "/home/malte/Documents/Programming Projects/Advent of Code 2024/src/Day3/Day3Input.txt";;
        List<Character> list = day3.loadFile(pathname); // Load Input char by char as ArrayList
        int result = day3.finalSearch(list);
        //System.out.println(list);
       System.out.println("Result: " +result);


    }

    public List<Character> loadFile(String pathname){      // load File char by char
        List<Character> list = new ArrayList<Character>();
        try (FileReader reader = new FileReader(pathname)) {
            int character;
            while ((character = reader.read()) != -1) {
                list.add((char) character);
                //System.out.println(list);
            }
        }catch (IOException e){
                e.printStackTrace();
            }
        return list;
    }


    public boolean find(char character,List<Character> list, int i){
        if (list.get(i) == character) return true;
        return false;
    }

    private static boolean isLetterOrDigit(char c) {   //returns true if digit
        return (c >= '0' && c <= '9');
    }

    public boolean findMul(List<Character> list, int start){
        Day3 day3 = new Day3();
        if (day3.find('m',list,start) == true && day3.find('u',list,start+1) == true && day3.find('l',list,start+2) == true && day3.find('(',list,start+3) == true) return true;

        return false;
        }

        private int findInterRow(List<Character> list, int start){
            Day3 day3 = new Day3();
            String mergedString = "";
            for (int i = 0;i<3;i++){
                int counter = i +start;
                if (day3.isLetterOrDigit(list.get(counter)) == true){
                    String mergedStringTemp = "" + list.get(counter);
                    mergedString = mergedString + mergedStringTemp;
                }
                else break;
            }

            return Integer.parseInt(mergedString);
        }

        private int findIntergerSize(int interger){
            int size = String.valueOf(Math.abs(interger)).length();
            return size;
        }

        private int finalSearch(List<Character> list){
            Day3 day3 = new Day3();
            int multiplication=0;
            int maxLength = 4+3;
            for (int i = 0; i<list.size()-maxLength; i++){
                int currentLength =0;
                if (day3.findMul(list,i) == true) {
                    currentLength += i + 4;
                    if (day3.isLetterOrDigit(list.get(currentLength)) == true) {       // check if char after mul( ist integer
                        int multiplier1 = day3.findInterRow(list, currentLength);           // find first multiplier
                       // System.out.println(multiplier1);
                        int size1 = day3.findIntergerSize(multiplier1);       // find size of interger
                        currentLength += size1;
                        if (day3.find(',', list, currentLength) == true) {   //check if next char is ","
                            currentLength += 1;
                            int multiplier2 = day3.findInterRow(list, currentLength);
                            currentLength += day3.findIntergerSize(multiplier2);
                            if (day3.find(')', list, currentLength) == true) {
                                multiplication += multiplier1 * multiplier2;
                                System.out.println("("+ multiplier1+ "," + multiplier2 + ")");
                                //System.out.println(multiplier2);


                            }

                        }
                    }

                };

            }
            return multiplication;

        }

}






