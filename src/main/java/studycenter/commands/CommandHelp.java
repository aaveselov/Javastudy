package studycenter.commands;

import studycenter.validation.ILLegalCommandException;

import java.util.Collection;
import java.util.Vector;

public class CommandHelp implements Command {
    private Collection<Command> commands = new Vector<>();
    CommandHelp(Collection<Command> commands ) {
        this.commands = commands;
    }
    @Override public void execute() {
        System.out.println("commands usage:");
        for ( Command command : commands ) {
            System.out.println( "\t" + command.describeCorrectUsage() );
        }
        System.out.println("commands usage end.");
    }

    @Override public void init(String[] arguments) throws ILLegalCommandException {

    }

    @Override public String describeCorrectUsage() {
        return "help \t\t\t- will print all commands and its syntax";
    }
}
