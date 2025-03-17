package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/users")
    public String getUsers() {
        String url = "jdbc:mysql://" + System.getenv("DB_HOST") + ":3306/myappdb";
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASS");
        StringBuilder result = new StringBuilder();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name FROM users")) {

            while (rs.next()) {
                result.append(rs.getString("name")).append("<br>");
            }
        } catch (Exception e) {
            return "Database connection failed: " + e.getMessage();
        }

        return result.toString();
    }
}
