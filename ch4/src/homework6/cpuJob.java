// Traae Bloxham
// Dr. Kerby
// Data Structures and Algorithms
// 4/9/20
package homework6;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;


public class cpuJob {

    // job class  no reason to put it in another file for this homework, yeah?
    public class Job implements Comparable<Job> {
        // instances variables
        private int timeNeeded;
        private int jobPriority;
        private int jobName;
        // Cionstructor
        public Job (int time, int priority, int name) {
            timeNeeded = time;
            jobPriority = priority;
            jobName = name;
        }
        // GET
        public int getTimeNeeded(){ return timeNeeded; }
        public int getJobPriority(){ return jobPriority; }
        public int getJobName(){ return jobName; }
        public void process() {timeNeeded--;}

        public int compareTo(Job j) {
            if (this.getJobPriority() < j.getJobPriority()) {return -1;}
            else if (this.getJobPriority() == j.getJobPriority()) {return 0;}
            else { return 1;}
        }

        public String toString() {return "Job: " + jobName + " Priority: " + jobPriority + " \n Time remaining: " + timeNeeded; }
    }
    // end job class

    // track and names the jobs created
    protected int jobNum = 1;

    // makes a new jb with random pirority and time needed
    public Job makeJob(){
        Random r = new Random();
        int priority = 1 +  r.nextInt(19);         // random 1-20
        int length = 1 +  r.nextInt(99);            // random 1-100
        Job newJob = new Job(length, priority, jobNum);
        jobNum++;
        return newJob;
    }

    public static void main(String[] args) {
        // make a instance of the class to use my function
        cpuJob c = new cpuJob();

        // The Queue of jobs  start with 10
        PriorityQueue<Job> jobsQ = new PriorityQueue<>();
        for (int i=0; i<10; i++){
            jobsQ.add(c.makeJob());
        }

        // current job and time
        Job current = null;
        int curTime = 1;
        int timePerJob = 100;
        System.out.println("Starting processes.");

        // process the jobs
        while (!jobsQ.isEmpty()) {
            if (current == null) { current = jobsQ.peek(); }            // if no current job, get one
            if (timePerJob%curTime == 0) { jobsQ.add(c.makeJob()); }    // every 100 times add a new job to the queue
            curTime++;                                                  // increment time
            current.process();                                          // countdown the jobs time needed
            System.out.println(current.toString());                     // print the job to show work;
            if (current.getTimeNeeded() <= 0) {
                jobsQ.poll();
                current = null;
            }                                                           // if the job is finished, end it.
        }
        // I could have reduced steps by having it switch jobs on the las one being zero, but I liked the
        // flavor of it finishing and than going to find a new one.
    }
}