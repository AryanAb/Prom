public class Main {
    public static void main (String[] args) {
        Prom f = new Prom();
        play(f);
    }
    static void play (Prom f) {
        boolean inPlay = true;
        while (inPlay) {

            //Logic

            //updates and redraws panel
            if (f.getVisibility()) {
                f.redraw();
            } else {
                inPlay = false;
            }
        }
        f.dispose();
        System.out.println("The Window has been closed!!!!");
    }

}
