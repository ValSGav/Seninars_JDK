/*
Описать собственную коллекцию – список на основе массива.
Коллекция должна иметь возможность хранить любые типы данных, иметь методы добавления и удаления элементов.
* */
package seminar3.task1;

import java.util.ArrayList;

public class TestGenericClassCollection <T>{
    private Object[] someCollection;
    private int size;

    public TestGenericClassCollection() {
        someCollection = new Object[10];
    }

    public void add(T item){

        if(size>= someCollection.length){
            Object[] someCollectionNew = new Object[someCollection.length + 10];
            System.arraycopy(someCollectionNew, 0, someCollectionNew, 0, size);
            someCollection = someCollectionNew;
        }
        someCollection[size++] = item;
    }

    public void remove(int index){
        if (index < 0 || index >= size){
            return;
        }
        System.arraycopy(someCollection, index+1, someCollection, index, size-index);
        someCollection[size-1] = 0;
        size--;
    }
}
