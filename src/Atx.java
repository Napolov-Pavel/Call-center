import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Atx {
    private final int NEW_CALLS = 35;
    private final int TIME_BETWEEN_NEW_CALLS = 20000;
    private final int TIME_PROCESSING_CALL = 2000;
    private final int CAPACITY_CALL_QUEUE = 1000;
    private final Random generator = new Random();
    private final Queue<String> callQueue = new ArrayBlockingQueue<>(CAPACITY_CALL_QUEUE, true);

    public void addCalls() {
        while (true) {
            for (int i = 0; i < NEW_CALLS; i++) {
                callQueue.offer(createNumberPhone());
            }
            System.out.println("Поступило " + NEW_CALLS + " новых звонков");
            try {
                Thread.sleep(TIME_BETWEEN_NEW_CALLS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String createNumberPhone() {
        int numberOperator;
        int numberPart1;
        int numberPart2;
        int numberPart3;
        numberOperator = generator.nextInt(8);
        numberPart1 = generator.nextInt(8);
        numberPart2 = generator.nextInt(643) + 100;
        numberPart3 = generator.nextInt(8999) + 1000;
        return "8(9" + numberOperator + "" + numberPart1 + ") " + numberPart2 + "-" + numberPart3;
    }
    public void deletedCall() {
        while (true) {
            System.out.println("Оператор " + Thread.currentThread().getName() + " обработал звонок " + callQueue.poll());
            try {
                Thread.sleep(TIME_PROCESSING_CALL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
