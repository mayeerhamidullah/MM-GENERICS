package MM_GENERICS_PACK;

import java.io.IOException;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class Tablet_Purchase extends HttpServlet {
	private static final long serialVersionUID = 1L;

   

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mohammed","mohammed");
			
			String t1=request.getParameter("company");
			String t2=request.getParameter("tabname");
			String t3=request.getParameter("pack");
			String t4=request.getParameter("batch");
			String t5=request.getParameter("expire");
			int t6=Integer.parseInt(request.getParameter("mrp"));
			int t7=Integer.parseInt(request.getParameter("rate"));
			int t8=Integer.parseInt(request.getParameter("salerate"));
			
			
			CallableStatement ps=con.prepareCall("{call p_insert(?,?,?,?,?,?,?,?)}");
			
			ps.setString(1, t1);
			ps.setString(2, t2);
			ps.setString(3, t3);
			ps.setString(4, t4);
			ps.setString(5, t5);
			ps.setInt(6, t6);
			ps.setInt(7, t7);
			ps.setInt(8, t8);
			
			 ps.executeUpdate();
		if(ps!=null) {
				out.print("purchase details registered successfully");
			
		}
		
		else
		{
			out.print("purchase details registration failed");
		}
			con.close();
			ps.close();
			
			
			
		}
		 catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
