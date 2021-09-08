package studycenter.commands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static final Map<String, Command> namedCommands = new HashMap<>();

    static {
        namedCommands.put("help", new CommandHelp(null));
        namedCommands.put("student-add", new CommandStudentAdd());
        namedCommands.put("student-list", new CommandStudentList());
    }

    Command createCommand(String input) {
        String[] parsedCommand = input.split("[ ]+");
        String commandName = parsedCommand[0];
        String[] commandArguments = Arrays.copyOfRange(parsedCommand, 1, parsedCommand.length);

        Command createdCommand = namedCommands.getOrDefault(commandName, new CommandHelp(namedCommands.values()));
        createdCommand.init(commandArguments);

        //student-add studentName

        //student [assignToCourse] studentName courseName

        //student [score] [studentName]

        //student [timeLeft] [studentName]

        //student [averageScore] [studentName]

        //student [canBeDischarged] [studentName]

        //student [sorted] [sortBy]

        //student [filtered] [filterBy]


        return createdCommand;
    }
}
