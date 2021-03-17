
package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {

    private static final Logger logger = LogManager.getLogger(Calculator.class);
    public Calculator() {
    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double num, num1, num2;
        do {
            System.out.println("Calculator-DevOps, Choose to perform operation");
            System.out.print("Press 1 to find factorial\nPress 2 to find Square root\nPress 3 to find power\nPress 4 to find natural logarithm\n" +
                    "Press 5 to exit\nEnter your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException error) {
                return;
            }

            switch (choice) {
                case 1:
                    // factorial
                    System.out.print("Enter a number : ");
                    num = scanner.nextDouble();
                    System.out.println("Factorial of "+num+" is : " + calculator.findFactorial(num));
                    System.out.println("\n");

                    break;
                case 2:
                    // find square root
                    System.out.print("Enter a number : ");
                    num  = scanner.nextDouble();
                    System.out.println("Square root of "+num+" is : " + calculator.findSquareRoot(num));
                    System.out.println("\n");


                    break;
                case 3:
                    // power
                    System.out.print("Enter the first number : ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter the second number : ");
                    num2 = scanner.nextDouble();
                    System.out.println(num1+ " raised to power "+num2+" is : " + calculator.findPower(num1, num2));
                    System.out.println("\n");
                    break;
                case 4:
                    // find natural log
                    System.out.print("Enter a number : ");
                    num1 = scanner.nextDouble();
                    System.out.println("Natural log of "+num1+" is : " + calculator.findNaturalLog(num1));
                    System.out.println("\n");

                    break;
                default:
                    System.out.println("Exiting....");
                    System.out.println("\n");
                    return;
            }
        } while (true);
    }


    public double findFactorial(double num) {
        logger.info("[FACTORIAL of] - " + num);
        double result = fact(num);
        logger.info("[RESULT : FACTORIAL] - " + result);
        return result;
    }



    public double findSquareRoot(double num) {
        logger.info("[SQUARE ROOT] - " + num);
        double result = Math.sqrt(num);
        logger.info("[RESULT - SQUARE ROOT] - " + result);
        return result;
    }


    public double findPower(double num1, double num2) {
        logger.info("[POWER - " + num1 + " RAISED TO] " + num2);
        double result = Math.pow(num1,num2);
        logger.info("[RESULT - POWER] - " + result);
        return result;
    }

    public double findNaturalLog(double num) {
        logger.info("[NATURAL LOG] - " + num);
        double result = 0;
        try {

            if (num <0 ) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN 0.0/0.0");
            }
             else {
                result = Math.log(num);
            }
        } catch (ArithmeticException error) {
            System.out.println("[EXCEPTION - LOG] - Cannot find log of negative numbers " + error.getLocalizedMessage());
        }
        logger.info("[RESULT - NATURAL LOG] - " + result);
        return result;
    }
    public double fact(double num) {
        double facto = 1;
        for(int i = 1; i <= num; ++i)
        { facto *= i;   }
        return  facto;
    }
}