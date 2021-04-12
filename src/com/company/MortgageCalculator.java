package com.company;

import java.text.NumberFormat;

public class MortgageCalculator {
    private final static byte PARCENTAGE = 100;
    private final static byte TOTAL_MONTH = 12;

    private int principal;
    private  float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double remainingBalance(short numberOfPaymentsMade) {
        float monthlyInterest = getMonthlyInterest();
        short period = (short) getPeriod();

        float a = (float) Math.pow((1 + monthlyInterest), period);
        float b = (float) Math.pow((1 + monthlyInterest), numberOfPaymentsMade);

        double balance = (principal * (a - b)) / (a - 1);
        return balance;
    }

    public double mortgageCal() {
        float monthlyInterest = getMonthlyInterest();
        short period = (short) (years * TOTAL_MONTH);
        float n = (float) Math.pow((1 + monthlyInterest), period);

        double mortgage = (principal * (monthlyInterest * n)) / (n - 1);
        return mortgage;
    }

    public double[] getRemainingBalance(){
        var balances = new double[getPeriod()];
        for (short month = 1; month <= balances.length; month++)
            balances[month - 1] = remainingBalance(month);
        return balances;
    }

    private float getMonthlyInterest() {
        return annualInterest / PARCENTAGE / TOTAL_MONTH;
    }

    private int getPeriod() {
        return years * TOTAL_MONTH;
    }
}
