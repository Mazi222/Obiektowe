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

        if(_subject==null)
            subject="";
        if(_content==null)
            content="";
        if(_mimeType==null)
            mimeType="";

    }

    public void sendemail(String _host,int port) throws javax.mail.MessagingException {

        String host=_host;

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.socketFactory.port", port);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", port);

        Session mailSession = Session.getDefaultInstance(props, new javax.mail.Authenticator()
                {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from,"sagem4");
                    }
                }
                );
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress(from));
        for (int i = 0; i < to.size(); i++)                 //dodawanie adresatów
        {
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to.get(i)));
        }
        for (int i = 0; i < cc.size(); i++)
        {
            message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(cc.get(i)));
        }
        for (int i = 0; i < bcc.size(); i++)
        {
            message.addRecipients(Message.RecipientType.BCC, InternetAddress.parse(bcc.get(i)));
        }
        message.setSubject(subject);
        message.setContent(content, "text/plain; charset=ISO-8859-2");

        Transport.send(message);
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
        public Builder addfrom(String _from) throws NotEmail {
            if(isEmail(_from)==false)
                throw new NotEmail();
            from=_from;
            return this;
        }
        public Builder addto(String _to) throws NotEmail {
            if(isEmail(_to)==false)
                throw new NotEmail();
            to.add(_to);
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

class NotEmail extends Exception{
    public NotEmail() {
        System.out.println("Zly mail");
    }
}