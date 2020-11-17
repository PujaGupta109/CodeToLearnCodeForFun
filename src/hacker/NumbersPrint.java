package hacker;

import java.util.stream.IntStream;

public class NumbersPrint {
    public static void printNumbers(int n){
        if(n<2){
        //    System.out.print("");
        }
        for(int i= 1; i<=n;i++){
            System.out.print(i + " ");
        }



        for(int i = n-1; i>=2;i--){
            System.out.println();
            for(int j= 1; j<=i;j++){
                if(j == i){
                    System.out.print(i+ " ");

                }else{
                    System.out.print("  ");
                }


            }


        }
        System.out.println();

        for(int i= 1; i<=n;i++){
            System.out.print(  i + " ");
        }
    }

    public static void main(String[] args){
        printnumbers2(9);
    }

    public static void printnumbers2(int n){
        StringBuilder builder = new StringBuilder();
        for(int row=n;row>0;row--){
            for(int col = 1; col<=n;col++){
                if(row==n || row==1 || row ==col)
                    builder.append(col).append(" ");
                else
                    builder.append("  ");
            }
            builder.append(System.lineSeparator());
        }
        System.out.println(builder.toString());
    }

    public static void printnumbers3(int n){
        StringBuilder builder = new StringBuilder();
        IntStream.iterate(n, i-> i-1).limit(n).forEach(row -> {
            IntStream.iterate(1, i-> i+1).limit(n).forEach(col -> {
                if(row==n || row==1 || row==col)
                    builder.append(col).append(" ");
                else
                    builder.append("  ");
            });
            builder.append(System.lineSeparator());
        });
        System.out.println(builder.toString());
    }

}
