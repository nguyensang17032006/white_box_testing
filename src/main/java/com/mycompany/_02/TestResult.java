package com.mycompany._02;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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

    public static void exportCSV() {

        try (PrintWriter writer = new PrintWriter(
                new FileWriter("TestResults.csv"))) {

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

            System.out.println("Da xuat file TestResults.csv");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}