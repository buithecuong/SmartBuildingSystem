<!DOCTYPE html>
<html>
<head>
    <title>Jsp Sample</title>
    <%@page import="java.sql.*;"%>
</head>
<body bgcolor=yellow>
    <%
	Statement st= null;
 	Connection con=(Connection)DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/smartbuilding","admin","Asdf$1234");
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
       
        st=con.createStatement();
        ResultSet rs=st.executeQuery("select device_id, temp from device_temp;");
    %><table border=1 align=center style="text-align:center">
      <thead>
          <tr>
             <th>Device ID</th>
             <th>Temperature (0C)</th>
          </tr>
      </thead>
      <tbody>
        <%while(rs.next())
        {
            %>
            <tr>
                <td><%=rs.getString("device_id") %></td>
                <td><%=rs.getString("temp") %></td>
            </tr>
            <%}%>
           </tbody>
        </table><br>
    <%}
    catch(Exception e){
        out.print(e.getMessage());%><br><%
    }
    finally{
        st.close();
        con.close();
    }
    %>
</body>
</html>

<!--executeUpdate() mainupulation and executeQuery() for retriving-->