package rh.increase;

import rh.SalaryIncrease;
import rh.exception.IllegalMaxSalaryIncreasePercentageException;

public class StandardSalaryIncrease implements SalaryIncrease {
	static final float MAX_SALARY_INCREASE_PERCENTAGE = 0.15f;
	private float salaryIncreasePercentage;

	
	public StandardSalaryIncrease(float salaryIncreasePercentage) {
		validateSalaryIncreasePercentage(salaryIncreasePercentage);
		this.salaryIncreasePercentage = salaryIncreasePercentage;
	}

	@Override
	public float getSalaryIncreaseAmount(float currentSalary) {
		return currentSalary * salaryIncreasePercentage;
	}	
	
	private void validateSalaryIncreasePercentage(float salaryIncreasePercentage) {
		if(salaryIncreasePercentage > MAX_SALARY_INCREASE_PERCENTAGE)throw new IllegalMaxSalaryIncreasePercentageException();
	}
	
	
}
