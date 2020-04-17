<%@ page import="java.io.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>

<%!
    // --- String Join Function
    public String join(ArrayList<?> arr, String del)
    {

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < arr.size(); i++)
        {

            if (i > 0) output.append(del);
            
            // --- Quote strings, only, for JS syntax
            if (arr.get(i) instanceof String) output.append("\"");
            output.append(arr.get(i));
            if (arr.get(i) instanceof String) output.append("\"");
        }

        return output.toString();
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Temperature History</title>
    <script type="text/javascript" src="https://cdn.zingchart.com/zingchart.min.js"></script>
</head>
<body>
    <script>
        <%
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            final String host = "jdbc:mysql://localhost/" + "chart";
            final Connection conn = DriverManager.getConnection(host, "admin", "Asdf$1234");
            final Statement stmt = conn.createStatement();
            final ResultSet rs = stmt.executeQuery("select date, temp from temperature");

            ArrayList<String> months = new ArrayList<String>();
            ArrayList<Double> users = new ArrayList<Double>();

            while(rs.next())
            {
                months.add(rs.getString("date"));
                users.add(Double.parseDouble(rs.getString("temp")));
            }

            conn.close();
        %>

        var Timestamp = [<%= join(months, ",") %>];
        var Temperature = [<%= join(users, ",") %>];
        
    </script>
    <script>
    window.onload = function()
    {
        zingchart.render
        ({
            id:"myChart",
            width:"100%",
            height:400,
            data:
            {
                "type":"bar",
                "title":
                {
                    "text":"Temperature Data Pulled from MySQL Database"
                },
                "scale-x":
                {
                    "labels": Timestamp
                },
                "plot":
                {
                    "line-width":1
                },
                "series":
                [
                    {
                      "values":Temperature
                    }
                ]
            }
        });
    };
    </script>
    <h1>Historical Temperature for Class Room B110</h1>
    <div id="myChart"></div>
</body>
</html>