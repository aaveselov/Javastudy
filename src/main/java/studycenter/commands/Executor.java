package studycenter.commands;

import studycenter.validation.ILLegalCommandException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Executor {
    public void listen() {
        Factory commandFactory = new Factory();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                try {
                    System.out.print("> ");
                    String commandCandidate = reader.readLine();
                    if ( null == commandCandidate )
                        return;
                    Command command = commandFactory.createCommand(commandCandidate);
                    if (command.execute().isPresent())
                        return;
                } catch (ILLegalCommandException e) {
                    e.printStackTrace();
                }
            }
        } catch (java.io.IOException e) {
            System.out.println("can't listen to commands");
        }
    }
}
