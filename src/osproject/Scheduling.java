/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package osproject;

/**
 *
 * @author alzeghaibi.
 */
public class Scheduling {

    private ArrayList<Process> processes;
    private ArrayList<Process> q1;
    private ArrayList<Process> q2;

    private int nextID = 0;
    private String chart;

    public Scheduling(ArrayList<Process> q1, ArrayList<Process> q2) {
        nextID = 0;
        processes = new ArrayList<Process>();

        for (int i = 0; i < q1.size(); i++) {
            processes.add(q1.get(i));
        }

        for (int i = 0; i < q2.size(); i++) {
            processes.add(q2.get(i));
        }

        sortByArrivalTime(processes);
    }

    private Process getNextProcess() {
        if (this.nextID == processes.size()) {
            return null;
        } else {
            return processes.get(nextID++);
        }
    }

    public ArrayList<Process> getProcesses() {
        return processes;
    }

    public String getChart() {
        return chart + " | ";
    }

    public void run() {
        q1 = new ArrayList<Process>();
        q2 = new ArrayList<Process>();
        chart = "";

        Process nextProcess = getNextProcess();

        int cpuClock = 0;
        Process cpuProcess = null;

        int quantum = 3;
        int counter = 0;

        while (nextProcess != null || q1.size() != 0 || q2.size() != 0 || cpuProcess != null) {

            if (nextProcess != null) {
                while (nextProcess.arrivalTime <= cpuClock) {
                    if (nextProcess.priority == 1) {
                        q1.add(nextProcess);
                    } else {
                        q2.add(nextProcess);
                    }

                    nextProcess = getNextProcess();
                    if (nextProcess == null) {
                        break;
                    }
                }
                sortByBurstTime(q2);
            }

            if (cpuProcess == null) {
                if (q1.size() != 0) {
                    cpuProcess = q1.removeFirst();
                } else if (q2.size() != 0) {
                    cpuProcess = q2.removeFirst();
                }
                excute(cpuProcess, cpuClock);
                counter = 0;
            }

            if (cpuProcess != null && cpuProcess.priority == 1) {
                if (counter == quantum && q1.size() != 0) {
                    q1.addLast(cpuProcess);
                    cpuProcess = q1.removeFirst();
                    excute(cpuProcess, cpuClock);
                    counter = 0;
                }

            } else if (cpuProcess != null && cpuProcess.priority == 2) {
                if (q1.size() != 0) {
                    q2.addLast(cpuProcess);
                    sortByBurstTime(q2);

                    cpuProcess = q1.removeFirst();
                    excute(cpuProcess, cpuClock);
                    counter = 0;
                }
            }

            cpuClock++;

            if (cpuProcess != null) {
                cpuProcess.timeInCPU++;
                counter++;
                if (cpuProcess.timeInCPU >= cpuProcess.burstTime) {
                    terminate(cpuProcess, cpuClock);
                    cpuProcess = null;
                    counter = 0;
                }
            }

        }
    }

    private Process excute(Process p, int clock) {
        if (p.timeInCPU == 0) {
            p.startTime = clock;
        }

        chart += " | P" + p.id;
        return p;
    }

    private void terminate(Process p, int clock) {
        p.terminateTime = clock;
        p.waitingTime = clock - p.arrivalTime - p.burstTime;
        p.responseTime = p.startTime - p.arrivalTime;
        p.turnAroundTime = p.burstTime + p.waitingTime;
    }

    private void sortByBurstTime(ArrayList<Process> q) {
        for (int i = 1; i < q.size(); i++) {
            for (int j = 0; j < (q.size() - i); j++) {
                if (q.get(j).burstTime > q.get(j + 1).burstTime) {
                    Process temp = q.get(j);
                    q.set(j, q.get(j + 1));
                    q.set((j + 1), temp);
                }
            }
        }
    }

    private void sortByArrivalTime(ArrayList<Process> q) {
        for (int i = 1; i < q.size(); i++) {
            for (int j = 0; j < (q.size() - i); j++) {
                if (q.get(j).arrivalTime > q.get(j + 1).arrivalTime) {
                    Process temp = q.get(j);
                    q.set(j, q.get(j + 1));
                    q.set((j + 1), temp);
                }
            }
        }
    }

}
