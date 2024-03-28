import java.util.ArrayList;
import java.util.Random;

public class Producer extends Thread {
    private NumberList numberList = new NumberList();

    public Producer(NumberList numberList){
        super("Producer");
        this.numberList = numberList;
    }
    public void run(){
        while(true) {

            int listCount = numberList.getNumberCount();
            if(listCount < 10){
                ArrayList<Integer> addable = new ArrayList<>();
                for(int i = 0; i < 10; i++){
                    addable.add(new Random().nextInt(1,10));
                }
                numberList.addNumbers(addable);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private ArrayList<Integer> genRandom(){
        Random random = new Random();
        ArrayList<Integer> arrRandom = new ArrayList<>();
        for(int i = 0; i < random.nextInt(1, 10); i++) {
            arrRandom.add(random.nextInt(1,10));
        }
        return arrRandom;
    }
}
