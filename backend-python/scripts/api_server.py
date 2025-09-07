from flask import Flask, request, jsonify
import joblib
import os
import numpy as np

app = Flask(__name__)

# Get the base directory (one level up from scripts/)
BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))

# Full path to the trained model
MODEL_PATH = os.path.join(BASE_DIR, "models", "linear_regression_model.pkl")

# Load the model
try:
    model = joblib.load(MODEL_PATH)
    print("✅ Model loaded successfully!")
except FileNotFoundError:
    print(f"❌ Model file not found at: {MODEL_PATH}")
    exit(1)

# Root endpoint for testing
@app.route("/", methods=["GET"])
def home():
    return "✅ AI/ML Prediction API is running!"

# Prediction endpoint
@app.route("/predict", methods=["POST"])
def predict():
    try:
        data = request.json
        # Ensure input is provided
        if "input" not in data:
            return jsonify({"error": "Missing 'input' in request body"}), 400

        # Convert input to numpy array
        sample_input = np.array([data["input"]])
        prediction = model.predict(sample_input)

        return jsonify({"prediction": prediction.tolist()})
    except Exception as e:
        return jsonify({"error": str(e)}), 500

# Run server on port 8000
if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8000, debug=True)
