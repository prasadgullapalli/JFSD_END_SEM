<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Loan Calculator</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
        }

        #sidebar {
            width: 200px;
            background: #333;
            color: #fff;
            height: 100vh;
            padding: 15px;
            box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
        }

        #sidebar h3 {
            margin: 0;
            padding-bottom: 15px;
            border-bottom: 1px solid #444;
        }

        #sidebar ul {
            list-style: none;
            padding: 0;
            margin: 20px 0 0;
        }

        #sidebar ul li {
            margin: 10px 0;
        }

        #sidebar ul li a {
            color: #fff;
            text-decoration: none;
        }

        .container {
            flex: 1;
            padding: 20px;
            background: #f7f9fc;
        }

        .inner-container {
            width: 90%;
            max-width: 900px;
            margin: 0 auto;
            padding: 20px;
            background: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        .slider-container {
            margin: 20px 0;
        }

        .slider-label {
            margin-bottom: 5px;
            font-weight: bold;
            color: #444;
        }

        .slider {
            width: 100%;
        }

        .result {
            margin: 20px 0;
            padding: 10px;
            background: #eef5ff;
            border: 1px solid #ccdfff;
            border-radius: 5px;
        }

        .charts {
            display: flex;
            justify-content: center;
            gap: 20px;
            flex-wrap: wrap;
        }

        .charts canvas {
            width: 300px;
            height: 300px;
        }
    </style>
</head>
<body>
    <!-- Sidebar -->
    <nav id="sidebar">
        <h3>OLMS - Customer</h3>
        <ul>
            <li><a href="/loan-request/save">Apply loan</a></li>
            <li><a href="/loan-request/by-customer-id">Loans</a></li>
            <li><a href="/customer-dashboard/profile">Settings</a></li>
            <li><a href="/user-activity/cust-activity">My Activity</a></li>
            <li><a href="/emi-calculator">Calculate EMI</a></li>
        </ul>
    </nav>

    <div class="container">
        <div class="inner-container">
            <h1>Loan Calculator</h1>

            <div class="slider-container">
                <label class="slider-label">Loan Amount: <span id="loanAmountDisplay">500000</span> INR</label>
                <input type="range" id="loanAmount" class="slider" min="50000" max="1000000" step="10000" value="500000">
            </div>

            <div class="slider-container">
                <label class="slider-label">Loan Period: <span id="loanPeriodDisplay">5</span> Years</label>
                <input type="range" id="loanPeriod" class="slider" min="1" max="30" step="1" value="5">
            </div>

            <div class="slider-container">
                <label class="slider-label">Interest Rate: <span id="interestRateDisplay">7.5</span>%</label>
                <input type="range" id="interestRate" class="slider" min="1" max="15" step="0.1" value="7.5">
            </div>

            <div class="result">
                <p>Monthly EMI: <strong id="monthlyEMI">0</strong> INR</p>
                <p>Total Principal: <strong id="totalPrincipal">0</strong> INR</p>
                <p>Total Interest: <strong id="totalInterest">0</strong> INR</p>
                <p>Total Amount Payable: <strong id="totalPayable">0</strong> INR</p>
            </div>

            <div class="charts">
                <canvas id="pieChart"></canvas>
                <canvas id="lineChart"></canvas>
            </div>
        </div>
    </div>

    <script>
        const loanAmountSlider = document.getElementById('loanAmount');
        const loanPeriodSlider = document.getElementById('loanPeriod');
        const interestRateSlider = document.getElementById('interestRate');

        const loanAmountDisplay = document.getElementById('loanAmountDisplay');
        const loanPeriodDisplay = document.getElementById('loanPeriodDisplay');
        const interestRateDisplay = document.getElementById('interestRateDisplay');

        const monthlyEMI = document.getElementById('monthlyEMI');
        const totalPrincipal = document.getElementById('totalPrincipal');
        const totalInterest = document.getElementById('totalInterest');
        const totalPayable = document.getElementById('totalPayable');

        const pieChartCanvas = document.getElementById('pieChart');
        const lineChartCanvas = document.getElementById('lineChart');

        let pieChart, lineChart;

        function calculateEMI() {
            const loanAmount = parseFloat(loanAmountSlider.value);
            const loanPeriod = parseFloat(loanPeriodSlider.value);
            const interestRate = parseFloat(interestRateSlider.value) / 12 / 100;
            const numberOfMonths = loanPeriod * 12;

            const emi = (loanAmount * interestRate * Math.pow(1 + interestRate, numberOfMonths)) / 
                (Math.pow(1 + interestRate, numberOfMonths) - 1);

            const totalPrincipalValue = loanAmount;
            const totalInterestValue = emi * numberOfMonths - loanAmount;
            const totalPayableValue = emi * numberOfMonths;

            loanAmountDisplay.textContent = loanAmount;
            loanPeriodDisplay.textContent = loanPeriod;
            interestRateDisplay.textContent = (interestRate * 12 * 100).toFixed(1);

            monthlyEMI.textContent = emi.toFixed(2);
            totalPrincipal.textContent = totalPrincipalValue.toFixed(2);
            totalInterest.textContent = totalInterestValue.toFixed(2);
            totalPayable.textContent = totalPayableValue.toFixed(2);

            updateCharts(loanAmount, totalInterestValue);
        }

        function updateCharts(principal, interest) {
            const yearlyBreakdown = [];
            const totalYears = parseInt(loanPeriodSlider.value);
            const totalPrincipal = parseFloat(principal);

            for (let i = 1; i <= totalYears; i++) {
                yearlyBreakdown.push({
                    year: i,
                    principal: totalPrincipal / totalYears,
                    interest: interest / totalYears
                });
            }

            const years = yearlyBreakdown.map(y => `Year ${y.year}`);
            const principalData = yearlyBreakdown.map(y => y.principal);
            const interestData = yearlyBreakdown.map(y => y.interest);

            if (pieChart) pieChart.destroy();
            if (lineChart) lineChart.destroy();

            pieChart = new Chart(pieChartCanvas, {
                type: 'pie',
                data: {
                    labels: ['Principal', 'Interest'],
                    datasets: [{
                        data: [principal, interest],
                        backgroundColor: ['#4caf50', '#ff5722']
                    }]
                }
            });

            lineChart = new Chart(lineChartCanvas, {
                type: 'line',
                data: {
                    labels: years,
                    datasets: [
                        {
                            label: 'Principal',
                            data: principalData,
                            borderColor: '#4caf50',
                            fill: false
                        },
                        {
                            label: 'Interest',
                            data: interestData,
                            borderColor: '#ff5722',
                            fill: false
                        }
                    ]
                }
            });
        }

        loanAmountSlider.addEventListener('input', calculateEMI);
        loanPeriodSlider.addEventListener('input', calculateEMI);
        interestRateSlider.addEventListener('input', calculateEMI);

        calculateEMI();
    </script>
</body>
</html>
