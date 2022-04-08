package studycenter.score;

import studycenter.studyprogram.Course;
import studycenter.validation.ILLegalCommandException;

import java.util.Vector;

/**
 * holds Topic marks
 */
public class ScoreBook {
    Float maximumPossibleAverage = new Float( 0 );
    Float average = new Float(0);
    private final Vector<TopicTestScore> testScoreVector = new Vector<>();



    public ScoreBook(Course course) {
        course.getTopics()
                .forEach(topic -> testScoreVector.add(new TopicTestScore(topic)));
    }

    public void testPassed(Score score) {
        try {
            testScoreVector.stream()
                    .filter(t -> !t.getTaken())
                    .findFirst().get()
                    .setMark(score);
            System.out.println(testScoreVector);

            int summaryScore = testScoreVector.stream().map(TopicTestScore::getMark).mapToInt(Score::getMark).sum();
            long passedTests = getPassedTestsNumber();
            average = 1.0f * summaryScore / passedTests;
            long remainingTests = getRemainingTestsNumber();
            maximumPossibleAverage = ( average * passedTests + Score.MAXIMUM_SCORE * remainingTests)
                    / (passedTests + remainingTests);
        } catch ( java.util.NoSuchElementException e ) {
            throw new ILLegalCommandException("all tests passed");
        }
    }

    public Integer getTimeRemaining() {
        return testScoreVector.stream()
                .filter(t -> !t.getTaken())
                .mapToInt(TopicTestScore::getDuration)
                .sum();
    }

    public Float getAverageScore() {
        return average;
    }

    @Override public String toString() {
        return "ScoreBook{" +
                "maximumPossibleAverage=" + maximumPossibleAverage +
                ", average=" + average +
                ", testScoreVector=" + testScoreVector +
                '}';
    }

    public Float getMaximumPossibleAverage() {
        return maximumPossibleAverage;
    }

    private Long getPassedTestsNumber() {
        return testScoreVector.stream()
                .filter(TopicTestScore::getTaken)
                .count();
    }

    private Long getRemainingTestsNumber() {
        return testScoreVector.stream()
                .filter(t -> !t.getTaken())
                .count();
    }
}
