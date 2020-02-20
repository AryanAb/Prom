import java.util.concurrent.TimeUnit;

public class Main {
    public static void main (String[] args) throws InterruptedException {
        Prom f = new Prom();
        play(f);
    }
    static void play (Prom f) throws InterruptedException {
        boolean inPlay = true;
        while (inPlay) {

            //updates and redraws panel
            if (f.getVisibility()) {
                f.redraw();
            } else {
                inPlay = false;
            }
        }
        TimeUnit.SECONDS.sleep(1);
        f.dispose();
    }

}
