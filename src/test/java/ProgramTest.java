import app.Program;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class ProgramTest {

    Program p1;
    Program p2;


    @Before
    public void setUp() throws Exception {
        p1 = new Program("NameTest", "DescTest");
        p2 = new Program("NameTest");
    }
    @Test
    public void testEmptyDescriptionIfNotProvided() throws Exception {
        assertEquals("", p2.getDescription());
    }
    @Test
    public void testSetName() throws Exception {
        p2.setName("test");
        assertEquals("test", p2.getName());
    }
    @Test
    public void testToString() throws Exception {
        assertEquals("NameTest: DescTest", p1.toString());
    }

}