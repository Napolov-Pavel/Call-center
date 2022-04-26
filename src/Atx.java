import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Atx {
    private static final int OPERATOR = 8;
    private static final int PART1 = 8;
    private static final int PART2 = 643;
    private static final int PART3 = 8999;
    private static final int HUNDRED = 100;
    private static final int THOUSAND = 1000;
    private static final int NEW_CALLS = 35;
    private static final int TIME_BETWEEN_NEW_CALLS = 20000;
    private static final int TIME_PROCESSING_CALL = 2000;
    private static final int CAPACITY_CALL_QUEUE = 1000;
    private static final Random generator = new Random();
    private static final Queue<String> callQueue = new ArrayBlockingQueue<>(CAPACITY_CALL_QUEUE, true);

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
        int numberOperator = generator.nextInt(OPERATOR);
        int numberPart1 = generator.nextInt(PART1);
        int numberPart2 = generator.nextInt(PART2) + HUNDRED;
        int numberPart3 = generator.nextInt(PART3) + THOUSAND;
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
