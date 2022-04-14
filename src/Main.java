public class Main {
    private static final int TIME_BETWEEN_THREAD = 500;
    public static void main(String[] args) throws InterruptedException {
        Atx atx = new Atx();
        Thread calls = new Thread(null, atx::addCalls, "ATX");
        Thread maria = new Thread(null, atx::deletedCall, "Maria");
        Thread tom = new Thread(null, atx::deletedCall, "Tom");
        Thread lion = new Thread(null, atx::deletedCall, "Lion");
        calls.start();
        Thread.sleep(TIME_BETWEEN_THREAD);
        maria.start();
        Thread.sleep(TIME_BETWEEN_THREAD);
        tom.start();
        Thread.sleep(TIME_BETWEEN_THREAD);
        lion.start();
    }
}
