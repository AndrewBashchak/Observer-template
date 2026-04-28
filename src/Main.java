import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StockExchange stockExchange = new StockExchange();
        Scanner scanner = new Scanner(System.in);
        List<Observer> allObservers = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Add (Investor) | 2. Add (Broker) | 3. Change price | 4. Delete by name | 5. Exit");
            int action = scanner.nextInt();
            scanner.nextLine();

            if (action == 1 || action == 2) {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();

                Observer newPerson = (action == 1) ? new Investor(name) : new Broker(name);

                allObservers.add(newPerson);
                stockExchange.attach(newPerson);
                System.out.println("Done!");

            } else if (action == 3) {
                System.out.print("Stock name: ");
                String stock = scanner.nextLine();
                System.out.print("Price: ");
                double price = scanner.nextDouble();
                stockExchange.setStockPrice(stock, price);

            } else if (action == 4) {
                System.out.print("Who to delete? (enter name): ");
                String targetName = scanner.nextLine();

                Observer toRemove = null;
                for (Observer o : allObservers) {
                    if (o.toString().equals(targetName)) {
                        toRemove = o;
                        break;
                    }
                }

                if (toRemove != null) {
                    stockExchange.detach(toRemove);
                    allObservers.remove(toRemove);
                    System.out.println("User " + targetName + " unsubscribed");
                } else {
                    System.out.println("Not found");
                }

            } else if (action == 5) {
                break;
            }
        }
    }
}