package Delay;

/**
 * Created by danielabel on 04.02.18.
 */
public class Delay {

    private static boolean enabled = true;

    public static void wait(int seconds) {
        try {
            if (enabled) Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
