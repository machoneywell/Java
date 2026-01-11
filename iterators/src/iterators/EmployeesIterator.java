package iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EmployeesIterator implements Iterator<Employee> {
    private Employee[] employees;
    private int index = 0;
    private int numberOfEmployees = 0;
    // Store all the workers whose department matches the provided departmentName in the employees array.
    // The size of employees array should be equal to the number of workers who match the departmentName.
    // Example:
    // e1.department = "Accounting"  &&  e2.department = "Finance" && e3.department = "CS" && e4.department = "CS"
    // EmployeesIterator([e1, e2, e3, e4], "Accounting") --> employees array contains only one element which is e1
    // EmployeesIterator([e1, e2, e3, e4], "CS") --> employees array contains two elements which are e3 and e4
    public EmployeesIterator(Employee[] workers, String departmentName) {
        for (Employee worker : workers) {
            if (worker.getDepartmentName().equals(departmentName)) {
                numberOfEmployees++;
            }
        }

        employees = new Employee[numberOfEmployees];

        int currIndex = 0;
        for (Employee worker : workers) {
            if (worker.getDepartmentName().equals(departmentName)) {
                employees[currIndex] = worker;
                currIndex++;
            }
        }
        numberOfEmployees = 0;
    }

    // You can't modify this function.
    public int getLength() {
        return employees.length;
    }

    // Return true if there is a next employee in the array.
    public boolean hasNext() {
        return index < employees.length;
    }

    // Return the next employee. If there is no next employee throw NoSuchElementException
    public Employee next() {
        if (!hasNext() )
            throw(new NoSuchElementException("ArrayIterator: no more elements in array"));
        Employee nextEmployee = employees[index];
        index++;
        return nextEmployee;
    }

    // Use hasNext() and next() to iterate
    // and return number of Employees with Salary higher than the input s
    public int getNumberOfEmployeesWithSalaryHigherThan(int s) {
        while (hasNext()) {
            Employee employee = next();
            if (employee.getSalary() > s) {
                numberOfEmployees++;
            }
        }
        index = 0;
        return numberOfEmployees;
    }

}
