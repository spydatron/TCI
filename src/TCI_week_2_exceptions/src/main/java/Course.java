import java.util.Date;

/**
 * Model Class responsible to hold course data.
 */
public class Course {
    /**
     * The name of the course.
     */
    private final String name;
    /**
     * Start date of the course.
     */
    private final Date start;
    /**
     * End date of the course.
     */
    private final Date end;

    /**
     * Initialization of the course.
     * @param courseName name of the course.
     * @param courseStartDate start date of the course.
     * @param courseEndDate end date of the course.
     */
    public Course(final String courseName,
                  final Date courseStartDate,
                  final Date courseEndDate) {

        this.name = courseName;
        this.start = courseStartDate;
        this.end = courseEndDate;
    }

    /**
     * Get the end date of the course.
     * @return end date of the course.
     */
    public Date getEnd() {
        return end;
    }

    /**
     * Get the start date of the course.
     * @return start date of the course.
     */
    public Date getStart() {
        return start;
    }

    /**
     * Get the name of the course.
     * @return name of the course.
     */
    public String getName() {
        return name;
    }
}
