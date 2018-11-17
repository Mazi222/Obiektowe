package lab6.zad1;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    public MyPanel(int xAxisSize, int yAxisSize)
    {
        setPreferredSize(new Dimension(xAxisSize,yAxisSize));
    }
}
