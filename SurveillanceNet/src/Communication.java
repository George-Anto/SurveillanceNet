
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
	
	//���������� ����� ������� ��� �� ������������� ��� ����������� �������� 
	//���� ���� ���������� ��� ��� �������� ���� ��� ��������� ����.
	public void printInfo(){}
	
	public String getPhoneNumber1() {
		return phoneNumber1;
	}
	
	public String getPhoneNumber2() {
		return phoneNumber2;
	}
	
	//���������� ������� ��� �� ������������� ���� ���� �������� PhoneCall
	//��� �� �������� �� �������������� ��� �������� duration ����� ��� ������
	//��� ������. ���� � ������� ���������� ��� ���� -1 �������� ��� �� ����������� 
	//��� ����� ����� Pnonecall.
	public abstract int getDuration(); 
	
	//���������� ������� ��� �� ������������� ���� ���� �������� SMS
    //��� �� �������� �� �������������� ��� �������� content ����� ��� ������
	//��� ������. ���� � ������� ���������� ��� ���� null �������� ��� �� ����������� 
	//��� ����� ����� SMS.
	public abstract String getContent();
}
