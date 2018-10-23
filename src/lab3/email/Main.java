package lab3.email;

import javax.mail.MessagingException;

public class Main {
    public static void main(String [] argv)
    {
        String from="raf@vp.pl";
        String to="raf@vp.pl";
        String host="smtp.poczta.onet.pl";
        int port=465;

        try{
            EmailMessage test= EmailMessage.builder().addfrom(from).addto(to).addsubject("test").addcontent("testowo").build();
            test.sendemail(host,port);
        }
        catch(MessagingException e){
            e.printStackTrace();
        }
        catch(NotEmail a){                                          //podany ciag nie jest mailem
            System.out.println("Tu powina być obsługa wyjątku");
        }
        catch(NotEnoughArguments a) {                               //nie podano odbiorcy i/lub nadawcy
            System.out.println("Tu powina być obsługa wyjątku");
        }
    }

}
//a