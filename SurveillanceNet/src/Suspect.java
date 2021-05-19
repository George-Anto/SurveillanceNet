import java.util.ArrayList;

public class Suspect {
	
	private String name;
	private String nickName;
	private String country;
	private String town;
	//Δημιουργία λιστών για την εν δυνάμι καταχώρηση περισοτέρων από 
	//ένα νούμερο και συνεργάτες για κάθε ύποπτο.
	private ArrayList<String> phoneNumbers;
	private ArrayList<Suspect> partners;
	
	public Suspect(String name, String nickName, String country, String town) {
		this.name = name;
		this.nickName = nickName;
		this.country = country;
		this.town = town;
		this.phoneNumbers = new ArrayList<String>();
		this.partners = new ArrayList<Suspect>();
	}
	
	public void addNumber(String number) {
		phoneNumbers.add(number);
	}
	
	public void partnership(Suspect aSuspect) {
		boolean flag = false;
		for(Suspect partner: partners) {
			if(partner.equals(aSuspect)) {
				flag = true;
			}
		}
		if(!flag) {
			partners.add(aSuspect);
		}
	}
	
	public ArrayList<String> getPhoneNumbers(){
		return phoneNumbers;
	}
	
	public boolean isConnectedTo(Suspect aSupect) {
		for(Suspect partner: partners) {
			if(partner.equals(aSupect))
				return true;
		}
		return false;
	}
	
	public ArrayList<Suspect> getCommonPartners(Suspect aSuspect){
		ArrayList<Suspect> commonSuspects = new ArrayList<>();
		for(Suspect partner1: partners) {
			for(Suspect partner2: aSuspect.partners) {
				if(partner1.equals(partner2))
					commonSuspects.add(partner1);
			}
		}
		return commonSuspects;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCodeName() {
		return nickName;
	}
	
	public ArrayList<Suspect> getPartners() {
		return partners;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void printPartners() {
		for(Suspect partner: partners) {
			System.out.print("Name: " + partner.name + "," + " Code Name: " + partner.nickName);
			if(partner.country.equals(country))
				System.out.print("*");
			System.out.println();
		}
	}
	
}
