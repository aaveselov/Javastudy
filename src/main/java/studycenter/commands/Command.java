package studycenter.commands;

import studycenter.validation.ILLegalCommandException;

import java.util.Optional;


public interface Command {
    void init(String[] arguments) throws ILLegalCommandException;

    Optional<Integer> execute();

    String describeCorrectUsage();

    String name();
}
