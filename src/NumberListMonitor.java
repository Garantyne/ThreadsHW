import java.util.ArrayList;

public class NumberListMonitor extends Thread{
    private NumberList numberList;

    public NumberListMonitor(NumberList numberList){
        super("NumberListMonitor");
        this.numberList = numberList;
    }

    public void run(){
        while(true) {
            if (numberList.getNumberCount() > 0) {
                ArrayList<Integer> nn = numberList.getNumberList();
                System.out.print("[Monitor]NumberList: ");
                for (int i : nn) {
                    System.out.print(i + " ");
                }
                System.out.println();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
