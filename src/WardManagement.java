import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Sim Sheng Hao		
 * Student ID: 22012312
 * Class: W64E
 * Date/Time Last modified: Friday 03-02-2023 01:27
 */


public class WardManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// (** Advanced Functionality **) --> Initialization of revenue array with the month name and number
		Revenue[] revenueArr = new Revenue[12];
		revenueArr[0] = new Revenue("January" ,1);
		revenueArr[1] = new Revenue("February", 2);
		revenueArr[2] = new Revenue("March", 3);
		revenueArr[3] = new Revenue("April", 4);
		revenueArr[4] = new Revenue("May", 5);
		revenueArr[5] = new Revenue("June", 6);
		revenueArr[6] = new Revenue("July", 7);
		revenueArr[7] = new Revenue("August", 8);
		revenueArr[8] = new Revenue("September", 9);
		revenueArr[9] = new Revenue("October", 10);
		revenueArr[10] = new Revenue("November", 11);
		revenueArr[11] = new Revenue("December", 12);


		//initialise Ward array with ward objects 
		Ward[] wardArr = new Ward[4];

		//-------------------
		// Complete code here
		wardArr[0] = new Ward("A", "1 Bed, attached bath/toilet", 10, 535.00);
		wardArr[1] = new Ward("B1", "4 Bed, attached bath/toilet", 20, 266.43);
		wardArr[2] = new Ward("B2", "6 Bed, common bath/toilet", 20, 83.00);
		wardArr[3] = new Ward("C", "8 Bed, common bath/toilet", 50, 37.00);
		//-------------------



		//initialise Patient arraylist with patient objects	
		ArrayList<Patient> patientList = new ArrayList<Patient>();

		//-------------------
		// Complete code here
		Patient p1 = new Patient("111A", "John Lee", "A", 2, "01/12/2022");
		Patient p2 = new Patient("222B", "Mary Jane", "B1", 11, "02/12/2022");
		Patient p3 = new Patient("333C", "Abdul Musri", "B1", 12, "03/12/2022");
		Patient p4 = new Patient("444D", "Jane Tan", "B2", 2, "12/12/2022", "", 3);
		Patient p5 = new Patient("555E", "Paul Tan", "C", 2, "02/11/2022", "", 4);
		Patient p6 = new Patient("666F", "Paul Ng", "C", 3, "03/11/2022", "09/11/2022", 0);
		Patient p7 = new Patient("777G", "Wong Kuan", "C", 4, "02/12/2022");

		patientList.add(p1);
		patientList.add(p2);
		patientList.add(p3);
		patientList.add(p4);
		patientList.add(p5);
		patientList.add(p6);
		patientList.add(p7);
		//-------------------



		//display standard menu and ask for option
		int option = -99;
		publicMenu();


		//indefinite while loop
		while(option != 10) {
			boolean patientfound = true;
			option = Helper.readInt("\nEnter option or 0 for main menu > ");

			//check for  options
			if(option == 0) {
				//display main menu
				publicMenu();
			} else if (option == 1) {
				//list ward info
				displayWardInfo(wardArr);		
			} else if (option == 2) {
				//display patient in ward
				displayPatientList(patientList);
			} else if (option == 3) {
				//admit patient
				admitPatient(patientList);
			} else if (option == 4) {
				//discharged patient
				patientfound = dischargePatient(patientList);
			} else if (option == 5) {
				//Remove patient visit
				patientfound = removePatient(patientList);
			} else if (option == 6) {
				//register visit
				patientfound = registerVisit(patientList);
			} else if (option == 7) {
				//End visit
				patientfound = endVisit(patientList);
			} else if (option == 8) {
				//End visit
				displayWardOverview(patientList, wardArr);
			} else if (option == 9) { 
				// Enhancement option (Advanced Functionality)
				revenueCalculation(patientList, wardArr, revenueArr); // Enhancement option reference
			} else if (option == 10) { 
				//log out
				System.out.println("\nGood bye!");
			} else {
				//invalid option chosen
				System.out.println("\n*** Invalid option selected ***\n");
			}

			//if patient does not exist based on return boolean
			if (!patientfound) {
				System.out.println("\n*** No such patient in ward ***\n");
			}

		}

	} // end of main





	//-------------------------------------------------------------------------------------------------------
	//static method to print the standard menu 
	//-------------------------------------------------------------------------------------------------------
	public static void publicMenu() {
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*****     PATIENT  MANAGEMENT  MENU     *****");
		Helper.line(45, "*");

		//-------------------
		// Complete code here
		// Doing the menu printing
		System.out.println("1. View all Ward Info");
		System.out.println("2. Display Patient List");
		System.out.println("3. Admit Patient");
		System.out.println("4. Discharge Patient");
		System.out.println("5. Remove Patient");
		System.out.println("6. Register Visit");
		System.out.println("7. End Visit");
		System.out.println("8. Display Ward Overview");
		System.out.println("9. Revenue earned by hospital");		
		System.out.println("10. Logout");
		//-------------------

	}



	//-------------------------------------------------------------------------------------------------------
	//static method takes in a ward array and list out ward details in a tabular list
	//-------------------------------------------------------------------------------------------------------
	public static void displayWardInfo(Ward[] wardArr) {

		//-------------------
		// Complete code here
		String wardInfo = "";
		
		wardInfo += String.format("%-5s %-28s %-13s %-8s \n", "Ward", "Description", "Bed Count", "Bed Charge");
		for (int i = 0; i < wardArr.length; i++) {
			wardInfo += String.format("%-5s %-28s %-13d %-10.2f \n", wardArr[i].getWard(), wardArr[i].getDescription(), wardArr[i].getBedCount(), wardArr[i].getBedCharge());
		}
		System.out.println(wardInfo);
		//-------------------

	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and display all the patient information in a tabular list
	//-------------------------------------------------------------------------------------------------------
	public static void displayPatientList(ArrayList<Patient> patientList) {

		//-------------------
		// Complete code here
		
		System.out.println(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %19s", "NRIC4", "Name", "Ward", "Bed", "Date warded", "Date discharged", "Visitor count"));
		for (int i = 0; i < patientList.size(); i++) {
			System.out.println(String.format("%-15s %-15s %-15s %-15d %-15s %-15s %7d", patientList.get(i).getNric4(), patientList.get(i).getName(), patientList.get(i).getWard(), patientList.get(i).getBed(), patientList.get(i).getDateWarded(), patientList.get(i).getDateDischarged(), patientList.get(i).getVisitorCount()));
		}
		//-------------------

	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the admit patient functionality
	//-------------------------------------------------------------------------------------------------------
	public static void admitPatient(ArrayList<Patient> patientList) {

		//-------------------
		// Complete code here
		String nric = Helper.readString("Enter patient 4 digit NRIC > "); // Requesting for the user input of the new patient for their NRIC
		String patientName = Helper.readString("Enter patient name > "); // Requesting for the user input of the new patient for their name
		String ward = Helper.readString("Enter ward > "); // Requesting for the user input of the new patient for their Ward
		int bed = Helper.readInt("Enter bed > "); // Requesting for the user input of the new patient for their bed number
		String dateWarded = Helper.readString("Enter date warded > "); // Requesting for the user input of the new patient for their ward date
		System.out.println();
		patientList.add(new Patient(nric, patientName, ward, bed, dateWarded)); // Adding the new patient object into the patientList based on the inputs above
		for (int i = 0; i < patientList.size(); i++) { // Iterating through the patientList to display the new patient added upon successful adding 
			if (patientList.get(i).getName().equalsIgnoreCase(patientName)) {
				patientList.get(i).display();
				System.out.println("\n*** Patient has been added ***");
			}
		}
		//-------------------

	}



	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the discharge patient functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean dischargePatient(ArrayList<Patient> patientList) {

		boolean patientfound = false;

		//-------------------
		// Complete code here
		String patientName = Helper.readString("Enter patient name > ");
		for (int i = 0; i < patientList.size(); i++) {
			if(patientList.get(i).getName().equalsIgnoreCase(patientName) == true) { // Checking if the name in the patient list matches the patientName input variable
				if (patientList.get(i).getDateDischarged().equalsIgnoreCase("") == false) { // Checking if the discharged date is empty 
					patientfound = true;
					System.out.println("\n*** Patient has already been discharged ***\n");
				}
				else if (patientList.get(i).getDateDischarged().equalsIgnoreCase("") == true){ // Checking if the discharged date is empty 
					System.out.println();
					patientList.get(i).display();
					System.out.println();
					String discharge = Helper.readString("Enter date discharged > ");
					patientList.get(i).setDateDischarged(discharge);
					patientList.get(i).setVisitorCount(0);
					patientfound = true;
					System.out.println("\n*** Patient is discharged ***\n");
				}
			}
		}
		//-------------------

		return patientfound;

	}




	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the remove patient functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean removePatient(ArrayList<Patient> patientList) {

		boolean patientfound = false;

		//-------------------
		// Complete code here
		String patientName = Helper.readString("Enter patient name > ");
		for (int i = 0; i < patientList.size(); i++) {
			if(patientList.get(i).getName().equalsIgnoreCase(patientName) == true) { // Checking if the name in the patient list matches the patientName input variable
				System.out.println();
				patientList.get(i).display();
				System.out.println();
				char deletion = Helper.readChar("Confirm deletion (y/n) > ");
				if (deletion == 'y') {
					patientList.remove(i);
					patientfound = true;
					System.out.println("\n*** Patient has been deleted ***");
				}
				else {
					patientfound = true;
					System.out.println();
				}
			}
		}
		//-------------------

		return patientfound;
	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the register visit functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean registerVisit(ArrayList<Patient> patientList) {

		boolean patientfound = false;

		//-------------------
		// Complete code here
		String patientName = Helper.readString("Enter patient name > ");
		for (int i = 0; i < patientList.size(); i++) {
			if(patientList.get(i).getName().equalsIgnoreCase(patientName) == true) { // Checking if the name in the patient list matches the patientName input variable
				int visitorsAllowed = 4 - patientList.get(i).getVisitorCount();
				if (patientList.get(i).getDateDischarged().equalsIgnoreCase("") == false) { // Checking if the discharged date is empty 
					patientfound = true;
					System.out.println();
					patientList.get(i).display();
					System.out.println("\n*** Patient has been discharged ***");
				}
				else if (visitorsAllowed > 0) { // Checking the visitors allowed 
					System.out.println();
					patientList.get(i).display();
					System.out.println(String.format("\n*** Only %d visitor(s) allowed ***\n", visitorsAllowed));
					System.out.println();
					int visitors = Helper.readInt("Enter number of new visitors > ");
					int totalvisitors = patientList.get(i).getVisitorCount() + visitors;
					patientfound = true;
					if (totalvisitors > 4) {
						patientfound = true;
						System.out.println("\n*** Visitors exceeded ***");
					}
					else {
						patientfound = true;
						patientList.get(i).setVisitorCount(totalvisitors);
						System.out.println("\n*** Please proceed to ward ***");
					}
				}
				else if (visitorsAllowed == 0) { // Checking the visitors allowed 
					System.out.println();
					patientList.get(i).display();
					patientfound = true;
					System.out.println("\n*** No additional visitor allowed ***");
				}
			}
		}
		//-------------------
		return patientfound;
	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the end visit functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean endVisit(ArrayList<Patient> patientList) {

		boolean patientfound = false;

		//-------------------
		// Complete code here
		String patientName = Helper.readString("Enter patient name > ");
		for (int i = 0; i < patientList.size(); i++) {
			if(patientList.get(i).getName().equalsIgnoreCase(patientName) == true) { // Checking if the name in the patient list matches the patientName input variable
				if (patientList.get(i).getDateDischarged().equalsIgnoreCase("") == false) { // Checking if the discharged date is empty 
					patientfound = true;
					System.out.println();
					patientList.get(i).display();
					System.out.println("\n*** Patient has been discharged ***");
				}
				else {
					patientList.get(i).display();
					System.out.println();
					int visitorsLeaving = Helper.readInt("Enter number of visitor(s) leaving > ");
					int remainingVisitor = patientList.get(i).getVisitorCount() - visitorsLeaving;
					if (visitorsLeaving < patientList.get(i).getVisitorCount()) {
						System.out.println();
						patientfound = true;
						patientList.get(i).setVisitorCount(remainingVisitor);
						System.out.println(String.format("*** No of visitor(s) still at ward : %d ***", remainingVisitor));
					}
					else {
						patientfound = true;
						System.out.println("*** Visitors(s) leaving is more than visited ***");
					}
				}
			}
		}
		//-------------------
		return patientfound;
	}



	//------------------------------------------------------------------------------------------------------------
	//static method that takes in a patient arraylist, a ward array and display an overview of the ward information
	//------------------------------------------------------------------------------------------------------------
	public static void displayWardOverview (ArrayList<Patient> patientList, Ward[] wardArr) {

		//-------------------
		// Complete code here
		int bedTotal = 0; // Total Bed Counter for ALL wards
		int patientTotal = 0; // Total Patient Counter for ALL wards
		int visitorTotal = 0; // Total Visitor Counter for ALL wards
		String output = ""; // Initialized output variable to perform concatenation

		output += String.format("%-20s %-30s %-15s %-15s %-15s\n", "Ward", "Description", "Bed Count", "Patients", "Visitors");
		for(int i = 0; i < wardArr.length; i++) {
			int patientCounter = 0; // patientCounter is to do a count of current number of patients in each ward by iteration
			int visitorCounter = 0; // visitorCounter is to do a count of current number of visitors are there in each ward by iteration
			bedTotal += wardArr[i].getBedCount(); // Computing the total bed count from all the wards by doing a sum by iteration

			for(int k = 0; k < patientList.size(); k++) {
				if(patientList.get(k).getWard().equals(wardArr[i].getWard())) { // Do a check for patients being discharged
					patientCounter++;
					visitorCounter += patientList.get(k).getVisitorCount(); // Adding the visitor count to the visitor counter based on the patient's ward and 

					if(!patientList.get(k).getDateDischarged().equalsIgnoreCase("")) { // If patient is being discharged, the patient Counter will decrease by one as it should be excluded
						patientCounter--;
					}
				}
			}
			patientTotal += patientCounter; // Total Patient Counter to get the total sum of all patients from all wards
			visitorTotal += visitorCounter; // Total Visitor Counter to get the total sum of all visitors from all wards
			output += String.format("%-20s %-30s %-15d %-15d %-15d\n", wardArr[i].getWard(), wardArr[i].getDescription(), wardArr[i].getBedCount(), patientCounter, visitorCounter);
		}
		output += String.format("\n%-20s %-30s %-15d %-15d %-15d\n", "Total:", "", bedTotal, patientTotal, visitorTotal);
		System.out.println(output); // Printing out the concatenated output String variable
		//-------------------

	}

	// Advanced Functionality (Revenue calculation for patients / Date format validation check)
	public static void revenueCalculation(ArrayList<Patient> patientList, Ward[] wardArr, Revenue[] revenueArr) {

		Helper.line(60, "=");
		System.out.println("********************* HOSPITAL REVENUE *********************");
		Helper.line(60, "=");
		String output = ""; // Initializing output variable do perform string concatenation
		double Yearly_revenue = 0.0; // Total revenue for the whole year counter
		output += String.format("%-15s %36s", "Month", "Revenue Earned"); 
		for(int i = 0; i < wardArr.length; i++) {
			for(int k = 0; k < patientList.size(); k++) {
				if(patientList.get(k).getWard().equalsIgnoreCase(wardArr[i].getWard())) { // Looping through to check for the patient's ward and do necessary amendments
					if (!patientList.get(k).getDateDischarged().equalsIgnoreCase("")) { // To check if patient is discharged or not
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // This line is to format the date into the format being placed inside the argument 
						String startDate = patientList.get(k).getDateWarded(); // To obtain the date warded for all the patients
						String endDate = patientList.get(k).getDateDischarged(); // To obtain the date discharged for all the patients (if Applicable)
						LocalDate formattedStartDate = LocalDate.parse(startDate, formatter); // To format the start date of the patient from the String datatype in the user input into LocalDate datatype with the time format being set in the formatter
						LocalDate formattedEndDate = LocalDate.parse(endDate, formatter); // To format the end date of the patient from the String datatype in the user input into LocalDate datatype with the time format being set in the formatter
						int stayLength = formattedEndDate.getDayOfYear() - formattedStartDate.getDayOfYear(); // To obtain the length of patient's stay
						double amountEarned = stayLength * wardArr[i].getBedCharge(); // To compute the amount of money the patient has to pay based on the length of their stay and ward cost
						Yearly_revenue += amountEarned; // To compute the yearly revenue by adding the amount the patient pay for the whole year
						double monthly_revenue = 0.0; // Revenue counter by month 
						for (int j = 0; j < revenueArr.length; j++) {
							if (formattedEndDate.getMonthValue() == revenueArr[j].getMonthValue()) { // Checking the 
								monthly_revenue += amountEarned; // Storing the amount earned by month into this variable
								revenueArr[j].setRevenue(monthly_revenue); // Setting the revenue to the monthly_revenue counter after getting the 
								output += String.format("\n%-15s %27s", revenueArr[j].getMonthName(), revenueArr[j].getRevenue());
							}
						}
					}
				}
			}	
		}
		output += String.format("\n%-15s %-30s", "Total Revenue earned for whole year: ", Yearly_revenue);
		System.out.println(output); // Printing out the concatenated output String variable
	}


}