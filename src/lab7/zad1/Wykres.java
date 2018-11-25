package lab7.zad1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.LinkedList;

public class Wykres extends Application{

    private final static int WIDTH=800;
    private final static int HEIGHT=600;

    private Polynomial polynomial = new Polynomial(0,0,0,0);

    private double from=-100;       //wartość x od której idziemy do "to" a nie liczba pikseli
    private double to=100;
    private double scaleX=1;
    private double scaleY=1;

    private TextField aChange= new TextField("0");
    private TextField bChange= new TextField("0");
    private TextField cChange= new TextField("0");
    private TextField dChange= new TextField("0");
    private TextField fromChange = new TextField(Double.toString(from));
    private TextField toChange= new TextField(Double.toString(to));
    private TextField scaleXChange= new TextField(Double.toString(scaleX));
    private TextField scaleYChange= new TextField(Double.toString(scaleY));


    private Button button1;
    private Button button2;

    @Override
    public void start(Stage primaryStage)
    {
        Group group = new Group();
        Scene scene1 = new Scene(group,WIDTH,HEIGHT);

        Group textFieldGroup = new Group();
        Scene scene2 = new Scene(textFieldGroup,400,HEIGHT);

        button1 = new Button("Go to settings");
        button1.setLayoutX(10);
        button1.setLayoutY(10);
        button1.setOnAction(e->primaryStage.setScene(scene2));
        group.getChildren().add(button1);

        button2 = new Button("Go to polynomian");
        button2.setLayoutX(10);
        button2.setLayoutY(10);
        button2.setOnAction(e->primaryStage.setScene(scene1));
        textFieldGroup.getChildren().add(button2);

        scene1.setFill(Color.WHEAT);
        scene2.setFill(Color.WHEAT);

        drawPolynomial(group);
        setTextFieldProperties(group,textFieldGroup);
        drawText(group, textFieldGroup);

        primaryStage.setTitle("Wykres");
        primaryStage.setScene(scene1);
        primaryStage.show();

    }

    private void drawPolynomial(Group group)
    {
        Line xAxis= new Line(0,HEIGHT/2,WIDTH,HEIGHT/2);
        Line yAxis= new Line(WIDTH/2,0,WIDTH/2,HEIGHT);

        group.getChildren().addAll(xAxis,yAxis);

        int valueForX;
        int valueForLastX=calculatePolynomianValue((int)from);

        for (int x = (int) from + 1; x <= to; ++x)
        {
            valueForX = calculatePolynomianValue(x);
            Line line = new Line(x * scaleX - scaleX + WIDTH / 2, -valueForLastX * scaleY + HEIGHT / 2, x * scaleX + WIDTH / 2, -valueForX * scaleY + HEIGHT / 2);
            valueForLastX = valueForX;
            group.getChildren().add(line);
        }
    }

    private void updatePolynomian(Group group, Group textFieldGroup)
    {
        group.getChildren().clear();
        group.getChildren().add(button1);
        drawPolynomial(group);
        drawText(group, textFieldGroup);
    }

    private int calculatePolynomianValue(int x)
    {
        return (int)(polynomial.getA()*(x*x*x)+polynomial.getB()*(x*x)+polynomial.getC()*(x)+polynomial.getD());
    }

    private void setTextFieldProperties(Group group, Group textFieldGroup)
    {
        textFieldGroup.getChildren().addAll(aChange,bChange,cChange,dChange,fromChange,toChange,scaleXChange,scaleYChange);

        aChange.setLayoutX(60);
        aChange.setLayoutY(50);

        bChange.setLayoutX(60);
        bChange.setLayoutY(100);

        cChange.setLayoutX(60);
        cChange.setLayoutY(150);

        dChange.setLayoutX(60);
        dChange.setLayoutY(200);

        fromChange.setLayoutX(60);
        fromChange.setLayoutY(250);

        toChange.setLayoutX(60);
        toChange.setLayoutY(300);

        scaleXChange.setLayoutX(60);
        scaleXChange.setLayoutY(350);

        scaleYChange.setLayoutX(60);
        scaleYChange.setLayoutY(400);

        aChange.setOnAction(e->{
            polynomial.setA(Double.parseDouble(aChange.getText()));
            updatePolynomian(group, textFieldGroup);
        });
        bChange.setOnAction(e->{
            polynomial.setB(Double.parseDouble(bChange.getText()));
            updatePolynomian(group, textFieldGroup);
        });
        cChange.setOnAction(e->{
            polynomial.setC(Double.parseDouble(cChange.getText()));
            updatePolynomian(group, textFieldGroup);
        });
        dChange.setOnAction(e->{
            polynomial.setD(Double.parseDouble(dChange.getText()));
            updatePolynomian(group, textFieldGroup);
        });
        fromChange.setOnAction(e->{
            from=Double.parseDouble(fromChange.getText());
            updatePolynomian(group, textFieldGroup);
        });
        toChange.setOnAction(e->{
            to=Double.parseDouble(toChange.getText());
            updatePolynomian(group, textFieldGroup);
        });
        scaleXChange.setOnAction(e->{
            scaleX=Double.parseDouble(scaleXChange.getText());
            updatePolynomian(group, textFieldGroup);
        });
        scaleYChange.setOnAction(e->{
            scaleY=Double.parseDouble(scaleYChange.getText());
            updatePolynomian(group, textFieldGroup);
        });
    }

    private void drawText(Group group, Group textFieldGroup)
    {
        Text text1 = new Text( WIDTH - 10, HEIGHT / 2 + 10,"x");
        Text text2 = new Text(WIDTH / 2 + 10, 10, "y");
        Text text3 = new Text(10, 65, "A:");
        Text text4 = new Text(10, 115, "B:");
        Text text5 = new Text(10, 165, "C:");
        Text text6 = new Text(10,215, "D:");
        Text text7 = new Text(10,265, "FROM:");
        Text text8 = new Text(10,315, "TO:");
        Text text9 = new Text(10,365, "SCALE:");
        Text text10 = new Text(20,HEIGHT-20, "W(x)=Ax^3+Bx^2+Cx+D");
        Text text11 = new Text(20,HEIGHT-20, "W(x)=Ax^3+Bx^2+Cx+D");
        Text text12 = new Text(WIDTH/2 +10,HEIGHT/2 + 20, "0");
        textFieldGroup.getChildren().addAll(text3, text4, text5, text6, text7, text8, text9, text10);
        group.getChildren().addAll(text1, text2, text11, text12);
    }

    public static void main(String[] argv)
    {
      launch();
    }


}
