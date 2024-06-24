/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: {Sheng Hao}
 * Student ID: {22012312}
 * Class: {W64E}
 * Date/Time created: Tuesday 29-11-2022 22:49
 */

/**
 * @author simsh
 *
 */
public class Ward {
	
	private String ward;
	private String description;
	private int bedCount;
	private double bedCharge;
	
	// Constructor
	public Ward(String ward, String description, int bedCount, double bedCharge) {
		this.ward = ward;
		this.description = description;
		this.bedCount = bedCount;
		this.bedCharge = bedCharge;
	}
	
	// 1st Method
	public String getWard() {
		return ward;
	}
	
	// 2nd Method
	public String getDescription() {
		return description;
	}
	
	// 3rd Method
	public int getBedCount() {
		return bedCount;
	}
	
	// 4th Method
	public double getBedCharge() {
		return bedCharge;
	}
	
}
