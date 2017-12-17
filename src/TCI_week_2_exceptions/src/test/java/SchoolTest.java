
import exception.CourseException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;

public class SchoolTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    public Date getDate(String dateFormat, String dateString){
        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        try {
            if(dateString != ""){
                date = formatter.parse(dateString);
                return date;
            }
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return new Date();
    }

    @Test
    public void assertGetCoursesByNameNull(){
        int count = 0;
        Date startDate ;
        Date courseStartDate = new Date();
        Date courseEndDate ;
        String courseEndDateStr = "14-Nov-2017";
        String startDateStr = "25-Jan-2017";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        School school = null;
        try {
            startDate = formatter.parse(startDateStr);
            courseEndDate = formatter.parse(courseEndDateStr);
            school = new School("Fontys", startDate);
            count = school.getCoursesByName("PCS2").size();
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(0, count);
    }


    @Test
    public void assertGetCoursesNull(){
        int count = 0;
        Date startDate ;
        Date courseStartDate = new Date();
        Date courseEndDate ;
        String courseEndDateStr = "14-Nov-2017";
        String startDateStr = "25-Jan-2017";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        School school = null;
        try {
            startDate = formatter.parse(startDateStr);
            courseEndDate = formatter.parse(courseEndDateStr);
            school = new School("Fontys", startDate);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(0, school.getCourses().size());
    }
    @Test
    public void assertGetCoursesByName(){
        int count =3;
        Date startDate ;
        Date courseStartDate = new Date();
        Date courseStartDate2 = null;
        Date courseEndDate ;
        Date courseEndDate2 ;
        String courseEndDateStr = "13-Nov-2017";
        String courseEndDateStr2 = "30-June-2018";
        String startDateStr1 = "25-Jan-2017";
        String startDateStr2 = "05-March-2018";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        School school = null;
        try {
            startDate = formatter.parse(startDateStr1);
            courseStartDate2 = formatter.parse(startDateStr2);
            courseEndDate = formatter.parse(courseEndDateStr);
            courseEndDate2 = formatter.parse(courseEndDateStr2);
            school = new School("Fontys", startDate);

            school.addCourse(new Course("PCS4", startDate, courseEndDate));
            school.addCourse(new Course("TCI", startDate, courseEndDate));
            school.addCourse(new Course("PCS4", courseStartDate2, courseEndDate2));
            school.addCourse(new Course("SAI", startDate, courseEndDate));

            count = school.getCoursesByName("PCS4").size();
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(2, count);
    }
    @Test
    public void assertGetCourses(){
        Date startDate ;
        Date courseStartDate = new Date();
        Date courseEndDate ;
        String courseEndDateStr = "13-Nov-2017";
        String startDateStr = "25-Jan-2017";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        School school = null;
        try {
            startDate = formatter.parse(startDateStr);
            courseEndDate = formatter.parse(courseEndDateStr);
            school = new School("Fontys", startDate);

            school.addCourse(new Course("PCS4", startDate, courseEndDate));
            school.addCourse(new Course("TCI", startDate, courseEndDate));
            school.addCourse(new Course("Math3", startDate, courseEndDate));
            school.addCourse(new Course("SOT", startDate, courseEndDate));
            school.addCourse(new Course("ES4", startDate, courseEndDate));

        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(5, school.getCourses().size());
    }


//    @Test(expected = CourseException.class)
//    public void addCourseShouldThrowCEforEnddateBeforeStardate(){
//        int count =3;
//        Date startDate = getDate("dd-MMM-yyyy", "13-Nov-2017");
//        Date courseStartDate = getDate("dd-MMM-yyyy", "24-Oct-2017");;
//        Date courseEndDate = getDate("dd-MMM-yyyy", "23-Oct-2017");
//
//        School school = new School("Fontys Hogeschool", startDate);
//        school.addCourse(new Course("PCS4", courseStartDate, courseEndDate));
//    }

    @Test(expected = IllegalArgumentException.class)
    public void addCourseShouldThrowIAEforEndateBeforeStardate(){
        Date startDate = getDate("dd-MMM-yyyy", "13-Nov-2017");
        Date courseStartDate = getDate("dd-MMM-yyyy", "24-Oct-2017");;
        Date courseEndDate = getDate("dd-MMM-yyyy", "23-Oct-2017");

        School school = new School("Fontys Hogeschool", startDate);
        school.addCourse(new Course("PCS4", courseStartDate, courseEndDate));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addCourseShouldThrowIAEforCourseStillRunning(){
        Date startDate = getDate("dd-MMM-yyyy", "13-Nov-2017");
        Date courseStartDate = getDate("dd-MMM-yyyy", "24-Oct-2017");;
        Date courseEndDate = getDate("dd-MMM-yyyy", "23-Oct-2017");

        School school = new School("Fontys Hogeschool", startDate);
        school.addCourse(new Course("PCS4", courseStartDate, courseEndDate));
        school.addCourse(new Course("MATH4", courseStartDate, courseEndDate));
        school.addCourse(new Course("PCS4", courseStartDate, courseEndDate));
    }


}
