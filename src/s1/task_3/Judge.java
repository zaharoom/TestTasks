package s1.task_3;

import java.util.*;

/**
 * Class manages Cockroach threads and counts results of run
 */
public class Judge implements OnFinishListener {

    private int cockroachCounter = 0;
    //results of the lap
    private List<CockroachResult> cockroachResults = new ArrayList<>();
    //total results are stored by cockroach name (it mus be unique)
    private Map<String, CockroachResult> totalCockroachResults = new HashMap<>();
    //total list Cockroaches in the run
    private List<Cockroach> cockroaches = new ArrayList<>();
    private int runsCount;


    @Override
    public void onFinish(String name, int speed) {
        System.out.print(cockroachCounter + " ");
        cockroachResults.add(new CockroachResult(name, speed));
        if (cockroachCounter > 1) {
            cockroachCounter--;
        } else  {
            countResults();
        }
    }

    // "wipe" for next run
    private void wipeData() {
        cockroachCounter = cockroaches.size();
        cockroachResults.clear();
    }

    /**
     * Method gives results before each lap and adds there to total results array
     * If run was last - it outputs results
     */
    private void countResults() {
        if (runsCount > 1) {
            for (CockroachResult c : cockroachResults) {
                totalCockroachResults.put(c.getName(), sumResults(c, totalCockroachResults.get(c.getName())));
            }
            wipeData();
            startRun(--runsCount);
        } else {
            showResults();
        }
    }

    /**
     * Sum results of last lap of run and last written in array result.
     * Actually in this method only time parameter summed up
     *
     * @param lapResult last run result
     * @param totalResult result given from the Map with the same key like int "lapResult"
     * @return instance of CockroachResult with summed up parameters
     */
    private CockroachResult sumResults (CockroachResult lapResult, CockroachResult totalResult) {
        if (totalResult != null) {
            return new CockroachResult(lapResult.getName(), totalResult.time + lapResult.time);
        } else {
            return new CockroachResult(lapResult.getName(), lapResult.time);
        }
    }

    /**
     *
     */
    private void showResults() {
        System.out.println("\nshow total results:");
        TreeSet<CockroachResult> finalResult = new TreeSet<>();
        finalResult.addAll(totalCockroachResults.values());//fast way to sort with comparator
        int position = 1;
        for (CockroachResult cr : finalResult) {
            System.out.println(position + " is finished " + cr.getName() + " with speed " + cr.getSpeed() + " cm/s " + cr.getTime() + " seconds");
            position++;
        }
    }


    /**
     * Method to add Cockroach to run.
     * To proper work of total results counter you need to use unique name of Cockroach
     *
     * @param name new unique name of Cockroach
     */
    public void addCockroachToRun(String name) {
        Cockroach cockroach = new Cockroach(name);
        cockroach.setOnFinishListener(this);
        cockroaches.add(cockroach);
        cockroachCounter++;
    }

    /**
     * Method is invoking every time when the program needs to start one lap run
     * parameter "runsCount" assigns to the local variable
     *
     * @param runsCount number of laps in the run
     */
    public void startRun(int runsCount) {
        this.runsCount = runsCount;
        for (Cockroach c : cockroaches) {
            new Thread(c).start();
        }
        System.out.println("\nRun is started! Laps to run: " + runsCount);
    }
}
