package main;

/**
 * Created by Artur on 28.04.2015.
 */
public class Model {

    private double oper1 = 0;
    private char operation;

    public double action(String oper1, char operation, boolean first){
        if(first){
            this.oper1 = Double.parseDouble(oper1);
        }
        else{
            this.oper1 = calculate(oper1);
        }
        this.operation = operation;
        return this.oper1;
    }

    public double calculate(String oper2){
        double op2 = Double.parseDouble(oper2);
        switch (operation) {
            case '+':return this.oper1 = this.oper1 + op2;
            case '-': return this.oper1 = this.oper1 - op2;
            case '*': return this.oper1 = this.oper1 * op2;
            case '/': if(op2 != 0) return this.oper1 = this.oper1 / op2;
                      else return 0;
            default: return 0;
            }
    }

    public void clear(){
        this.oper1 = 0;
        this.operation = ' ';
    }

}
