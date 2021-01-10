package testClasses;

public class Client {
    /**
     * 程序入口
     *
     * @param args
     */
    public static void main(String[] args) {
        Pet d = new Dog();
        Pet r = new Rabbit();
        Master master = new Master();
        master.feed(d);
        Object obj = new Object();
        master.feed(r);
    }


}
