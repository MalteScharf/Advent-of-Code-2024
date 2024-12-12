package Day2;

import java.io.IOException;
import java.util.ArrayList;

public class Day2Main {
    public static void main(String[] args) throws IOException {
        Day2 day2 = new Day2();
        Day2Dampened day2Dampened = new Day2Dampened();

        ArrayList<ArrayList<Integer>> list = day2.loadFile();
        int numberOfSafeReports = day2.countSafeReports(list);
        int numberOfSafeReportsDampened = day2Dampened.countSafeReports(list);

        System.out.println("SafeReports: " + numberOfSafeReports);
        System.out.println("SafeReports Dampened: " + numberOfSafeReportsDampened);


    }

}
