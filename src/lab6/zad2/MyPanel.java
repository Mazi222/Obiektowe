package lab6.zad2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

public class MyPanel extends JPanel implements ActionListener {

    final int WIDTH;
    final int HEIGHT;

    private JTextField aChange, bChange, cChange, dChange;

    Polynomial polynomial;

    MyPanel(final int WIDTH, final int HEIGHT, Polynomial polynomial)
    {
        super();
        setLayout(null);
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.polynomial = polynomial;

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setVisible(true);


    }

    @Override
    protected void paintComponent(Graphics graphics)
    {
        aChange= new JTextField(Double.toString(polynomial.getA()));
        bChange= new JTextField(Double.toString(polynomial.getB()));
        cChange= new JTextField(Double.toString(polynomial.getC()));
        dChange= new JTextField(Double.toString(polynomial.getD()));

        aChange.setLocation(50,50);
        bChange.setLocation(50,100);
        cChange.setLocation(50,150);
        dChange.setLocation(50,200);

        aChange.addActionListener(this);
        bChange.addActionListener(this);
        cChange.addActionListener(this);
        dChange.addActionListener(this);

        aChange.setBounds(50,50,50,20);
        bChange.setBounds(50,100,50,20);
        cChange.setBounds(50,150,50,20);
        dChange.setBounds(50,200,50,20);

        add(aChange);
        add(bChange);
        add(cChange);
        add(dChange);

        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);

        graphics.setColor(Color.BLACK);
        Graphics2D graphics2D=(Graphics2D)graphics;

        drawPolynomial(graphics2D);
        drawText(graphics);

    }

    private void drawPolynomial(Graphics2D graphics2D)
    {
        Line2D xAxis= new Line2D.Double(0,HEIGHT/2,WIDTH,HEIGHT/2);
        Line2D yAxis= new Line2D.Double(WIDTH/2,0,WIDTH/2,HEIGHT);
        graphics2D.draw(xAxis);
        graphics2D.draw(yAxis);

        int from=-5;
        int to=5;
        int scale=5;
        int valueForX;
        int valueForLastX=calculatePolynomianValue(from);
        for(int x=from+1;x<to;++x)
        {
            valueForX=calculatePolynomianValue(x);
            Line2D line2D = new Line2D.Double(x*scale-scale+WIDTH/2,-valueForLastX+HEIGHT/2,x*scale+WIDTH/2,-valueForX+HEIGHT/2);
            valueForLastX=valueForX;
            graphics2D.draw(line2D);
        }
    }
    private int calculatePolynomianValue(int x)
    {
        return (int)(polynomial.getA()*(x*x*x)+polynomial.getB()*(x*x)+polynomial.getC()*(x)+polynomial.getD());
    }

    private void drawText(Graphics graphics)
    {
        graphics.drawString("x", WIDTH - 10, HEIGHT / 2);
        graphics.drawString("y", WIDTH / 2 + 10, 10);
        graphics.drawString("A:", 10, 50);
        graphics.drawString("B:", 10, 100);
        graphics.drawString("C:", 10, 150);
        graphics.drawString("D:", 10,200);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        if(source==aChange)
        {
            String newAValue=aChange.getText();
            polynomial.setA(Double.parseDouble(newAValue));
        }
        else if(source==bChange)
        {
            String newBValue=bChange.getText();
            polynomial.setB(Double.parseDouble(newBValue));
        }
        else if(source==cChange)
        {
            String newCValue=cChange.getText();
            polynomial.setC(Double.parseDouble(newCValue));
        }
        else if(source==dChange)
        {
            String newDValue=dChange.getText();
            polynomial.setD(Double.parseDouble(newDValue));
        }
        repaint();
    }
}
