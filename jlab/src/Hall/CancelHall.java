package Hall;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cancelHall
 */
@WebServlet("/CancelHall")
public class CancelHall extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 static Connection c;
     static Statement s;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelHall() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cphno = request.getParameter("cphno1");
		 PrintWriter out = response.getWriter();
		 
		  out.print("<html><body><p>" + "---------------Here is Your Cancel Booking Details-------------<br><br>Phone number : " + cphno + 
				  "<br>Your booking will be cancelled. Have a great day!" + "</body></html>");
		  
		  try{
			  //Statement s = (Statement)DatabaseInstance.getInstance().createStatement();
			  Statement s = (Statement)DatabaseInstance.getInstance().createStatement();
			  String deleteQuery = "delete from BoxOffice where cphno = " + cphno;
			  s.executeUpdate(deleteQuery);
			  System.out.println("Deleted successfully");
			  
		  }catch(Exception e){
			  System.out.println("Error while deleting " + e.getLocalizedMessage());
		  }
		  
		  
		  
		  
		
	}

	

}
