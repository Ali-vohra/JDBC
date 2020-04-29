import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Connect {

	public static void main(String[] args) throws IOException {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe", "system", "ali");
			
			PreparedStatement ps = con.prepareStatement("create table book(book_id number(2),title varchar(20),author varchar(20),publisher varchar(20),price number(5))");
					
			ps.execute();
			System.out.println("Table created successfully");
			
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
		
}


