package MM_GENERICS_PACK;

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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
public class TABLET_PURCHASE_RETRIEVE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String t1=request.getParameter("tabname");
		
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mohammed","mohammed");
		PreparedStatement ps=con.prepareStatement("select * from purchase_table where tabname=?");
		ps.setString(1, t1);
		ResultSet rs=ps.executeQuery();
		out.print("<center>");
		out.print("<center>");
		out.print("<table width=85% border=1>");
		out.print("<tr>");
		out.print("<th>COMPANY</th>");
		out.print("<th>TABLET NAME</th>");
		out.print("<th>PACK</th>");
		out.print("<th>BATCH</th>");
		out.print("<th>EXPIRY DATE</th>");
		out.print("<th>MRP</th>");
		out.print("<th>RATE</th>");
		out.print("<th>SALES RATE</th>");
		out.print("</tr>");
		
		if(rs.next()) {
		out.print("<!DOCTYPE html>");
		out.print("<meta charset=ISO-8859-1>");
			out.print("<html>");
			
			out.print("<body bgcolor=palered>");
			
		out.print("<center>");
		out.print("<br>"+"<br>"+"<br>"+"<br>");
		out.print("<tr>");
		out.print("<td>"+rs.getString(1)+"</td>");
out.print("<td>"+rs.getString(2)+"</td>");
out.print("<td>"+rs.getString(3)+"</td>");
out.print("<td>"+rs.getString(4)+"</td>");
out.print("<td>"+rs.getString(5)+"</td>");
out.print("<td>"+rs.getInt(6)+"</td>");
out.print("<td>"+rs.getInt(7)+"</td>");
out.print("<td>"+rs.getInt(8)+"</td>");
out.print("</tr>");
out.print("</table>");

out.print("</center>");
out.print("</center>");
out.print("</body>");
out.print("</html");
con.close();
		rs.close();
		con.close();
		}
		else
		{
			out.print("something problem");
		}
		}
		
		catch (ClassNotFoundException e) {
		
		e.printStackTrace();
		}

		catch (Exception e) {
			
			e.printStackTrace();
			}
		}
}
