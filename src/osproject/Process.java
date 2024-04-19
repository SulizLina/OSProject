
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
    //

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getTerminateTime() {
        return terminateTime;
    }

    public void setTerminateTime(int terminateTime) {
        this.terminateTime = terminateTime;
    }

    public int getTurnAroundTime() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(int turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(int responseTime) {
        this.responseTime = responseTime;
    }

    public int getTimeInCPU() {
        return timeInCPU;
    }

    public void setTimeInCPU(int timeInCPU) {
        this.timeInCPU = timeInCPU;
    }
    
    
    
}
