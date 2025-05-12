<%@ page import="java.io.File" %>
<%@ page import="java.io.IOException" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<html>
<head>
    <title>View QR Code</title>
</head>
<body>
    <h1>QR Code for Product</h1>

    <%
        // Get the qrCode text from the request parameter
        String qrCodeText = request.getParameter("qrCode");
        if (qrCodeText != null && !qrCodeText.isEmpty()) {
            // Build the file path for the QR code image
            String qrCodeImagePath = "/qr-codes/" + qrCodeText + ".png";
    %>
            <h3>QR Code for: <%= qrCodeText %></h3>
            <img src="qr-codes/<%= qrCodeText %>.png" alt="QR Code Image" />
    <%
        } else {
    %>
            <p>No QR code available for this product.</p>
    <%
        }
    %>
</body>
</html>
