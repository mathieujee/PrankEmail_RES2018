package smtp.protocol;

import model.email.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class SmtpClient implements ISmtpClient {


    public static final String RETURN = "\r\n";
    private String smtpServerAddress;
    private int smtpServerPort = 25;

    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    private ArrayList<Prank> prank;

    public SmtpClient(String smtpServerAddress, int port, ArrayList<Prank> prank){

        this.smtpServerAddress = smtpServerAddress;
        this.smtpServerPort = port;
        this.prank = new ArrayList<Prank>(prank);
    }

    public void sendEmail(){

        try {

            socket = new Socket(smtpServerAddress, smtpServerPort);
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

            reader.readLine();

            writer.write(Protocol.CMD_HELLO + RETURN);
            writer.flush();

            String line = reader.readLine();

            while (line.startsWith("250-")){
                line = reader.readLine();
            }

            for(Prank p : prank){

                writer.write(Protocol.CMD_MAIL_FROM + p.getSender().getEmail() + RETURN);
                writer.flush();
                reader.readLine();

                for(Person person : p.getVictims()){
                    writer.write(Protocol.CMD_RCPT_TO + person.getEmail() + RETURN);
                    writer.flush();
                    reader.readLine();
                }

                for(Person person : p.getWitnessesToCC()){
                    writer.write(Protocol.CMD_RCPT_TO + person.getEmail() + RETURN);
                    writer.flush();
                    reader.readLine();
                }

                writer.write(Protocol.CMD_DATA + RETURN);
                writer.flush();
                reader.readLine();

                StringBuilder data = new StringBuilder();
                data.append("From: ").append(p.getSender().getEmail());

                data.append(RETURN).append("To: ");
                data.append(p.getVictims().get(0).getEmail());
                for(int i = 1; i < p.getVictims().size(); ++i){
                    data.append(", " + p.getVictims().get(i).getEmail());
                }

                data.append(RETURN).append("CC: ");
                data.append(p.getWitnessesToCC().get(0).getEmail());
                for(int i = 1; i < p.getWitnessesToCC().size(); ++i){
                    data.append(", " + p.getWitnessesToCC().get(i).getEmail());
                }

                data.append(RETURN).append("Subject: ");
                data.append("Congratulations, you've won 1$ !!!");

                data.append(RETURN + RETURN).append(p.getMessage()).append(Protocol.CMD_END_DATA + RETURN);
                writer.write(data.toString() + RETURN);
                writer.flush();
                reader.readLine();
            }

            writer.write(Protocol.CMD_QUIT + RETURN);
            writer.flush();
            socket.close();
            writer.close();
            reader.close();

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
