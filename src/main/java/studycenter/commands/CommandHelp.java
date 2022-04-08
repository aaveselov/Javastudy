package studycenter.commands;

import studycenter.validation.ILLegalCommandException;

import java.util.Optional;

public class CommandHelp implements Command {
    CommandHelp() {

    }
    @Override public Optional<Integer> execute() {
        Factory.describeAllCommands();
        return Optional.empty();
    }

    @Override public void init(String[] arguments) throws ILLegalCommandException {

    }

    @Override public String describeCorrectUsage() {
        return name() + "\t\t\t- will print all commands and syntax";
    }

    @Override public String name() {
        return "help";
    }
}
