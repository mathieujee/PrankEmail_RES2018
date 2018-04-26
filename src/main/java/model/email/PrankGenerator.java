package model.email;

import config.ConfigurationManager;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Generate a Prank
 */
public class PrankGenerator {

    private ConfigurationManager configurationManager;

    /**
     * Create a Prank with configuration Manager
     * @param configurationManager
     */
    public PrankGenerator(ConfigurationManager configurationManager) {
        this.configurationManager = configurationManager;
    }

    /**
     * Return a prank
     * @return a prank
     */
    public ArrayList<Prank> generatePranks() {

        ArrayList<Prank> prankBuild = new ArrayList<Prank>();

        ArrayList<String> messages = configurationManager.getMessages();

        int nbGroups = configurationManager.getNumberOfGroups();

        ArrayList<Person> victims = configurationManager.getVictims();
        Collections.shuffle(victims);

        ArrayList<Person> wToCC = configurationManager.getwitnessesToCC();

        // Check if there are at least 3 people for each group
        if (victims.size() / nbGroups < 3) {
            nbGroups = victims.size() / 3;
        }

        ArrayList<Group> groups = new ArrayList<Group>();

        for (int i = 0; i < nbGroups; ++i) {
            groups.add(new Group());
        }

        for (int i = 0; i < victims.size(); ++i) {
            groups.get(i % nbGroups).add(victims.get(i));
        }

        for(Group g : groups){
            ArrayList<Person> prankVictims = g.getPersonList();
            prankBuild.add(new Prank(prankVictims.remove(0), prankVictims, wToCC, messages.get(random(0,messages.size()-1))));
        }

        return prankBuild;
    }

    private int random(int min, int max) {

        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }
}
