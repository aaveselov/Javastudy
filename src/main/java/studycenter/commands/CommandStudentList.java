package studycenter.commands;

import org.reflections.Reflections;
import studycenter.Student;
import studycenter.StudyCenter;
import studycenter.commands.StudentsCompare.StudentsCompare;
import studycenter.score.ScoreBook;
import studycenter.validation.ILLegalCommandException;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Stream;

import static java.lang.System.out;

public class CommandStudentList implements Command {
    String all;
    private static final Map<String, StudentsCompare> supportedComparators = new HashMap<>();
//    Vector<IStudentFilter> filters;
//    static {
//        ClassLoader classLoader = CommandStudentList.class.getClassLoader();
//        Reflections reflections = new Reflections(StudentsCompare.class.getCanonicalName());
//        Set<Class<? extends StudentsCompare>> classes = reflections.getSubTypesOf(StudentsCompare.class);
//        for (Class<? extends StudentsCompare> aClass : classes) {
//            try {
//                StudentsCompare command = aClass.getDeclaredConstructor().newInstance();
//                supportedComparators.put(command.getName(), command );
//            } catch (java.lang.ReflectiveOperationException e ) {
//                System.out.println("error in Veselov code");
//                e.printStackTrace();
//            }
//        }
//    }
    private Vector<StudentsCompare> comparators = new Vector<>();

    private static void listStudents(Stream<Student> studentStream) {
        studentStream.forEach(out::println);
    }

    @Override public void init(String[] arguments) throws ILLegalCommandException {
        //create supportedComparators
    }

    @Override public void execute() {
        listStudents(StudyCenter.getStudents());
    }

    @Override public String describeCorrectUsage() {
        String returnValue = name() + "\t\t\t- lists all studied students";
        for( StudentsCompare compare : supportedComparators.values() ) {
            returnValue += "\t\t\t\t ["+compare.getName()+"]";
        }
        return returnValue;
    }

    //    public static void listStudents(Comparator<Student> comparator, Predicate<Student> filter) {
    //        listStudents(studentMap.values().stream().filter(filter).sorted(comparator));
    //    }

    @Override public String name() {
        return "student-list";
    }
}
