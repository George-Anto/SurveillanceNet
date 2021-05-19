
public class SMS extends Communication {
	
	private String content;

	public SMS(String phoneNumber1, String phoneNumber2, int day, int month, int year, String content) {
		super(phoneNumber1, phoneNumber2, day, month, year);
		this.content = content;
	}
	
	//������� printInfo ��� ����������� ��� ������ ��� ������ Communication 
	//��� ����������� ����� SMS.
	public void printInfo() {
		System.out.println("This SMS has the following info: ");
		System.out.println("Between " + phoneNumber1 + " --- " + phoneNumber2);
		System.out.println("On " + day + "/" + month + "/" + year);
		System.out.println("Text: " + content);
	}
	
	//������� getContent ��� ����������� ��� ������ ��� ������ Communication 
	//��� ��� ��������� ��� ����� content �� ��������� ��� �� ����������� ����� 
	//����� SMS.
	public String getContent() {
		return content;
	}

	@Override
	public int getDuration() {
		// TODO Auto-generated method stub
		return 0;
	}

}
