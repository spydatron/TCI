package exception;

import java.util.Date;

import static java.lang.String.format;

/**
 * Exception thrown upon CRUD operation on courses.
 */
public class CourseException extends Exception {
    /**
     * Message displayed when a course is still running.
     */
    private static final String MESSAGE_COURSE_STILL_RUNNING =
            "Another course with name '%s' is running from '%s', "
                    + "select a start date later than period '%s'.";
    /**
     * Message displayed when a course is created with an end date
     * happening before the starting date.
     */
    private static final String MESSAGE_COURSE_ENDDATE_BEFORE_STARTDATE =
            "A course must not have a start date after the ending date. "
                    + "Starting given was '%s' and end was '%s'.";

    /**
     *
     * @param courseStartDate the date at which the course is going to start.
     * @param courseEndDate the date at which the course is going to stop.
     */
    public CourseException(final Date courseStartDate,
                           final Date courseEndDate) {
        super(format(
                MESSAGE_COURSE_ENDDATE_BEFORE_STARTDATE,
                courseStartDate,
                courseEndDate));
    }

    /**
     * @param newCourseName   the name of the course.
     * @param courseStartDate the date at which the course is going to start.
     * @param courseStopDate  the date at which the course is going to stop.
     */
    public CourseException(final String newCourseName,
                           final Date courseStartDate,
                           final Date courseStopDate) {
        super(format(
                MESSAGE_COURSE_STILL_RUNNING,
                newCourseName,
                courseStartDate,
                courseStopDate));
    }
}
