import java.io.*;
import java.math.*;

class Investment implements Serializable {
    private double investAmount;
    private int numberOfYears;
    private double annualInterestRate;
    

    public Investment(double investAmount,int numberOfYears,double annualInterestRate ) {
        this.investAmount = investAmount;
        this.numberOfYears = numberOfYears;
        this.annualInterestRate = annualInterestRate;
    }

/*    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public double getInvestAmount() {
        return investAmount;
    }

    public void setinvestAmount(double investAmount) {
        this.investAmount = investAmount;
    }*/

    public double getFutureValue() {
        double monthlyInterestRate = annualInterestRate / 1200;
        double FutureValue = investAmount*(Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
        return FutureValue;
    }
}
