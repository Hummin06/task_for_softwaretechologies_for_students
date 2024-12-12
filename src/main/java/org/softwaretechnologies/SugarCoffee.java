package org.softwaretechnologies;

public class SugarCoffee implements CoffeeInterface
{
    private final CoffeeInterface coffee;

    public SugarCoffee(CoffeeInterface coffee)
    {
        this.coffee = coffee;
    }

    @Override
    public int getCost()
    {
        return coffee.getCost() + 20;
    }

    @Override
    public String description()
    {
        return coffee.description() + " + sugar";
    }
}