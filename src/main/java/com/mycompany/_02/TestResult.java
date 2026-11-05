/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany._02;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sang
 */
public class TestResult {

    static List<TestResult> results = new ArrayList<>();

    String testcaseID;
    long expResult;
    long actResult;
    String loaiVe;
    String hangGhe;
    int soNgayDatTruoc;
    int thuBay;
    double hanhLy;
    String thanhVien;
    boolean ngayLe;
    double giaVeCoBan;

    public TestResult(String testcaseID, long expResult, long actResult,
            String loaiVe, String hangGhe, int soNgayDatTruoc,
            int thuBay, double hanhLy, String thanhVien,
            boolean ngayLe, double giaVeCoBan) {

        this.testcaseID = testcaseID;
        this.expResult = expResult;
        this.actResult = actResult;
        this.loaiVe = loaiVe;
        this.hangGhe = hangGhe;
        this.soNgayDatTruoc = soNgayDatTruoc;
        this.thuBay = thuBay;
        this.hanhLy = hanhLy;
        this.thanhVien = thanhVien;
        this.ngayLe = ngayLe;
        this.giaVeCoBan = giaVeCoBan;
    }

    public static void addResult(String testcaseID,
            long expResult, long actResult,
            String loaiVe, String hangGhe,
            int soNgayDatTruoc, int thuBay,
            double hanhLy, String thanhVien,
            boolean ngayLe, double giaVeCoBan) {

        results.add(new TestResult(
                testcaseID, expResult, actResult,
                loaiVe, hangGhe, soNgayDatTruoc,
                thuBay, hanhLy, thanhVien,
                ngayLe, giaVeCoBan
        ));
    }

    // Đọc dữ liệu kiểm thử từ file CSV
    public static List<String[]> importCSV(String filePath) throws IOException {

        List<String[]> data = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get(filePath), StandardCharsets.UTF_8)) {

            String header = reader.readLine();

            if (header == null) {
                throw new IOException("File CSV trống: " + filePath);
            }

            String line;
            int row = 1;

            while ((line = reader.readLine()) != null) {
                row++;

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] values = parseCSVLine(line);

                if (values.length != 11) {
                    throw new IOException(
                            "Dòng " + row + " phải có đúng 11 cột dữ liệu"
                    );
                }

                for (int i = 0; i < values.length; i++) {
                    values[i] = values[i].trim();
                }

                if (values[0].startsWith("\uFEFF")) {
                    values[0] = values[0].substring(1);
                }

                data.add(values);
            }
        }

        if (data.isEmpty()) {
            throw new IOException(
                    "File CSV không có dữ liệu kiểm thử: " + filePath
            );
        }

        return data;
    }

    // Phân tích từng dòng CSV thành các cột dữ liệu
    private static String[] parseCSVLine(String line) throws IOException {

        List<String> fields = new ArrayList<>();
        StringBuilder value = new StringBuilder();
        boolean quoted = false;

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if (ch == '"') {
                if (quoted && i + 1 < line.length()
                        && line.charAt(i + 1) == '"') {

                    value.append('"');
                    i++;

                } else {
                    quoted = !quoted;
                }

            } else if (ch == ',' && !quoted) {
                fields.add(value.toString());
                value.setLength(0);

            } else {
                value.append(ch);
            }
        }

        if (quoted) {
            throw new IOException(
                    "Lỗi định dạng CSV: Dấu ngoặc kép chưa được đóng"
            );
        }

        fields.add(value.toString());

        return fields.toArray(new String[0]);
    }

    // Xuất kết quả kiểm thử ra file CSV
    public static void exportCSV() {
        results.sort((a, b) -> {
            return a.testcaseID.compareTo(b.testcaseID);
        });
        try (PrintWriter writer = new PrintWriter(
                new FileWriter("JunitTestResults.csv"))) {

            writer.println(
                    "TestcaseID,loaiVe,hangGhe,soNgayDatTruoc,"
                    + "thuBay,hanhLy,thanhVien,ngayLe,"
                    + "giaVeCoBan,Expected,Actual,Status"
            );

            for (TestResult r : results) {

                String status = r.expResult == r.actResult
                        ? "PASSED" : "FAILED";

                writer.println(
                        r.testcaseID + "," 
                        + r.loaiVe + ","
                        + r.hangGhe + ","
                        + r.soNgayDatTruoc + ","
                        + r.thuBay + ","
                        + r.hanhLy + ","
                        + r.thanhVien + ","
                        + r.ngayLe + ","
                        + r.giaVeCoBan + ","
                        + r.expResult + ","
                        + r.actResult + ","
                        + status
                );
            }


        } catch (IOException e) {
        }
    }
}
