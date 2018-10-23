package lab3.email;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

import java.util.LinkedList;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class EmailMessage {
    private String from;
    private LinkedList<String> to;
    private String subject;
    private String content;
    private String mimeType;
    private LinkedList<String> cc;
    private LinkedList<String> bcc;

    private EmailMessage(String _from, LinkedList<String> _to, String _subject, String _content,
                         String _mimeType, LinkedList<String> _cc, LinkedList<String> _bcc){
        from=_from;
        to=_to;
        subject=_subject;
        content=_content;
        mimeType=_mimeType;
        cc=_cc;
        bcc=_bcc;
    }

    public void sendemail() throws MessagingException, javax.mail.MessagingException {
        String host="smtp.poczta.onet.pl";
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.poczta.onet.pl");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session mailSession = Session.getDefaultInstance(props, new javax.mail.Authenticator()
                {
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        return new PasswordAuthentication(from,"sagem4");
                    }
                }
                );
        mailSession.setDebug(true);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress(from));
        for (int i = 0; i < to.size(); i++)
        {
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to.get(i)));
        }
        message.setSubject(subject);
        message.setContent(content, "text/plain; charset=ISO-8859-2");
        Transport.send(message);
        System.out.println("KONIEC");
    }

    public static Builder builder(){
        return new EmailMessage.Builder();
    }

    public static class Builder{

        private String from;
        private LinkedList<String> to=new LinkedList();;
        private String subject;
        private String content;
        private String mimeType;
        private LinkedList<String> cc=new LinkedList();;
        private LinkedList<String> bcc=new LinkedList();;

        Builder(){
        }
        public Builder addfrom(String _from)
        {
           // if(isEmail(_from)==false)
                //rzucaj wyjatek TODO
            from=_from;
            return this;
        }
        public Builder addto(String _to)
        {
           // if(isEmail(_to)==false)
                //rzuca wyjatek
            to.add(_to);
            //TODO
            return this;
        }
        public Builder addsubject(String _subject)
        {
            subject=_subject;
            return this;
        }
        public Builder addcontent(String _content)
        {
            content=_content;
            return this;
        }
        public Builder addmimeType(String _mimeType)
        {
            mimeType=_mimeType;
            return this;
        }
        public Builder addcc(String _cc)
        {
            cc.add(_cc);
            return this;
        }
        public Builder addbcc(String _bcc)
        {
            bcc.add(_bcc);
            return this;
        }

        private boolean isEmail(String email)
        {
            boolean result = true;
            try {
                InternetAddress emailAddr = new InternetAddress(email);
                emailAddr.validate();
            } catch (AddressException ex) {
                result = false;
            }
            return result;
        }
        private boolean isall()
        {
            if(from!=null && to != null)
                return true;
            return false;
        }
        public EmailMessage build(){

            return new EmailMessage(from, to, subject, content, mimeType, cc, bcc);
        }

    }
}
