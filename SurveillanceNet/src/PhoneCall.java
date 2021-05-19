
public class PhoneCall extends Communication {
	
	private int duration;

	public PhoneCall(String phoneNumber1, String phoneNumber2, int day, int month, int year, int duration) {
		super(phoneNumber1, phoneNumber2, day, month, year);
		this.duration = duration;
	}
	
	//Μέθοδος printInfo που επικαλύπτει την μέθοδο της κλάσης Communication
	//για αντικείμενα τύπου PhoneCall.
	public void printInfo() {
		System.out.println("This phone call has the following info: ");
		System.out.println("Between " + phoneNumber1 + " --- " + phoneNumber2);
		System.out.println("On " + day + "/" + month + "/" + year);
		System.out.println("Duration: " + duration);
	}
	
	//Μέθοδος getDuration που επικαλύπτει την μέθοδο της κλάσης Communication 
	//για την επιστροφή της τιμής duration σε περίπτωση που το αντικείμενο είναι
	//τύπου Pnonecall.
	public int getDuration() {
		return duration;
	}

	@Override
	public String getContent() {
		// TODO Auto-generated method stub
		return null;
	}

}
