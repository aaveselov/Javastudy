package StudyCenter;

// start with this link
// https://stackoverflow.com/questions/62989576/how-to-read-from-yaml-file-in-java
// the tutorial
// https://www.baeldung.com/java-snake-yaml

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class StudyCenter {

    private String applicationName;

    public static void main(String[] args) {
        Yaml yaml = new Yaml();
        InputStream inputStream = StudyCenter
                .class
                .getClassLoader()
                .getResourceAsStream("properties.yaml");
        Map<String, Object> obj = yaml.load(inputStream);
        System.out.println(obj);
    }
}
