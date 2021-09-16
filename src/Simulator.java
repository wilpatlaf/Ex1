import java.util.ArrayList;
import java.util.List;

import rh.Employee;
import rh.SalaryIncrease;
import rh.increase.GradualSalaryIncrease;
import rh.increase.StandardSalaryIncrease;

public class Simulator {

	public static void main(String[] args) {
		new Simulator();
	}
	
	private List<Employee> ListOfEmployee;
	
	public Simulator() {
		System.out.println("STRATEGY PATTERN et POLYMORPHISEME ***********");
		this.seedData();
		this.printData("Employés avant les augmentations");
		this.applySalaryIncrease();
		this.printData("Employés après les augmentations");
	}
	
	private void sortByNumber() {
		//Comparator<Employee> byNumber = new SortingByNumberComparator();
		EmployeeSortComparatorFactory myFactory = new EmployeeSortComparatorFactory(EmployeeComparatorType.BY_NUMBER);
		
		this.ListOfEmployee.sort(null);
	}
	
	private void seedData() {
		this.ListOfEmployee = new ArrayList<Employee>();
		
		Employee employee1 = new Employee("Ei", 50000);
		Employee employee2 = new Employee("Venti", 50000);
		
		
		this.ListOfEmployee.add(new Employee("Jean", 50000));
		this.ListOfEmployee.add(new Employee("Diluc", 1000));
		this.ListOfEmployee.add(new Employee("Kaeya", 1000));
		
		this.ListOfEmployee.add(employee2);
		
		this.ListOfEmployee.add(new Employee("Lisa", 23000));
		this.ListOfEmployee.add(new Employee("Amber", 15000));
		
		this.ListOfEmployee.add(employee1);
		
		this.ListOfEmployee.add(new Employee("Nemu", 52000));
		
	}

	private void applySalaryIncrease() {
		int counter = 0;
		for(Employee employee : ListOfEmployee) {
			SalaryIncrease increase;
			if (counter % 2 == 0) {
				increase = new StandardSalaryIncrease(.1f);
			}
			else {
				increase = new GradualSalaryIncrease(.1f);
			}
			employee.addToHistoryOfSalaryIncrease(increase);
			counter++;
		}
	}

	private void printData(String string) {
		for (Employee employee : ListOfEmployee) {
			System.out.println(employee.toString());
		}
		
	}



}
