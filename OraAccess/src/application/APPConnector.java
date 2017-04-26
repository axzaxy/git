package application;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.*;
import oracle.net.aso.i;
public class APPConnector {
	//connection object that is going to be used for the whole app
	private Connection con=null;
	
	//create the connection, which will be used when log in was executed.
	// it returns a string so that the controller can print the error message
	
	public String CreateConnection (String user, String pass, String url){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url,user,pass);
			System.out.println("connecting to the database.");
		}catch (Exception e){
			e.printStackTrace();
		 String s="fail to connect to the database.\n\n";
		 StringWriter trace=new StringWriter();
		 e.printStackTrace(new PrintWriter(trace));
		 s+=trace.toString();
		 return s;
	}
		return "Successfully connected to the database.";
	}
	
	//Execute a given query, which is a string
	//return a string, which is the result.
	public String Query (String sql){

		try{
			
			Statement stmt = con.createStatement();
			System.out.println("Going to query");
		    ResultSet rs = stmt.executeQuery(sql);
		    System.out.println("query complete");
		    
			String result="";
		    while (rs.next()) {
		        System.out.println(rs.getString(1));
		        result+=rs.getString(1)+"\n";
		    }
		    result+="\n\n\n Query Ended Successfully";
			return result;
		}catch (Exception e){
			e.printStackTrace();
		return "fail to query the database.\n\n"+e.getMessage();
		}

	}
}
