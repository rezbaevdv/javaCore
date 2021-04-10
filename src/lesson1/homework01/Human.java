package lesson1.homework01;

public class Human implements CanRun, CanJump{

    int jumpHeight;
    int runLength;
    String name;

    public Human (int jumpHeight, int runLength, String name) {
        this.jumpHeight = jumpHeight;
        this.runLength = runLength;
        this.name = name;
    }

    @Override
    public void jump(int height) {

    }

    @Override
    public void run(int length) {

    }
}