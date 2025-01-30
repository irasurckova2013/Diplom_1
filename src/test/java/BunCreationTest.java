import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.*;

public class BunCreationTest {
    private Bun bun;

    @Before
    public void setUp() {

    }

    @Test
    public void testBunCreation() {
        bun = new Bun("Sesame", 1.5f);
        assertEquals("Sesame", bun.getName());
        assertEquals(1.5f, bun.getPrice(), 0.01);
    }

    @Test
    public void testBunName() {
        bun = new Bun("Whole Wheat", 2.0f);
        assertEquals("Whole Wheat", bun.getName());
    }

    @Test
    public void testBunPrice() {
        bun = new Bun("Gluten Free", 2.5f);
        assertEquals(2.5f, bun.getPrice(), 0.01);
    }
}