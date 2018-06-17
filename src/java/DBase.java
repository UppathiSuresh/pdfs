
import java.sql.*;
import java.util.*;
public class DBase 
{
	ResultSet rs;
	Connection con;
	Statement st;
	Vector v;
	static String DbIPaddr="localhost";
	
	public Statement dbcon()throws Exception
	{
	      Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://"+DbIPaddr+":3306/pdfs","root","root");
                st=con.createStatement();
		return st;
	}
	public void insert(String s)throws Exception
	{
	  dbcon();	
      st.executeUpdate(s);
      closeConnection();
	}
	public void delete(String s1)throws Exception
	{
	  dbcon();
      st.executeUpdate(s1);
      closeConnection();
	}
	public Vector select(String s)throws Exception
	{
		dbcon(); 
		v=new Vector();
		 rs= st.executeQuery(s);
		 while(rs.next())
		 {		
			 String q1=rs.getString(1);
			 String q2=rs.getString(2);
			 String q3=rs.getString(3);
			 v.add(q1);
			 v.add(q2);
			 v.add(q3);		 
		 }
		closeConnection();
		return v;
	}

	public boolean check(String s)throws Exception
	{
		boolean res=false;
		dbcon();
		rs= st.executeQuery(s);
		if(rs.next())
		{
			res=true;
		}
		closeConnection();
		return res;
	}


	public String selectSingleValue(String s)throws Exception
	{
		dbcon();
		rs= st.executeQuery(s);
		String pword="";
		if(rs.next())
		{		
			pword=rs.getString(1);		 
		}		
		closeConnection();
		return pword;
	}
	public void closeConnection(){
		try{
		if(con!=null){
			st.close();
			con.close();
		}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public ResultSet selectData(String s)throws Exception{
		dbcon();
		rs= st.executeQuery(s);
		return rs;
	}
	public int port(String s)throws Exception{
		
		dbcon();
		rs= st.executeQuery(s);
		int port=0;
		if(rs.next())
		{
		 port=rs.getInt(1);
	
	}	return port;
		}
	
	public ResultSet blockport(String s)throws Exception{
		
		dbcon();
		rs= st.executeQuery(s);
		
		return rs;
		}
}