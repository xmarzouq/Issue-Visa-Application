package Program;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Immigration {

	ArrayList<Tourist> tourists = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	
	public String issueVisitVisa(String name, String passport) throws Exception {
		int creditCard = 0;
		boolean paid = false;
		String done = "";
		for(Tourist x: tourists) {
			if(x.getName().equalsIgnoreCase(name) && x.getPasport().equals(passport)) {
				System.out.println("Your data is recorded befor!");
				System.err.println("Your application is rejected! ");
				System.exit(0);
			}

		}
		Tourist x = new Tourist(name, passport);
		tourists.add(x);
		System.out.println("\nEnter your credit card details");
		System.out.print("--> ");
		creditCard = scanner.nextInt();
		FileWriter fw = new FileWriter("bank.txt",true);
		PrintWriter out = new PrintWriter(fw);
		out.println("new credit card: " + creditCard);
		out.close();
		System.out.print("\nPaid successfully?   ");
		paid = scanner.nextBoolean();
		if(!paid){
			System.err.println("Your application is rejected! ");
			System.exit(0);
		} if(paid) {
			x.setVisaDuration(3);
			x.setVisaNumber(x.getName() + x.getVisaDuration() + x.getPasport());
			FileWriter fw2 = new FileWriter("data.txt",true);
			PrintWriter out2 = new PrintWriter(fw2);
			out2.println("tourist visa number " + x.getVisaNumber());
			out2.println("tourist visa duration " + x.getVisaDuration());
			out2.println("-----------------------------------");
			out2.close();
			System.out.println("\n\n\t\t\t----->Tourist visa details<-----");
			System.out.println("\n\t\t\tTourist name: " + x.getName());
			System.out.println("\t\t\tTourist passport number: " + x.getPasport());
			System.out.println("\t\t\tTourist visa duration: " + x.getVisaDuration());
			System.out.println("\t\t\tTourist visa number: " + x.getVisaNumber());
			done = x.getVisaNumber();
		}
	return done;
	}
}
