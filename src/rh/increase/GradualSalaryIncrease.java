package rh.increase;

import rh.IllegalExceedMaxSalaryIncrease;
import rh.SalaryIncrease;

public class GradualSalaryIncrease implements SalaryIncrease{
	 //FIXME ordre déclaration: static en 1er
	private float salaryIncreasePercentage;
	 //FIXME static + NOM_MAJUSCULES
	private final float maxSalaryIncreasePercentage = 0.20f;
	
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
		 //FIXME pas la bonne exception levée!!
		if(salaryIncreasePercentage > maxSalaryIncreasePercentage)throw new IllegalExceedMaxSalaryIncrease();
	}

}
