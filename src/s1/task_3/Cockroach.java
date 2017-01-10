package s1.task_3;

/**
 * Class describes classical Cockroach-runner.
 * Typically each of them has a name
 */
public class Cockroach implements Runnable {

    private OnFinishListener onFinishListener;
    private String name;
    private int speed;

    public Cockroach(String name) {
        this.name = name;
        speed = getRunTime();
    }

    /**
     * This method simulates the run of Cockroach
     */
    @Override
    public void run() {
        try {
            Thread.sleep(speed);
            Thread.currentThread().interrupt();
            onFinishListener.onFinish(name, speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setOnFinishListener(OnFinishListener l) {
        this.onFinishListener = l;
    }

    /**
     * Calculating time which needs the Cockroach to fight the distance
     * Average distance in Cockroach run is 1.5 meters
     *
     * @return value in range from 1000 to 5000 inclusive
     */
    private int getRunTime() {
        return (int) ((Math.random() * 10 + 3) * 1000);
    }

}
