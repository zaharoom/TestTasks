package s1.task_3;

/**
 * Stores result of the finished Cockroach
 */
public class CockroachResult implements Comparable {
    private String name;
    public int time;

    public CockroachResult(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return String.format("%.3f", (float) time / 1000);
    }

    public String getSpeed() {
        return String.format("%.2f", 150f / (time / 1000));
    }

    @Override
    public int compareTo(Object o) {
        CockroachResult cockroachResult = (CockroachResult) o;

        return Integer.compare(time, cockroachResult.time);
    }
}
