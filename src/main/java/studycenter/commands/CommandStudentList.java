package studycenter.commands;

import org.reflections.Reflections;
import studycenter.Student;
import studycenter.StudyCenter;
import studycenter.commands.students_compare.StudentsCompare;
import studycenter.commands.students_filter.StudentsFilter;
import studycenter.validation.ILLegalCommandException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Stream;

import static java.lang.System.out;

public class CommandStudentList implements Command {
    private static final Map<String, StudentsCompare> supportedComparators = new HashMap<>();
    private static final Map<String, StudentsFilter> supportedFilters = new HashMap<>();

    static {
        ClassLoader classLoader = CommandStudentList.class.getClassLoader();
        Reflections reflections = new Reflections("studycenter");
        {
            Set<Class<? extends StudentsCompare>> classes = reflections.getSubTypesOf(StudentsCompare.class);
            for (Class<? extends StudentsCompare> aClass : classes) {
                try {
                    StudentsCompare command = aClass.getDeclaredConstructor().newInstance();
                    supportedComparators.put(command.getName(), command);
                } catch (java.lang.ReflectiveOperationException e) {
                    System.out.println("error in Veselov code");
                    e.printStackTrace();
                }
            }
        }
        {
            Set<Class<? extends StudentsFilter>> classes = reflections.getSubTypesOf(StudentsFilter.class);
            for (Class<? extends StudentsFilter> aClass : classes) {
                try {
                    StudentsFilter command = aClass.getDeclaredConstructor().newInstance();
                    supportedFilters.put(command.getName(), command);
                } catch (java.lang.ReflectiveOperationException e) {
                    System.out.println("error in Veselov code");
                    e.printStackTrace();
                }
            }
        }
    }

    String all;
    Vector<StudentsCompare> comparators;
    Vector<StudentsFilter> filters;

    private static void listStudents(Stream<Student> studentStream) {
        studentStream.forEach(out::println);
    }

    @Override public void init(String[] arguments) throws ILLegalCommandException {
        //choose needed comparators and filters
        for (String argument : arguments) {
            if (supportedComparators.containsKey(argument)) {
                comparators.add(supportedComparators.get(argument));
            } else if (supportedFilters.containsKey(argument)) {
                filters.add(supportedFilters.get(argument));
            } else {
                throw new ILLegalCommandException(name() + "unsupported argument " + argument);
            }
        }
    }

    @Override public void execute() {
        listStudents(StudyCenter.getStudents());
    }

    @Override public String describeCorrectUsage() {
        String returnValue = name() + "\t\t\t- lists all studied students. Parameters:";
        for (StudentsCompare compare : supportedComparators.values()) {
            returnValue += "\n\t\t\t\t [" + compare.getName() + "]";
        }
        for (StudentsFilter filter : supportedFilters.values()) {
            returnValue += "\n\t\t\t\t [" + filter.getName() + "]";
        }
        return returnValue;
    }

    @Override public String name() {
        return "student-list";
    }
}
