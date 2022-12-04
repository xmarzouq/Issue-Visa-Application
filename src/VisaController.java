import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Program.Tourist;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class VisaController implements Initializable{
	ArrayList<Tourist> tourists = new ArrayList<>();

	private StringBuilder name = new StringBuilder();
	private StringBuilder passport = new StringBuilder();
	private StringBuilder visa = new StringBuilder();

	@FXML
    private TextField nameId;

    @FXML
    private TextField passportId;

    @FXML
    private Label dataMessageId;

    @FXML
    private Button saveButtonId;
    
    

    @FXML
    private TextField creditCardId;

    @FXML
    private Button payButton;
    
    @FXML
    private TitledPane titlePaneId;
    
    @FXML
    private Label bankMessageId;
    

    @FXML
    private TabPane tapId;
    
    @FXML
    private Tab savedDataTap;

    @FXML
    private Text dataId;
    
    @FXML
    private Button viewData;


	@FXML
	void handleButtonAction(ActionEvent event) throws IOException {
		name = new StringBuilder(nameId.getText());
		passport = new StringBuilder(passportId.getText());
		bankMessageId.setText("  ");
		checkData();
	}

	void checkData() throws IOException {
		boolean found = false;
		for(Tourist x: tourists) {
			if(name.toString().toLowerCase().equalsIgnoreCase(x.getName().toLowerCase()) || 
					passport.toString().toLowerCase().equalsIgnoreCase(x.getPasport().toLowerCase())) {
				dataMessageId.setText("Your data is already recorded!");
				nameId.clear();
				passportId.clear();
				titlePaneId.setExpanded(false);
				titlePaneId.setDisable(true);
				found = true;
				//				System.exit(0);
			}
		} if(!found) {
			nameId.clear();
			passportId.clear();
			saveButtonId.setText("Saved!");
			dataMessageId.setText("Fill the form for the payment");
			tourists.add(new Tourist(passport.toString(), name.toString()));
			System.out.println(tourists.get(tourists.size()-1));
			titlePaneId.setExpanded(true);
			titlePaneId.setDisable(false);
		}
	}
	void makePayment() throws IOException {
		int creditCard = Integer.parseInt(creditCardId.getText()); 
		FileWriter fw = new FileWriter("bank.txt",true);
		PrintWriter out = new PrintWriter(fw);
		out.println("new credit card: " + creditCard);
		out.close();
	}


	
	
    @FXML
    void handleNotPaid(ActionEvent event) {
    	creditCardId.clear();
//    	titlePaneId.setExpanded(false);
		titlePaneId.setDisable(true);
    	bankMessageId.setText("\tNot Approved\n\tStart again");
    }

    @FXML
    void handlePaid(ActionEvent event) throws IOException {
    	bankMessageId.setText("\tApproved");
		visa.append(passport.toString().toUpperCase() + 3 + name.toString().toUpperCase());
		tourists.get(tourists.size()-1).setVisaDuration(3);
		
		tourists.get(tourists.size()-1).setVisaNumber(visa.toString());
		FileWriter fw = new FileWriter("data.txt",true);
		PrintWriter out = new PrintWriter(fw);
		out.println("tourist visa number " + tourists.get(tourists.size()-1).getVisaNumber());
		out.println("tourist visa duration " + tourists.get(tourists.size()-1).getVisaDuration());
		out.println("-----------------------------------");
		out.close();
		viewData.fire();
		
    }

    @FXML
    void handlePayButton(ActionEvent event) throws IOException {
		makePayment();
		bankMessageId.setText("Waiting for bank approval...");
    }
    

	@FXML
    void handleViewData(ActionEvent event) {
    	titlePaneId.setExpanded(false);
		titlePaneId.setDisable(true);
		StringBuilder data = new StringBuilder();
		data.append("----->Tourist visa details<-----");
		data.append("\nTourist Name: "  + tourists.get(tourists.size() -1).getName());
		data.append("\nTourist Passport Number: "  + tourists.get(tourists.size() -1).getPasport());
		data.append("\nTourist Visa Duration: "  + tourists.get(tourists.size() -1).getVisaDuration());
		data.append("\nTourist Visa Number: "  + tourists.get(tourists.size() -1).getVisaNumber());
		
		
		
		
		
		
		dataId.setText(data.toString());
		
		
		tapId.getSelectionModel().select(1);
    }
	

    @FXML
    void handleGetBack(ActionEvent event) {
    	titlePaneId.setExpanded(false);
		titlePaneId.setDisable(true);
    	tapId.getSelectionModel().select(0);
    	dataMessageId.setText("  ");
		
    }

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub

	}
	
	

}









