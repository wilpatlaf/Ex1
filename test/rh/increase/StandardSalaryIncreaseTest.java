package rh.increase;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import rh.IllegalExceedMaxSalaryIncrease;

class StandardSalaryIncreaseTest {
	
	 //FIXME voir commentaire GradualSalaryIncreaseTest
	
	private final static int NEW_SALARY = 50000;

	@Test
	public void canCreateStandardSalaryIncrease() {
		//Arrange
		StandardSalaryIncrease salaryIncrease = new StandardSalaryIncrease(0.15f);
		//Act
		
		//Assert
		assertTrue(salaryIncrease != null);
	}
	
	@Test
	public void cantExceedMaxStandardSalaryIncrease() {
		assertThrows(IllegalExceedMaxSalaryIncrease.class,
		() -> new StandardSalaryIncrease(0.16f));
	}

	@Test
	public void canApplyStandardSalaryIncrease1() {
		//Arrange
		float SALARY_INCREASE_PERCENTAGE = 0.1f;
		StandardSalaryIncrease salaryIncrease = new StandardSalaryIncrease(SALARY_INCREASE_PERCENTAGE);
		//Act
		float increasedSalary = NEW_SALARY + salaryIncrease.getSalaryIncreaseAmount(NEW_SALARY);
		//Assert
		assertEquals(increasedSalary, 55000);
	}
	
	@Test
	public void canApplyStandardSalaryIncrease2() {
		//Arrange
		float SALARY_INCREASE_PERCENTAGE1 = 0.1f;
		float SALARY_INCREASE_PERCENTAGE2 = 0.15f;
		StandardSalaryIncrease salaryIncrease1 = new StandardSalaryIncrease(SALARY_INCREASE_PERCENTAGE1);
		StandardSalaryIncrease salaryIncrease2 = new StandardSalaryIncrease(SALARY_INCREASE_PERCENTAGE2);
		//Act
		float increasedSalary = NEW_SALARY + salaryIncrease1.getSalaryIncreaseAmount(NEW_SALARY);
		increasedSalary += salaryIncrease2.getSalaryIncreaseAmount(increasedSalary);
		//Assert
		assertEquals(increasedSalary, 63250);
	}

}
