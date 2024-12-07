<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Admin Login - Axis Bank</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        body {
            background: #B41F45;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            color: white;
        }
        .login-container {
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.3);
            color: #333333;
            width: 320px;
        }
        h3 {
            color: #B41F45;
            text-align: center;
        }
        .form-group label {
            color: #555555;
        }
        button {
            width: 100%;
            padding: 10px;
            border: none;
            background-color: #B41F45;
            color: white;
            border-radius: 4px;
            font-size: 16px;
        }
        button:hover {
            background-color: #8e1536;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h3>Admin Login</h3>
        <form action="/admin/authenticate" method="post">
            <div class="form-group">
                <label>Username:</label>
                <input type="text" name="username" class="form-control" required />
            </div>
            <div class="form-group">
                <label>Password:</label>
                <input type="password" name="password" class="form-control" required />
            </div>
            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>