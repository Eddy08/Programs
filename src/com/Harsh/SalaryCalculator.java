package com.Harsh;

//import java.util.Arrays;
import java.util.Scanner;

public class SalaryCalculator {
    public static long totalSalary(long[] slabs, long[] tax, long rebate, long employeesTax[]) {
        long salary[] = new long[employeesTax.length];
        long taxPercentage[] = new long[tax.length - 1];
        long taxAmount = 0;
        for (int i = 0; i < tax.length - 1; i++) {
            if (i != 0) {
                taxPercentage[i] = ((slabs[i] - slabs[i - 1]) * tax[i]) / 100;
            } else {
                taxPercentage[i] = (slabs[i] * tax[i]) / 100;
            }
            taxAmount += taxPercentage[i];
        }

        reverse(taxPercentage, taxPercentage.length);
        reverse(tax, tax.length);
        /*
         * long taxPercentageNew[] = new long[tax.length]; taxPercentageNew =
         * taxPercentage; taxPercentageNew[tax.length - 1] = 0;
         */
        for (int i = 0; i < employeesTax.length; i++) {
            salary[i] = calcSalary(slabs, rebate, employeesTax, taxPercentage, tax, taxAmount, i);

        }
        long totalSum = 0;
        for (int i = 0; i < salary.length; i++) {
            totalSum += salary[i] + rebate;
            // System.out.println(salary[i] + rebate);
        }
        return totalSum;
        //System.out.println(totalSum);

    }

    private static long calcSalary(long[] slabs, long rebate, long[] employeesTax, long[] taxPercentage, long[] tax,
                                   long amount, int index) {
        long salary = 0;
        long tempTax = employeesTax[index];
        int i = 0;
        int y = 0;
        while (tempTax != 0) {
            if (tempTax == amount) {
                salary += (taxPercentage[y]) * 100 / (tax[y + 1]);
                tempTax = tempTax - taxPercentage[y];
                y++;
                amount = tempTax;
            } else {
                salary += (tempTax - amount) * 100 / (tax[i]);
                tempTax = tempTax - ((tempTax - amount) *100 / (tax[i])* tax[i] / 100);
                if (i < taxPercentage.length && tempTax > amount) {
                    amount = amount - taxPercentage[i];
                }
            }
            i++;
        }
        salary += slabs[0];
        return salary;
    }

    static void reverse(long a[], int n) {
        int i, k;
        long t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }

    }

    public static void main(String[] args) {
// My Code
        Scanner sc = new Scanner(System.in);
        String firstLine = sc.nextLine();
// sc.nextLine();
        String secondLine = sc.nextLine();
// sc.nextLine ();
        String thirdLine = sc.nextLine();
// sc.nextLine();
        String fourthLine = sc.nextLine();

        String slabs[] = firstLine.split(" ");

        long slabs1[] = new long[slabs.length];
        for (int i = 0; i < slabs.length; i++) {
            slabs1[i] = Long.parseLong(slabs[i]);
        }

        String tax[] = secondLine.split(" ");
        long tax1[] = new long[tax.length];
        for (int i = 0; i < tax.length; i++) {
            tax1[i] = Long.parseLong(tax[i]);
        }
        long rebate = Long.parseLong(thirdLine);
        String employees[] = fourthLine.split(" ");
        long employees1[] = new long[employees.length];
        for (int i = 0; i < employees.length; i++) {
            employees1[i] = Long.parseLong(employees[i]);
        }
        System.out.println(totalSalary(slabs1, tax1, rebate, employees1));

    }
}