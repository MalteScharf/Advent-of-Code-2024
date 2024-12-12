package Day2;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Day2Dampened extends Day2 {

    public ArrayList<Integer> removeOneBadLevelIncreasing(ArrayList<Integer> list){
        for (int i = 0; i< list.size()-2;i++){
            int difference = list.get(i + 1) - list.get(i);
            int differencePlusOne = list.get(i + 2) - list.get(i);
            System.out.println(list);
            System.out.println(i);
            System.out.println(difference);
            System.out.println(differencePlusOne);

            //if (1 > difference && difference > 3){
            if (1 <= differencePlusOne && differencePlusOne <= 3){
                    list.remove(i+1);
                    System.out.println(difference +"removed");
                    break;
            //}

            }

        }

        return list;
    }
    @Override
    public boolean checkIncreasing(ArrayList<Integer> list) {
        this.removeOneBadLevelIncreasing(list);
        boolean safe = false;

        int size = list.size() - 1;
        for (int i = 0; i < size; i++) {
            int difference = list.get(i + 1) - list.get(i);
            if (1 <= difference && difference <= 3) safe = true;
            else {
                safe = false;
                break;
            }
        }
        return safe;
    }


  //  @Override
  /*  public boolean checkDecreasing(ArrayList<Integer> list) {
        boolean safe = false;
        int margin = 0;
        int size = list.size()-1;
        for (int i = 0; i < size; i++) {
            int difference = list.get(i + 1) -list.get(i);
            if (-1 >= difference && difference >= -3) safe = true;
            else {
                margin++;
            }
            if (margin>1) {
                safe = false;
                break;
            }
        }
        return safe;
    } */


}
