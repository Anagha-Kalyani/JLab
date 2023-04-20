package Hall;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class BookHall
 */
@WebServlet("/BookHall")
public class BookHall extends HttpServlet {
        private static final long serialVersionUID = 1L;
        static Connection c;
        static Statement s;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookHall() {
        super();
        // TODO Auto-generated constructor stub
    }
        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
//                response.getWriter().append("Served at: ").append(request.getContextPath());
                    String cname =  request.getParameter("cname");
                    String cphno = request.getParameter("cphno");
                String matchname = request.getParameter("matchname");
                //String qty = request.getParameter("qty");
                int qty = Integer.parseInt(request.getParameter("qty"));
                double billAmount = 0.0;
                PrintWriter out = response.getWriter();
                if(matchname.equals("RCB VS CSK")) {
                        billAmount = 12000.00;
                }
                else if(matchname.equals("RCB VS RR")) billAmount = 9000.00;
                else if(matchname.equals("RCB VS MI")) billAmount = 11000.00;
                else if(matchname.equals("RCB VS KKR")) billAmount = 8000.00;
               
               double finalBill=qty*billAmount;
               
                out.print("<html><body><p>" + "---------------Here are Your Booking Details-------------<br><br></p><p>Match name : " + matchname + "</p>");
                out.print("<p>Name : " + cname + "</p><p>Phone number : " + cphno + "</p><p>Number of tickets booked : "+ qty +"</p><br>Your total bill amount is " + finalBill + "</body></html>");
                try {
//                                Class.forName("com.mysql.cj.jdbc.Driver");
//                                c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "msrit");
//                                System.out.println(c.toString());
//                                s = (Statement) c.createStatement();
                	Statement s = (Statement)DatabaseInstance.getInstance().createStatement();
                                String qty1=Integer.toString(qty);
;                               String amt=Double.toString(finalBill);
                                String queryToExecute = String.format(
                                                "insert into BoxOffice  (cname, cphno, matchname, qty, amt) values ('%s', '%s', '%s', '%s','%s')",
                                                cname, cphno, matchname, qty1, amt);
                                 int update = s.executeUpdate(queryToExecute);
                                 
                                 
                                 String r2 = String.format("select * from BoxOffice");
                                 
                                 ResultSet rs = s.executeQuery(r2);
                                 
                                 while(rs.next()){
                                    //Display values
                                    System.out.println("Customer Name: " + rs.getString("cname"));
                                    System.out.println("Phone number: " + rs.getString("cphno"));
                                    System.out.println("Match name: " + rs.getString("matchname"));
                                    System.out.println("Number of tickets bought: " + rs.getString("qty"));
                                 }
                                s.close();
                                c.close();
                        } catch (Exception err) {
                                System.out.println(err);
                        }
        }
        
}