package Program;

public class Tourist {
	private String pasport;
	private String name;
	private int visaDuration;
	private String visaNumber;
	
	public Tourist(String pasport, String name) {
		super();
		this.pasport = pasport;
		this.name = name;
	}
	public String getPasport() {
		return pasport;
	}
	public void setPasport(String pasport) {
		this.pasport = pasport;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVisaDuration() {
		return visaDuration;
	}
	public void setVisaDuration(int visaDuration) {
		this.visaDuration = visaDuration;
	}
	public String getVisaNumber() {
		return visaNumber;
	}
	public void setVisaNumber(String visaNumber) {
		this.visaNumber = visaNumber;
	}
	@Override
	public String toString() {
		return "Tourist [pasport=" + pasport + ", name=" + name
				+ ", visaDuration=" + visaDuration + ", visaNumber="
				+ visaNumber + "]";
	}
	
	
	
}
