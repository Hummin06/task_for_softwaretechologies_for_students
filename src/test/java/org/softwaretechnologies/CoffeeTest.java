package org.softwaretechnologies;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoffeeTest
{
    @Test
    void costCoffeeWithMilk()
    {
        CoffeeInterface coffee = new MilkCoffee(new Coffee());
        assertEquals(coffee.getCost(),60);
    }

    @Test
    void costCoffeeWithMilkSugar()
    {
        CoffeeInterface coffee = new SugarCoffee(new MilkCoffee(new Coffee()));
        assertEquals(coffee.getCost(),80);
    }
}