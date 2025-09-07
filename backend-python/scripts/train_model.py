import joblib
import numpy as np
from sklearn.linear_model import LinearRegression
import os

# Create directory for models if not exist
os.makedirs("../models", exist_ok=True)

# Dummy training data
X = np.array([[1], [2], [3], [4]])
y = np.array([2, 4, 6, 8])

# Train model
model = LinearRegression()
model.fit(X, y)

# Save model
joblib.dump(model, "../models/linear_regression_model.pkl")
print("✅ Model trained and saved to ../models/linear_regression_model.pkl")
