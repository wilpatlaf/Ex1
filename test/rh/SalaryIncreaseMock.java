package rh;

public class SalaryIncreaseMock implements SalaryIncrease {
	
	public static final int salaryIncrease = 1000;  	 //DONE?/ c'est un Stub. Donc static final et public pour utilisation dans les tests
	
	public SalaryIncreaseMock() {
	}

	@Override
	public float getSalaryIncreaseAmount(float salaryIncreaseAmount) {
		return salaryIncrease;
	}

}
