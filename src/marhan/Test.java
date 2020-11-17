package marhan;

import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        Integer[] arr = {5,7,3,4,6,2,-3};

       // System.out.println(sumPair(arr,9));
        System.out.println(diffPair(arr,6));

Runnable noargs= ()->System.out.println("");
    }


    public static void m1(int a, int b)

    {

    }

    public static String sumPair(Integer[] arr, int k){
        HashMap<Integer,Integer> pairs = new HashMap<>();
        for(int a : arr){
            if(pairs.containsKey(a)){
                return "Pair found "+a +" ,"+ pairs.get(a);
            }
            if(k>a){
                pairs.put(k-a,a);
            }
        }

        return "Pair not found";
    }
    public static String diffPair(Integer[] arr, int k){
        HashMap<Integer,Integer> pairs = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        for(int a : arr){
            if(pairs.containsKey(a)){
                builder.append( "Pair found ("+a +" ,"+ pairs.get(a) + ")\n");
            }
            pairs.put(a-k,a);
            pairs.put(a+k,a);
        }
        if(!builder.toString().isEmpty()){
            return builder.toString();
        }

        return "Pair not found";
    }
}
interface fInt{
    default int m1(int a, int b){
        return(a+b);
    }
}


