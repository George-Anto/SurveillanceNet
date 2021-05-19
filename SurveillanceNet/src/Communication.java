
public abstract class Communication {
	
	protected String phoneNumber1;
	protected String phoneNumber2;
	protected int day;
	protected int month;
	protected int year;
	
	public Communication(String phoneNumber1, String phoneNumber2, int day, int month, int year) {
		this.phoneNumber1 = phoneNumber1;
		this.phoneNumber2 = phoneNumber2;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	//Δημιουργία κενής μεθόδου που θα επικαλίπτεται από αντίστοιχες μεθόδους 
	//μέσα στις υποκλάσεις για την εμφάνιση όλων των ιδιοτήτων τους.
	public void printInfo(){}
	
	public String getPhoneNumber1() {
		return phoneNumber1;
	}
	
	public String getPhoneNumber2() {
		return phoneNumber2;
	}
	
	//Δημιουργία μεθόδου που θα επικαλίπτεται μεσα στην υποκλάση PhoneCall
	//για να μπορούμε να χρησιμοποιούμε την ιδιότητα duration εκτός της κλάσης
	//που ανήκει. Όταν η μέθοδος επιστρέφει την τιμή -1 σημαίνει πως το αντικείμενο 
	//δεν είναι τύπου Pnonecall.
	public abstract int getDuration(); 
	
	//Δημιουργία μεθόδου που θα επικαλίπτεται μεσα στην υποκλάση SMS
    //για να μπορούμε να χρησιμοποιούμε την ιδιότητα content εκτός της κλάσης
	//που ανήκει. Όταν η μέθοδος επιστρέφει την τιμή null σημαίνει πως το αντικείμενο 
	//δεν είναι τύπου SMS.
	public abstract String getContent();
}
