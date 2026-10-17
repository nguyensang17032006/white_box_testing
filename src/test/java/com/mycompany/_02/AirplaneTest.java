/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany._02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Sang
 */
public class AirplaneTest {

    static Airplane airplane;
    String currentTestcaseID;
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

    @BeforeAll
    public static void setUpClass() {
        airplane = new Airplane();
        TestResult.results.clear();
    }

    @BeforeEach
    public void setup() {
        currentTestcaseID = null;
        expResult = -1;
        actResult = Long.MIN_VALUE;
    }

    // Dùng vòng lặp for để chuyển dữ liệu CSV thành tham số JUnit
    private static List<Arguments> csvData(String path) throws IOException {
        List<String[]> data = TestResult.importCSV(path);
        List<Arguments> arguments = new ArrayList<>();
        for (String[] row : data) {
            arguments.add(Arguments.of((Object[]) row));
        }
        return arguments;
    }

    // Dữ liệu của bảng quyết định số 1
    public static List<Arguments> dataTC15toTC18() throws IOException {
        return csvData("AirplaneTestCases/Data_TC15toTC18.csv");
    }

    // Dữ liệu của bảng quyết định số 2
    public static List<Arguments> dataTC19toTC23() throws IOException {
        return csvData("AirplaneTestCases/Data_TC19toTC23.csv");
    }

    // Dữ liệu của bảng quyết định số 3
    public static List<Arguments> dataTC24toTC29() throws IOException {
        return csvData("AirplaneTestCases/Data_TC24toTC29.csv");
    }

    // Dữ liệu của bảng quyết định số 4
    public static List<Arguments> dataTC30toTC38() throws IOException {
        return csvData("AirplaneTestCases/Data_TC30toTC38.csv");
    }

    // Dữ liệu của bảng quyết định số 5
    public static List<Arguments> dataTC39toTC43() throws IOException {
        return csvData("AirplaneTestCases/Data_TC39toTC43.csv");
    }

    // Dữ liệu của bảng quyết định số 6
    public static List<Arguments> dataTC44toTC47() throws IOException {
        return csvData("AirplaneTestCases/Data_TC44toTC47.csv");
    }

    // Dữ liệu của bảng quyết định số 7
    public static List<Arguments> dataTC48toTC51() throws IOException {
        return csvData("AirplaneTestCases/Data_TC48toTC51.csv");
    }

    // Dữ liệu của bảng quyết định số 8
    public static List<Arguments> dataTC52toTC54() throws IOException {
        return csvData("AirplaneTestCases/Data_TC52toTC54.csv");
    }

    // Chuyển 11 cột CSV thành tham số của hàm tính giá vé
    private void runCSVTest(String testcaseID, String loaiVe, String hangGhe,
            String soNgay, String thu, String kg, String thanhVien,
            String le, String giaGoc, String expected) {
        currentTestcaseID = testcaseID;
        this.loaiVe = nullable(loaiVe);
        this.hangGhe = nullable(hangGhe);
        this.soNgayDatTruoc = Integer.parseInt(soNgay);
        this.thuBay = Integer.parseInt(thu);
        this.hanhLy = Double.parseDouble(kg);
        this.thanhVien = nullable(thanhVien);
        this.ngayLe = Boolean.parseBoolean(le);
        this.giaVeCoBan = Double.parseDouble(giaGoc);
        this.expResult = Long.parseLong(expected);
        this.actResult = Airplane.tinhGiaVe(this.loaiVe, this.hangGhe,
                this.soNgayDatTruoc, this.thuBay, this.hanhLy,
                this.thanhVien, this.ngayLe, this.giaVeCoBan);
        assertEquals(expResult, actResult, testcaseID);
    }

    private static String nullable(String value) {
        return value == null || value.equalsIgnoreCase("null") ? null : value;
    }

    // Bảng quyết định số 1
    @ParameterizedTest(name = "{0} - {1}")
    @MethodSource("dataTC15toTC18")
    public void testTC15toTC18_Condition(String testcaseID, String description,
            String loaiVe, String hangGhe, String soNgayDatTruoc,
            String thuBay, String hanhLy, String thanhVien,
            String ngayLe, String giaVeCoBan, String expected) {
        runCSVTest(testcaseID, loaiVe, hangGhe, soNgayDatTruoc,
                thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan, expected);
    }

    // Bảng quyết định số 2
    @ParameterizedTest(name = "{0} - {1}")
    @MethodSource("dataTC19toTC23")
    public void testTC19toTC23_Condition(String testcaseID, String description,
            String loaiVe, String hangGhe, String soNgayDatTruoc,
            String thuBay, String hanhLy, String thanhVien,
            String ngayLe, String giaVeCoBan, String expected) {
        runCSVTest(testcaseID, loaiVe, hangGhe, soNgayDatTruoc,
                thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan, expected);
    }

    // Bảng quyết định số 3
    @ParameterizedTest(name = "{0} - {1}")
    @MethodSource("dataTC24toTC29")
    public void testTC24toTC29_Condition(String testcaseID, String description,
            String loaiVe, String hangGhe, String soNgayDatTruoc,
            String thuBay, String hanhLy, String thanhVien,
            String ngayLe, String giaVeCoBan, String expected) {
        runCSVTest(testcaseID, loaiVe, hangGhe, soNgayDatTruoc,
                thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan, expected);
    }

    // Bảng quyết định số 4
    @ParameterizedTest(name = "{0} - {1}")
    @MethodSource("dataTC30toTC38")
    public void testTC30toTC38_Condition(String testcaseID, String description,
            String loaiVe, String hangGhe, String soNgayDatTruoc,
            String thuBay, String hanhLy, String thanhVien,
            String ngayLe, String giaVeCoBan, String expected) {
        runCSVTest(testcaseID, loaiVe, hangGhe, soNgayDatTruoc,
                thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan, expected);
    }

    // Bảng quyết định số 5
    @ParameterizedTest(name = "{0} - {1}")
    @MethodSource("dataTC39toTC43")
    public void testTC39toTC43_Condition(String testcaseID, String description,
            String loaiVe, String hangGhe, String soNgayDatTruoc,
            String thuBay, String hanhLy, String thanhVien,
            String ngayLe, String giaVeCoBan, String expected) {
        runCSVTest(testcaseID, loaiVe, hangGhe, soNgayDatTruoc,
                thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan, expected);
    }

    // Bảng quyết định số 6
    @ParameterizedTest(name = "{0} - {1}")
    @MethodSource("dataTC44toTC47")
    public void testTC44toTC47_Condition(String testcaseID, String description,
            String loaiVe, String hangGhe, String soNgayDatTruoc,
            String thuBay, String hanhLy, String thanhVien,
            String ngayLe, String giaVeCoBan, String expected) {
        runCSVTest(testcaseID, loaiVe, hangGhe, soNgayDatTruoc,
                thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan, expected);
    }

    // Bảng quyết định số 7
    @ParameterizedTest(name = "{0} - {1}")
    @MethodSource("dataTC48toTC51")
    public void testTC48toTC51_Condition(String testcaseID, String description,
            String loaiVe, String hangGhe, String soNgayDatTruoc,
            String thuBay, String hanhLy, String thanhVien,
            String ngayLe, String giaVeCoBan, String expected) {
        runCSVTest(testcaseID, loaiVe, hangGhe, soNgayDatTruoc,
                thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan, expected);
    }

    // Bảng quyết định số 8
    @ParameterizedTest(name = "{0} - {1}")
    @MethodSource("dataTC52toTC54")
    public void testTC52toTC54_Condition(String testcaseID, String description,
            String loaiVe, String hangGhe, String soNgayDatTruoc,
            String thuBay, String hanhLy, String thanhVien,
            String ngayLe, String giaVeCoBan, String expected) {
        runCSVTest(testcaseID, loaiVe, hangGhe, soNgayDatTruoc,
                thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan, expected);
    }

    // Kiểm tra số ngày đặt trước âm
    @Test
    public void testTC01_Path() {
        loaiVe = "MotChieu";
        hangGhe = "Business";
        soNgayDatTruoc = -4;
        thuBay = 4;
        hanhLy = 5;
        thanhVien = "Silver";
        ngayLe = true;
        giaVeCoBan = 1_200_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Kiểm tra vé một chiều Economy, đặt trước dưới 7 ngày
    @Test
    public void testTC02_Path() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 2;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        expResult = 1_200_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Kiểm tra khứ hồi, cuối tuần, hành lý 16kg, Silver
    @Test
    public void testTC03_Path() {
        loaiVe = "KhuHoi";
        hangGhe = "Economy";
        soNgayDatTruoc = 2;
        thuBay = 6;
        hanhLy = 16;
        thanhVien = "Silver";
        ngayLe = false;
        giaVeCoBan = 1_100_000;
        expResult = 2_748_600;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Kiểm tra hạng Business
    @Test
    public void testTC04_Path() {
        loaiVe = "MotChieu";
        hangGhe = "Business";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        expResult = 1_900_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Kiểm tra hạng FirstClass
    @Test
    public void testTC05_Path() {
        loaiVe = "MotChieu";
        hangGhe = "FirstClass";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        expResult = 2_850_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Kiểm tra đặt trước từ 30 ngày
    @Test
    public void testTC06_Path() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 30;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        expResult = 850_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Kiểm tra đặt trước 7–29 ngày
    @Test
    public void testTC07_Path() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 7;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        expResult = 950_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Kiểm tra ngày lễ trùng thứ Sáu
    @Test
    public void testTC08_Path() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 5;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = true;
        giaVeCoBan = 1_000_000;
        expResult = 1_282_500;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Kiểm tra ngày lễ vào ngày thường
    @Test
    public void testTC09_Path() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = true;
        giaVeCoBan = 1_000_000;
        expResult = 1_187_500;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Kiểm tra cuối tuần không có ngày lễ
    @Test
    public void testTC10_Path() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 7;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        expResult = 1_045_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Kiểm tra hành lý trên 20kg
    @Test
    public void testTC11_Path() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 21;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        expResult = 1_250_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Kiểm tra hành lý trên 7kg đến 20kg
    @Test
    public void testTC12_Path() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 8;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        expResult = 1_100_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Kiểm tra giảm phí hành lý Gold
    @Test
    public void testTC13_Path() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 8;
        thanhVien = "Gold";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        expResult = 1_070_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Kiểm tra giảm phí hành lý Platinum
    @Test
    public void testTC14_Path() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 8;
        thanhVien = "Platinum";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        expResult = 1_070_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        String testcaseID = currentTestcaseID != null
                ? currentTestcaseID
                : testInfo.getTestMethod().get().getName().replace("test", "");
        TestResult.addResult(testcaseID, expResult, actResult,
                loaiVe, hangGhe, soNgayDatTruoc, thuBay,
                hanhLy, thanhVien, ngayLe, giaVeCoBan);
    }

    @AfterAll
    public static void tearDownClass() {
        TestResult.exportCSV();
    }
}
