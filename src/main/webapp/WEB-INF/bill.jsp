<%@ page import="model.Product" %>
<html>
<head>
    <title>Bill - Product Purchase</title>
</head>
<body>
    <h1>Bill for Product</h1>

    <%
        Product product = (Product) request.getAttribute("product");
        if (product != null) {
    %>
        <p><strong>Product Name:</strong> <%= product.getName() %></p>
        <p><strong>Price:</strong> $<%= product.getPrice() %></p>
        <p><strong>Status:</strong> <%= product.getStatus() %></p>
        <hr />
        <p>Thank you for your purchase!</p>
    <%
        } else {
    %>
        <p>Product not found or already bought.</p>
    <%
        }
    %>
</body>
</html>
