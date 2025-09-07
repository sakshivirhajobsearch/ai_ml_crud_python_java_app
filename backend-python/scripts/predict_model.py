import os
import joblib

# Get the base directory (one level up from scripts/)
BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))

# Construct the full path to the model
MODEL_PATH = os.path.join(BASE_DIR, "models", "linear_regression_model.pkl")

# Load the model
try:
    model = joblib.load(MODEL_PATH)
    print("Model loaded successfully!")
except FileNotFoundError:
    print(f"Model file not found at: {MODEL_PATH}")
    exit(1)

# Example prediction (replace with your actual input)
import numpy as np
sample_input = np.array([[5.0]])  # Example input shape should match your trained model
prediction = model.predict(sample_input)
print("Prediction:", prediction)
