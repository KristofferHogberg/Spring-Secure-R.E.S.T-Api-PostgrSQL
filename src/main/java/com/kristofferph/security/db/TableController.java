package com.kristofferph.security.db;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1/tables")
public class TableController {

    @Autowired
    private DataSource dataSource;

    @DeleteMapping("/{tableName}")
    public ResponseEntity<String> dropTable(@PathVariable String tableName) {
        try (Connection connection = dataSource.getConnection()) {
            connection.createStatement().executeUpdate("DROP TABLE IF EXISTS " + tableName);
            return new ResponseEntity<>("Table " + tableName + " was dropped successfully", HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>("Failed to drop table " + tableName + ": " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}