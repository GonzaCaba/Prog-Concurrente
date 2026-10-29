public static void main(String  args[]) {
    PingPongThread t1 = new PingPongThread("PING", 33);
    PingPongThread t2 = new PingPongThread("PONG", 10);

    t1.start();
    t2.start();

    try{
        Thread.sleep(5000);
    } catch(InterruptedException e){

    };
}
