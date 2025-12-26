# Automated Deployment Guide

## Overview
This document outlines the automated deployment process for the **Academy Back-End Java Spring Service**.
The system is configured to automatically deploy changes whenever code is pushed to the `prod` branch.

## Deployment Pipeline

### 1. Trigger
The deployment process, defined in GitHub Actions, is triggered automatically by:
- A `push` event to the **`prod`** branch.

### 2. Execution Environment
- The deployment flows run on a **Self-Hosted Runner** configured on the local Windows server.
- This ensures direct access to the Docker environment where the service is hosted.

### 3. Deployment Steps
The automated workflow performs the following operation sequence:

1.  **Checkout Code**: Retrieves the latest code from the `prod` branch.
2.  **Configuration Setup**: Prepares necessary Docker configuration files.
3.  **Service Restart**:
    - Stops the existing container.
    - Builds the new Docker image based on the latest code.
    - Starts the service container.

## Service Specification

- **Container Name**: `docker-academy-back-end-javaspring-service`
- **Network**: `academy-network`
- **Ports**:
    - HTTP: `8080` (External) -> `80` (Internal)
    - HTTPS: `8443` (External) -> `443` (Internal)

## Maintenance

To initiate a deployment, simply commit and push your changes to the `prod` branch:

```bash
git checkout prod
git merge main  # or apply changes
git push origin prod
```

The system will handle the rest automatically.
