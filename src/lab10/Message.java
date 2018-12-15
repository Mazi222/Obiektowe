package lab10;

public class Message {

    private String textMessage;
    private Shape shape;

    Message(String textMessage, Shape shape)
    {
        this.textMessage=textMessage;
        this.shape=shape;
    }
    public String getTextMessage() {
        return textMessage;
    }

    public Shape getShape() {
        return shape;
    }
}
