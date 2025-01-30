import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private Ingredient ingredient;
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                { IngredientType.SAUCE, "hot sauce", 100.0f },
                { IngredientType.FILLING, "cutlet", 150.0f },
                { IngredientType.SAUCE, "chili sauce", 200.0f },
                { IngredientType.FILLING, "sausage", 250.0f }
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void testGetName() {
        assertEquals("Ingredient name should be '" + name + "'", name, ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals("Ingredient price should be " + price, price, ingredient.getPrice(), 0.01);
    }

    @Test
    public void testGetType() {
        assertEquals("Ingredient type should be " + type, type, ingredient.getType());
    }
}