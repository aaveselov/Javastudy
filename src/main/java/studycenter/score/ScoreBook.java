package studycenter.score;

import studycenter.studyprogram.Course;

import java.util.Vector;

/**
 * holds Topic marks
 */
public class ScoreBook {
    Vector<TopicTestScore> testScoreVector;
    int currentTopic;

    public ScoreBook(Course course) {
        currentTopic = 0;
        //init testScoreVector
    }

    void testPassed(Score score) {
        //check bounds
        //remember score
        //advance currentTopic
    }

    public Float getAverageScore() {
        if (null == testScoreVector || 0 == currentTopic || testScoreVector.isEmpty()) {
            return 0.0f;
        }
        else {
            int summaryScore = testScoreVector.stream().map(TopicTestScore::getMark).mapToInt(Score::getMark).sum();
            int testsTaken = testScoreVector.size();
            return 1.0f * summaryScore / testsTaken;
        }
    }
}
