package studycenter.student.score;


import studycenter.validation.IllegalInitialDataException;

/**
 *     mark must be in range 1-100
 */
public class Score {

    private int mark;

    public Score(int mark) throws IllegalInitialDataException{
        setMark(mark);
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) throws IllegalInitialDataException {
        if ( mark < 1 || mark > 100 )
            throw new IllegalInitialDataException( mark + "over limits. must be 1..100");
        this.mark = mark;
    }
}
