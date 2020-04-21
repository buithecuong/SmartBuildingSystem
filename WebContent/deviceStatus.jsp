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

            final String host = "jdbc:mysql://35.183.144.230/smartbuilding";
            final Connection conn = DriverManager.getConnection(host, "admin", "Asdf$1234");
            final Statement stmt = conn.createStatement();
            final ResultSet rs = stmt.executeQuery("select device_id, temp from device_temp");

            ArrayList<String> devices = new ArrayList<String>();
            ArrayList<Double> temps = new ArrayList<Double>();

            while(rs.next())
            {
                devices.add(rs.getString("device_id"));
                temps.add(Double.parseDouble(rs.getString("temp")));
            }

            conn.close();
        %>

        var devices = [<%= join(devices, ",") %>];
        var Temperature = [<%= join(temps, ",") %>];
        
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
                    "text":"Device Status Data Pulled from MySQL Database"
                },
                "scale-x":
                {
                    "labels": devices
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
    <h1>Device Temperature Status</h1>
    <div id="myChart"></div>
</body>
</html>