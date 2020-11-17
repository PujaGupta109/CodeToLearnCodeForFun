package hacker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MergeSort {
    public static List<Integer> mergeSort(List<Integer> l1, List<Integer> l2){
        int finalSize = l1.size()+l2.size();
        List<Integer> finalList = new ArrayList(finalSize);
        int i1=0;
        int i2=0;
        int i0 =0;

        while(i0<finalSize){
            int first = (i1<l1.size()?l1.get(i1):Integer.MAX_VALUE);
            int second = (i2<l2.size()?l2.get(i2):Integer.MAX_VALUE);
            if(first<second) {
                finalList.add(i0, first);
                i1++;
            }
                else if(first==second){
                finalList.add(i0, first);
                i1++;
                i0++;
                finalList.add(i0, second);
                     i2++;
                }
            else{
                finalList.add(i0,second);
                i2++;
            }
            i0++;
        }


        return finalList;
    }

    public static void main(String[] args){
        List l1 = new ArrayList(3);
        l1.add(0,1);
        l1.add(1,3);
        l1.add(2,5);
        List l2 = new ArrayList(4);
        l2.add(0,2);
        l2.add(1,4);
        l2.add(2,5);
        l2.add(3,6);
        List mergedList = mergeSort(l1,l2);
        System.out.println(mergedList);

    }
}
