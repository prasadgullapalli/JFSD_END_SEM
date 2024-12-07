<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Online Loan Management System - OLMS</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet" />
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        /* General styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f9fc;
            color: #333;
        }
        .navbar {
            background-color: #870b0b; /* Axis Bank-like dark maroon */
        }
        .navbar-nav .nav-item .nav-link {
            color: #fff;
            font-weight: bold;
        }
        .navbar-nav .nav-item .nav-link:hover {
            color: #f0b90b; /* Gold color on hover */
        }
        .hero-section {
            background-image: url('./images/3.jpg'); /* Background image */
            background-size: cover;
            background-position: center;
            color: #333; /* Changed to black */
            padding: 120px 0;
            text-align: center;
        }
        .hero-section h1 {
            font-size: 3rem;
            font-weight: bold;
            color: #333; /* Changed to black */
        }
        .btn-primary {
            background-color: #f0b90b;
            border: none;
        }
        .btn-primary:hover {
            background-color: #c89700;
        }
        .section-title {
            color: #870b0b;
            text-align: center;
            margin-top: 60px;
            font-size: 2rem;
        }
        /* Section styling */
        .services-section, .about-section, .contact-section {
            padding: 40px 0;
        }
        .service-card {
            border: 1px solid #ddd;
            border-radius: 5px;
            transition: transform 0.3s ease;
            text-align: center;
        }
        .service-card img {
            width: 100%;
            border-radius: 5px 5px 0 0;
        }
        .service-card:hover {
            transform: translateY(-10px);
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
        }
        .footer {
            background-color: #870b0b;
            color: #fff;
            padding: 20px 0;
            text-align: center;
        }
    </style>
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark">
        <a class="navbar-brand" href="#">OLMS</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#services">Services</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#about">About Us</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#contact">Contact</a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- Hero Section -->
    <section class="hero-section">
        <h1>Welcome to Online Loan Management System</h1>
        <p>Your trusted partner for secure and reliable financial services.</p>
        <a href="/login" class="btn btn-primary">Get Started</a>
    </section>

    <!-- Services Section -->
    <section class="services-section" id="services">
        <h2 class="section-title">Our Services</h2>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="card service-card p-3">
                        <img src="./images/4.jpg" alt="Personal Loans">
                        <h4>Personal Loans</h4>
                        <p>Flexible personal loan options to meet your financial needs.</p>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card service-card p-3">
                        <img src="./images/5.jpg" alt="Home Loans">
                        <h4>Home Loans</h4>
                        <p>Get easy financing for your dream home with affordable rates.</p>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card service-card p-3">
                        <img src="./images/6.jpg" alt="Education Loans">
                        <h4>Education Loans</h4>
                        <p>We support your educational journey with accessible loan options.</p>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- About Us Section -->
    <section class="about-section" id="about">
        <h2 class="section-title">About Us</h2>
        <div class="container">
            <p>Welcome to the Online Loan Management System (OLMS), where we provide tailored financial solutions to individuals and businesses. Our mission is to simplify the lending process with innovative technology and dedicated customer service. At OLMS, we offer a range of loan options to meet diverse needs, from personal and education loans to home financing solutions.</p>
            <p>Our team is committed to helping you achieve your financial goals through transparent practices, secure systems, and expert guidance. With a focus on convenience and accessibility, OLMS aims to redefine the way you experience loans by integrating cutting-edge digital tools and unparalleled service quality.</p>
            <p>Join the many satisfied customers who have chosen OLMS as their trusted financial partner. We are here to guide you every step of the way, ensuring a seamless and personalized experience. Discover the difference with OLMS – your reliable financial companion.</p>
        </div>
    </section>

    <!-- Contact Section -->
    <section class="contact-section" id="contact">
        <h2 class="section-title">Contact Us</h2>
        <div class="container">
            <form>
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" id="name" placeholder="Enter your name" required>
                </div>
                <div class="form-group">
                    <label for="email">Email address</label>
                    <input type="email" class="form-control" id="email" placeholder="Enter email" required>
                </div>
                <div class="form-group">
                    <label for="message">Message</label>
                    <textarea class="form-control" id="message" rows="3" placeholder="Your message" required></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </section>

    <!-- Footer -->
    <footer class="footer">
        <p>&copy; 2024 OLMS. All rights reserved.</p>
    </footer>

    <!-- Scripts -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>