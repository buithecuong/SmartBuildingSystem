<%@ page import="java.sql.*" %>

<% Class.forName("com.mysql.jdbc.Driver"); %>

<HTML>
    <HEAD>
        <TITLE>The tableName Database Table </TITLE>
    </HEAD>

    <BODY>
        <H1>The tableName Database Table </H1>

        <% 
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://35.183.144.230:3306/smartbuilding", "admin", "Asdf$1234");

            Statement statement = connection.createStatement() ;
            ResultSet resultset = 
                statement.executeQuery("select device_id, temp from device_temp") ; 
        %>

        <TABLE BORDER="1">
            <TR>
                <TH>Device ID</TH>
                <TH>Temperature</TH>>
            </TR>
            <% while(resultset.next()){ %>
            <TR>
                <TD> <%= resultset.getString(1) %></td>
                <TD> <%= resultset.getString(2) %></TD>
            </TR>
            <% } %>
        </TABLE>
    </BODY>
</HTML>
