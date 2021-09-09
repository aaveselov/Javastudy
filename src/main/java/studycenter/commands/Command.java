package studycenter.commands;

import studycenter.validation.ILLegalCommandException;

//student [assignToCourse] studentName courseName

//student [score] [studentName]

//student [timeLeft] [studentName]

//student [averageScore] [studentName]

//student [canBeDischarged] [studentName]

//student [sorted] [sortBy]

//student [filtered] [filterBy]

public interface Command {
    void init(String [] arguments ) throws ILLegalCommandException;
    void execute();
    String describeCorrectUsage();
    String name();
}
