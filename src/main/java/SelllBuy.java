import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MyClass {
    Queue<Player> maxHeap= new PriorityQueue<>((a,b)-> a.score-b.score);
    public static void main(String [] args){

        addScore(1,10);
        addScore(2,10);
        List<Player> ans= getTop(1);


    }

    public void addScore(int id,int score){
        Player player= new Player(id,score);
        if(maxHeap.get(player)){
            Player  player1= maxHeap.contains(player)  ;
            player1.score +=score;
            return;
        }

        maxHeap.add(player);
    }

    public List<Player> getTop(int k){
        List<Player> ans= new ArrayList<>();
        while(maxHeap.size()>0 && k-->0){
            Player p= maxheap.poll();
            ans.add(p);
        }
        return ans;
    }
    public void reset(int id){
        Player p= maxHeap.find(new Player(id,0));
        p.score=0;
    }
    private class Player{
        public int id;
        public int score;
        public Player(int id ,int score){
            this.id=id;
            this.score=score;
        }
        public boolean equals(Player player){
            return player.id==this.id;
        }
    }
}
}
