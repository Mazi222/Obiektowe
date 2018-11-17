package lab6.zad2;

import java.awt.*;


public class PolynomialTest {
    public static void main(String[] argv) {

        final int WIDTH = 1024;
        final int HEIGHT = 768;
        Polynomial polynomial = new Polynomial(0,0,0,4);

        EventQueue.invokeLater(new Runnable() {
        @Override
        public void run () {
            new MyFrame(WIDTH, HEIGHT, polynomial);
        }
    });
}
}
