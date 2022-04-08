package studycenter.commands;

import org.reflections.Reflections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Factory {
    private static final Map<String, Command> namedCommands = new HashMap<>();

    static {
        ClassLoader classLoader = Factory.class.getClassLoader();
        Reflections reflections = new Reflections("studycenter");
        Set<Class<? extends Command>> classes = reflections.getSubTypesOf(Command.class);
        for (Class<? extends Command> aClass : classes) {
            try {
                Command command = aClass.getDeclaredConstructor().newInstance();
                namedCommands.put(command.name(), command );
            } catch (java.lang.ReflectiveOperationException e ) {
                System.out.println("error in Veselov code");
                e.printStackTrace();
            }
        }
    }

    static void describeAllCommands() {
        System.out.println("commands usage:");
        for ( Command command : namedCommands.values() ) {
            System.out.println( "\t" + command.describeCorrectUsage() );
        }
        System.out.println("commands usage end.");
    }

    Command createCommand(String input) {
        String[] parsedCommand = input.split("[ ]+");
        String commandName = parsedCommand[0];
        String[] commandArguments = Arrays.copyOfRange(parsedCommand, 1, parsedCommand.length);

        Command createdCommand = namedCommands.getOrDefault(commandName, new CommandHelp());
        createdCommand.init(commandArguments);
        return createdCommand;
    }
}
