import java.util.ArrayList;

public class NumberList {
    private ArrayList<Integer> numberList = new ArrayList<Integer>();
    private final int SIZE_OF_LIST = 10;

    public NumberList(){};

    public int getNumberCount(){
        synchronized (this) {
            return numberList.size();
        }
    }

    public void addNumbers(ArrayList<Integer> numbers){
        synchronized (this) {
            if (numberList.size() < SIZE_OF_LIST) {
                this.numberList.addAll(numbers);
            }
        }
    }

    public ArrayList<Integer> extractNumberList(int n){
        synchronized (this) {
            ArrayList<Integer> removed = new ArrayList<Integer>();
            if (n <= numberList.size()) {
                for (int i = numberList.size() - 1; i > n; i--) {
                    removed.add(numberList.remove(i));
                }
            }
            return removed;
        }
    }

    public ArrayList<Integer> getNumberList(){
        synchronized (this) {
            return new ArrayList<Integer>(numberList);
        }
    }
}
