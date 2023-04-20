
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>IPL Box Office</title>
</head>
<style>
    table, th, td {
       border: 1px solid black;
    }
 </style>
<body>
    <body>
        <h1>Welcome to IPL Box Office</h1><br>
        <h3>Ticket prices today:</h3>
        <table>
            <tr>
                <th>Match Name</th>
                <th>Price per Ticket (INR)</th>
            </tr>
            <tr>
                <td>Royal Challengers Bangalore VS Chennai Super Kings</td>
                <td>12000</td>
            </tr>
            <tr>
                <td>Royal Challengers Bangalore VS Rajasthan Royals</td>
                <td>9000</td>
            </tr>
            <tr>
                <td>Royal Challengers Bangalore VS Mumbai Indians</td>
                <td>11000</td>
            </tr>
            <tr>
                <td>Royal Challengers Bangalore VS Kolkata Knight Riders</td>
                <td>8000</td>
            </tr>
        </table>
        <br>
        <br>
        <h3>Enter these details to book tickets:</h3>
            <form action="BookHall" method="get">
                <fieldset>
                    Customer Name : <input type="text" name="cname"/><br>
                    Phone Number  : <input type="text" name="cphno" /><br>
                    Match :
                    <select name="matchname">
                        <option>RCB VS CSK</option>
                        <option>RCB VS RR</option>
                        <option>RCB VS MI</option>
                        <option>RCB VS KKR</option>
                    </select><br>
                    Number of Tickets  : <input type="number" name="qty" /><br>
                    <input type="submit"/><br>
                </fieldset>
               
            </form>
            
        </body>
       
</body>
</html>
