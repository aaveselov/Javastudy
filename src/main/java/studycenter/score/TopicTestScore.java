package studycenter.score;

import studycenter.studyprogram.Topic;

import java.util.Date;

public class TopicTestScore {
    private Topic topic;
    private Boolean taken;
    private Score mark;
    private int duration;

    public Boolean getTaken() {
        return taken;
    }

    public void setMark(Score mark) {
        this.mark = mark;
        taken = true;
    }

    TopicTestScore(Topic topic) {
        this.topic = topic;
        this.taken = false;
        this.mark = new Score(Score.DEFAULT_SCORE);
        this.duration = topic.getDuration();
    }
    public Score getMark() {
        return mark;
    }

    public int getDuration() {
        return duration;
    }

    public Topic getTopic() {
        return topic;
    }

    @Override public String toString() {
        return "TopicTestScore{" +
                "topic=" + topic +
                ", taken=" + taken +
                ", mark=" + mark +
                '}';
    }
}