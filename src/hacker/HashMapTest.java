package hacker;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args){
        HashMap<String,String> countryCaps = new HashMap<>();
        countryCaps.put("India","New Delhi");
        countryCaps.put("China", "Bejeing");
        countryCaps.put("Brazil","Brasilia");
        countryCaps.put("Japan","Tokyo");
        countryCaps.put("Turkey", "Ankara");

        for(String s: countryCaps.values()){
            System.out.println(s);
        }

}

    }