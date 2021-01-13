package com.github.volodyalombrozo.excel_65704046;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Excel65704046Application implements CommandLineRunner {

    private final MyDataSource dataSource;

    @Autowired
    public Excel65704046Application(final MyDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(Excel65704046Application.class, args);
    }

    @Override
    public void run(final String... args) {
        dataSource.initDB();
        List<Object[]> data = dataSource.loadData();
        String filePath = "/your/path/to/file";
        ExcelFile excelFile = new ExcelFile(data, filePath);
        excelFile.export();
    }
}
