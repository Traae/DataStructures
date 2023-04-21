package Ch2;

public class Test {
    public static void main(String[] args) {
        Progression prog = new Progression(0) ;
        prog.printProgression(10);

        ArithmaticProg ap = new ArithmaticProg(10, 100);
        ap.printProgression(10);

        GeometricProg gp = new GeometricProg(30, 4);
        gp.printProgression(10);

        FibbyProgression fp = new FibbyProgression();
        fp.printProgression(10);
    }
}
