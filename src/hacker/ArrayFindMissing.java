package hacker;

import java.util.Arrays;

public class ArrayFindMissing {
    public  static void findMissing(int[] arr, int n){
        Arrays.sort((arr));
int j = 0;
        for(int i=1; i<=n;i++){
            if(arr[j] != i  && j< arr.length){
                System.out.println("Missing number: "+ i);

            } else {
                j++;
            }
        }
    }

    public static void main(String[] args){

        int[] arr = {4,6,8,5};
        findMissing(arr,8);
    }
}
