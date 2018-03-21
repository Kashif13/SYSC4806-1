import app.AcademicYear;
import app.Course;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseTest {

    Course course1;
    Course course2;


    @Before
    public void setUp() throws Exception {
        course1 = new Course("NameTest","DescTest", AcademicYear.YEAR_1);
        course2 = new Course("NameTest");
    }
    @Test
    public void testEmptyDescriptionIfNotProvided() throws Exception {
        assertEquals(null, course2.getDescription());
        course2.setDescription("DescTest2");
    }
    @Test
    public void testSetYear() throws Exception {
        course1.setYear(AcademicYear.YEAR_2);
        assertEquals(AcademicYear.YEAR_2, course1.getYear());
    }

}