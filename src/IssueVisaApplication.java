import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class IssueVisaApplication extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("IssueVisaForm.fxml"));
		primaryStage.setTitle("Issue Visa Form Application");
		Image icon = new Image("icon.png");
		primaryStage.getIcons().add(icon);
		Scene scene = new Scene(root, Color.BISQUE);
		//primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}