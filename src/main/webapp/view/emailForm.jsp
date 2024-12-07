<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Email Form</title>
    <!-- Bootstrap 4 CDN for responsive design -->
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
            text-align: center;
        }

        label {
            font-size: 1rem;
            font-weight: 600;
            color: #333;
        }

        input, select, textarea {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        button {
            width: 100%;
            background-color: #007bff;
            color: #fff;
            padding: 12px;
            border-radius: 5px;
            font-size: 1.1rem;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .select-customer {
            font-size: 1rem;
            padding: 10px;
        }

        .select-customer option {
            font-size: 1rem;
        }

        .btn-custom {
            background-color: #007bff;
            color: #fff;
            border-radius: 5px;
            padding: 10px 20px;
            text-decoration: none;
            display: inline-block;
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

            button {
                font-size: 1rem;
            }
        }
    </style>

    <script type="text/javascript">
        // JavaScript to update email when customer name is selected
        function updateEmail() {
            var select = document.getElementById("customerSelect");
            var emailField = document.getElementById("toemail");
            var selectedEmail = select.options[select.selectedIndex].getAttribute("data-email");
            emailField.value = selectedEmail;
        }
    </script>

</head>

<body>
    <div class="container">
        <h1>Send an Email</h1>
        <form action="/email/send" method="post">
            <div class="form-group">
                <label for="customerSelect">Select Customer:</label><br>
                <select id="customerSelect" name="customerId" class="form-control select-customer" onchange="updateEmail()">
                    <option value="">--Select Customer--</option>
                    <!-- Iterate through the customers and create an option for each -->
                    <c:forEach var="customer" items="${customers}">
                        <option value="${customer.customerId}" data-email="${customer.emailId}">
                            ${customer.firstName} ${customer.lastName}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="toemail">To Email:</label><br>
                <input type="email" id="toemail" name="toemail" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="subject">Subject:</label><br>
                <input type="text" id="subject" name="subject" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="message">Message:</label><br>
                <textarea id="message" name="message" rows="4" class="form-control" required></textarea>
            </div>

            <button type="submit" class="btn btn-primary">Send Email</button>
        </form>
    </div>

    <!-- Bootstrap JS and dependencies (for responsiveness) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
