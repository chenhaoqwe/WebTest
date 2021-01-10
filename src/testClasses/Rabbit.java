package testClasses;

public class Rabbit extends Pet {
    @Override
    public void eat() {
        System.out.println("rabbit eat");
    }

    @Override
    public void shout() {
        System.out.println("rabbit shout");
    }
}
