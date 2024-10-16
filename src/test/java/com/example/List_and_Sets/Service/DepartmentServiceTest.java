package com.example.List_and_Sets.Service;

import com.example.List_and_Sets.Employee;
import com.example.List_and_Sets.exeption.EmployeeNotFoundExeption;
import com.example.List_and_Sets.service.DepartmentServiceImpl;
import com.example.List_and_Sets.service.EmployeeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Collections.EMPTY_LIST;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    private static final List<Employee> employeeList = List.of(
            new Employee("Григорий", "Щербаков", "Борисович", 4, 100_000),
            new Employee("Анна", "Иванова", "Петровна", 2, 300_000),
            new Employee("Егор", "Сидоров", "Михайлович", 4, 600_000),
            new Employee("Мария", "Кузнецова", "Васильевна", 2, 250_000),
            new Employee("Олег", "Романов", "Павлович", 4, 500_000),
            new Employee("Наталья", "Соколова", "Николаевна", 2, 200_000),
            new Employee("Артем", "Степанов", "Дмитриевич", 3, 400_000),
            new Employee("Екатерина", "Федорова", "Ефимовна", 3, 350_000),
            new Employee("Александр", "Козлов", "Андреевич", 3, 275_000)
    );
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @DisplayName("Положительный тест на получение сотрудника по департаменту")
    @Test
    void addEmployeeByDepartmentTest() {
        //given
        int requestedDepartment = 1;
        List<Employee> expectedEmployees = employeeList.stream()
                .filter(employee -> employee.getDepartament() == requestedDepartment)
                .toList();

        when(employeeService.getAllEmployees())
                .thenReturn(employeeList);
        //when
        List<Employee> actualEmployees = departmentService.getEmployeesByDepartment(requestedDepartment);
        //then
        verify(employeeService,times(1)).getAllEmployees();
        assertEquals(expectedEmployees, actualEmployees);
    }
    @DisplayName("Негативный тест на получение сотрудника из не существующего департамента")
    @Test
    void addEmployeeByDepartmentNegativeTest() {
        //given
        int requestedDepartment = 100;

        when(employeeService.getAllEmployees())
                .thenReturn(employeeList);
        //when
        List<Employee> actualEmployees = departmentService.getEmployeesByDepartment(requestedDepartment);
        // then
        verify(employeeService,times(1)).getAllEmployees();
        assertTrue(actualEmployees.isEmpty());
    }
    @DisplayName("Негативный тест на получение сотрудника с пустым хранилищем")
    @Test
    void addEmployeeByDepartmentNegativeNullPointerTest() {
        //given
        int requestedDepartment = 1;

        when(employeeService.getAllEmployees())
                .thenReturn(EMPTY_LIST);
        //when
        List<Employee> actualEmployees = departmentService.getEmployeesByDepartment(requestedDepartment);
        // then
        verify(employeeService,times(1)).getAllEmployees();
        assertTrue(actualEmployees.isEmpty());
    }

    @DisplayName("Положительный тест на получение суммы зарплат по департаменту")
    @ParameterizedTest()
    @MethodSource("provideDataForSum")
    void getSumSalaryByDepartmentTest(int department,long expected) {
        //given
        when(employeeService.getAllEmployees())
        .thenReturn(employeeList);
        //when
        long actual = departmentService.getSumOfSalaryByDepartment(department);
        //then
        verify(employeeService,times(1)).getAllEmployees();
        assertEquals(expected,actual);
    }

    @DisplayName("Положительный тест на получения максимальной зарплаты по департаменту")
    @ParameterizedTest()
    @MethodSource("provideDataForMaxSalary")
    void getMaxSalaryByDepartmentTest(int department,long expected) {
        //given
        when(employeeService.getAllEmployees())
        .thenReturn(employeeList);
        //when
        long actual = departmentService.getMaxOfSalaryByDepartment(department);
        //then
        verify(employeeService,times(1)).getAllEmployees();
        assertEquals(expected,actual);
    }
    @DisplayName("Негативный тест на получение максимальной зарплаты по департаменту")
    @Test
    void getMaxSalaryByDepartmentNegativeTest() {
        //given
        int requestedDepartment = 100;
        when(employeeService.getAllEmployees())
        .thenReturn(employeeList);
        //when//then
        assertThrows(EmployeeNotFoundExeption.class, () ->
                departmentService.getMaxOfSalaryByDepartment(requestedDepartment));
    }

    @DisplayName("Положительный тест на получение минимальной зарплаты по департаменту")
    @ParameterizedTest
    @MethodSource("provideDataForMinSalary")
    void getMinSalaryByDepartmentTest(int department,long expected) {
        //given
        when(employeeService.getAllEmployees())
        .thenReturn(employeeList);
        //when
        long actual = departmentService.getMinOfSalaryByDepartment(department);
        //then
        verify(employeeService,times(1)).getAllEmployees();
        assertEquals(expected,actual);
    }

    @DisplayName("Негативный тест на получение минимальной зарплаты по департаменту")
    @Test
    void getMinSalaryByDepartmentNegativeTest() {
        //given
        int requestedDepartment = 100;
        when(employeeService.getAllEmployees())
        .thenReturn(employeeList);
        //when//then
        assertThrows(EmployeeNotFoundExeption.class, () ->
                departmentService.getMinOfSalaryByDepartment(requestedDepartment));
    }

    public static Stream<Arguments> provideDataForSum(){
        return Stream.of(
                Arguments.of(4,1_200_000),
                Arguments.of(2,750_000),
                Arguments.of(3,1_025_000),
                Arguments.of(100,0));
    }

    public static Stream<Arguments> provideDataForMaxSalary(){
        return Stream.of(
                Arguments.of(4,600_000),
                Arguments.of(2,300_000),
                Arguments.of(3,400_000));
    }

    public static Stream<Arguments> provideDataForMinSalary(){
        return Stream.of(
                Arguments.of(4,100_000),
                Arguments.of(2,200_000),
                Arguments.of(3,275_000));
    }
}


