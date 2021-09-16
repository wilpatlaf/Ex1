package rh.increase;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import rh.IllegalExceedMaxSalaryIncrease;

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
		assertThrows(IllegalExceedMaxSalaryIncrease.class,
		() -> new GradualSalaryIncrease(0.21f));  	 //FIXME chiffre magique: utilisation la constante de la classe testée pour le test
	}

	@Test
	public void canApplyGradualSalaryIncrease1() {
		//Arrange
		float SALARY_INCREASE_PERCENTAGE = 0.1f;
		GradualSalaryIncrease salaryIncrease = new GradualSalaryIncrease(SALARY_INCREASE_PERCENTAGE);
		//Act
		float increasedSalary = NEW_SALARY + salaryIncrease.getSalaryIncreaseAmount(NEW_SALARY);
		//Assert
		 //FIXME ordre des paramètres
		assertEquals(increasedSalary, 10750);  	 //FIXME calcul magique
	}

	@Test
	public void canApplyStandardSalaryIncrease2() {
		//Arrange
		float SALARY_INCREASE_PERCENTAGE1 = 0.1f;
		float SALARY_INCREASE_PERCENTAGE2 = 0.15f;
		GradualSalaryIncrease salaryIncrease1 = new GradualSalaryIncrease(SALARY_INCREASE_PERCENTAGE1);
		GradualSalaryIncrease salaryIncrease2 = new GradualSalaryIncrease(SALARY_INCREASE_PERCENTAGE2);
		//Act
		float increasedSalary = NEW_SALARY + salaryIncrease1.getSalaryIncreaseAmount(NEW_SALARY);
		increasedSalary += salaryIncrease2.getSalaryIncreaseAmount(increasedSalary);
		//Assert
		//FIXME ordre des paramètres
		assertEquals(increasedSalary, 11959.375); 	 //FIXME calcul magique
	}

}
