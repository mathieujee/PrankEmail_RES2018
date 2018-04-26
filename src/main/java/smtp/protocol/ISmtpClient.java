package smtp.protocol;

import java.io.IOException;

/**
 * SMTP Client
 */
public interface ISmtpClient {

    /**
     * Send Email to a server
     * @throws IOException
     */
    public void sendEmail() throws IOException;
}
