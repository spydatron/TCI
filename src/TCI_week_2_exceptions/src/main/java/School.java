import exception.CourseException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class responsible to hold and manipulate courses.
 */
public class School {
    /**
     * School name.
     */
    private final String name;
    /**
     * School opening date.
     */
    private final Date openingDate;
    /**
     * List of courses available at the school.
     */
    private List<Course> courses;

    /**
     * @param schoolName        of the school.
     * @param schoolOpeningDate opening date of the school.
     */
    public School(final String schoolName, final Date schoolOpeningDate) {
        this.name = schoolName;
        this.openingDate = schoolOpeningDate;
        courses = new ArrayList<Course>();
    }

    /**
     * Add a course to the list of available ones.
     *
     * @param course the course to be added to the list.
     */
    public void addCourse(final Course course) {
        addCourse(course.getName(), course.getStart(), course.getEnd());
    }


    /**
     * Add a course to the list of available ones.
     *
     * @param courseName  name of the course to be added.
     * @param courseStart start date.
     * @param courseEnd   end date.
     */
    public void addCourse(final String courseName,
                          final Date courseStart,
                          final Date courseEnd) {
        // Make sure that the starting date is before the end date.
        try {
            if (courseStart.after(courseEnd)) {
                throw new CourseException(courseStart, courseEnd);
            }
        } catch (final CourseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        // Make sure the course exists.
        try {
            final List<Course> coursesMatch = getCoursesByName(courseName);
            for (Course courseMatch : coursesMatch) {
                if (courseMatch.getEnd().after(courseStart)) {
                    throw new CourseException(
                            courseName,
                            courseMatch.getStart(),
                            courseMatch.getEnd());
                }
            }
        } catch (final CourseException error) {
            throw new IllegalArgumentException(error.getMessage());
        }

        courses.add(
                new Course(courseName, courseStart, courseEnd)
        );
    }

    /**
     * Retrieve courses with a given name.
     *
     * @param courseName the name of the course to be matched.
     * @return the course found matching the given name.
     * @throws CourseException thrown in case the course was not found.
     */
    public List<Course> getCoursesByName(final String courseName) {
        List<Course> coursesMatchingName = new ArrayList<Course>();
        for (final Course course : courses) {
            if (course.getName().equals(courseName)) {
                coursesMatchingName.add(course);
            }
        }
        return coursesMatchingName;
    }

    /**
     * Returns a list of all available courses.
     *
     * @return list of courses.
     */
    public List<Course> getCourses() {
        return courses;
    }
}
