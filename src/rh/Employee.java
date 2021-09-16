package rh;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	 //FIXME ordre des déclarations: static d'abord, d'instance ensuite
	private String name;
	private int number;
	private int annualSalary;   //FIXME inutile - redondance - à supprimer
	private int defaultAnnualSalary;
	private final int MaxAnnualSalary = 100000;   //FIXME static + NOM_MAJUSCULES  	 //FIXME publique pour utilisation dans les tests
	private static final int countIncrease = 10;   //FIXME NOM_MAJUSCULES
	private static int count;
	
	private List<SalaryIncrease> historyOfSalaryIncrease;
	

	public Employee(String name, int salary) {
		this.name = name;
		this.setNumber(count);
		this.setAnnualSalary(salary);
		 //FIXME cohérence: this
		defaultAnnualSalary = annualSalary;
		historyOfSalaryIncrease = new ArrayList<SalaryIncrease>();
	}
	
	 //FIXME nommage increaseCountQuoi?
	private void increaseCount() {
		count += countIncrease;
	}
	
	 //FIXME nommage getCountQuoi?
	public static int getCount() {
		return count;
	}
	
	public static int get_countIncrease() {   //FIXME si static et final, peut être public. Donc pas besoin de cette méthode
		return countIncrease;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return this.number;
	}

	 //FIXME privée
	public void setNumber(int number) {
		increaseCount();
		this.number = count;

	}

	public int getAnnualSalary() {
		applySalaryIncrease();
		return this.annualSalary;
	}

	private void setAnnualSalary(int salary) {
		validateAnnualSalary(salary);
		this.annualSalary = salary;
	}
	
	public void addToHistoryOfSalaryIncrease(SalaryIncrease standardSalaryIncrease) {
		this.historyOfSalaryIncrease.add(standardSalaryIncrease);
	}
	
	 //FIXME privée! Quel service est offert ici?
	public void applySalaryIncrease() {
		annualSalary = defaultAnnualSalary;
		for (SalaryIncrease standardSalaryIncrease : historyOfSalaryIncrease) {
			annualSalary += standardSalaryIncrease.getSalaryIncreaseAmount(annualSalary);
		}
	}
	
	private void validateAnnualSalary(int salary) {
		if(salary > MaxAnnualSalary)throw new IllegalInitializeAnnualSalaryException();
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", number=" + number + ", annual salary=" + getAnnualSalary() + "]";
	}



}
