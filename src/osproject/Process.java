
package osproject;

/**
 *
 * @author alzeghaibi.
 */
public class Process {

    public int id;
    public int priority;
    public int arrivalTime;
    public int burstTime;
    public int startTime;
    public int terminateTime;
    public int turnAroundTime;
    public int waitingTime;
    public int responseTime;
    public int timeInCPU;

    public Process(int id, int arrivalTime, int burstTime, int priority) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.priority = priority;
        this.burstTime = burstTime;
        this.startTime = 0;
        this.terminateTime = 0;
        this.turnAroundTime = 0;
        this.waitingTime = 0;
        this.responseTime = 0;
        this.timeInCPU = 0;
    }

    public String toString() {
        return "  ID: P" + id
                + "\n  Priority: " + priority
                + "\n  CPU burst: " + burstTime
                + "\n  Arrival Time: " + arrivalTime
                + "\n  Start Time: " + startTime
                + "\n  Termination Time: " + terminateTime
                + "\n  Turn around Time: " + turnAroundTime
                + "\n  Waiting Time: " + waitingTime
                + "\n  Response Time: " + responseTime;
    }
}
