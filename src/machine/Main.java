package machine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean switchOff = false;

            Scanner scanner = new Scanner(System.in);

            while (!switchOff) {
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                String action = scanner.next();
                switch (action) {
                    case "buy":
                            CoffeeMachine.buyAction();
                        break;
                    case "fill":
                       CoffeeMachine.fillAction();
                        break;
                    case "take":
                        CoffeeMachine.takeAction();
                        break;
                    case "remaining":
                      CoffeeMachine.printStatus();
                        break;
                    case "exit":
                        switchOff = true;
                        break;
                    default:
                        System.out.println("Wrong input!");
                }
            }
        }

    }
