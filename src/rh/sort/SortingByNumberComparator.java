package rh.sort;

import.java.util.Comparator;

import.rh.Employee;


public class SortingByNumberComparator implements Comparator<Employee>{
	
	
	@Override
	public int compare(Employee employee1, Employee employee2) {
		Integer employee1Number = Integer.valueOf(employee1.getNumber());
		Integer employee2Number = Integer.valueOf(employee2.getNumber());
		return employee1Number.compareTo(employee2Number);
	}
	
	
	
}
