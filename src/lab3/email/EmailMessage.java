package lab3.email;

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

    public void sendemail(String host,int port) throws javax.mail.MessagingException {

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
        for (String aTo : to) {
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(aTo));
        }
        for (String aCc : cc) {
            message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(aCc));
        }
        for (String aBcc : bcc) {
            message.addRecipients(Message.RecipientType.BCC, InternetAddress.parse(aBcc));
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
        private LinkedList<String> to= new LinkedList<>();
        private String subject;
        private String content;
        private String mimeType;
        private LinkedList<String> cc=new LinkedList<>();
        private LinkedList<String> bcc=new LinkedList<>();

        public Builder addfrom(String _from) throws NotEmail {
            if(!isEmail(_from))
                throw new NotEmail();
            from=_from;
            return this;
        }
        public Builder addto(String _to) throws NotEmail {
            if(!isEmail(_to))
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

        private boolean isEmail(String email)       //sprawdzanie czy ciąg znaków jest mailem
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
            return from != null && to != null;
        }
        public EmailMessage build() throws NotEnoughArguments {
            if(!isall())
                throw new NotEnoughArguments();
            return new EmailMessage(from, to, subject, content, mimeType, cc, bcc);
        }

    }
}

class NotEmail extends Exception{
    public NotEmail() {
        System.out.println("Zly mail");
    }
}

class NotEnoughArguments extends Exception{
    public NotEnoughArguments() {
        System.out.println("Brak nadawcy i/lub odbiorcy");
    }
}

