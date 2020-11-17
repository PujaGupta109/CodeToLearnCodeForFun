package hacker;

import java.util.*;

class Checker implements Comparator<Player>{
    public int compare(Player p1, Player p2){

        if(p1.score == p2.score){
          return  p1.name.compareTo(p2.name);
                    }else return p1.score-p2.score;
    }
}

class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class CheckerTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player,((o1,o2)->
                (  o2.score-o1.score)!=0?o2.score-o1.score:o1.name.compareTo(o2.name)
        ) );
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
