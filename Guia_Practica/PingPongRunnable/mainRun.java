public static void main(String  args[]) {
    PingPongRunnable t1 = new PingPong("PING", 33);
    PingPongRunnable t2 = new PingPong("PONG", 10);

    Thread t3 = new Thread(t1);
    Thread t4 = new Thread(t2);

    t1.start();
    t2.start();

}
