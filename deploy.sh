#!/bin/bash
set -e

echo "=== Deploying Academy Backend ==="

# Load the Docker image
echo "Loading Docker image..."
docker load -i /tmp/deploy/academy-backend.tar

# Stop existing container if running
echo "Stopping existing container..."
docker stop academy-main-api-prod 2>/dev/null || true
docker rm academy-main-api-prod 2>/dev/null || true

# Start new container
echo "Starting new container..."
docker run -d \
  --name academy-main-api-prod \
  --restart unless-stopped \
  -p 0.0.0.0:80:80 \
  -e SPRING_PROFILES_ACTIVE=prod \
  -e SERVER_ADDRESS=0.0.0.0 \
  academy-backend:latest

# Cleanup
echo "Cleaning up..."
rm -f /tmp/deploy/academy-backend.tar

# Health check
echo "Waiting for application to start..."
sleep 10
if curl -s http://localhost:80/ > /dev/null; then
  echo "✅ Deployment successful!"
else
  echo "❌ Health check failed!"
  exit 1
fi
