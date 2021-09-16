package rh.increase;

import rh.IllegalExceedMaxSalaryIncrease;
import rh.SalaryIncrease;

public class StandardSalaryIncrease implements SalaryIncrease {
	private float salaryIncreasePercentage;
	private final float maxSalaryIncreasePercentage = 0.15f;
	
	public StandardSalaryIncrease(float salaryIncreasePercentage) {
		validateSalaryIncreasePercentage(salaryIncreasePercentage);
		this.salaryIncreasePercentage = salaryIncreasePercentage;
	}

	@Override
	public float getSalaryIncreaseAmount(float currentSalary) {
		return currentSalary * salaryIncreasePercentage;
	}	
	
	private void validateSalaryIncreasePercentage(float salaryIncreasePercentage) {
		if(salaryIncreasePercentage > maxSalaryIncreasePercentage)throw new IllegalExceedMaxSalaryIncrease();
	}
	
	
}
