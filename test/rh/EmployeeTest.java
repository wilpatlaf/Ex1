package rh;

import static org.junit.Assert.assertThrows;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rh.exception.IllegalInitializeAnnualSalaryException;

class EmployeeTest {
	private final static String NEW_NAME = "Bob";
	private final static int NEW_SALARY = 100000;
	
	private Employee anEmployee = null;
	
	@BeforeEach
	public void setUp_anEmployee() {
		anEmployee = new Employee(NEW_NAME, NEW_SALARY);
	}

	@Test
	public void createEmployeeShouldInitializeName() {
		//Assert
		assertEquals(anEmployee.getName(), NEW_NAME);
	}

	@Test
	public void createEmployeeShouldInitializeNumber() {
		//Assert
		assertEquals(Employee.getCountNumber(), anEmployee.getNumber());
	}
	
	@Test
	public void createEmployeeShouldNotInitializeAnnualSalaryIfAnnualSalaryExceedsMaxAnnualSalary() {
		//Arrange
		int excessSalary = Employee.MAX_ANNUAL_SALARY + 1;

		assertThrows(IllegalInitializeAnnualSalaryException.class,
		() -> new Employee(NEW_NAME, excessSalary));  	 //DONE? chiffre magique
	}
	
	@Test
	public void create2EmployeesShouldBeSpacedByCountIncrease() {
		//Act
		Employee Employee1 = new Employee(NEW_NAME, NEW_SALARY);
		Employee Employee2 = new Employee(NEW_NAME, NEW_SALARY);
		//Assert
		assertEquals(Employee1.getNumber(), Employee2.getNumber() - Employee.COUNT_INCREASE);
	}
	
	@Test
	public void canApplySalaryIncrease1() {
		//Arrange
		int expectedSalaryIncrease = NEW_SALARY + 1000;
		//Act
		SalaryIncreaseMock salaryIncrease = new SalaryIncreaseMock();
		anEmployee.addToHistoryOfSalaryIncrease(salaryIncrease);
		//Assert
		assertEquals(expectedSalaryIncrease, anEmployee.getAnnualSalary());  	 //DONE? calcul magique Utiliser 
	}
	
	@Test
	public void canApplySalaryIncrease2() {
		//Arrange
		SalaryIncreaseMock salaryIncrease = new SalaryIncreaseMock();
		int expectedAnnualSalary = (int) (NEW_SALARY + (salaryIncrease.getSalaryIncreaseAmount(NEW_SALARY) * 2));
		//Act
		//DONE? utiliser un Fake pour le mock sinon code mal testé si toujours même salary increase amount

		anEmployee.addToHistoryOfSalaryIncrease(salaryIncrease);
		anEmployee.addToHistoryOfSalaryIncrease(salaryIncrease);	
		//Assert
		assertEquals(expectedAnnualSalary, anEmployee.getAnnualSalary());  	 //DONE? calcul magique Utiliser salaryIncrease du mock
	}
	
	@Test
	public void canGetAnnualSalaryWithNoIncrease() {
		//Arrange
		//Act
		//Assert
		assertEquals(anEmployee.getAnnualSalary(), 100000);
	}
}
