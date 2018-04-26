package config;

import model.email.*;
import java.io.IOException;
import java.util.List;

/**
 * Manage the configuration for the prank with extern files.
 */
public interface IConfigurationManager {

    /**
     * Create a List with people on the file
     *
     * @param filename the path to the file
     * @return a List of people
     * @throws IOException
     */
    public List<Person> victims(String filename) throws IOException;

    /**
     * Return a List with victims
     * @return a List with victims
     */
    public List<Person> getVictims();

    /**
     * Create a List with messages on the file
     *
     * @param filename the path to the file
     * @return a List with messages on the file
     * @throws IOException
     */
    public List<String> messages(String filename) throws IOException;

    /**
     * Return a List with messages
     * @return a List with messages
     */
    public List<String> getMessages();

    /**
     * Return a List with witnessesCC
     * @return a List with witnessesCC
     */
    public List<Person> getwitnessesToCC();

    /**
     * Return the SMTP server port
     * @return the SMTP server port
     */
    public int getSmtpServerPort();

    /**
     * Return the number of groups
     * @return the number of groups
     */
    public int getNumberOfGroups();

    /**
     * Return the SMTP server address
     * @return the SMTP server address
     */
    public String getSmtpServerAddress();
}
