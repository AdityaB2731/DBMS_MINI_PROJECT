# Test script for Railway Booking System API
Write-Host "Testing Railway Booking System API..." -ForegroundColor Green

# Wait for application to start
Write-Host "Waiting for application to start..." -ForegroundColor Yellow
Start-Sleep -Seconds 15

# Test GET all bookings
Write-Host "`n1. Testing GET /api/bookings/all" -ForegroundColor Cyan
try {
    $response = Invoke-WebRequest -Uri "http://localhost:8080/api/bookings/all" -Method GET
    Write-Host "Status Code: $($response.StatusCode)" -ForegroundColor Green
    Write-Host "Response: $($response.Content)" -ForegroundColor White
} catch {
    Write-Host "Error: $($_.Exception.Message)" -ForegroundColor Red
}

# Test POST new booking
Write-Host "`n2. Testing POST /api/bookings/add" -ForegroundColor Cyan
$bookingData = @{
    passengerName = "John Doe"
    trainName = "Express 123"
    source = "Mumbai"
    destination = "Delhi"
} | ConvertTo-Json

try {
    $response = Invoke-WebRequest -Uri "http://localhost:8080/api/bookings/add" -Method POST -Body $bookingData -ContentType "application/json"
    Write-Host "Status Code: $($response.StatusCode)" -ForegroundColor Green
    Write-Host "Response: $($response.Content)" -ForegroundColor White
} catch {
    Write-Host "Error: $($_.Exception.Message)" -ForegroundColor Red
}

# Test GET all bookings again
Write-Host "`n3. Testing GET /api/bookings/all (after adding booking)" -ForegroundColor Cyan
try {
    $response = Invoke-WebRequest -Uri "http://localhost:8080/api/bookings/all" -Method GET
    Write-Host "Status Code: $($response.StatusCode)" -ForegroundColor Green
    Write-Host "Response: $($response.Content)" -ForegroundColor White
} catch {
    Write-Host "Error: $($_.Exception.Message)" -ForegroundColor Red
}

Write-Host "`nAPI Testing Complete!" -ForegroundColor Green
