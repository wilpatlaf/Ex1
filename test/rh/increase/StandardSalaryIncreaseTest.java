package rh.increase;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;
import rh.exception.IllegalMaxSalaryIncreasePercentageException;

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
		//Arrange
		float maxGradualSalaryIncreaseExcess = StandardSalaryIncrease.MAX_SALARY_INCREASE_PERCENTAGE + 0.01f;
		
		assertThrows(IllegalMaxSalaryIncreasePercentageException.class,
		() -> new StandardSalaryIncrease(maxGradualSalaryIncreaseExcess));
	}

	@Test
	public void canApplyStandardSalaryIncrease1() {
		//Arrange
		float SALARY_INCREASE_PERCENTAGE = 0.1f;
		StandardSalaryIncrease salaryIncrease = new StandardSalaryIncrease(SALARY_INCREASE_PERCENTAGE);
		int expectedIncreasedSalary = (int) (NEW_SALARY + (NEW_SALARY * SALARY_INCREASE_PERCENTAGE));
		//Act
		float increasedSalary = NEW_SALARY + salaryIncrease.getSalaryIncreaseAmount(NEW_SALARY);
		//Assert
		assertEquals(expectedIncreasedSalary, increasedSalary);
	}
	
	@Test
	public void canApplyStandardSalaryIncrease2() {
		//Arrange
		float SALARY_INCREASE_PERCENTAGE1 = 0.1f;
		float SALARY_INCREASE_PERCENTAGE2 = 0.15f;
		StandardSalaryIncrease salaryIncrease1 = new StandardSalaryIncrease(SALARY_INCREASE_PERCENTAGE1);
		StandardSalaryIncrease salaryIncrease2 = new StandardSalaryIncrease(SALARY_INCREASE_PERCENTAGE2);
		float expectedIncreasedSalary = NEW_SALARY + (NEW_SALARY * SALARY_INCREASE_PERCENTAGE1); 
		expectedIncreasedSalary += (expectedIncreasedSalary * SALARY_INCREASE_PERCENTAGE2);
		//Act
		float increasedSalary = NEW_SALARY + salaryIncrease1.getSalaryIncreaseAmount(NEW_SALARY);
		increasedSalary += salaryIncrease2.getSalaryIncreaseAmount(increasedSalary);
		//Assert
		assertEquals(expectedIncreasedSalary, increasedSalary);
	}

}
