package smtp.protocol;

import java.io.IOException;

public interface ISmtpClient {

    public void sendEmail() throws IOException;
}
