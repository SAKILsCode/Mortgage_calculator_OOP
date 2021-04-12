package com.company;

public class Main {

    public static void main(String[] args) {
        int principal = (int)Input.getInput("Principal (1K - 1M): ", 1000, 1000000);
        float annualInterest = (float)Input.getInput("Annual Interest Rate: ", 1, 30);
        byte years = (byte)Input.getInput("Period (Years): ", 1, 30);

        var calculator = new MortgageCalculator(principal, annualInterest, years);
        var report = new MortgageReport(calculator);

        report.printMortgage();
        report.printPaymentSchedule();
    }

}