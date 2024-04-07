package osproject;

/**
 *
 * @author alzeghaibi.
 */
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainClass {

    public static ArrayList<Process> q1 = new ArrayList<Process>();
    public static ArrayList<Process> q2 = new ArrayList<Process>();

    private static void getProcessInformation(Scanner scr) {
        System.out.print("Enter the number of processes: ");
        int num = scr.nextInt();

        q1 = new ArrayList<Process>();
        q2 = new ArrayList<Process>();

        System.out.println("Enter process information:");
        for (int i = 1; i <= num; i++) {
            System.out.println("\tP" + i + ": ");

            System.out.print("\t\tArrival time: ");
            int arrivalTime = scr.nextInt();

            System.out.print("\t\tCPU burst: ");
            int burstTime = scr.nextInt();

            System.out.print("\t\tPriority: ");
            int priority = scr.nextInt();

            Process process = new Process(i, arrivalTime, burstTime, priority);

            if (priority == 1) {
                q1.add(process);
            } else {
                q2.add(process);
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char ch = '0';
    }
}
