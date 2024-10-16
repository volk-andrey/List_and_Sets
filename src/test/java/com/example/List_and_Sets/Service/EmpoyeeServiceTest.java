package com.example.List_and_Sets.Service;

import com.example.List_and_Sets.Employee;
import com.example.List_and_Sets.exeption.EmployeeAlreadeyAddedExeption;
import com.example.List_and_Sets.exeption.EmployeeNotFoundExeption;
import com.example.List_and_Sets.exeption.EmployeeStorageFullExeption;
import com.example.List_and_Sets.service.EmployeeService;
import com.example.List_and_Sets.service.EmployeeServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class EmpoyeeServiceTest {
    private final EmployeeService employeeService = new EmployeeServiceImpl();
    private static final Random RANDOM = new Random();

    @DisplayName("Положительный тест на добавление нового сотрудника")
    @Test
    void addEmployeeTest() {
        //given
        int sizeBeforeAdding = employeeService.getAllEmployees().size();
        int expectedSizeAfterAdding = ++sizeBeforeAdding;
        Employee newEmployee = new Employee("Григорий","Щербаков","Борисович",4,100_000);
        //when
        employeeService.addEmployee(newEmployee);
        //then
        int sizeAfterAdding = employeeService.getAllEmployees().size();
        assertEquals(expectedSizeAfterAdding, sizeAfterAdding);
        boolean isAdded = employeeService.getAllEmployees()
                .stream()
                .anyMatch(newEmployee::equals);
        assertTrue(isAdded);
    }
    @DisplayName("Отрицательный тест на превышение количества сотрудников")
    @Test
    void addEmployeeIsFullTest() {
        //given
        int maxAllowedCount = 10;
        Stream.generate(EmpoyeeServiceTest::getRandomEmployee)
                .limit(maxAllowedCount - 1)
                .forEach(employeeService::addEmployee);
        //when//then
        assertDoesNotThrow(() -> employeeService.addEmployee(getRandomEmployee()));
        assertThrows(EmployeeStorageFullExeption.class, () ->
                employeeService.addEmployee(getRandomEmployee()));
        int actualSize = employeeService.getAllEmployees().size();
        assertEquals(maxAllowedCount, actualSize);
    }
    @DisplayName("Отрицательный тест на повторное добавление сотрудника")
    @Test
    void addEmployeeAlreadyAddedTest() {
        //given
        Employee employee = getRandomEmployee();
        //when//then
        assertDoesNotThrow(() -> employeeService.addEmployee(employee));
        assertThrows(EmployeeAlreadeyAddedExeption.class, () ->
                employeeService.addEmployee(employee));
    }
    @DisplayName("Положительный тест на удаление сотрудника")
    @Test
    void RemoveEmployeeTest() {
        //given
        Employee employee = getRandomEmployee();
        employeeService.addEmployee(employee);
        int sizeBeforeRemoving = employeeService.getAllEmployees().size();
        int expectedSizeAfterRemoving = --sizeBeforeRemoving;
        //when
        employeeService.removeEmployee(employee);
        //then
        int sizeAfterRemoving = employeeService.getAllEmployees().size();
        assertEquals(expectedSizeAfterRemoving, sizeAfterRemoving);
        boolean isRemoved = employeeService.getAllEmployees()
                .stream()
                .noneMatch(employee::equals);
        assertTrue(isRemoved);
    }

    @DisplayName("Отрицательный тест на удаление несуществующего сотрудника")
    @Test
    void RemoveEmployeeNotAddedTest() {
        //given
        Employee employee = getRandomEmployee();
        //when//then
        assertThrows(EmployeeNotFoundExeption.class, () -> employeeService.removeEmployee(employee));
    }

    @DisplayName("Положительный тест на поиск сотрудника по имени")
    @Test
    void getEmployeeByNameTest() {
        //given
        Employee employeeExtendFindByName = getRandomEmployee();
        employeeService.addEmployee(employeeExtendFindByName);
        int maxAllowedCount = 10;
        Stream.generate(EmpoyeeServiceTest::getRandomEmployee)
                .limit(maxAllowedCount - 2)
                .forEach(employeeService::addEmployee);
        //when
        Employee employeeFindByName = employeeService.findEmployee(
                employeeExtendFindByName.getFirstName(),
                employeeExtendFindByName.getLastName(),
                employeeExtendFindByName.getSerName()
        );
        //then
        assertEquals(employeeExtendFindByName, employeeFindByName);
    }

    @DisplayName("Отрицательный тест на поиск не существующего сотрудника по имени")
    @Test
    void getEmployeeByNameNotAddedTest() {
        //given
        Employee employeeExtendFindByName = getRandomEmployee();
        //when//then
        assertThrows(EmployeeNotFoundExeption.class, () ->
                employeeService.findEmployee(
                        employeeExtendFindByName.getFirstName(),
                        employeeExtendFindByName.getLastName(),
                        employeeExtendFindByName.getSerName()));
    }


    public static Employee getRandomEmployee() {
        return new Employee( RANDOM.nextInt() + "Григорий" + RANDOM.nextInt(),
                RANDOM.nextInt() + "Щербаков" + RANDOM.nextInt(),
                "Борисович",4,100_000);
    }
}


