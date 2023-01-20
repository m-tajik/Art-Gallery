package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class login implements Initializable{
	
	@FXML
	private MediaView mview;
	private Label l;
	@FXML
	private JFXTextField t;
	@FXML
	private JFXPasswordField pass;

	@FXML
	public void signin(ActionEvent event){
		String url = "jdbc:mysql://localhost:3306/artgallery";
		String user="root";
		String pass2="pph2244800!";
		String uname=t.getText();
		String pass1 =pass.getText();
		try {
			//1.Get connection
			Connection mycon = DriverManager.getConnection(url,user,pass2);
			//2.Create a statement object
			Statement mystat = mycon.createStatement();
			//3.Execute SQL query
			String sq= "select * from admin where username='"+uname+"'and password='"+pass1+"'";
			ResultSet myre= mystat.executeQuery(sq);
			if(myre.next()) {
				
			
			Parent nextwindow = FXMLLoader.load(getClass().getResource("/application/menu.fxml"));
			Scene add = new Scene(nextwindow,1100,700);
			Stage stage = new Stage();
			stage.setScene(add);
			stage.show();
			}
			else 
			{
				l.setText("Try Again!!");
			JOptionPane.showMessageDialog(null, "Try Again");
			}
			}
			catch(Exception exc)
			{
			exc.printStackTrace();
			}
	}
	
	@FXML
	public void cancel(ActionEvent event1) {
		Platform.exit();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		Media md = new Media("file:///E:/Thinking_of_visiting_our_campus_and_meeting_our_admissions_team.mp4");
		MediaPlayer player = new MediaPlayer(md);
		mview.setMediaPlayer(player);
		player.setVolume(0);
		player.play();
	}

	
}
