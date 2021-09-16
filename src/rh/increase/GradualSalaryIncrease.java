package rh.increase;

import rh.SalaryIncrease;
import rh.exception.IllegalMaxSalaryIncreasePercentageException;

public class GradualSalaryIncrease implements SalaryIncrease{
	static final float MAX_SALARY_INCREASE_PERCENTAGE = 0.20f;
	 //DONE? ordre déclaration: static en 1er
	private float salaryIncreasePercentage;
	 //DONE? static + NOM_MAJUSCULES

	
	public GradualSalaryIncrease(float salaryIncreasePercentage) {
		validateSalaryIncreasePercentage(salaryIncreasePercentage);
		this.salaryIncreasePercentage = salaryIncreasePercentage;
	}

	@Override
	public float getSalaryIncreaseAmount(float currentSalary) {
		float firstSalaryIncreaseAmount = (currentSalary / 2) * (salaryIncreasePercentage / 2);
		float secondSalaryIncreaseAmount = (currentSalary / 2) * salaryIncreasePercentage;
		return firstSalaryIncreaseAmount + secondSalaryIncreaseAmount;
	}	
	
	private void validateSalaryIncreasePercentage(float salaryIncreasePercentage) {
		 //DONE? pas la bonne exception levée!!
		if(salaryIncreasePercentage > MAX_SALARY_INCREASE_PERCENTAGE)throw new IllegalMaxSalaryIncreasePercentageException();
	}

}
