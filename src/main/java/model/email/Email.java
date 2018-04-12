package model.email;

public class Email {

    private String mailFrom;
    private String[] mailTo = new String[0];
    private String[] cc;
    private String subject;
    private String content;

    public Email(String mailFrom, String[] mailTo, String[] cc, String subject, String content) {
        if(mailFrom == null)
            throw new IllegalArgumentException("You must specify the author of the mail.");

        this.mailFrom = mailFrom;

        if(mailTo.length <= 0 || mailTo == null)
            throw new IllegalArgumentException("There must be at least one recipient.");

        this.mailTo = mailTo;

        this.cc = cc;

        if(subject == null || subject.equals("")) {
            this.subject = "No Subject";
        }
        else {
            this.subject = subject;
        }

        if(content == null) {
            this.content = "";
        }
        else {
            this.content = content;
        }
    }

    public String getMailFrom() {
        return mailFrom;
    }

    public String[] getMailTo() {
        return mailTo;
    }

    public String[] getCc() {
        return cc;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    public void setMailTo(String[] mailTo) {
        this.mailTo = mailTo;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
