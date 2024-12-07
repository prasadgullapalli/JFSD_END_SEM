<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Online Loan Management System</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <style>
        body {
            background: linear-gradient(to bottom, #3c1053, #ad5389);
            color: #fff;
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
        }
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 90vh;
            flex-wrap: wrap;
            padding: 20px;
        }
        .image-container {
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .image-container img {
            max-width: 90%;
            border-radius: 15px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.3);
        }
        .login-container {
            flex: 1;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }
        .btn-styled {
            background-color: #4e54c8;
            color: white;
            border: none;
            border-radius: 30px;
            font-size: 18px;
            padding: 12px 20px;
            width: 70%;
            margin: 15px 0;
            text-align: center;
            transition: all 0.3s ease-in-out;
        }
        .btn-styled:hover {
            background-color: #6a11cb;
            transform: scale(1.05);
        }
        .footer {
            text-align: center;
            padding: 10px 0;
            background-color: #3c1053;
            color: white;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
        h1 {
            text-align: center;
            color: white;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <h1>Online Loan Management System [OLMS]</h1>
    <div class="container">
        <!-- Image Section -->
        <div class="image-container">
            <img src="../images/bank-loan.jpg" alt="Bank Loan">
        </div>
        <!-- Login Buttons Section -->
        <div class="login-container">
            <a href="/admin/display" class="btn-styled">Admin Login</a>
            <a href="/employee-login/display" class="btn-styled">Employee Login</a>
            <a href="/customer/display" class="btn-styled">Customer Login</a>
        </div>
    </div>
    <div class="footer">
        <p>Online Loan Management System</p>
    </div>
</body>
</html>
