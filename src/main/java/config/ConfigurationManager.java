package config;

import model.email.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

public class ConfigurationManager implements IConfigurationManager {

    private String smtpServerAdress;
    private int smtpServerPort;
    private int numberOfGroups;
    private List<Person> witnessesToCC;
    private List<Person> victims;
    private List<String> messages;


    public ConfigurationManager() throws IOException {
        victims = victims("./src/main/resources/victims.utf8");
        messages = messages("./src/main/resources/prankmails.utf8");

        Properties properties = new Properties();
        FileInputStream file = new FileInputStream("./src/main/resources/config.properties");
        properties.load(file);
        numberOfGroups = Integer.parseInt(properties.getProperty("numberOfGroups"));
        smtpServerAdress = properties.getProperty("smtpServerAddress");
        smtpServerPort = Integer.parseInt(properties.getProperty("smtpServerPort"));
        witnessesToCC = new ArrayList<Person>();
        String loadedWitnesses = properties.getProperty("witnessesToCC");
        String[] splitedWitness = loadedWitnesses.split(", ");
        for(String s : splitedWitness){
            witnessesToCC.add(new Person(s));
        }
    }


    public ArrayList<Person> victims(String filename) throws IOException {
        ArrayList<Person> victims = new ArrayList<Person>();
        FileInputStream fileInputStream = new FileInputStream(filename);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String email;
        while ((email = bufferedReader.readLine()) != null) {
            victims.add(new Person(email));
        }
        return victims;
    }

    public ArrayList<String> messages(String filename) throws IOException {
        ArrayList<String> messages = new ArrayList<String>();
        FileInputStream fileInputStream = new FileInputStream(filename);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("====")) {
                messages.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            } else {
                stringBuilder.append(line).append("\n");
            }
        }
        return messages;
    }

    public ArrayList<Person> getVictims() {
        return new ArrayList<Person>(victims);
    }

    public ArrayList<String> getMessages() {
        return new ArrayList<String>(messages);
    }

    public ArrayList<Person> getwitnessesToCC() {
        return new ArrayList<Person>(witnessesToCC);
    }

    public int getSmtpServerPort() {
        return smtpServerPort;
    }

    public int getNumberOfGroups() {
        return numberOfGroups;
    }

    public String getSmtpServerAddress() {
        return smtpServerAdress;
    }
}
