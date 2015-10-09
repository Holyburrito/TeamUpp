package DatabaseConnector;
import java.sql.*;
import java.util.Scanner;

public class dbExp3 {
	public static void main( String args[] )
	  {
	    Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");
	      System.out.println("Would you like to make an entry into the database?");
	      Scanner in = new Scanner(System.in);
	      int choice = in.nextInt();
	      
	      while(choice == 1){
	    	  System.out.println("Please enter the name of the member: ");
	    	  String tempName = in.next();
	    	  System.out.println("Please enter the phone number of the member: ");
	    	  String phone = in.next();
	    	  System.out.println("Please enter the class of the member: ");
	    	  String year = in.next();
	    	  System.out.println("Please enter the address of the member: ");
	    	  String tempAddress = in.next();
	    	  System.out.println("Please enter the email of the member: ");
	    	  String tempEmail = in.next();
		      stmt = c.createStatement();
	    	  //ID = phone number
		      String values = String.format("VALUES (%s, '%s', %s, '%s', %s );", phone, tempName, year, tempAddress, tempEmail);
		      System.out.println("VALUES:" + values);
		      String sql = "INSERT INTO MEMBERS (ID,NAME,CLASS,ADDRESS,EMAIL) " + values;
		      System.out.println("STATEMENT: " + sql);
		      stmt.executeUpdate(sql);
		      System.out.println("Would you like to make anotner entry into the database?");
		      choice = in.nextInt();
		      
	       }
	      in.close();
	      stmt.close();
	      c.commit();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Records created successfully");
	  }
}
