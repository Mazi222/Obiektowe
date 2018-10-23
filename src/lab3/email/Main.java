package lab3.email;

import javax.mail.MessagingException;

public class Main {
    public static void main(String [] argv)
    {
        String to="raf@vp.pl";
        String from="raf@vp.pl";
        try{
            EmailMessage test= EmailMessage.builder().addfrom("raf@vp.pl").addsubject("Test").addto("raf@vp.pl").addcontent("dsdsds").build();
            test.sendemail();
        }
        catch(MessagingException e){
            e.printStackTrace();
        } catch (com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException e) {
            e.printStackTrace();
        }
    }

}
