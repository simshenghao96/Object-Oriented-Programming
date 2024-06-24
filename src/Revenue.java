/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: {Sheng Hao}
 * Student ID: {22012312}
 * Class: {W64E}
 * Date/Time created: Thursday 02-02-2023 00:07
 */

/**
 * @author simsh
 *
 */
// C208 Graded Assignment (ESE)
// Advanced Functionality 
public class Revenue {
	
	private String monthName;
	private int monthValue;
	private int year;
	private double revenue;
	
	public Revenue(String monthName, int monthValue, int year, double revenue) {
		this.monthName = monthName;
		this.monthValue = monthValue;
		this.year = year;
		this.revenue = revenue;
	}
	public Revenue(String monthName, int monthValue) {
		this.monthName = monthName;
		this.monthValue = monthValue;
		this.year = 2022;
		this.revenue = 0.0;
	}
	
	public String getMonthName() {
		return monthName;
	}
	
	public int getMonthValue() {
		return monthValue;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	
}
