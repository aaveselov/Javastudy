package studycenter.studyprogram;

/** Программа обучения состоит из набора тем, которые студент проходит последовательно.
 *
 */
public class Topic {
    private String name;
    private Integer duration;

    public Topic() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override public String toString() {
        return "Topic{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}
