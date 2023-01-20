package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXTextField;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class connectdelete extends Application {

	private JFXTextField pp;
	
	public void deletedatal(ActionEvent event)
	{String ur = "jdbc:mysql://localhost:3306/artgallery";
	String use="root";
	String pas="pph2244800!";
	
	
	String pr=pp.getText();
	
		
		try {
			//1.Get connection
			Connection myc = DriverManager.getConnection(ur,use,pas);
			//2.Create a statement object
			Statement my = myc.createStatement();
			//3.Execute SQL query
			String delateSq= "DELETE  FROM artists WHERE Name="+pr+";";
			my.executeUpdate(delateSq);
			JOptionPane.showMessageDialog(null, "The data is deleted");
			}
			catch(Exception exc)
			{
			exc.printStackTrace();
			}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
