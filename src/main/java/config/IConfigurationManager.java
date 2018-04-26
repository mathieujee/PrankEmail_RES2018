package config;

import model.email.*;
import java.io.IOException;
import java.util.List;


public interface IConfigurationManager {

    public List<Person> victims(String filename) throws IOException;

    public List<Person> getVictims();

    public List<String> messages(String filename) throws IOException;

    public List<String> getMessages();

    public List<Person> getwitnessesToCC();

    public int getSmtpServerPort();

    public int getNumberOfGroups();

    public String getSmtpServerAddress();
}
