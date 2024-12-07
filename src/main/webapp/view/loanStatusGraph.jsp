<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<!-- Bootstrap CSS CDN -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
<!-- Our Custom CSS -->
<link rel="stylesheet" href="../static/css/sideBar.css" />

    <title>Loan Status Distribution</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin: 20px;
        }
        canvas {
            max-width: 700px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
    <h1>Loan Status Distribution</h1>

    <!-- Pie chart for Loan Status Distribution -->
    <h2>Loan Status Pie Chart</h2>
    <canvas id="loanStatusPieChart" width="400" height="400"></canvas>

    <script>
        // Fetch loan status data from the backend
        fetch('/api/loans/status-distribution')
            .then(response => response.json())
            .then(data => {
                const labels = Object.keys(data); // Loan statuses (e.g., Approved, Declined)
                const values = Object.values(data); // Loan counts

                const ctx = document.getElementById('loanStatusPieChart').getContext('2d');
                new Chart(ctx, {
                    type: 'pie',
                    data: {
                        labels: labels,
                        datasets: [{
                            label: 'Loan Status Distribution',
                            data: values,
                            backgroundColor: [
                                '#36A2EB', // Approved
                                '#FF6384', // Declined
                                '#FFCE56'  // Pending, etc.
                            ],
                            hoverOffset: 4
                        }]
                    },
                    options: {
                        responsive: true,
                        plugins: {
                            legend: {
                                display: true,
                                position: 'top',
                            },
                            title: {
                                display: true,
                                text: 'Loan Status Distribution'
                            }
                        }
                    }
                });
            })
            .catch(error => console.error('Error fetching data:', error));
    </script>

    <!-- Bar chart for Loan Status Distribution -->
    <h2>Loan Status Bar Chart</h2>
    <canvas id="loanStatusBarChart" width="400" height="400"></canvas>

    <script>
        fetch('/api/loans/status-distribution')
            .then(response => response.json())
            .then(data => {
                const labels = Object.keys(data); // Loan statuses
                const values = Object.values(data); // Loan counts

                const ctx = document.getElementById('loanStatusBarChart').getContext('2d');
                new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: labels,
                        datasets: [{
                            label: 'Loan Status Distribution',
                            data: values,
                            backgroundColor: '#36A2EB', // Bar color
                            borderColor: '#1D4E89', // Border color
                            borderWidth: 1
                        }]
                    },
                    options: {
                        responsive: true,
                        plugins: {
                            legend: {
                                display: false
                            },
                            title: {
                                display: true,
                                text: 'Loan Status Bar Chart'
                            }
                        },
                        scales: {
                            y: {
                                beginAtZero: true
                            }
                        }
                    }
                });
            })
            .catch(error => console.error('Error fetching data:', error));
    </script>

    <!-- Doughnut chart for Loan Status Distribution -->
    <h2>Loan Status Doughnut Chart</h2>
    <canvas id="loanStatusDoughnutChart" width="400" height="400"></canvas>

    <script>
        fetch('/api/loans/status-distribution')
            .then(response => response.json())
            .then(data => {
                const labels = Object.keys(data); // Loan statuses
                const values = Object.values(data); // Loan counts

                const ctx = document.getElementById('loanStatusDoughnutChart').getContext('2d');
                new Chart(ctx, {
                    type: 'doughnut',
                    data: {
                        labels: labels,
                        datasets: [{
                            label: 'Loan Status Distribution',
                            data: values,
                            backgroundColor: [
                                '#36A2EB', // Approved
                                '#FF6384', // Declined
                                '#FFCE56'  // Pending, etc.
                            ],
                            hoverOffset: 4
                        }]
                    },
                    options: {
                        responsive: true,
                        plugins: {
                            legend: {
                                display: true,
                                position: 'top',
                            },
                            title: {
                                display: true,
                                text: 'Loan Status Doughnut Chart'
                            }
                        }
                    }
                });
            })
            .catch(error => console.error('Error fetching data:', error));
    </script>

    <!-- Radar chart for Loan Status Distribution -->
    <h2>Loan Status Radar Chart</h2>
    <canvas id="loanStatusRadarChart" width="400" height="400"></canvas>

    <script>
        fetch('/api/loans/status-distribution')
            .then(response => response.json())
            .then(data => {
                const labels = Object.keys(data); // Loan statuses
                const values = Object.values(data); // Loan counts

                const ctx = document.getElementById('loanStatusRadarChart').getContext('2d');
                new Chart(ctx, {
                    type: 'radar',
                    data: {
                        labels: labels,
                        datasets: [{
                            label: 'Loan Status Distribution',
                            data: values,
                            backgroundColor: 'rgba(54, 162, 235, 0.2)',
                            borderColor: '#36A2EB',
                            borderWidth: 2
                        }]
                    },
                    options: {
                        responsive: true,
                        plugins: {
                            legend: {
                                display: true,
                                position: 'top',
                            },
                            title: {
                                display: true,
                                text: 'Loan Status Radar Chart'
                            }
                        },
                        scales: {
                            r: {
                                beginAtZero: true
                            }
                        }
                    }
                });
            })
            .catch(error => console.error('Error fetching data:', error));
    </script>

    <!-- Back Button -->
    <div style="margin-top: 30px;">
        <a href="/customer-dashboard/display" class="btn btn-primary">Back to Dashboard</a>
    </div>

</body>
</html>
