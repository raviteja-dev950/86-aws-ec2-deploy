package com.ravi.ec2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@SpringBootApplication
@RestController
public class Ec2Application {
  public static void main(String[] args) {
    SpringApplication.run(Ec2Application.class, args);
  }

  @GetMapping("/")
  public Map<String, String> home() {
    return Map.of(
      "tier", "9 - DevOps + Cloud",
      "project", "86-aws-ec2-deploy",
      "status", "Live on AWS EC2 - Free Tier",
      "owner", "RaviTeja"
    );
  }
}