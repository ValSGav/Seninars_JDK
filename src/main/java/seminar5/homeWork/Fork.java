package seminar5.homeWork;

public class Fork {
    protected boolean isUsed;
    protected int number;

    public Fork() {
        isUsed = false;
        number = count + 1;
        count ++;
    }

    protected static int count = 0;

    public void setUsed() {
        isUsed = true;
    }

    public void setUnused() {
        isUsed = false;
    }

    public boolean getUsed(){
        return isUsed;
    }

    @Override
    public String toString() {
        return String.format("Вилка номер %d", number);
    }
}
