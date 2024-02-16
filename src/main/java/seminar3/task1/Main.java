package seminar3.task1;

import java.io.DataInputStream;

public class Main {
    public static void main(String[] args) {

        TestGenericClass testClass = new TestGenericClass("asdf", new DataInputStream(System.in), 2);
        System.out.println(testClass.getClassName());
    }

}
