package studycenter.commands;

import studycenter.validation.ILLegalCommandException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandExecutor {
    public void listen() {
        CommandFactory commandFactory = new CommandFactory();
        try( BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)) ) {
            while ( true ) {
                try {
                    System.out.print("> ");
                    String commandCandidate = reader.readLine();
                    Command command = commandFactory.createCommand(commandCandidate );
                    command.execute();
                } catch ( ILLegalCommandException e ) {
                    System.out.println( e );

                }
            }
        } catch( java.io.IOException e ) {
            System.out.println("can't listen to commands");
        }
    }
}
