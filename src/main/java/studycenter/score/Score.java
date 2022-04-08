package studycenter.score;


import studycenter.validation.IllegalInitialDataException;

/**
 *     mark must be in range 1-100
 */
public class Score {
    private int mark;
    public static final int MAXIMUM_SCORE = 100;
    public static final int MINIMUM_SCORE = 1;
    public static final int DEFAULT_SCORE = 0;
    public static final float PASSING_AVERAGE = 75;

    public Score(int mark) throws IllegalInitialDataException{
        setMark(mark);
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) throws IllegalInitialDataException {
        if ( DEFAULT_SCORE != mark && (mark < MINIMUM_SCORE || mark > MAXIMUM_SCORE ) )
            throw new IllegalInitialDataException( mark + "over limits. must be 1..100");
        this.mark = mark;
    }

    @Override public String toString() {
        return "Score{" +
                "mark=" + mark +
                '}';
    }
}
