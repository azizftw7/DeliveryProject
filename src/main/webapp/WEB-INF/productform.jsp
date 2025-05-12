<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
    <h1>Product List</h1>

    <table border="1">
        <tr>
            <th>Product ID</th>
            <th>Name</th>
            <th>Status</th>
            <th>Price</th>
            <th>QR Code</th>
        </tr>

        <%
            List<Product> products = (List<Product>) request.getAttribute("products");
            if (products != null && !products.isEmpty()) {
                for (Product product : products) {
        %>
                    <tr>
                        <td><%= product.getId() %></td>
                        <td><%= product.getName() %></td>
                        <td><%= product.getStatus() %></td>
                        <td><%= product.getPrice() %></td>
                        <td>
                            <!-- Link to view QR Code on a separate page -->
                            <a href="viewQRCode.jsp?qrCode=<%= product.getQrCode() %>">View QR Code</a>
                        </td>
                    </tr>
        <%
                }
            } else {
        %>
                <tr><td colspan="5">No products found</td></tr>
        <%
            }
        %>
    </table>
</body>
</html>
