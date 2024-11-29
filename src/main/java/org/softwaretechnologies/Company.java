package org.softwaretechnologies;

import java.util.List;
import java.util.ArrayList;
import org.softwaretechnologies.employee.Employee;
import org.softwaretechnologies.employee.EmployeeType;

public class Company
{
    private final String name;
    private final List<Employee> employeeList;

    public Company(String name)
    {
        this.name = name;
        this.employeeList = new ArrayList<>();
    }

    public void addEmployee(String name, int baseSalary, EmployeeType type)
    {
        Employee employee = EmployeeFactory.createEmployee(name, baseSalary, type);
        employeeList.add(employee);
    }

    public int getMonthSalary(int month)
    {
        int totalSalary = 0;

        for (Employee employee : employeeList)
        {
            totalSalary += employee.getMonthSalary(month);
        }

        return totalSalary;
    }

    public String getName()
    {
        return name;
    }
}