package rh;

import static org.junit.Assert.assertThrows;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
		assertEquals(Employee.getCount(), anEmployee.getNumber());
	}
	
	@Test
	public void createEmployeeShouldNotInitializeAnnualSalaryIfAnnualSalaryExceedsMaxAnnualSalary() {

		assertThrows(IllegalInitializeAnnualSalaryException.class,
		() -> new Employee(NEW_NAME, NEW_SALARY + 1));  	 //DONE? chiffre magique
	}
	
	@Test
	public void create2EmployeesShouldBeSpacedByCountIncrease() {
		//Act
		Employee Employee1 = new Employee(NEW_NAME, NEW_SALARY);
		Employee Employee2 = new Employee(NEW_NAME, NEW_SALARY);
		//Assert
		assertEquals(Employee1.getNumber(), Employee2.getNumber() - Employee.get_countIncrease());
	}
	
	@Test
	public void canApplySalaryIncrease1() {
		//Arrange
		
		//Act
		SalaryIncreaseMock salaryIncrease = new SalaryIncreaseMock();
		anEmployee.addToHistoryOfSalaryIncrease(salaryIncrease);
		anEmployee.applySalaryIncrease();
		//Assert
		assertEquals(anEmployee.getAnnualSalary(), 101000);  	 //FIXME calcul magique Utiliser 
	}
	
	@Test
	public void canApplySalaryIncrease2() {
		//Arrange
		//Act
		//FIXME utiliser un Fake pour le mock sinon code mal testé si toujours même salary increase amount
		SalaryIncreaseMock salaryIncrease = new SalaryIncreaseMock();
		anEmployee.addToHistoryOfSalaryIncrease(salaryIncrease);
		anEmployee.addToHistoryOfSalaryIncrease(salaryIncrease);	
		//Assert
		assertEquals(anEmployee.getAnnualSalary(), 102000);  	 //FIXME calcul magique Utiliser salaryIncrease du mock
	}
	
	@Test
	public void canGetAnnualSalaryWithNoIncrease() {
		//Arrange
		//Act
		//Assert
		assertEquals(anEmployee.getAnnualSalary(), 100000);
	}
}
