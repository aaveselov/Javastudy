package studycenter.student.score;

import studycenter.studyprogram.Course;

import java.util.Vector;

/**
 * holds Topic marks
 */
public class ScoreBook {
    Vector<TopicTestScore> testScoreVector;
    int currentTopic;

    ScoreBook(Course course ) {
        currentTopic = 0;
        //init testScoreVector
    }
    void testPassed( Score score ) {
      //check bounds
        //remember score
        //advance currentTopic
    }
}
