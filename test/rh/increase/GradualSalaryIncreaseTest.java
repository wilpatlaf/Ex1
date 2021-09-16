package rh.increase;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import rh.exception.IllegalMaxSalaryIncreasePercentageException;

class GradualSalaryIncreaseTest {

	private final static int NEW_SALARY = 10000;

	@Test
	public void canCreateGradualSalaryIncrease() {
		//Arrange
		GradualSalaryIncrease salaryIncrease = new GradualSalaryIncrease(0.2f);
		//Act

		//Assert
		assertTrue(salaryIncrease != null);
	}

	@Test
	public void cantExceedMaxGradualSalaryIncrease() {
		//Arrange
		float maxGradualSalaryIncreaseExcess = GradualSalaryIncrease.MAX_SALARY_INCREASE_PERCENTAGE + 0.01f;
		
		assertThrows(IllegalMaxSalaryIncreasePercentageException.class,
		() -> new GradualSalaryIncrease(maxGradualSalaryIncreaseExcess));  	 //DONE? chiffre magique: utilisation la constante de la classe testée pour le test
	}

	@Test
	public void canApplyGradualSalaryIncrease1() {
		//Arrange
		float SALARY_INCREASE_PERCENTAGE = 0.1f;
		GradualSalaryIncrease salaryIncrease = new GradualSalaryIncrease(SALARY_INCREASE_PERCENTAGE);
		float expectedIncreasedSalary = NEW_SALARY + (NEW_SALARY/4 * SALARY_INCREASE_PERCENTAGE) + (NEW_SALARY/2 * SALARY_INCREASE_PERCENTAGE);
		//Act
		float increasedSalary = NEW_SALARY + salaryIncrease.getSalaryIncreaseAmount(NEW_SALARY);
		//Assert
		 //DONE? ordre des paramètres
		assertEquals(expectedIncreasedSalary, increasedSalary);  	 //DONE? calcul magique
	}

	@Test
	public void canApplyGradualSalaryIncrease2() {
		//Arrange
		float SALARY_INCREASE_PERCENTAGE1 = 0.1f;
		float SALARY_INCREASE_PERCENTAGE2 = 0.15f;
		GradualSalaryIncrease salaryIncrease1 = new GradualSalaryIncrease(SALARY_INCREASE_PERCENTAGE1);
		GradualSalaryIncrease salaryIncrease2 = new GradualSalaryIncrease(SALARY_INCREASE_PERCENTAGE2);
		float expectedIncreasedSalary = NEW_SALARY + (NEW_SALARY/4 * SALARY_INCREASE_PERCENTAGE1) + (NEW_SALARY/2 * SALARY_INCREASE_PERCENTAGE1);
		expectedIncreasedSalary += (expectedIncreasedSalary/4 * SALARY_INCREASE_PERCENTAGE2) + (expectedIncreasedSalary/2 * SALARY_INCREASE_PERCENTAGE2);
		//Act
		float increasedSalary = NEW_SALARY + salaryIncrease1.getSalaryIncreaseAmount(NEW_SALARY);
		increasedSalary += salaryIncrease2.getSalaryIncreaseAmount(increasedSalary);
		//Assert
		//DONE? ordre des paramètres
		assertEquals(expectedIncreasedSalary, increasedSalary); 	 //DONE? calcul magique
	}

}
