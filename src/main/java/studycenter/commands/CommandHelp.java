package studycenter.commands;

import studycenter.validation.ILLegalCommandException;

import java.util.Collection;
import java.util.Vector;

public class CommandHelp implements Command {
    private Collection<Command> commands = new Vector<>();
    CommandHelp() {
        this.commands = commands;
    }
    @Override public void execute() {
        CommandFactory.describeAllCommands();
    }

    @Override public void init(String[] arguments) throws ILLegalCommandException {

    }

    @Override public String describeCorrectUsage() {
        return name() + "\t\t\t- will print all commands and its syntax";
    }

    @Override public String name() {
        return "help";
    }
}
