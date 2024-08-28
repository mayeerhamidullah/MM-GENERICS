package MM_GENERICS_PACK;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


public class customer_sale_retrieve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int t1=Integer.parseInt(request.getParameter("phoneno"));
		
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mohammed","mohammed");
		PreparedStatement ps=con.prepareStatement("select product,pack,expire,qty,rate,gst_perce,amount,mrp,gst_value,amount+gst_value from customer_sale where phoneno=?");
		ps.setInt(1, t1);
		
		ResultSet rs=ps.executeQuery();
		
		out.print("<br>"+"MM Generics,"+"<br>"+"Muncipal Office opp,"+"<br>"+"Nandigama,"+"<br>"+"521185.");
        out.print("<br><br><br><br>");
		
        
		
        out.print("<style>");
		out.print("table,th,td { border:1px solid black}");
		
		
		out.print("</style>");
        
        out.print("<center>");
				out.print("<table style=width:75%>");
				
				 
				ResultSetMetaData rsmd=ps.getMetaData();
				int totalColumn=rsmd.getColumnCount();
				out.print("<tr>");
				for(int i=1;i<=totalColumn;i++)
				{
					out.print("<th>"+rsmd.getColumnName(i)+"</th>");
				}
				
		
				out.print("</tr>");
			
				out.print("</table>");
				
				while(rs.next()) {
					
					 out.print("<style>");
						out.print("table,th,td { border:1px solid black}");
						
						
						out.print("</style>");
				        
				        out.print("<center>");
								out.print("<table style=width:75%>");
			        
					out.print("<tr>");
					
		out.print("<td>"+rs.getString(1)+"</td>");
		out.print("<td>"+rs.getString(2)+"</td>");
		out.print("<td>"+rs.getString(3)+"</td>");
		out.print("<td>"+rs.getFloat(4)+"</td>");
		out.print("<td>"+rs.getFloat(5)+"</td>");
		out.print("<td>"+rs.getFloat(6)+"</td>");
		out.print("<td>"+rs.getFloat(7)+"</td>");
		out.print("<td>"+rs.getFloat(8)+"</td>");
		out.print("<td>"+rs.getFloat(9)+"</td>");
		out.print("<td>"+rs.getFloat(10)+"</td>");
		
		out.print("</tr>");
		out.print("</table>");
		
			}
				
				
		con.close();
		ps.close();
		rs.close();
		}
		
		catch (ClassNotFoundException e) {
		
		e.printStackTrace();
		}

		catch (Exception e) {
			
			e.printStackTrace();
			}
	}
}

	


