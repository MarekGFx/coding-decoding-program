package application;
	
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Label label1 = new Label("Źródło:");
			label1.getStyleClass().add("my-label");
			Label label2 = new Label("Wynik operacji:");
			label2.getStyleClass().add("my-label");
			Label label3 = new Label("Operacja:");
			label3.getStyleClass().add("my-label");
			
			TextField text1 = new TextField("");
			text1.getStyleClass().add("my-field");
			TextField text2 = new TextField("");
			text2.getStyleClass().add("my-field");
			
			RadioButton kodowanie = new RadioButton("kodowanie");
			RadioButton dekodowanie = new RadioButton("dekodowanie");
			
			Button wykonajB = new Button("Wykonaj");
			wykonajB.setId("button1");
			Button kopiujB = new Button("Kopiuj");
			kopiujB.setId("button1");
			
			
			GridPane root = new GridPane();
			root.getStyleClass().add("root");
			root.setPadding(new Insets(20));
		    root.setHgap(25);
		    root.setVgap(15);
			

			root.add(label1,0,1);
			root.add(text1, 0, 2);
			root.add(label2,0,3);
			root.add(text2, 0, 4);
			root.add(label3, 2, 1);
			root.add(kodowanie, 2, 2);
			root.add(dekodowanie, 2, 3);
			root.add(wykonajB, 0, 5);
			GridPane.setHalignment(kopiujB, HPos.RIGHT);
			root.add(kopiujB, 0, 3);
			
			ToggleGroup tgroup = new ToggleGroup ();
			kodowanie.setToggleGroup(tgroup);
			dekodowanie.setToggleGroup(tgroup);
			
			CodingLogic codinglogic = new CodingLogic();
			
			wykonajB.setOnAction(
					event1->{
						if (tgroup.getSelectedToggle() == null ) {
					Alert alert = new Alert(AlertType.ERROR,"Wybierz wymaganą operację kodowania lub dekodowania ");
					alert.show();
						}else { 
							if(kodowanie.isSelected()) {				
								text2.setText(codinglogic.encoding(text1.getText()));
								}	
							if(dekodowanie.isSelected()) {							
								text2.setText(codinglogic.decoding(text1.getText()));
								}	
							}
						});
			
			kopiujB.setOnAction(
					event1->{
						text1.setText(text2.getText());
					});
			
			
			Scene scene = new Scene(root,400,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Program Kodujący");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
