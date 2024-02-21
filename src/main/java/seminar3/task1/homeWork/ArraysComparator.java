package seminar3.task1.homeWork;

public class ArraysComparator {
    public <O, P> boolean compareArrays(O[] array1, P[] array2) {
        if (array1.length == array2.length) {

            // я случайно подсмотрел начало следующего семинара
            // тоже не понял, что достаточно проверить на совпадение типов
            for (int i = 0; i < array1.length; i++) {
                if (!array1[i].getClass().getName().equals(array2[i].getClass().getName()))
                    return false;
            }
            return true;
        } else {
            return false;
        }
    }
}
