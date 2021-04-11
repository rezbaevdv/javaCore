package lesson1.homework01;

public class Robot implements CanRun, CanJump {

    int jumpHeight;
    int runLength;
    String name;

    public Robot (int jumpHeight, int runLength, String name) {
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
