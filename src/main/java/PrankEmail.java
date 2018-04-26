import config.ConfigurationManager;
import model.email.PrankGenerator;
import smtp.protocol.SmtpClient;

import java.io.IOException;

public class PrankEmail {

    public static void main(String[] args) throws IOException {
        ConfigurationManager configurationManager = new ConfigurationManager();
        PrankGenerator prankGenerator = new PrankGenerator(configurationManager);
        SmtpClient client = new SmtpClient(configurationManager.getSmtpServerAddress(),
                configurationManager.getSmtpServerPort(), prankGenerator.generatePranks());
        client.sendEmail();
    }
}
