<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>QR Code Viewer</title>
    <style>
        body {
		    font-family: Arial, sans-serif;
		    text-align: center;
		    padding: 40px;
		    background-color: #e6e9f0; /* softer light-gray-blue background */
		}
        h1 {
            color: #3B00DB;
        }
        .qr-container {
		    margin-top: 30px;
		    padding: 25px;
		    background: #ffffff; /* keep white QR background */
		    border: 3px solid #3B00DB; /* add a bold border */
		    border-radius: 10px;
		    display: inline-block;
		    box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2);
		}
        img {
            width: 250px;
            height: 250px;
        }
    </style>
</head>
<body>
    <h1>QR Code Viewer</h1>

    <%
        String qrCodeText = request.getParameter("qrCode");
        if (qrCodeText != null && !qrCodeText.isEmpty()) {
    %>
        <div class="qr-container">
            <h3>QR Code for: <%= qrCodeText %></h3>
            <img src="qr-codes/<%= qrCodeText %>.png" alt="QR Code" />
        </div>
    <%
        } else {
    %>
        <p>No QR code provided.</p>
    <%
        }
    %>
</body>
</html>
