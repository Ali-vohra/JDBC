import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class PLSQL {

	public static void main(String[] args) throws IOException {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe", "system", "ali");
			
			CallableStatement cs = con.prepareCall("{call change()}");
			cs.execute();
			
			PreparedStatement ps4 = con.prepareStatement("select * from book");
			ResultSet rs1 = ps4.executeQuery();
			while(rs1.next())
			{
				System.out.println(rs1.getInt("book_id") + " " + rs1.getString("title") + " " + rs1.getString("author") + " " + rs1.getString("publisher") + " " + rs1.getInt("price"));
			}
					
			
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
		
}


