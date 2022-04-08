package studycenter.studyprogram;

import java.util.Vector;

/** Каждый студент может проходить обучение по определённой учебной программе
 *
 */
public class Course {
    private String name;
    private Vector<Topic> topics;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Vector<Topic> topics) {
        this.topics = topics;
    }

    @Override public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", topics=" + topics +
                '}';
    }
}
