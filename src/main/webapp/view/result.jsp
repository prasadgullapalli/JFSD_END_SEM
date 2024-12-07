<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Email Result</title>
    <!-- Bootstrap 4 CDN for Responsive Design -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS for additional styling -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f7fa;
            padding-top: 50px;
        }

        .container {
            max-width: 600px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 30px;
            margin: 0 auto;
        }

        h1 {
            font-size: 2rem;
            color: #333;
            margin-bottom: 20px;
        }

        .result-text {
            font-size: 1.1rem;
            color: #333;
            margin-bottom: 20px;
        }

        .result-text.success {
            color: green;
        }

        .result-text.error {
            color: red;
        }

        .btn-custom {
            background-color: #007bff;
            color: #fff;
            border-radius: 5px;
            padding: 10px 20px;
            text-decoration: none;
            display: inline-block;
            margin-right: 10px;
            margin-top: 20px;
        }

        .btn-custom:hover {
            background-color: #0056b3;
        }

        @media (max-width: 767px) {
            .container {
                padding: 20px;
            }

            h1 {
                font-size: 1.5rem;
            }
        }
    </style>
</head>

<body>
    <div class="container">
        <h1>Email Result</h1>
        <div class="result-text ${result eq 'Success' ? 'success' : 'error'}">
            <p>${result}</p>
        </div>
        <a href="/email/form" class="btn-custom">Send another email</a>
        <a href="/employee/display" class="btn-custom">Go Back to Dashboard</a>
    </div>

    <!-- Bootstrap JS and dependencies (for responsiveness) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
