import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);
        boolean run = true;
        int point;
        int numWins = 0;
        int numLosses = 0;
        String response = "";
        System.out.println("Welcome to Craps!");
        while (run) {
            System.out.println("Rolling the dice...");
            int die1 = rnd.nextInt(6) +1;
            int die2 = rnd.nextInt(6) +1;
            int sum = die1 + die2;
            int incorrectInput = 0;
            System.out.println("Die 1: " + die1);
            System.out.println("Die 2: " + die2);
            System.out.println("Sum " + sum);
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Crapped out!");
                numLosses += 1;
                incorrectInput = 0;
                do{
                    if (incorrectInput > 0){
                        System.out.print("Invalid input.");
                    }
                    System.out.print("Would you like to play again? (y/n)");
                    incorrectInput += 1;
                    response = in.nextLine();
                }while (!response.equals("n") && !response.equals("y"));
            } else if (sum == 7 || sum == 11) {
                System.out.println("You win! Congratulations!");
                numWins += 1;
                incorrectInput = 0;
                do{
                    if (incorrectInput > 0) {
                        System.out.print("Invalid input.");
                    }
                    System.out.print("Would you like to play again? (y/n)");
                    incorrectInput += 1;
                    response = in.nextLine();
                }while (!response.equals("n") && !response.equals("y"));
            } else {
                point = sum;
                System.out.println("Point is now" + point);
                do{
                    die1 = rnd.nextInt(6) +1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;
                    System.out.println("Roll: " + sum);
                    if (sum == 7) {
                        System.out.println("Crapped out!");
                        numLosses += 1;
                        incorrectInput = 0;
                        do{
                            if (incorrectInput > 0) {
                                System.out.print("Invalid input.");
                            }
                            System.out.print("Would you like to play again? (y/n)");
                            incorrectInput += 1;
                            response = in.nextLine();
                        } while (!response.equals("n") && !response.equals("y"));
                    } else if (sum == point) {
                        System.out.println("You win! Congratulations!");
                        numWins += 1;
                        incorrectInput = 0;
                        do{
                            if (incorrectInput > 0) {
                                System.out.print("Invalid input.");
                            }
                            System.out.print("Would you like to play again? (y/n)");
                            incorrectInput += 1;
                            response = in.nextLine();
                        } while (!response.equals("n") && !response.equals("y"));
                    } else{
                        System.out.println("Trying for point. Rolling again...");
                        die1 = rnd.nextInt(6) + 1;
                        die2 = rnd.nextInt(6) + 1;
                        sum = die1 + die2;
                    }
                } while (sum != 7 && sum != point);
            }
            if (response.equals("n")){
                System.out.println(String.format("Thank you for playing! You played %d games: %dW & %dL", numWins + numLosses, numWins, numLosses));
                System.exit(0);
            }
        }





    }
}