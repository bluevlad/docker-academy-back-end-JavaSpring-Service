# CI/CD Architecture & Security Setup Guide

## 1. Overview
This project uses a **Self-hosted GitHub Actions Runner** to deploy the Spring Boot Microservice to a local Windows environment running Docker Desktop.

- **Source Code**: GitHub Repository
- **Runner**: Local Windows PC (Self-hosted)
- **Containerization**: Docker
- **Target environment**: Local Docker container

## 2. Security Configuration (CRITICAL)
To prevent credential leaks, the following security measures are enforced:

### 2.1. Git Ignore Rules
The following directories and files are excluded from version control via `.gitignore` and **must never be forcibly added**:
- `/actions-runner/`: Contains the runner's unique identity and authentication tokens (`.credentials`).
- `.env`: Contains runtime environment variables.
- `.gradle/`, `build/`, `target/`: Build artifacts.

### 2.2. Secrets Management
Sensitive information is strictly managed using **GitHub Secrets**:
- **Settings Path**: `Settings` > `Security` > `Secrets and variables` > `Actions`

## 3. Self-hosted Runner Setup Instructions
If the runner needs to be re-installed or moved to a new machine:

1.  **Navigate to GitHub**:
    - Go to `Settings` > `Actions` > `Runners` > `New self-hosted runner`.
    - Select **Windows** architecture (x64).

2.  **Installation (PowerShell)**:
    ```powershell
    mkdir actions-runner; cd actions-runner
    Invoke-WebRequest -Uri https://github.com/actions/runner/releases/download/v2.321.0/actions-runner-win-x64-2.321.0.zip -OutFile actions-runner.zip
    Add-Type -AssemblyName System.IO.Compression.FileSystem ; [System.IO.Compression.ZipFile]::ExtractToDirectory("$PWD/actions-runner.zip", "$PWD")
    ```

3.  **Configuration**:
    ```powershell
    ./config.cmd --url https://github.com/bluevlad/docker-academy-back-end-JavaSpring-Service --token <DISPLAYED_TOKEN_ON_GITHUB>
    ```
