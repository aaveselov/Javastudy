package studycenter.commands;

import studycenter.validation.ILLegalCommandException;

public interface Command {
    void init(String [] arguments ) throws ILLegalCommandException;
    void execute();
    String describeCorrectUsage();
}
