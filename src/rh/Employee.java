package rh;

import java.util.ArrayList;
import java.util.List;

import rh.exception.IllegalInitializeAnnualSalaryException;

public class Employee {
	 //DONE? ordre des déclarations: static d'abord, d'instance ensuite
	static final int COUNT_INCREASE = 10;   //DONE? NOM_MAJUSCULES
	private static int count;
	static final int MAX_ANNUAL_SALARY = 100000;   //DONE? static + NOM_MAJUSCULES  	 //DONE? publique pour utilisation dans les tests
	
	private String name;
	private int number;
	private int defaultAnnualSalary;	
	private List<SalaryIncrease> historyOfSalaryIncrease;
	

	public Employee(String name, int salary) {
		this.name = name;
		setNumber(count);
		setAnnualSalary(salary);
		 //DONE? cohérence: this
		historyOfSalaryIncrease = new ArrayList<SalaryIncrease>();
	}
	
	 //DONE? nommage increaseCountQuoi?
	private void increaseCountNumber() {
		count += COUNT_INCREASE;
	}
	
	 //DONE? nommage getCountQuoi?
	public static int getCountNumber() {
		return count;
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

	 //DONE? privée
	private void setNumber(int number) {
		increaseCountNumber();
		this.number = count;

	}

	public int getAnnualSalary() {
		int increasedSalary = defaultAnnualSalary;
		for (SalaryIncrease standardSalaryIncrease : historyOfSalaryIncrease) {
			increasedSalary += standardSalaryIncrease.getSalaryIncreaseAmount(defaultAnnualSalary);
		}
		return increasedSalary;
	}

	private void setAnnualSalary(int salary) {
		validateAnnualSalary(salary);
		this.defaultAnnualSalary = salary;
	}
	
	public void addToHistoryOfSalaryIncrease(SalaryIncrease standardSalaryIncrease) {
		this.historyOfSalaryIncrease.add(standardSalaryIncrease);
	}
	
	private void validateAnnualSalary(int salary) {
		if(salary > MAX_ANNUAL_SALARY)throw new IllegalInitializeAnnualSalaryException();
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", number=" + number + ", annual salary=" + getAnnualSalary() + "]";
	}



}
