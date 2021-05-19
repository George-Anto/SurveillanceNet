import java.util.ArrayList;

public class Registry {
	
	//Δημιουργία λιστών για υπόπτους και επικοινωνίες.
	private ArrayList<Suspect> listOfSuspects;
	private ArrayList<Communication> Communications;
	
	public Registry() {
		this.listOfSuspects = new ArrayList<Suspect>();
		this.Communications = new ArrayList<Communication>();
	}
	
	public void addSuspect(Suspect aSuspect) {
		listOfSuspects.add(aSuspect);
	}
	
	public void addCommunication(Communication aCommunication) {
		Communications.add(aCommunication);
		//Εξετάζουμε να βρούμε σε ποιους υπόπτους ανήκουν τα τηλέφωνα που καταχωρήαμε 
		//στην λίστα με τις επικοινωνίες για να τους κάνουμε συνεργάτες χρησιμοποιόντας 
		//την μέθοδο partnership της κλάσης Suspect. 
		for(Suspect suspect1: listOfSuspects) {
			for(String phone1: suspect1.getPhoneNumbers()) {
				if(phone1.equals(aCommunication.phoneNumber1)) {
					for(Suspect suspect2: listOfSuspects) {
						for(String phone2: suspect2.getPhoneNumbers()) {
							if(phone2.equals(aCommunication.phoneNumber2)) {
								suspect1.partnership(suspect2);
								suspect2.partnership(suspect1);
							}
						}
					}
				}
			}
		}
	}
	
	public Suspect getSuspectWithMostPartners() {
		int mostPartners = -1;
		int counter = 0;
		Suspect topSuspect = null;
		for(Suspect suspect: listOfSuspects) {
			for(Suspect partner: suspect.getPartners()) {
				counter++;
			}
			if(counter > mostPartners) {
				mostPartners = counter;
				topSuspect = suspect;
			}
		}
		return topSuspect;
	}
	
	public void printSuspectsFromCountry(String aCountry) {
		System.out.println("Suspects coming from " + aCountry);
		for(Suspect suspect: listOfSuspects) {
			if(suspect.getCountry().equals(aCountry))
				System.out.println(suspect.getName() + " (" + suspect.getCodeName() + ")");
		}
	}
	
	public ArrayList<Communication> getCommunications() {
		return Communications;
	}
	
	 public PhoneCall getLongestPhoneCallBetween(String number1, String number2) {
		 int largerDuration = 0;
		 PhoneCall longestCall = null;
		 for(Communication call: Communications) {
			 if(call.phoneNumber1.equals(number1) && call.phoneNumber2.equals(number2) && call.getDuration() > largerDuration) {
				longestCall = new PhoneCall(call.phoneNumber1, call.phoneNumber2, call.day, call.month, call.year, call.getDuration());
				largerDuration = call.getDuration();
			 }
		 }
		 return longestCall;
	 }
	 
	 //Μέθοδος για την επιστροφή λίστας με ύποπτα μηνύματα μεταξύ δύο αριθμών
	 //η οποία δεν δουλεύει σωστά παρόλο που δεν βγάζει compile errors.
	 public ArrayList<SMS> getMessagesBetween(String number1, String number2) {
		 ArrayList<SMS> listOfSMS = new ArrayList<>(); 
		 for(Communication sms: Communications) {
			 if(sms.phoneNumber1.equals(number1) && sms.phoneNumber2.equals(number2)) {
				 ArrayList<Character> currentContent = new ArrayList<>();
				 for(int i=0; i < sms.getContent().length(); i++)
					 currentContent.add(sms.getContent().charAt(i));
				  int i = 0;
				 while(i < currentContent.size()) { 
					 ArrayList<Character> word = new ArrayList<>();
					 while(!(currentContent.get(i).equals(' '))) {
						 word.add(currentContent.get(i));
						 i++;
					 }
					 if(word.equals("Bomb") || word.equals("Attack") || word.equals("Explosives") || word.equals("Gun")) {
							 SMS suspiciousSMS = new SMS(sms.phoneNumber1, sms.phoneNumber2, sms.day, sms.month, sms.year, sms.getContent());
							 listOfSMS.add(suspiciousSMS);
							 
						 }
					 i++;
				 }
			 }
		 }
		 return listOfSMS;
	 }

}
