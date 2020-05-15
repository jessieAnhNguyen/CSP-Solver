import Solutions.*;

import java.util.Scanner;

public class Main {
    /**
     * Main class: run this file to run the whole program
     * @param args
     */
    public static void main(String[] args) {
        boolean play = true;
        while(play) {
            System.out.println("Constraint Satisfaction Problems by Anh Nguyen and Phuong Vu");
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter 1, 2 or 3 to see problem formulation and solution to each of the following problems: ");
            System.out.println("1. The Australian Map Coloring problem");
            System.out.println("2. The Job Shop Scheduling problem");
            System.out.println("3. The n-Queens problem");
            System.out.println("4. The Y = X^2 problem");
            System.out.println("5. The inconsistent problem");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    new AusMapColorSolution();
                    break;
                case 2:
                    new JobShopSchedulingSolution();
                    break;
                case 3:
                    System.out.print("How many queens do you wish to place on a board so that they are not attacking each other? : ");
                    int numOfQueens = scanner.nextInt();
                    new nQueenSolution(numOfQueens);
                    break;

                case 4:
                    System.out.print("How much do you want the range to be (example: 10, 100, 200): ");
                    int numRange = scanner.nextInt();
                    new Problem4Solution(numRange);
                    break;
                case 5:
                    new MackworthSolution();
                    break;
                default:
                    continue;
            }

            System.out.println();
            System.out.print("Do you want to see more constraint satisfaction problems? (y/n): ");
            String loop = scanner.next();
            if(loop.equals("y")) {
                play = true;
            } else {
                play = false;
            }
            System.out.println();
        }
    }
}
