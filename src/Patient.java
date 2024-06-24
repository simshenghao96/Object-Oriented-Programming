/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: {Sheng Hao}
 * Student ID: {22012312}
 * Class: {W64E}
 * Date/Time created: Tuesday 29-11-2022 22:55
 */

/**
 * @author simsh
 *
 */
public class Patient {
	
	// Fields (To check on the topic for encapsulation at the much behind lessons) 
	private String nric4;
	private String name;
	private String ward;
	private int bed;
	private String dateWarded;
	private String dateDischarged;
	private int visitorCount;
	
	// Constructor 1 
	public Patient(String nric4, String name, String ward, int bed, String dateWarded, String dateDischarged, int visitorCount) {
		this.nric4 = nric4;
		this.name = name;
		this.ward = ward;
		this.bed = bed;
		this.dateWarded = dateWarded;
		this.dateDischarged = dateDischarged;
		this.visitorCount = visitorCount;
	}
	
	// Constructor 2
	public Patient(String nric4, String name, String ward, int bed, String dateWarded) {
		this.nric4 = nric4;
		this.name = name;
		this.ward = ward;
		this.bed = bed;
		this.dateWarded = dateWarded;
		this.dateDischarged = "";
		this.visitorCount = 0;
	}
	
	// Method 1
	public String getNric4() {
		return nric4;
	}
		
	// Method 2
	public String getName() {
		return name;
	}
	
	// Method 3
	public String getWard() {
		return ward;
	}
	
	// Method 4
	public int getBed() {
		return bed;
	}
	
	// Method 5
	public String getDateWarded() {
		return dateWarded;
	}
	
	// Method 6
	public String getDateDischarged() {
		return dateDischarged;
	}
	
	// Method 7
	public void setDateDischarged(String dateDischarged) {
		this.dateDischarged = dateDischarged;
	}
	
	// Method 8
	public int getVisitorCount() {
		return visitorCount;
	}
	
	// Method 9
	public void setVisitorCount(int visitorCount) {
		this.visitorCount = visitorCount;
	}
	
	// Method 10
	public void display() {
		System.out.println("Patient Name          : " + name);
		System.out.println("Ward                  : " + ward);
		System.out.println("Bed                   : " + bed);
		System.out.println("Date warded           : " + dateWarded);
		System.out.println("Date discharged       : " + dateDischarged);
		System.out.println("No of visitor(s)      : " + visitorCount);
	}
	
	
	

}
