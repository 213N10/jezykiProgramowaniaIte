package zadanie2;

public class LeafThread extends Thread{
    private int time;
    LeafThread (int time){
        super();
        this.time=time;
    }
    @Override
    public void run(){
        try {
            while(true){
                sleep(this.time);
                iterate();
                System.out.println("check");

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    };
    private void iterate(){
        for (Leaf[] el:Map.mapa) {
            for (Leaf leaf: el){
                /*if (leaf.has_worm==false)*/ leaf.consume(-1);
            }
        }
        Map.map_refresh();
    }

}
