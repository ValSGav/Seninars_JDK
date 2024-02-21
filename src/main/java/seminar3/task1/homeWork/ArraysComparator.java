package seminar3.task1.homeWork;

public class ArraysComparator {
    public <O, P> boolean compareArrays(O[] array1, P[] array2) {
        if (array1.getClass().getSimpleName() == array2.getClass().getSimpleName()
                && array1.length == array2.length) {

            for (int i = 0; i < array1.length; i++) {
                if (!array1[i].equals(array2[i]))
                    return false;
            }
            return true;
        } else {
            return false;
        }
    }
}
