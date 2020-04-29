import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class DataManipulation {

	public static void main(String[] args) throws IOException {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe", "system", "ali");
			Scanner sc = new Scanner(System.in);
			PreparedStatement ps = con.prepareStatement("insert into book values(?,?,?,?,?)");
			while(true)
			{
				System.out.println("Enter Book id:");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Book title:");
				String title = sc.nextLine();
				System.out.println("Enter Book author:");
				String author = sc.nextLine();
				System.out.println("Enter Book publisher:");
				String publ = sc.nextLine();
				System.out.println("Enter Book price:");
				int price = sc.nextInt();
				sc.nextLine();
				ps.setInt(1, id);
				ps.setString(2, title);
				ps.setString(3, author);
				ps.setString(4, publ);
				ps.setInt(5, price);
				ps.execute();
				System.out.println("Do you want to continue:y/n");
				String op = sc.nextLine();
				if(op.equals("n"))
				{
					break;
				}
			}
			
			PreparedStatement ps1 = con.prepareStatement("update book set price = 4000 where book_id = 1");
			ps1.execute();
			
			PreparedStatement ps4 = con.prepareStatement("select * from book");
			ResultSet rs1 = ps4.executeQuery();
			while(rs1.next())
			{
				System.out.println(rs1.getInt("book_id") + " " + rs1.getString("title") + " " + rs1.getString("author") + " " + rs1.getString("publisher") + " " + rs1.getInt("price"));
			}
			
			PreparedStatement ps2 = con.prepareStatement("delete from book where book_id = 1");
			ps2.execute();
			
			PreparedStatement ps3 = con.prepareStatement("select * from book");
			ResultSet rs = ps3.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt("book_id") + " " + rs.getString("title") + " " + rs.getString("author") + " " + rs.getString("publisher") + " " + rs.getInt("price"));
			}
			
			ps.close();
			ps1.close();
			ps2.close();
			ps3.close();
			ps4.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
		
}


