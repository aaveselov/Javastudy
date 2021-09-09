package studycenter.commands;

import studycenter.validation.ILLegalCommandException;

import java.util.Optional;

public class CommandExit implements Command {
    @Override public Optional<Integer> execute() {
        return Optional.of(0);
    }

    @Override public void init(String[] arguments) throws ILLegalCommandException {

    }

    @Override public String describeCorrectUsage() {
        return name() + "\t\t\t- exit program";
    }

    @Override public String name() {
        return "exit";
    }
}
