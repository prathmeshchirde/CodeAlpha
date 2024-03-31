package CodeAlpha_Task;
import java.util.Scanner;
public class Travel_Itinerary_Planner {
	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Welcome to the Travel Itinerary Planner!");

	        System.out.print("Enter number of destinations: ");
	        int numDestinations = scanner.nextInt();

	        String[] destinations = new String[numDestinations];
	        String[] dates = new String[numDestinations];

	        for (int i = 0; i < numDestinations; i++) {
	            System.out.print("Enter destination " + (i + 1) + ": ");
	            destinations[i] = scanner.next();
	            System.out.print("Enter date for destination " + (i + 1) + " (MM/DD/YYYY): ");
	            dates[i] = scanner.next();
	        }

	        System.out.println("\nYour Travel Plan:");
	        for (int i = 0; i < numDestinations; i++) {
	            System.out.println("Destination: " + destinations[i] + ", Date: " + dates[i]);
	        }
	    }
}
