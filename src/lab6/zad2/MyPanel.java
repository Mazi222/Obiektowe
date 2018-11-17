package lab6.zad2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

public class MyPanel extends JPanel implements ActionListener {

    final int WIDTH;
    final int HEIGHT;

    //private JTextField aChange, bChange, cChange, dChange;

    Polynomial polynomial;

    int from=-5;
    int to=5;
    int scale=5;

    private JTextField aChange= new JTextField(3);
    private JTextField bChange= new JTextField(3);
    private JTextField cChange= new JTextField(3);
    private JTextField dChange= new JTextField(3);
    private JTextField fromChange = new JTextField(Integer.toString(from),3);
    private JTextField toChange= new JTextField(Integer.toString(to),3);
    private JTextField scaleChange= new JTextField(Integer.toString(scale),3);

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
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);

        graphics.setColor(Color.BLACK);
        Graphics2D graphics2D=(Graphics2D)graphics;

        setTextFieldProperties();
        drawPolynomial(graphics2D);
        drawText(graphics);

    }

    private void drawPolynomial(Graphics2D graphics2D)
    {
        Line2D xAxis= new Line2D.Double(0,HEIGHT/2,WIDTH,HEIGHT/2);
        Line2D yAxis= new Line2D.Double(WIDTH/2,0,WIDTH/2,HEIGHT);
        graphics2D.draw(xAxis);
        graphics2D.draw(yAxis);

        int valueForX;
        int valueForLastX=calculatePolynomianValue(from);
        for(int x=from+1;x<=to;++x)
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

    private void setTextFieldProperties()
    {
        aChange.setBounds(60,50,50,20);
        bChange.setBounds(60,100,50,20);
        cChange.setBounds(60,150,50,20);
        dChange.setBounds(60,200,50,20);
        fromChange.setBounds(60,250,50,20);
        toChange.setBounds(60,300,50,20);
        scaleChange.setBounds(60,350,50,20);

        aChange.addActionListener(this);
        bChange.addActionListener(this);
        cChange.addActionListener(this);
        dChange.addActionListener(this);
        fromChange.addActionListener(this);
        toChange.addActionListener(this);
        scaleChange.addActionListener(this);

        add(aChange);
        add(bChange);
        add(cChange);
        add(dChange);
        add(fromChange);
        add(toChange);
        add(scaleChange);
    }

    private void drawText(Graphics graphics)
    {
        graphics.drawString("x", WIDTH - 10, HEIGHT / 2);
        graphics.drawString("y", WIDTH / 2 + 10, 10);
        graphics.drawString("A:", 10, 50);
        graphics.drawString("B:", 10, 100);
        graphics.drawString("C:", 10, 150);
        graphics.drawString("D:", 10,200);
        graphics.drawString("FROM:", 10,250);
        graphics.drawString("TO:", 10,300);
        graphics.drawString("SCALE:", 10,350);

    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        if(source==aChange)
        {
            polynomial.setA(Double.parseDouble(aChange.getText()));
        }
        else if(source==bChange)
        {
            polynomial.setB(Double.parseDouble(bChange.getText()));
        }
        else if(source==cChange)
        {
            polynomial.setC(Double.parseDouble(cChange.getText()));
        }
        else if(source==dChange)
        {
            polynomial.setD(Double.parseDouble(dChange.getText()));
        }
        else if(source==fromChange)
        {
            from=Integer.parseInt(fromChange.getText());
        }
        else if(source==toChange)
        {
            to=Integer.parseInt(toChange.getText());
        }
        else if(source==scaleChange)
        {
            scale=Integer.parseInt(scaleChange.getText());
        }
        repaint();
    }
}
