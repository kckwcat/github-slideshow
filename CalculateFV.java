import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;

import java.math.*;

public class CalculateFV extends Application 
{
    public TextField tfAnnualInterestRate = new TextField();
    
    private TextField tfNumberOfYears = new TextField();
    private TextField tfInvestAmount = new TextField();
    private TextField tfFutureValue = new TextField();
    private Button btCalculate = new Button("Calculate");

    @Override
    public void start(Stage primaryStage) {
        // Create UI
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(15);
        gridPane.setVgap(15);

        gridPane.add(new Label("Investment Amount:"), 0, 0);
        gridPane.add(tfInvestAmount, 1, 0);
        
        gridPane.add(new Label("Number of Years:"), 0, 1);
        gridPane.add(tfNumberOfYears, 1, 1);

        gridPane.add(new Label("Annual Interest Rate:"), 0, 2);
        gridPane.add(tfAnnualInterestRate, 1, 2);
        
        gridPane.add(new Label("Future Value:"), 0, 3);
        gridPane.add(tfFutureValue, 1, 3);

        gridPane.add(btCalculate, 1, 5);

        tfAnnualInterestRate.setAlignment(Pos.CENTER_RIGHT);
        tfNumberOfYears.setAlignment(Pos.CENTER_RIGHT);
        tfInvestAmount.setAlignment(Pos.CENTER_RIGHT);
        tfFutureValue.setAlignment(Pos.CENTER_RIGHT);
        

        btCalculate.setOnAction(e -> calculateFutureValue());

        Scene scene = new Scene(gridPane, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculate Future Value");
        primaryStage.show();
        }

    private void calculateFutureValue() {
        
        double interest = Double.parseDouble(tfAnnualInterestRate.getText());
        int year = Integer.parseInt(tfNumberOfYears.getText());
        double investAmount = Double.parseDouble(tfInvestAmount.getText());
        
        Investment invest = new Investment(investAmount,year,interest);
        double fv = invest.getFutureValue();

        tfFutureValue.setText(String.format("%,.2f", fv));
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}

