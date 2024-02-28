package seminar5.homeWork;

public class WiseMan extends Thread {

    private final Fork  leftFork, rightFork;
    private final int numbOfSuccessfulMeals;
    private final Talker talker;
    private final String name;

    public WiseMan(Fork leftFork, Fork rightFork, int numbOfSuccessfulMeals, Talker talker, String name) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.numbOfSuccessfulMeals = numbOfSuccessfulMeals;
        this.talker = talker;
        this.name = name;
    }
    @Override
    public void run() {
        try {
            doIt();
        } catch (InterruptedException e){
            e.getStackTrace();
        }
    }

    private void doIt() throws InterruptedException {
        int successfulMeals = 0;
        boolean isInStateOfReflection = true;

        while (successfulMeals < numbOfSuccessfulMeals) {

            if (!isInStateOfReflection) {
                sleep(1000);
                isInStateOfReflection = true;
                //talker.talk(String.format("Мудрец %s говорит: Ура! Я поел!", this.name));
                System.out.println(String.format("Мудрец %s говорит: Ура! Я поел!", this.name));
                changeForkStatus(false);
                successfulMeals ++;
            } else {
                if (changeForkStatus(true)) {
                    //talker.talk(String.format("Мудрец %s говорит: Беру вилки \t%s \t и %s>", this.name, this.leftFork, this.rightFork));
                    System.out.println(String.format("Мудрец %s говорит: Беру вилки \t%s \t и %s>", this.name, this.leftFork, this.rightFork));
                    sleep(1000);
                    isInStateOfReflection = false;

                }
            }
        }
        //talker.talk(String.format("Мудрец %s говорит: Ну все! Я наелся! И, заодно, придмал как колдовать... давайте кого-нибудь испепелим!", this.name));
        System.out.println(String.format("Мудрец %s говорит: Ну все! Я наелся! И, заодно, придмал как колдовать... давайте кого-нибудь испепелим!", this.name));
        interrupt();
    }

    private synchronized boolean changeForkStatus(boolean pickUp) {

        if (pickUp) {
            if (leftFork.getUsed() || rightFork.getUsed()) return false;
            leftFork.setUsed();
            rightFork.setUsed();
        } else {
            leftFork.setUnused();
            rightFork.setUnused();
        }
        return true;
    }
}
