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
 
    public static Scheduling schedular;
  
    
    

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
            scr.nextLine();

            System.out.print("\t\tCPU burst: ");
            int burstTime = scr.nextInt();
            scr.nextLine();

            System.out.print("\t\tPriority: ");
            int priority = scr.nextInt();
            scr.nextLine();

            Process process = new Process(i, arrivalTime, burstTime, priority);

            if (priority == 1) {
                q1.add(process);
            } else {
                q2.add(process);
            }
        }
         schedular = new Scheduling(q1, q2);
         schedular.run();
    }
  
    
 private static void Report() {
    try (PrintWriter writer = new PrintWriter("Report.txt")) {
        System.out.println("Multilevel Queue Scheduling Report");
        writer.println("Multilevel Queue Scheduling Report");
        System.out.println("----------------------------------");
        writer.println("----------------------------------");
        
        System.out.println("Scheduling Order: " + schedular.getChart());
        writer.println("Scheduling Order: " + schedular.getChart());

        double totalTurnAroundTime = 0;
        double totalWaitingTime = 0;
        double totalResponseTime = 0;
        ArrayList<Process> allProcesses = schedular.getProcesses();

        for (int i = 0; i < allProcesses.size(); i++) {
            Process p = allProcesses.get(i);
            
            System.out.println(p.toString());
            writer.println(p.toString());
            System.out.println();

            totalTurnAroundTime += p.getTurnAroundTime();
            totalWaitingTime += p.getWaitingTime();
            totalResponseTime += p.getResponseTime();
        }

        int totalProcesses = allProcesses.size();
        System.out.println("Average Turnaround Time: " + (totalTurnAroundTime / totalProcesses));
        writer.println("Average Turnaround Time: " + (totalTurnAroundTime / totalProcesses));
        System.out.println("Average Waiting Time: " + (totalWaitingTime / totalProcesses));
        writer.println("Average Waiting Time: " + (totalWaitingTime / totalProcesses));
        System.out.println("Average Response Time: " + (totalResponseTime / totalProcesses));
        writer.println("Average Response Time: " + (totalResponseTime / totalProcesses));
    } catch (FileNotFoundException e) {
        System.out.println("Error writing to the file: " + e.getMessage());
    }
}



    

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        

        char ch = '0';
        while (ch != '3') {
            System.out.println("Multilevel Queue Scheduling:");
            System.out.println("----------------------------");
            System.out.println("1) Process information.");
            System.out.println("2) Report.");
            System.out.println("3) Exit.");
            System.out.println("---------");
            System.out.print("Choice: ");

            ch = input.next().charAt(0);
            if (ch == '1') {
                getProcessInformation(input);
              
                   
                
                
            } else if (ch == '2') {
                Report();
       
                    break;

          
            } else if (ch == '3') {
                break;
            }

            System.out.println();
        }
        input.close();
    }
}
