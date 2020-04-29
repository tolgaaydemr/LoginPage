package application;

import com.scivue.Util.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.*;


public class SampleController {
	
	Connection baglanti=null;
	PreparedStatement sorguIfadesi = null;
	ResultSet getirilen = null;
	String sql;
	
	public SampleController() {
		baglanti = VeritabaniUtil.Baglan();
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txt_Adi;

    @FXML
    private Button btn_Giris;

    @FXML
    private PasswordField txt_Parola;
    
    @FXML
    private Label lbl_Sonuc;

    @FXML
    void btn_giris_Click(ActionEvent event) {
    	sql="select * from `giris` where kul_Adi=? and kul_Sifre=?";
    	try {
			sorguIfadesi=baglanti.prepareStatement(sql);
			sorguIfadesi.setString(1, txt_Adi.getText().trim());
			sorguIfadesi.setString(2, txt_Parola.getText().trim());
			ResultSet getirilen=sorguIfadesi.executeQuery();
			
			if (!getirilen.next()) {
				lbl_Sonuc.setText("Kullanýcý adý ya da þifre hatalý!!!");
			} else {
				//lbl_Sonuc.setText("\"ID:\"+getirilen.getString(1)+\"\\n\"+\"Kullanýcý Adý: \"+getirilen.getString(\"kul_Adi\")+\"\\n\"+\"Kullanýcý Þifresi:\"+getirilen.getString(\"kul_sifre\")");
				System.out.println("ID:"+getirilen.getString(1)+"\n"+"Kullanýcý Adý: "+getirilen.getString("kul_Adi")+"\n"+"Kullanýcý Þifresi:"+getirilen.getString("kul_sifre"));
			}
		} 
    	catch (Exception e) {
			lbl_Sonuc.setText(e.getMessage().toString());
		}
    }

    @FXML
    void initialize() {
        assert txt_Adi != null : "fx:id=\"txt_Adi\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btn_Giris != null : "fx:id=\"btn_Giris\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txt_Parola != null : "fx:id=\"txt_Parola\" was not injected: check your FXML file 'Sample.fxml'.";
        assert lbl_Sonuc != null : "fx:id=\"lbl_Sonuc\" was not injected: check your FXML file 'Sample.fxml'.";
    }
}
