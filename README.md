# 🚀 Project 86 – AWS EC2 Deploy + Docker | Full Stack DevOps System | EC2 Ready

![Java 21](https://img.shields.io/badge/Java-21-E76F00?logo=openjdk&logoColor=white)
![Spring Boot 3.2.5](https://img.shields.io/badge/Spring%20Boot-3.2.5-6DB33F?logo=springboot&logoColor=white)
![Docker Ready](https://img.shields.io/badge/Docker-Ready-2496ED?logo=docker&logoColor=white)
![AWS EC2](https://img.shields.io/badge/AWS-EC2-FF9900?logo=amazonec2&logoColor=white)
![Ubuntu](https://img.shields.io/badge/Ubuntu-22.04-E95420?logo=ubuntu&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.9+-C71A36?logo=apachemaven&logoColor=white)
![Tomcat](https://img.shields.io/badge/Apache%20Tomcat-11.0.24-D4AF00?logo=apachetomcat&logoColor=white)
![Port](https://img.shields.io/badge/Port-9494%20%7C%2080-20B000)
![Status](https://img.shields.io/badge/Status-EC2%20Ready-20B000)



**Live URL:** https://eight6-aws-ec2-deploy.onrender.com/

[![Live](https://img.shields.io/badge/Live-Render-brightgreen?style=for-the-badge&logo=render)](https://eight5-github-actions-ci.onrender.com)




Project 86 - Part of Java 100 Projects Challenge - DevOps + Cloud Tier
---

# 📖 Project Overview

**AWS EC2 Deploy System** is Project 86 of **Tier 9 – DevOps + Cloud Deployment**, developed using **Java 21**, **Spring Boot 3.2.5**, **Docker**, **AWS EC2 (t2.micro Free Tier)**, **Ubuntu 22.04**, **Maven**, and **Apache Tomcat 11.0.24** in a **production EC2 deployed repo**.

Spring Boot REST API running on port 9494 inside Docker container on AWS EC2 instance now manually deployed via SSH + `deploy.sh` and auto-deploy via GitHub Actions SSH returns live JSON `{"status":"Live on AWS EC2 - Free Tier","project":"86-aws-ec2-deploy","tier":"9 - DevOps + Cloud"}`. This repo contains **Dockerfile (multi-stage)**, **deploy.sh**, **.github/workflows/ec2-deploy.yml**, **Spring Boot source** - eliminating manual local run only. One `git push` gives full EC2 live production URL.

This is Project 86 of Tier 9 - After GitHub Actions CI (Project 85), now real cloud deployment base for S3, RDS, Load Balancer, CloudWatch.

**Bug Fixed:** `Error: Permission denied (publickey)` when SSH to EC2 - PEM key has wrong permissions `0644` too open. Fixed by `chmod 400 86-key.pem` + using correct user `ubuntu` not `ec2-user` for Ubuntu AMI.

**Bug Fixed:** `Error: Port 9494: Connection timed out` from browser - Security Group not allowing Custom TCP 9494. Fixed by EC2 Console -> Security Groups -> Inbound Rules -> Add Rule -> Type: Custom TCP, Port: 9494, Source: 0.0.0.0/0.

**Bug Fixed:** `Error: Cannot connect to the Docker daemon at unix:///var/run/docker.sock. Is the docker daemon running?` on EC2 - Docker service not started. Fixed by `sudo systemctl start docker` + `sudo systemctl enable docker` + `sudo usermod -aG docker ubuntu`.

**Bug Fixed:** `Error: docker: command not found` - Docker not installed on fresh Ubuntu EC2. Fixed by `sudo apt update && sudo apt install docker.io -y` before build.

---

# ✨ Features

- EC2 Ready status API with JSON response - `{"status":"Live on AWS EC2 - Free Tier",...}`
- Fully production deployed - Docker container on AWS EC2 t2.micro Free Tier
- AWS EC2 Launch - Ubuntu 22.04 AMI with t2.micro (Free tier eligible)
- Security Group Config - Inbound rules for SSH (22), Custom 9494, HTTP (80) open to 0.0.0.0/0
- Dockerfile Multi-Stage - `maven:3.9-eclipse-temurin-21` builder + `eclipse-temurin:21-jdk` runtime - Image ~180MB
- One-Command Deploy - `deploy.sh` with `docker stop || true`, `docker build`, `docker run -d --restart always`
- Auto-Restart on Reboot - `--restart always` flag ensures container up after EC2 restart
- GitHub Actions CD - `.github/workflows/ec2-deploy.yml` with `appleboy/ssh-action@v1.0.3` auto deploys on `push to main`
- SSH Key Authentication - PEM key via GitHub Secrets `EC2_HOST`, `EC2_SSH_KEY`
- Spring Boot banner v3.2.5 inside EC2 `docker logs`
- Tomcat initialized with port 9494 (http) inside EC2 Docker container
- Started Application in 6.2 seconds (EC2 t2.micro) vs 11.4 seconds (Local Eclipse)
- Verified with `http://EC2_PUBLIC_IP:9494` -> Live JSON + `docker ps` -> `Up 5 minutes`
- Public Production URL - `http://3.110.XX.XX:9494` accessible anywhere - Portfolio ready

---

# 🛠 Technologies Used

- Java 21.0.10
- Spring Boot 3.2.5
- Spring Web - REST API
- Docker - Multi-stage build
- Docker Hub - Optional for EC2 pull (or build on EC2)
- AWS EC2 - t2.micro Free Tier - Region ap-south-1 (Mumbai)
- Ubuntu 22.04 LTS - EC2 OS
- GitHub Actions - `appleboy/ssh-action@v1.0.3` for CD
- GitHub Secrets - `EC2_HOST`, `EC2_USERNAME`, `EC2_SSH_KEY`
- Dockerfile - `FROM maven:3.9 AS builder` + `FROM eclipse-temurin:21-jdk`
- deploy.sh - Bash script for EC2 deploy
- Security Groups - EC2 Firewall config
- Maven 3.9+
- Apache Tomcat 11.0.24 (Embedded) - TomcatWebServer
- PuTTY / OpenSSH - For SSH connection
- Windows 11 - PowerShell + Eclipse IDE
- AWS Console - EC2 Dashboard

---

# 📂 Project Structure - EC2 Repo

```text
86-aws-ec2-deploy
│
├── .github
│   └── workflows
│       └── ec2-deploy.yml
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── ravi
│   │   │           └── ec2
│   │   │               └── Ec2Application.java
│   │   │
│   │   └── resources
│   │       └── application.properties
│   │
│   └── test
│       └── java
│           └── com
│               └── ravi
│                   └── ec2
│                       └── Ec2ApplicationTests.java
│
├── screenshots
│   ├── demo1-ec2-launch.png
│   ├── demo2-security-group.png
│   ├── demo3-ssh-connect.png
│   ├── demo4-docker-build-ec2.png
│   └── demo5-live-ec2-url.png
│
├── Dockerfile
├── deploy.sh
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

---

# ▶ How to Run - EC2 Repo

## 1⃣ Clone the Repository

```bash
git clone https://github.com/raviteja-dev950/86-aws-ec2-deploy.git
cd 86-aws-ec2-deploy
```

---

## 2⃣ Verify application.properties & Controller

- Verify `src/main/resources/application.properties`

```properties
spring.application.name=86-aws-ec2-deploy
server.port=9494
```

- Verify `Ec2Application.java`

```java
package com.ravi.ec2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@SpringBootApplication
@RestController
public class Ec2Application {
  public static void main(String[] args) { SpringApplication.run(Ec2Application.class, args); }

  @GetMapping("/")
  public Map<String, String> home() {
    return Map.of(
      "tier","9 - DevOps + Cloud",
      "project","86-aws-ec2-deploy",
      "status","Live on AWS EC2 - Free Tier",
      "owner","RaviTeja"
    );
  }
}
```

- Verify `Dockerfile`

```dockerfile
FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 9494
ENTRYPOINT ["java","-jar","app.jar"]
```

- Verify `deploy.sh`

```bash
#!/bin/bash
echo "🚀 Deploying 86-aws-ec2-deploy on EC2..."
docker stop app86 || true
docker rm app86 || true
docker build -t app86 .
docker run -d -p 9494:9494 -p 80:9494 --restart always --name app86 app86
echo "✅ LIVE at http://$(curl -s http://169.254.169.254/latest/meta-data/public-ipv4):9494"
docker logs app86
```

- Verify `.github/workflows/ec2-deploy.yml`

```yaml
name: Deploy to EC2
on:
  push:
    branches: [ "main" ]
jobs:
  deploy:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - name: Deploy to EC2 via SSH
        uses: appleboy/ssh-action@v1.0.3
        with:
          host: ${{ secrets.EC2_HOST }}
          username: ubuntu
          key: ${{ secrets.EC2_SSH_KEY }}
          script: |
            cd ~/86-aws-ec2-deploy
            git pull origin main
            chmod +x deploy.sh
            ./deploy.sh
```

---

## 3⃣ Launch AWS EC2 (Free Tier)

Go to `AWS Console -> EC2 -> Launch Instance`

```text
Name: 86-ec2-deploy
OS: Ubuntu Server 22.04 LTS (Free tier)
Instance Type: t2.micro (Free tier)
Key Pair: Create new -> 86-key.pem -> Download
Security Group: Create
  - SSH (22) -> My IP
  - Custom TCP (9494) -> 0.0.0.0/0
  - HTTP (80) -> 0.0.0.0/0
Launch
```

Expected: Instance State `Running` + Public IPv4 `3.110.XX.XX`

---

## 4⃣ Connect via SSH & Deploy

```bash
# Fix PEM permission
chmod 400 86-key.pem

# SSH (Ubuntu user)
ssh -i "86-key.pem" ubuntu@3.110.XX.XX

# Inside EC2
sudo apt update
sudo apt install openjdk-21-jdk docker.io git -y
sudo systemctl start docker
sudo systemctl enable docker
sudo usermod -aG docker ubuntu
exit

# Reconnect
ssh -i "86-key.pem" ubuntu@3.110.XX.XX

git clone https://github.com/raviteja-dev950/86-aws-ec2-deploy.git
cd 86-aws-ec2-deploy
chmod +x deploy.sh
./deploy.sh
```

Expected:

```text
🚀 Deploying 86-aws-ec2-deploy on EC2...
Successfully built
app86 running
✅ LIVE at http://3.110.XX.XX:9494
Tomcat started on port 9494
Started Ec2Application in 6.2 seconds
```

---

## 5⃣ Verify Live on AWS

Open Browser:

```
http://3.110.XX.XX:9494
```

Expected:

```json
{
  "tier":"9 - DevOps + Cloud",
  "project":"86-aws-ec2-deploy",
  "status":"Live on AWS EC2 - Free Tier",
  "owner":"RaviTeja"
}
```

Check Docker:

```bash
docker ps
# CONTAINER ID   IMAGE   STATUS         PORTS
# abc123         app86   Up 5 minutes   0.0.0.0:9494->9494/tcp

docker logs app86
# Tomcat started on port 9494
```

---

## 6⃣ Add GitHub Secrets for Auto CD (Optional but Recommended)

Go to `GitHub Repo -> Settings -> Secrets and variables -> Actions -> New repository secret`

Add 3 secrets:

```text
EC2_HOST = 3.110.XX.XX
EC2_USERNAME = ubuntu
EC2_SSH_KEY = (Paste full content of 86-key.pem)
```

Push:

```bash
git add .
git commit -m "Project 86 - AWS EC2 Deploy - Live on EC2"
git push -u origin main
```

Check `Actions Tab -> Deploy to EC2 -> SUCCESS Green`

---

# 🔄 Flow Diagram - How EC2 Deploy Works

```text
    User Laptop (Eclipse)
        │
        ├── E:\Java-100-Projects\86-aws-ec2-deploy
        │       ├── src -> Ec2Application.java
        │       ├── Dockerfile (multi-stage)
        │       └── deploy.sh
        │
        ▼
    git push origin main
        │
        ├───▶ GitHub Repository: raviteja-dev950/86-aws-ec2-deploy
        │           │
        │           ▼
        │       GitHub Actions CD Triggered (on: push main)
        │           │
        │           └── appleboy/ssh-action@v1.0.3
        │                 └── SSH to EC2 -> git pull -> ./deploy.sh
        │
        └───▶ Manual Deploy (Alternative)
              │
              ▼
    AWS Console -> EC2
        │
        ├── Launch Instance: Ubuntu 22.04 + t2.micro (Free Tier)
        │     ├── Key Pair: 86-key.pem (chmod 400)
        │     └── Security Group: 22 (SSH) + 9494 (Custom) + 80 (HTTP)
        │
        ▼
    SSH to EC2: ssh -i 86-key.pem ubuntu@3.110.XX.XX
        │
        ├── Step 1: sudo apt update && sudo apt install openjdk-21-jdk docker.io git -y
        ├── Step 2: sudo systemctl start docker + enable
        ├── Step 3: git clone https://github.com/raviteja-dev950/86-aws-ec2-deploy.git
        ├── Step 4: cd 86-aws-ec2-deploy && chmod +x deploy.sh && ./deploy.sh
        │     ├── docker build -t app86 .
        │     └── docker run -d -p 9494:9494 --restart always --name app86 app86
        │
        ▼
    EC2 Public IP: 3.110.XX.XX:9494
        │
        ▼
    Browser: http://3.110.XX.XX:9494
         │
         ▼
    {
      tier: 9 - DevOps + Cloud,
      project: 86-aws-ec2-deploy,
      status: Live on AWS EC2 - Free Tier,
      owner: RaviTeja
    }
        │
        ▼
    Docker Hub Optional: docker push (if needed)
    Portfolio: Live AWS URL added to Resume + LinkedIn
```

---

# 📸 Screenshots

### Demo 1 - EC2 Instance Launched

AWS Console `EC2 -> Instances` shows Instance `86-ec2-deploy` State `Running` + Instance Type `t2.micro` + Public IPv4 `3.110.XX.XX` - Proof of Free Tier EC2 launch.

[Demo 1](screenshots/demo1-ec2-launch.png)

### Demo 2 - Security Group Inbound Rules

EC2 `Security Groups -> Inbound rules` shows 3 rules: SSH Port 22 (My IP), Custom TCP 9494 (0.0.0.0/0), HTTP 80 (0.0.0.0/0) - Proof of port 9494 open for Spring Boot.

[Demo 2](screenshots/demo2-security-group.png)

### Demo 3 - SSH Connected to EC2

Terminal `ssh -i 86-key.pem ubuntu@3.110.XX.XX` shows Ubuntu prompt `ubuntu@ip-172-31-XX-XX:~$` - `java -version` shows `openjdk 21` + `docker --version` shows `Docker version 24.0.5` - Proof of EC2 ready.

[Demo 3](screenshots/demo3-ssh-connect.png)

### Demo 4 - Docker Build & Run on EC2

EC2 Terminal `cd 86-aws-ec2-deploy && ./deploy.sh` shows logs: `Successfully built`, `Tomcat started on port 9494`, `Started Ec2Application in 6.2 seconds` - `docker ps` shows `Up` - Proof of Docker container running on EC2.

[Demo 4](screenshots/demo4-docker-build-ec2.png)

### Demo 5 - Live on AWS EC2 - Browser

Browser `http://3.110.XX.XX:9494` shows JSON with `project: 86-aws-ec2-deploy`, `status: Live on AWS EC2 - Free Tier` - Pretty-printed - Proof of production live URL on AWS.

[Demo 5](screenshots/demo5-live-ec2-url.png)

---

# 🧪 API Testing Examples

```bash
# GET EC2 Ready - Local after Eclipse Run
curl http://localhost:9494

# GET EC2 Ready - LIVE on AWS
curl http://3.110.XX.XX:9494

# Check Health
curl http://3.110.XX.XX:9494/health

# SSH to EC2
ssh -i "86-key.pem" ubuntu@3.110.XX.XX

# Docker on EC2
docker ps
docker logs app86
docker stop app86
docker rm app86
docker images | grep app86

# Deploy Script on EC2
cd ~/86-aws-ec2-deploy
chmod +x deploy.sh
./deploy.sh

# Git Pull + Deploy (CD manual)
git pull origin main
./deploy.sh

# Check EC2 Public IP from inside EC2
curl http://169.254.169.254/latest/meta-data/public-ipv4

# Check open ports on EC2
sudo netstat -tulpn | grep 9494

# Trigger GitHub Actions CD
git commit --allow-empty -m "Trigger EC2 CD"
git push origin main
```

### Expected Response (localhost:9494 & EC2:9494) - EC2 Ready

```json
{
  "tier":"9 - DevOps + Cloud",
  "project":"86-aws-ec2-deploy",
  "status":"Live on AWS EC2 - Free Tier",
  "owner":"RaviTeja"
}
```

### Expected EC2 Terminal Log Response

```text
ubuntu@ip-172-31-XX-XX:~/86-aws-ec2-deploy$ ./deploy.sh
🚀 Deploying 86-aws-ec2-deploy on EC2...
app86
Removing app86
Sending build context to Docker daemon
Step 1/8 : FROM maven:3.9-eclipse-temurin-21 AS builder
...
Successfully built abc123
Successfully tagged app86:latest
abc123def456
✅ LIVE at http://3.110.12.34:9494
Tomcat started on port 9494 (http) with context path ''
Started Ec2Application in 6.214 seconds
```

### Expected Docker PS Response on EC2

```text
CONTAINER ID   IMAGE   COMMAND           CREATED         STATUS         PORTS                              NAMES
a1b2c3d4e5f6   app86   "java -jar app.jar"   5 minutes ago   Up 5 minutes   0.0.0.0:80->9494/tcp, 0.0.0.0:9494->9494/tcp   app86
```

**Testing Steps:**

1. Run `ssh -i 86-key.pem ubuntu@EC2_IP` - Should connect to EC2 Ubuntu prompt
2. Run `docker ps` - Should show `app86` container `Up`
3. Open `http://EC2_IP:9494` - Should return EC2 Ready JSON - Proof of AWS live
4. Run `git push origin main` - Should trigger `Deploy to EC2` workflow GREEN tick
5. Check `Actions Tab -> Deploy to EC2 -> SUCCESS` - Proof of CD working
6. Run `curl http://EC2_IP:9494` after push - Should still return JSON with no downtime (restart always)
7. Reboot EC2 `sudo reboot` + wait 1 min + `curl http://EC2_IP:9494` - Should still work (restart always)

---

# 🎯 Learning Outcomes

- Understanding AWS EC2 fundamentals - Elastic Compute Cloud vs Render/Railway vs Local
- Launching EC2 Instance - Ubuntu 22.04 LTS AMI + t2.micro Free Tier + ap-south-1 region
- Understanding Key Pair - PEM file `chmod 400` + `ubuntu` user for Ubuntu AMI vs `ec2-user` for Amazon Linux
- Configuring Security Groups - Inbound Rules for 22 (SSH), 80 (HTTP), 9494 (Spring Boot Custom) with 0.0.0.0/0
- Connecting via SSH - `ssh -i key.pem ubuntu@PUBLIC_IP` + PuTTY conversion `.pem` to `.ppk` for Windows
- Installing Java + Docker on EC2 - `apt update`, `openjdk-21-jdk`, `docker.io`, `systemctl start docker`, `usermod -aG docker`
- Understanding Docker on EC2 vs Local - Same Dockerfile works everywhere - Build once, run anywhere
- Creating `deploy.sh` - Bash script with `docker stop || true`, `docker rm || true`, `docker build`, `docker run -d --restart always`
- Understanding `--restart always` - Container auto-starts after EC2 reboot - Production requirement
- Using Git on EC2 - `git clone`, `git pull` for CD - Pull latest code from GitHub to EC2
- Creating GitHub Actions CD - `appleboy/ssh-action@v1.0.3` + Secrets `EC2_HOST`, `EC2_SSH_KEY` - Auto SSH + deploy on push
- Debugging `Permission denied (publickey)` - Wrong PEM permissions + wrong username
- Debugging `Connection timed out` - Security Group not open for 9494
- Understanding difference between Project 83 (Manual Docker local), 85 (GitHub Actions CI to Docker Hub), 86 (Docker to AWS EC2 production)
- Getting Public Production URL - `http://3.110.XX.XX:9494` - Add to Resume, LinkedIn, Portfolio - Real cloud project
- Preparing base for S3 (87), RDS (88), CloudWatch (89), Load Balancer (90)

---

# 🚀 Future Enhancements

- 🪣 Add S3 File Service - Project 87 - After EC2 deploy, add S3 bucket for file upload via `aws-sdk-java-s3`
- 🗄 Add RDS Integration - Project 88 - Connect EC2 Spring Boot to AWS RDS MySQL - Replace H2/local MySQL
- 📊 Add CloudWatch Logs - Project 89 - Ship Spring Boot logs to AWS CloudWatch via `logback` + CloudWatch agent
- ⚖ Add Load Balanced App - Project 90 - Launch 2 EC2 + ALB + Target Group + Health Checks - `http://alb-dns:9494`
- 🏗 Add Terraform Script - Project 91 - IaC for EC2 + Security Group via `terraform apply` instead of Console clicks
- 🔵🟢 Add Blue-Green Deploy - Project 92 - 2 EC2 Auto Scaling Groups - Zero downtime deploy
- 🔒 Add Nginx + SSL - Project 93 - Nginx reverse proxy `80 -> 9494` + Let's Encrypt SSL `https://yourdomain.com`
- 🌐 Add Custom Domain + Route53 - Project 94 - Map `api.raviteja.dev` to EC2 IP via Route53 A record
- 📦 Add ECR Instead of Docker Hub - Project 95 - Push to AWS ECR `aws ecr get-login-password | docker login`
- 🔐 Add IAM Role Instead of Keys - Project 96 - Attach IAM Role to EC2 for S3/RDS access - No hardcoded AWS keys
- 📈 Add Auto Scaling - Project 97 - ASG with min 1 max 3 + CloudWatch alarm CPU > 70% -> Scale out
- 🔍 Add Version Tagging + ECR - Project 98 - `v1.0.${{ github.run_number }}` tags on ECR + rollback via `docker run previous_tag`

---

# 👨💻 Author

Ravi Teja

Java Full Stack Developer

100 Java Full Stack Projects Challenge

Project 86 / 100

Tier 9 – DevOps + Cloud Deployment

---

## ⭐ Support

If you found this project helpful, consider giving it a ⭐ Star on GitHub.

**Single Repo:** [86-aws-ec2-deploy](https://github.com/raviteja-dev950/86-aws-ec2-deploy)

**Live URL:** `http://YOUR_EC2_PUBLIC_IP:9494` -> Replace with your EC2 IP after launch

**EC2 Instance:** `t2.micro` Free Tier - Ubuntu 22.04 - Region `ap-south-1` (Mumbai)

**Docker Image:** `app86:latest` on EC2 (or `ravitejadev950/86-aws-ec2-deploy:latest` on Docker Hub optional)

**GitHub Actions:** `Deploy to EC2` - On Push to `main` via SSH

**Secrets:** `EC2_HOST` + `EC2_SSH_KEY` (PEM content)

**Trigger:** `git push origin main` -> Actions GREEN -> EC2 auto deployed -> `http://EC2_IP:9494` LIVE

**SSH:** `ssh -i 86-key.pem ubuntu@EC2_IP`

**Deploy:** `chmod +x deploy.sh && ./deploy.sh` -> `docker ps` -> `curl localhost:9494`

**Pull:** `git clone https://github.com/raviteja-dev950/86-aws-ec2-deploy.git`
