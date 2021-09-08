package studycenter;

// start with this link
// https://stackoverflow.com/questions/62989576/how-to-read-from-yaml-file-in-java
// the tutorial
//TODO read and follow
// https://www.baeldung.com/java-snake-yaml

import org.yaml.snakeyaml.TypeDescription;
import studycenter.studyprogram.Course;
import studycenter.studyprogram.Topic;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

public class StudyCenter {
    public static void main(String[] args) {
        Constructor constructor = new Constructor(Course.class);
        TypeDescription customTypeDescription = new TypeDescription(Course.class);
        customTypeDescription.addPropertyParameters("topics", Topic.class);
        constructor.addTypeDescription(customTypeDescription);


        Yaml yaml = new Yaml(constructor);
        InputStream inputStream = StudyCenter
                .class
                .getClassLoader()
                .getResourceAsStream("courses.yaml");

        for (Object object : yaml.loadAll(inputStream)) {
            System.out.println(object);
        }
    }
}
