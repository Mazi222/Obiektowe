package lab3.email;

import java.util.LinkedList;
//import com.sun.mail.smtp;

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

    public static Builder builder(){
        return new EmailMessage.Builder();
    }

    public static class Builder{
        private String from;
        private LinkedList<String> to;
        private String subject;
        private String content;
        private String mimeType;
        private LinkedList<String> cc;
        private LinkedList<String> bcc;


        Builder(){
        }
        public Builder addfrom(String _from)
        {
            from=_from;
            //TODO
            return this;
        }
        public Builder addto(String _to)
        {
            to.add(_to);
            //TODO
            return this;
        }
        public Builder addsubject(String _subject)
        {
            subject=_subject;
            //TODO
            return this;
        }
        public Builder addcontent(String _content)
        {
            content=_content;
            //TODO
            return this;
        }

        private boolean isEmail(String mail)
        {

        }
        private boolean isall()
        {
            if(from!=null && to != null)
                return true;
            return false;
        }
        public EmailMessage build(){

            return new EmailMessage(from, to, subject, content, mimeType, cc, bcc;)
        }

    }
}
