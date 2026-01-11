import iterators.Employee;
import iterators.EmployeesIterator;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class TestIterator {

    Employee e1, e2, e3, e4, e5, e6;

    public void init() {
        e1 = new Employee(25, 9300, "T", "L", "Accounting");
        e2 = new Employee(30, 15000, "M", "Q", "Sales");
        e3 = new Employee(28, 7200, "N", "H", "Sales");
        e4 = new Employee(36, 2800, "J", "M", "Accounting");
        e5 = new Employee(40, 5500, "B", "D", "Marketing");
        e6 = new Employee(28, 13000, "C", "P", "Engineering");
    }

    @Test
    public void testLength1() {
        init();
        assertEquals(1, new EmployeesIterator(new Employee[] {e1}, "Accounting").getLength());
    }

    @Test
    public void testLength2() {
        init();
        assertEquals(2, new EmployeesIterator(new Employee[] {e1, e2, e3, e4, e5, e6}, "Accounting").getLength());
    }

    @Test
    public void testLength3() {
        init();
        assertEquals(0, new EmployeesIterator(new Employee[] {}, "Marketing").getLength());
    }

    @Test
    public void testLength4() {
        init();
        assertEquals(0, new EmployeesIterator(new Employee[] {e1, e2, e3, e4, e5, e6}, "CEO").getLength());
    }

    @Test
    public void testLength5() {
        init();
        assertEquals(1, new EmployeesIterator(new Employee[] {e1, e2, e3, e4, e5, e6}, "Engineering").getLength());
    }

    @Test(timeout=5000)
    public void testEmployeeIterator1() {
        init();
        Iterator<Employee> iter = new EmployeesIterator(new Employee[] {e1}, "Accounting");
        String s = "";
        while (iter.hasNext())
            s += iter.next().toString() + "\n";
        assertEquals("Department: Accounting, Name: T L, Age: 25, Salary: 9300\n", s);
    }

    @Test(timeout=5000)
    public void testEmployeeIterator2() {
        init();
        int size = 0;
        Iterator<Employee> iter = new EmployeesIterator(new Employee[] {e1, e2, e3, e4, e5, e6}, "Accounting");
        while (iter.hasNext()) {
            iter.next();
            size += 1;
        }
        assertEquals(2, size);
    }

    @Test(timeout=5000)
    public void testEmployeeIterator3() {
        init();
        int size = 0;
        Iterator<Employee> iter = new EmployeesIterator(new Employee[] {e1, e2, e3, e4, e5, e6}, "Marketing");
        while (iter.hasNext()) {
            iter.next();
            size += 1;
        }
        assertEquals(1, size);
    }

    @Test(timeout=5000)
    public void testEmployeeIterator4() {
        init();
        int size = 0;
        Iterator<Employee> iter = new EmployeesIterator(new Employee[] {}, "Marketing");
        while (iter.hasNext()) {
            iter.next();
            size += 1;
        }
        assertEquals(0, size);
    }

    @Test(timeout=5000)
    public void testEmployeeIterator5() {
        init();
        Iterator<Employee> iter = new EmployeesIterator(new Employee[] {e1, e2, e3, e4, e5, e6}, "Sales");
        String s = "";
        while (iter.hasNext())
            s += iter.next().toString() + "\n";
        assertEquals("Department: Sales, Name: M Q, Age: 30, Salary: 15000\nDepartment: Sales, Name: N H, Age: 28, Salary: 7200\n", s);
    }

    @Test(timeout=5000)
    public void testNumberOfEmployees1() {
        init();
        Iterator<Employee> iter = new EmployeesIterator(new Employee[] {e1, e2, e3, e4, e5, e6}, "Marketing");
        assertEquals(0, ((EmployeesIterator) iter).getNumberOfEmployeesWithSalaryHigherThan(6000));
    }

    @Test(timeout=5000)
    public void testNumberOfEmployees2() {
        init();
        Iterator<Employee> iter = new EmployeesIterator(new Employee[] {e1, e2, e3, e4, e5, e6}, "Sales");
        assertEquals(1, ((EmployeesIterator) iter).getNumberOfEmployeesWithSalaryHigherThan(7200));
    }
}
