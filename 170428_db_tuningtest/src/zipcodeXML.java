import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class zipcodeXML {
	public static void main(String args[]){
		try{
			Connection conn = null;	
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.149.128:1521:orasparta","scott","tiger");
			conn.setAutoCommit(false); // autocommit ¹æÁö
			System.out.println("driver load & DB connect success");
			Statement stmt = conn.createStatement();
			ResultSet rest = stmt.executeQuery("select * from zipcode order by seq");
			
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("zipcode");
			doc.appendChild(rootElement);
			while(rest.next()){							
				Element SEQUENCE = doc.createElement("SEQUENCE");
				rootElement.appendChild(SEQUENCE);
				
				Attr attr = doc.createAttribute("Num");
				attr.setValue(rest.getString(7));
				SEQUENCE.setAttributeNode(attr);
				
				Element ZIPCODE = doc.createElement("ZIPCODE");
				ZIPCODE.appendChild(doc.createTextNode(rest.getString(1)));
				SEQUENCE.appendChild(ZIPCODE);
				
				Element SIDO = doc.createElement("SIDO");
				SIDO.appendChild(doc.createTextNode(String.valueOf(rest.getString(2))));
				SEQUENCE.appendChild(SIDO);
				
				Element GUGUN = doc.createElement("GUGUN");
				GUGUN.appendChild(doc.createTextNode(String.valueOf(rest.getString(3))));
				SEQUENCE.appendChild(GUGUN);
				
				Element DONG = doc.createElement("DONG");
				DONG.appendChild(doc.createTextNode(String.valueOf(rest.getString(4))));
				SEQUENCE.appendChild(DONG);
				
				Element RI = doc.createElement("RI");
				RI.appendChild(doc.createTextNode(String.valueOf(rest.getString(5))));
				SEQUENCE.appendChild(RI);
				
				Element BUNJI = doc.createElement("BUNJI");
				BUNJI.appendChild(doc.createTextNode(String.valueOf(rest.getString(6))));
				SEQUENCE.appendChild(BUNJI);				
			}
			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer tf = tff.newTransformer();
		
			tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			tf.setOutputProperty(OutputKeys.INDENT, "yse");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new FileOutputStream(new File("c:\\1234\\zipcode.xml")));
			tf.transform(source, result);
			System.out.println("create xml success");
			stmt.close();		
			conn.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}