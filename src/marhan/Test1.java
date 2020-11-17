package marhan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test1 {

    public static void main(String[] args){

        Integer[] arr = {3,1,2,4,5,7,8,9,0,6};
        List<Integer> integers = Arrays.asList(arr);
        List output = integers.stream().filter(a-> a%2==0).sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        }).collect(Collectors.toList());



        System.out.println(output);
        output = integers.stream().sorted((o1,o2)->o2-o1).collect(Collectors.toList());




    }
}
