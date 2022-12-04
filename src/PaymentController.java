//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.URL;
//import java.util.ResourceBundle;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//
//public class PaymentController implements Initializable{
//
//    @FXML
//    private TextField creditCardId;
//
//    @FXML
//    private Button payButton;
//    
//    @FXML
//    private Button notPaidButton;
//
//    @FXML
//    private Button paidButton;
//    
//    @FXML
//    private Label paymentMessageId;
//
//    @FXML
//    void handlePayment(ActionEvent event) throws IOException {
//    	makePayment();
//    }
//    void makePayment() throws IOException {
//    	int creditCard = Integer.parseInt(creditCardId.getText()); 
//    	FileWriter fw = new FileWriter("bank.txt",true);
//		PrintWriter out = new PrintWriter(fw);
//		out.println("new credit card: " + creditCard);
//		out.close();
//    }
//    void handlePaid() {
//    	
//    }
//    
//    @FXML
//    void notPaidAction(ActionEvent event) {
//    	paymentMessageId.setText("Sorry your application is rejected !");
//    }
//
//    @FXML
//    void paidAction(ActionEvent event) {
//    	paymentMessageId.setText("Thank you !");
//    }
//
//	@Override
//	public void initialize(URL url, ResourceBundle rb) {
//		// TODO Auto-generated method stub
//	}
//
//}
