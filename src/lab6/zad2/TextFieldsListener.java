package lab6.zad2;
/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldsListener extends JPanel implements ActionListener {

    private JTextField aChange, bChange, cChange, dChange, eChange;
    private JLabel aLabel, bLabel, cLabel, dLabel, eLabel;
    private MyPanel panel;
    private Polynomial polynomial;

    public TextFieldsListener(final int WIDTH, MyPanel panel)
    {
        this.panel=panel;
        polynomial=panel.getPolynomial();
        panel.setLayout(null);

        addTextFields();
        setPreferredSize(new Dimension(WIDTH, 50));
    }


    @Override
    public void paint(Graphics graphics)
    {

    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        if(source==aChange)
        {
            String newAValue=aChange.getText();
            polynomial.setA(Integer.parseInt(newAValue));
        }
        else if(source==bChange)
        {
            String newBValue=bChange.getText();
            polynomial.setB(Integer.parseInt(newBValue));
        }
        else if(source==cChange)
        {
            String newCValue=cChange.getText();
            polynomial.setC(Integer.parseInt(newCValue));
        }
        else if(source==dChange)
        {
            String newDValue=dChange.getText();
            polynomial.setD(Integer.parseInt(newDValue));
        }
        else if(source==eChange)
        {
            String newEValue=eChange.getText();
            polynomial.setE(Integer.parseInt(newEValue));
        }
        panel.repaint();
    }
}
*/