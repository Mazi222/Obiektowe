package lab6.zad1;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

public class MousePanel implements MouseListener, MouseMotionListener {

    private int xAxisVal,yAxisVal;
    private MyPanel panel;
    private Shape shapeToMove;

    public MousePanel(MyPanel panel)
    {
        this.panel = panel;
        shapeToMove = null;
        panel.addMouseListener(this);
        panel.addMouseMotionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent)
    {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent)
    {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent)
    {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent)
    {
        shapeToMove = null;
        xAxisVal = mouseEvent.getX();
        yAxisVal = mouseEvent.getY();
        LinkedList<Shape> shapeList = panel.getShapeList();
        for(Shape checkedShape : shapeList)
        {
            if(checkedShape.mouseIn(xAxisVal, yAxisVal))
            {
                shapeToMove = checkedShape;
                break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent)
    {
        shapeToMove=null;
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        if(shapeToMove != null)
        {
            shapeToMove.setNewAxisValues(mouseEvent.getX()-xAxisVal,mouseEvent.getY()-yAxisVal);
            xAxisVal=mouseEvent.getX();
            yAxisVal=mouseEvent.getY();
            panel.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
