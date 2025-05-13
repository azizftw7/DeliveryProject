<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8d7da;
            color: #721c24;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 100%;
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #f5c6cb;
            border-radius: 5px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h1 {
            font-size: 24px;
            margin-bottom: 20px;
        }
        p {
            font-size: 18px;
        }
        a {
            text-decoration: none;
            color: #004085;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Something Went Wrong</h1>
        <p>It seems the product you're looking for has either already been bought or doesn't exist. Please check again.</p>
        <p><a href="/WEB-INF/productform.jsp">Back to Product List</a></p>
    </div>
</body>
</html>
