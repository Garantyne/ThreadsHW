import java.util.ArrayList;
import java.util.Random;

public class Consumer extends Thread{
    private NumberList numberList;

    public Consumer(NumberList numberList){
        super("Consumer");
        this.numberList = numberList;
    }

    public void run(){
        while (true) {
            Random random = new Random();
            int listCount = numberList.getNumberCount();
            int count = random.nextInt(1,10);
            ArrayList<Integer> extract = new ArrayList<Integer>();
            if (listCount >= count) {
                extract = numberList.extractNumberList(count);
            }else{
                count = listCount;
                extract = numberList.extractNumberList(count);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
