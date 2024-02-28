package seminar5.homeWork;

public class Main {
    public static void main(String[] args) {

        Talker talker = new Talker();

        Fork fork1 = new Fork();
        Fork fork2 = new Fork();
        Fork fork3 = new Fork();
        Fork fork4 = new Fork();
        Fork fork5 = new Fork();

        WiseMan wiseMan1 = new WiseMan(fork5, fork1, 3, talker, "Wise-man one");
        WiseMan wiseMan2 = new WiseMan(fork1, fork2, 3, talker, "Wise-man two");
        WiseMan wiseMan3 = new WiseMan(fork2, fork3, 3, talker, "Wise-man three");
        WiseMan wiseMan4 = new WiseMan(fork3, fork4, 3, talker, "Wise-man four");
        WiseMan wiseMan5 = new WiseMan(fork4, fork5, 3, talker, "Wise-man five");

        talker.start();
        wiseMan1.start();
        wiseMan2.start();
        wiseMan3.start();
        wiseMan4.start();
        wiseMan5.start();


    }
}
