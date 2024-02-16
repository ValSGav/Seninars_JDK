/*
Создать обобщенный класс с тремя параметрами (T, V, K).
Класс содержит три переменные типа (T, V, K),
конструктор, принимающий на вход параметры типа (T, V, K),
методы возвращающие значения трех переменных.

Создать метод, выводящий на консоль имена классов для трех переменных класса.
Наложить ограничения на параметры типа:
T должен реализовать интерфейс Comparable,
V должен реализовать интерфейс DataInput и расширять класс InputStream,
K должен расширять класс Number.
 */

package seminar3.task1;

import java.io.DataInput;
import java.io.InputStream;

public class TestGenericClass<T extends Comparable, V extends InputStream & DataInput, K extends Number> {
    T var1;
    V var2;
    K var3;

    public TestGenericClass(T var1, V var2, K var3) {
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
    }

    public T getVar1() {
        return var1;
    }

    public V getVar2() {
        return var2;
    }

    public K getVar3() {
        return var3;
    }

    public String getClassName() {
        StringBuilder sb = new StringBuilder();
        sb.append(var1.getClass().getSimpleName()).append("\n");
        sb.append(var2.getClass().getSimpleName()).append("\n");
        sb.append(var3.getClass().getSimpleName());
        return  sb.toString();
    };
}
