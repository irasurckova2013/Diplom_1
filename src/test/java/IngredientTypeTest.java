import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {

    @Test
    public void testIngredientTypeValues() {

        IngredientType[] types = IngredientType.values();
        assertNotNull("IngredientType values should not be null", types);
        assertEquals("There should be 2 types of ingredients", 2, types.length);

        assertEquals("First ingredient type should be SAUCE", IngredientType.SAUCE, types[0]);
        assertEquals("Second ingredient type should be FILLING", IngredientType.FILLING, types[1]);
    }

    @Test
    public void testIngredientTypeValueOf() {
        assertEquals("Should return SAUCE for 'SAUCE'", IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals("Should return FILLING for 'FILLING'", IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIngredientTypeValueOfInvalid() {
        IngredientType.valueOf("INVALID_TYPE");
    }
}