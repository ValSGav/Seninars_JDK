package seminar3.task1.homeWork;

public class Calculator {
    public  <I, E> double sum (E operandOne, I operandTwo) throws NumberFormatException{
        double res  = Double.parseDouble(operandOne.toString()) + Double.parseDouble(operandTwo.toString());
        return res;
    }

    public  <I, E> double multiply (E operandOne, I operandTwo) throws NumberFormatException{
        double res  = Double.parseDouble(operandOne.toString()) * Double.parseDouble(operandTwo.toString());
        return res;
    }

    @Override
    public String toString() {
        return "i am Calculator!";
    }

    public  <I, E> double divide (E operandOne, I operandTwo) throws NumberFormatException, ArithmeticException{
        double res  = Double.parseDouble(operandOne.toString()) / Double.parseDouble(operandTwo.toString());
        return res;
    }

    public  <I, E> double substract (E operandOne, I operandTwo) throws NumberFormatException{
        double res  = Double.parseDouble(operandOne.toString()) - Double.parseDouble(operandTwo.toString());
        return res;
    }
}
