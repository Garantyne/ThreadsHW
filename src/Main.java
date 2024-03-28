public class Main {
    public static void main(String[] args) throws Exception {
        NumberList numberList = new NumberList();
        Producer producer = new Producer(numberList);
        Consumer consumer = new Consumer(numberList);
        NumberListMonitor numberListMonitor = new NumberListMonitor(numberList);

        Thread[] threads = new Thread[3];
        threads[0] = consumer;
        threads[1] = producer;
        threads[2] = numberListMonitor;

        for(var v : threads){
            v.start();
        }
        for(var v : threads){
            v.join();
        }
    }
}