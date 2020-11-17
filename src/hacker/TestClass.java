package hacker;

import java.io.*;
import java.util.*;
class Booking{
    int start;
    int end;
}
public class TestClass {

    static int minParkingSpaces(int[][] parkingStartEndTimes) {
        Set<Booking> bookSet = new HashSet<>();
        int numberOfBookings = parkingStartEndTimes.length;
for(int[] arr : parkingStartEndTimes){
    Booking booking = new Booking();
    booking.start = arr[0];
  booking.end= arr[1];
   bookSet.add(booking);
}

return 0;
    }

    // DO NOT MODIFY ANYTHING BELOW THIS LINE!!

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        int[][] parkingStartEndTimeList = new int[n][2];
        String[] parkingStartEndTimes = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            String[] parkingStartEndTime = parkingStartEndTimes[i].split(",");
            for (int j = 0; j < parkingStartEndTime.length; j++) {
                parkingStartEndTimeList[i][j] = Integer.parseInt(parkingStartEndTime[j]);
            }
        }

        int out = minParkingSpaces(parkingStartEndTimeList);
        System.out.println(out);

        wr.close();
        br.close();
    }
}
