package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class control implements Initializable{
	@FXML
	private Pane pane;
	@FXML
	private Label l;
	@FXML
	private JFXTextField t;
	@FXML
	private JFXPasswordField pass;
	@FXML
	private BorderPane Ali;
	@FXML
	private ImageView imgview;
	@FXML
	private ImageView imgview1;
	@FXML
	private ImageView imgview2;
	@FXML
	private JFXTextField ID;
	@FXML
	private  JFXTextField NM;
	@FXML
	private   JFXTextField LN;
	@FXML
	private JFXTextField GD;

	@FXML
	private JFXTextField EMAIL;

	@FXML
	private JFXTextField PH;
	
	@FXML
	private JFXTextField id;
	
	@FXML
	private JFXTextField id1;
	
	@FXML
	private JFXTextField em;
	
	@FXML
	private JFXTextField phh;
	
	@FXML
	private JFXTextField phh1;
	@FXML
	private JFXTextField phh11;
	
	@FXML
	private MediaView mview;
	
	@FXML
	private JFXButton chooser;
	@FXML
	private JFXButton chooper;
	@FXML
	private JFXButton painto;
	@FXML
	private ImageView imview;
	@FXML
	private ImageView imview1;
	@FXML
	private ImageView imview2;
	@FXML
	private JFXTextField skid;
	@FXML
	private JFXTextField aid;
	@FXML
	private JFXTextField dart1;
	@FXML
	private JFXTextField dart2;
	
	@FXML
	private JFXTextField skid1;
	
	@FXML
	private JFXTextField skid11;
	
	@FXML
	private JFXTextField dart;
	
	@FXML
	private JFXTextField darti;
	
	@FXML
	private JFXTextField darti1;
	
	@FXML
	private JFXTextField darti11;
	
	private PreparedStatement store;
	private String Storestatement= "INSERT INTO artgallery.sketch(SK) VALUES(?)";
	
	private PreparedStatement stoore;
	private String Storestatemente= "INSERT INTO artgallery.digitalic (art) VALUES(?)";
	
	private PreparedStatement stooree;
	private String Storestatementee= "INSERT INTO artgallery.painting (painting) VALUES(?)";
	
	public void importandsav(ActionEvent event) throws SQLException, IOException {
		String url = "jdbc:mysql://localhost:3306/artgallery";
		String user="root";
		String pass="pph2244800!";
		Connection mi = DriverManager.getConnection(url,user,pass);
	    stooree=mi.prepareStatement(Storestatementee);
		FileChooser fi = new FileChooser();
		File fil = fi.showOpenDialog(painto.getScene().getWindow());
		FileInputStream fisel = new FileInputStream(fil);
		stooree.setBinaryStream(1 , fisel, fisel.available());
		stooree.execute();
		Image imee = new Image(fisel);
		imview.setImage(imee);
		
	}
		
	
	
	public void deletepaint(ActionEvent event)
	{String url = "jdbc:mysql://localhost:3306/artgallery";
	String user="root";
	String pass="pph2244800!";
 String nopee=darti.getText();
		
		try {
			//1.Get connection
			Connection mycon = DriverManager.getConnection(url,user,pass);
			//2.Create a statement object
			Statement mystat = mycon.createStatement();
			//3.Execute SQL query
			mystat.executeUpdate("delete from artgallery.painting where `ID` = "+nopee+";");
			JOptionPane.showMessageDialog(null, "The data is deleted successfully!");
			}
			catch(Exception exc)
			{
			exc.printStackTrace();
			}
	}
	
	public void importandsavee(ActionEvent event) throws SQLException, IOException {
		String url = "jdbc:mysql://localhost:3306/artgallery";
		String user="root";
		String pass="pph2244800!";
		Connection mice = DriverManager.getConnection(url,user,pass);
	    stoore=mice.prepareStatement(Storestatemente);
		FileChooser filechoosee = new FileChooser();
		File filee = filechoosee.showOpenDialog(chooper.getScene().getWindow());
		FileInputStream fise = new FileInputStream(filee);
		stoore.setBinaryStream(1 , fise, fise.available());
		stoore.execute();
		Image ime = new Image(fise);
		imview.setImage(ime);
		
	}
	
	public void deletedig(ActionEvent event)
	{String url = "jdbc:mysql://localhost:3306/artgallery";
	String user="root";
	String pass="pph2244800!";
 String nope=dart.getText();
		
		try {
			//1.Get connection
			Connection mycon = DriverManager.getConnection(url,user,pass);
			//2.Create a statement object
			Statement mystat = mycon.createStatement();
			//3.Execute SQL query
			mystat.executeUpdate("delete from artgallery.digitalic where `ID` = "+nope+";");
			JOptionPane.showMessageDialog(null, "The data is deleted successfully!");
			}
			catch(Exception exc)
			{
			exc.printStackTrace();
			}
	}
	
	
	
	
	public void importandsave(ActionEvent event) throws SQLException, IOException {
		String url = "jdbc:mysql://localhost:3306/artgallery";
		String user="root";
		String pass="pph2244800!";
		Connection mic = DriverManager.getConnection(url,user,pass);
	    store=mic.prepareStatement(Storestatement);
		FileChooser filechoose = new FileChooser();
		File file = filechoose.showOpenDialog(chooser.getScene().getWindow());
		FileInputStream fis = new FileInputStream(file);
		store.setBinaryStream(1 , fis, fis.available());
		store.execute();
		Image im = new Image(fis);
		imview.setImage(im);
		
	}
	
	public void deletesketch(ActionEvent event)
	{String url = "jdbc:mysql://localhost:3306/artgallery";
	String user="root";
	String pass="pph2244800!";
 String nop=skid.getText();
		
		try {
			//1.Get connection
			Connection mycon = DriverManager.getConnection(url,user,pass);
			//2.Create a statement object
			Statement mystat = mycon.createStatement();
			//3.Execute SQL query
			mystat.executeUpdate("delete from artgallery.sketch where `sketchID` = "+nop+";");
			JOptionPane.showMessageDialog(null, "The data is sketch successfully!");
			}
			catch(Exception exc)
			{
			exc.printStackTrace();
			}
	}
	public void resetdata()
	{
		NM.clear();
		LN.clear();
		GD.clear();
		EMAIL.clear();
		PH.clear();
		
	}
	
	public void resetdataa()
	{
		id1.clear();
		em.clear();
		phh.clear();
		phh1.clear();
		phh11.clear();
		
		
	}
	
	public void upddigit(ActionEvent event)
	{String url = "jdbc:mysql://localhost:3306/artgallery";
	String user="root";
	String pass="pph2244800!";
 String niro=dart1.getText();
	String emlia=dart2.getText();
	
		
		try {
			//1.Get connection
			Connection mycon = DriverManager.getConnection(url,user,pass);
			//2.Create a statement object
			Statement mystat = mycon.createStatement();
			//3.Execute SQL query
			mystat.executeUpdate("UPDATE digitalic SET artist="+emlia+" WHERE ID="+niro+"");
			JOptionPane.showMessageDialog(null, "Updated Succesfully!");
			}
			catch(Exception exc)
			{
			exc.printStackTrace();
			}
	}
	
	public void updatesketch(ActionEvent event)
	{String url = "jdbc:mysql://localhost:3306/artgallery";
	String user="root";
	String pass="pph2244800!";
 String nir=skid11.getText();
	String emli=skid1.getText();
	
		
		try {
			//1.Get connection
			Connection mycon = DriverManager.getConnection(url,user,pass);
			//2.Create a statement object
			Statement mystat = mycon.createStatement();
			//3.Execute SQL query
			mystat.executeUpdate("UPDATE sketch SET artistID="+emli+" WHERE sketchID="+nir+"");
			JOptionPane.showMessageDialog(null, "Updated Succesfully!");
			}
			catch(Exception exc)
			{
			exc.printStackTrace();
			}
	}
	
	public void updatepaint(ActionEvent event)
	{String url = "jdbc:mysql://localhost:3306/artgallery";
	String user="root";
	String pass="pph2244800!";
 String niri=darti1.getText();
	String emlii=darti11.getText();
	
		
		try {
			//1.Get connection
			Connection mycon = DriverManager.getConnection(url,user,pass);
			//2.Create a statement object
			Statement mystat = mycon.createStatement();
			//3.Execute SQL query
			mystat.executeUpdate("UPDATE painting SET ARTIST="+emlii+" WHERE ID="+niri+"");
			JOptionPane.showMessageDialog(null, "Updated Succesfully!");
			}
			catch(Exception exc)
			{
			exc.printStackTrace();
			}
	}
	
	public void rese()
	{
		
		skid11.clear();
		skid1.clear();
		
		
	}
	
	public void re()
	{
		
		darti1.clear();
		darti11.clear();
		
		
	}
	
	public void res()
	{
		
		dart1.clear();
		dart2.clear();
		
		
	}
	
	public void insertdata(ActionEvent event)
	{String url = "jdbc:mysql://localhost:3306/artgallery";
	String user="root";
	String pass="pph2244800!";

		
		
		String name=NM.getText();
		String lastname=LN.getText();
		String gender=GD.getText();
		String email=EMAIL.getText();
		String phone=PH.getText();
		
		try {
			//1.Get connection
			Connection mycon = DriverManager.getConnection(url,user,pass);
			//2.Create a statement object
			Statement mystat = mycon.createStatement();
			//3.Execute SQL query
			mystat.executeUpdate("INSERT INTO `artists` (Name,lname,Gender,Email,Phone) values ('"+name+"','"+lastname+"','"+gender+"','"+email+"','"+phone+"')");
			JOptionPane.showMessageDialog(null, "The data is inserted");
			}
			catch(Exception exc)
			{
			exc.printStackTrace();
			}
	}
	
	
	public void deletemethod(int id) {
		
	}
	
	
	public void deletedata(ActionEvent event)
	{String url = "jdbc:mysql://localhost:3306/artgallery";
	String user="root";
	String pass="pph2244800!";
 String n=id.getText();
		
		try {
			//1.Get connection
			Connection mycon = DriverManager.getConnection(url,user,pass);
			//2.Create a statement object
			Statement mystat = mycon.createStatement();
			//3.Execute SQL query
			mystat.executeUpdate("delete from artgallery.artists where AD = "+n+";");
			JOptionPane.showMessageDialog(null, "The data is Deleted successfully!");
			}
			catch(Exception exc)
			{
			exc.printStackTrace();
			}
	}
	
	public void updatedata(ActionEvent event)
	{String url = "jdbc:mysql://localhost:3306/artgallery";
	String user="root";
	String pass="pph2244800!";
 String nn=id1.getText();
	String eml=phh1.getText();
	String pn=phh11.getText();
	String pno=em.getText();
	String pni=phh.getText();
		
		try {
			//1.Get connection
			Connection mycon = DriverManager.getConnection(url,user,pass);
			//2.Create a statement object
			Statement mystat = mycon.createStatement();
			//3.Execute SQL query
			mystat.executeUpdate("UPDATE artgallery.artists SET Name = '"+pno+"', lname = '"+pni+"', Email = '"+eml+"', Phone = '"+pn+"' WHERE AD = '"+nn+"';");
			JOptionPane.showMessageDialog(null, "Updated Succesfully!");
			}
			catch(Exception exc)
			{
			exc.printStackTrace();
			}
	}
	

	
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
				
			JOptionPane.showMessageDialog(null, "Sorry, you should be an admin!");
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
	
	
	@FXML
	public void home(ActionEvent event) throws IOException{
	Parent Pane = FXMLLoader.load(getClass().getResource("home.fxml"));
	Ali.setCenter(Pane);
	}
	
	public void artist(ActionEvent event) throws IOException{
		Parent AnchorPane = FXMLLoader.load(getClass().getResource("artist.fxml"));
		Ali.setCenter(AnchorPane);
		}
	
	public void artwork(ActionEvent event) throws IOException{
		Parent TabPane = FXMLLoader.load(getClass().getResource("artwork.fxml"));
		Ali.setCenter(TabPane);
		}
	public void addartist(ActionEvent event) throws IOException{
		Parent AnchorPane = FXMLLoader.load(getClass().getResource("add.fxml"));
		Ali.setCenter(AnchorPane);
		}
	
	public void digital(ActionEvent event) throws IOException{
		Parent AnchorPane = FXMLLoader.load(getClass().getResource("digital.fxml"));
		Ali.setCenter(AnchorPane);
		}
	
	public void painting(ActionEvent event) throws IOException{
		Parent AnchorPane = FXMLLoader.load(getClass().getResource("painting.fxml"));
		Ali.setCenter(AnchorPane);
		}
	
	public void omid(ActionEvent event) throws IOException{
		Parent AnchorPane = FXMLLoader.load(getClass().getResource("artist.fxml"));
		Ali.setCenter(AnchorPane);
		}
	
	public void omd(ActionEvent event) {
		Image image = new Image("/application/omid.jpg");
		imgview.setImage(image);
	}
	public void mit(ActionEvent event) {
		Image image1 = new Image("/application/71318988_1108773972652658_6096023988620754944_n.jpg");
		imgview1.setImage(image1);
	}
	
	public void behesht(ActionEvent event) {
		Image image1 = new Image("/application/82268391_577966346092681_5934280906142384128_n.jpg");
		imgview2.setImage(image1);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
}
