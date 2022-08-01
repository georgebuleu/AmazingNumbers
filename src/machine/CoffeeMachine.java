package machine;

import java.util.Scanner;



public class CoffeeMachine {
    enum Action  {BUY, FILL, TAKE, REMAINING, EXIT}
    static final  int waterEspresso = 250, milkEspresso = 0 ,coffeeEspresso = 16, priceEspresso = 4;
    static final  int waterLatte = 350, milkLatte = 75, coffeeLatte = 20, priceLatte = 7;
    static final  int waterCappuccino = 200, milkCappuccino = 100, coffeeCappuccino = 12, priceCappuccino = 6;
    static Scanner scanner = new Scanner(System.in);
    static int availableWater = 400 , availableMilk = 540, availableCoffeeBeans = 120, availableRevenue =550, availableCups = 9;

            public static void buyAction () {
                System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu \n");
                String option = scanner.next();
                switch (option) {
                    case "1":
                        if (checkStock(waterEspresso, milkEspresso, coffeeEspresso)) {
                            availableWater -= waterEspresso;
                            availableCoffeeBeans -= coffeeEspresso;
                            availableCups--;
                            availableRevenue += priceEspresso;
                            break;
                        }
                        break;
                    case "2":
                        if (checkStock(waterLatte, milkLatte, coffeeLatte)) {
                            availableWater -= waterLatte;
                            availableMilk -= milkLatte;
                            availableCoffeeBeans -= coffeeLatte;
                            availableCups--;
                            availableRevenue += priceLatte;
                            break;
                        }
                        break;
                    case "3":
                        if (checkStock(waterCappuccino, milkCappuccino, coffeeCappuccino)) {
                            availableWater -= waterCappuccino;
                            availableCoffeeBeans -= coffeeCappuccino;
                            availableMilk -= milkCappuccino;
                            availableCups--;
                            availableRevenue += priceCappuccino;
                            break;
                        }
                        break;

                    case "back":
                        break;
                }
            }
            public static void fillAction () {
                System.out.print("Write how many ml of water you want to add:\n");
                int value = scanner.nextInt();
                availableWater += value;

                System.out.print("Write how many ml of milk you want to add:\n");
                value = scanner.nextInt();
                availableMilk += value;

                System.out.print("Write how many grams of coffee you want to add:\n");
                value = scanner.nextInt();
                availableCoffeeBeans += value;

                System.out.print("Write how many disposable cups you want to add:\n");
                value = scanner.nextInt();
                availableCups += value;
            }
            public static void takeAction () {
                System.out.println("I gave you $" + availableRevenue);
                availableRevenue = 0;
            }
            public static boolean checkStock ( int requiredWater, int requiredMilk, int requiredCoffeeBeans){
                if (requiredWater > availableWater) {
                    System.out.println("Sorry, not enough water!");
                    return false;
                } else if (requiredMilk > availableMilk) {
                    System.out.println("Sorry, not enough milk!");
                    return false;
                } else if (requiredCoffeeBeans > availableCoffeeBeans) {
                    System.out.println("Sorry, not enough coffee beans!");
                    return false;
                } else if (availableCups == 0) {
                    System.out.println("Sorry, not enough disposable cups!");
                    return false;
                }
                System.out.println("I have enough resources, making you a coffee!");
                return true;
            }
            public static void printStatus () {
                System.out.println("The coffee machine has: ");
                System.out.println(availableWater + " ml of water\n" + availableMilk + " ml of milk\n" + availableCoffeeBeans + " g of coffee beans\n");
                System.out.print(availableCups + " disposable cups\n" + "$" + availableRevenue + " of money\n\n");
            }
}
