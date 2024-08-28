package MM_GENERICS_PACK;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;


public class customer_sale_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mohammed","mohammed");
			
			
			String t1=request.getParameter("doctor");
			int t2=Integer.parseInt(request.getParameter("phoneno"));
			String t3=request.getParameter("tabname");
			int t4=Integer.parseInt(request.getParameter("gst"));
			int t5=Integer.parseInt(request.getParameter("qty"));
			
			
			CallableStatement ps=con.prepareCall("{call p_gst(?,?,?,?,?,?,?,?,?,?)}");
			
			
			ps.setString(1, t1);
			ps.setInt(2, t2);
			ps.setString(3, t3);
			ps.setInt(4, t4);
			ps.setInt(5, t5);
			
			ps.registerOutParameter(6, Types.VARCHAR);
			ps.registerOutParameter(7, Types.VARCHAR);
			ps.registerOutParameter(8, Types.INTEGER);
			ps.registerOutParameter(9, Types.INTEGER);
			ps.registerOutParameter(10, Types.INTEGER);

			
			 ps.executeUpdate();
		if(ps!=null) {
			out.print("successful");
			
		}
		
		else
		{
			out.print("failed");	
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
