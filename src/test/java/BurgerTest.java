import org.junit.Before;
import org.junit.Test;

import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BurgerTest {

    private Burger burger;
    private Bun bunMock;
    private Ingredient ingredientMock1;
    private Ingredient ingredientMock2;

    @Before
    public void setUp() {
        burger = new Burger();
        bunMock = mock(Bun.class);
        ingredientMock1 = mock(Ingredient.class);
        ingredientMock2 = mock(Ingredient.class);

        // Настройка мока для булочки
        when(bunMock.getName()).thenReturn("Sesame");
        when(bunMock.getPrice()).thenReturn(50.0f);

        burger.setBuns(bunMock);
    }

    @Test
    public void testAddIngredient() {
        when(ingredientMock1.getName()).thenReturn("Lettuce");
        when(ingredientMock1.getPrice()).thenReturn(10.0f);

        burger.addIngredient(ingredientMock1);

        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredientMock1, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        when(ingredientMock1.getName()).thenReturn("Tomato");
        when(ingredientMock1.getPrice()).thenReturn(15.0f);

        burger.addIngredient(ingredientMock1);
        burger.removeIngredient(0);

        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        when(ingredientMock1.getName()).thenReturn("Lettuce");
        when(ingredientMock2.getName()).thenReturn("Tomato");

        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);

        burger.moveIngredient(0, 1);

        assertEquals(ingredientMock2, burger.ingredients.get(0));
        assertEquals(ingredientMock1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        when(ingredientMock1.getPrice()).thenReturn(10.0f);
        when(ingredientMock2.getPrice()).thenReturn(15.0f);

        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);

        float expectedPrice = 50.0f * 2 + 10.0f + 15.0f; // 50 * 2 + 10 + 15
        assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }

    @Test
    public void testGetReceipt() {
        when(ingredientMock1.getName()).thenReturn("Lettuce");
        when(ingredientMock1.getType()).thenReturn(IngredientType.FILLING);

        burger.addIngredient(ingredientMock1);

        String expectedReceipt = "(==== Sesame ====)\n" +
                "= filling lettuce =\n" +
                "(==== Sesame ====)\n" +
                "\nPrice: 110.000000\n";

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}