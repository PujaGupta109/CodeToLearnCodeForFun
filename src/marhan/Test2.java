package marhan;

import java.util.concurrent.*;

public class Test2 {
     public static void main(String[] args) throws ExecutionException, InterruptedException {
         String[] arr = {"I am from Harman",  "I am also from Harman","I am from JP Morgan"};
         int result = 0;
         ExecutorService executorService = Executors.newFixedThreadPool(3);
for(String s : arr) {




    Future<Integer> future = executorService.submit(new Worker("Harman",s));
    result = result+ future.get();

}

System.out.println(result);
         executorService.shutdown();


    }



}

class Worker implements Callable<Integer>{
    private String searchString;
    private String sentence;
    Worker(String searchString, String sentence){
        this.searchString =searchString;
        this.sentence = sentence;
    }

    @Override
    public Integer call() throws Exception {
        int count =0;
        String[] arr = sentence.split(" ");
for(String s : arr){
    if(s.equals(searchString)){
        count++;
    }
}
        return count;
    }
}
