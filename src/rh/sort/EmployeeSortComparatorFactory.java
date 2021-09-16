package rh.sort;

import java.util.Comparator;

import rh.Employee;

public class EmployeeSortComparatorFactory {
	
	public enum ComparatorType{
		BY_NAME, BY_SALARY, BY_NUMBER
	}
	
	public Comparator<Employee> giveMeStrategyToCompareEmployee<Employee>(SortcomparatorType type){
		Comparator<Employee> sortComparator;
		
		switch(type) {
		case BY_NAME;
		break;
		case BY_SALARY;
		break;
		case BY_NUMBER;
		sortComparator = new SortingByNumberComparator();
		break;
		}
		return sortComparator;
	}
}
