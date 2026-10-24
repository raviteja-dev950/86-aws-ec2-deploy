#!/bin/bash
echo "🚀 Deploying 86-aws-ec2-deploy on EC2..."
docker stop app86 || true
docker rm app86 || true
docker build -t app86 .
docker run -d -p 9494:9494 -p 80:9494 --restart always --name app86 app86
echo "✅ LIVE at http://$(curl -s http://169.254.169.254/latest/meta-data/public-ipv4):9494"
docker logs app86