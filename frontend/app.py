from flask import Flask, render_template, request, redirect
import requests

app = Flask(__name__)
API_URL = "http://localhost:8080/api/bookings"

@app.route('/')
def home():
    # resp = requests.get(f"{API_URL}/all")
    # bookings = resp.json()
    bookings = []
    return render_template('index.html', bookings=bookings)

@app.route('/book', methods=['GET', 'POST'])
def book():
    if request.method == 'POST':
        data = {
            "passengerName": request.form['passengerName'],
            "trainName": request.form['trainName'],
            "source": request.form['source'],
            "destination": request.form['destination']
        }
        requests.post(f"{API_URL}/add", json=data)
        return redirect('/')
    return render_template('booking.html')

if __name__ == "__main__":
    app.run(debug=True)
