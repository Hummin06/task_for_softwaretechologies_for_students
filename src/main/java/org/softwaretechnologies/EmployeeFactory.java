package org.softwaretechnologies;

import org.softwaretechnologies.employee.*;

public class EmployeeFactory
{
    public static Employee createEmployee(String name, int baseSalary, EmployeeType type)
    {
        return switch (type)
        {
            case Tester -> new Tester(name, baseSalary);
            case Manager -> new Manager(name, baseSalary);
            case Programmer -> new Programmer(name, baseSalary);
        };
    }
}