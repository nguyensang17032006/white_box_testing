/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany._02;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

/**
 *
 * @author Sang
 */
public class AirplaneTest {

    static Airplane airplane;
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
    public static void setUpClass() throws Exception {
        airplane = new Airplane();
        TestResult.results.clear();
    }

    @BeforeEach
    public void setup() {
        expResult = -1;
        actResult = Long.MIN_VALUE;
    }

    /**
     * Test of tinhGiaVe method, of class Airplane.
     */
    // 
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
        actResult = -1;

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

    // Loại vé null
    @Test
    public void testTC15_Condition() {
        loaiVe = null;
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
        actResult = -1;

        assertEquals(expResult, actResult);
    }

    // Loại vé ngoài danh sách
    @Test
    public void testTC16_Condition() {
        loaiVe = "VIP";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
        actResult = -1;

        assertEquals(expResult, actResult);
    }

    // Loại vé MotChieu hợp lệ
    @Test
    public void testTC17_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        expResult = 950_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Loại vé KhuHoi hợp lệ
    @Test
    public void testTC18_Condition() {
        loaiVe = "KhuHoi";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        expResult = 1_710_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Hạng ghế null
    @Test
    public void testTC19_Condition() {
        loaiVe = "MotChieu";
        hangGhe = null;
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
        actResult = -1;

        assertEquals(expResult, actResult);
    }

    // Hạng ghế Economy hợp lệ
    @Test
    public void testTC20_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        expResult = 950_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Hạng ghế Business hợp lệ
    @Test
    public void testTC21_Condition() {
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

    // Hạng ghế FirstClass hợp lệ
    @Test
    public void testTC22_Condition() {
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

    // Hạng ghế ngoài danh sách
    @Test
    public void testTC23_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "VIP";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
        actResult = -1;

        assertEquals(expResult, actResult);
    }

    // Thành viên null
    @Test
    public void testTC24_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = null;
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
        actResult = -1;

        assertEquals(expResult, actResult);
    }

    // Thành viên Thuong hợp lệ
    @Test
    public void testTC25_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        expResult = 950_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Thành viên Silver hợp lệ
    @Test
    public void testTC26_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = "Silver";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        expResult = 950_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Thành viên Gold hợp lệ
    @Test
    public void testTC27_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = "Gold";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        expResult = 950_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Thành viên Platinum hợp lệ
    @Test
    public void testTC28_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = "Platinum";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        expResult = 950_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Thành viên ngoài danh sách
    @Test
    public void testTC29_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = "Diamond";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
        actResult = -1;

        assertEquals(expResult, actResult);
    }

    // Số ngày đặt trước âm
    @Test
    public void testTC30_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = -1;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
        actResult = -1;

        assertEquals(expResult, actResult);
    }

    // Thứ bay nhỏ hơn 1
    @Test
    public void testTC31_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 0;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
        actResult = -1;

        assertEquals(expResult, actResult);
    }

    // Thứ bay lớn hơn 7
    @Test
    public void testTC32_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 8;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
        actResult = -1;

        assertEquals(expResult, actResult);
    }

    // Hành lý NaN
    @Test
    public void testTC33_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = Double.NaN;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
        actResult = -1;

        assertEquals(expResult, actResult);
    }

    // Hành lý âm
    @Test
    public void testTC34_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = -1;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
        actResult = -1;

        assertEquals(expResult, actResult);
    }

    // Hành lý trên 30kg
    @Test
    public void testTC35_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 31;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
        actResult = -1;

        assertEquals(expResult, actResult);
    }

    // Giá vé không hữu hạn
    @Test
    public void testTC36_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = Double.POSITIVE_INFINITY;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
        actResult = -1;

        assertEquals(expResult, actResult);
    }

    // Giá vé cơ bản bằng 0
    @Test
    public void testTC37_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 0;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
        actResult = -1;

        assertEquals(expResult, actResult);
    }

    // Toàn bộ dữ liệu đầu vào hợp lệ
    @Test
    public void testTC38_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        expResult = 950_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Không có ngày lễ (AND false)
    @Test
    public void testTC39_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        expResult = 950_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Ngày lễ vào thứ Sáu
    @Test
    public void testTC40_Condition() {
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

    // Ngày lễ vào thứ Bảy
    @Test
    public void testTC41_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 6;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = true;
        giaVeCoBan = 1_000_000;
        expResult = 1_282_500;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Ngày lễ vào Chủ nhật
    @Test
    public void testTC42_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 7;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = true;
        giaVeCoBan = 1_000_000;
        expResult = 1_282_500;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Ngày lễ không trùng cuối tuần
    @Test
    public void testTC43_Condition() {
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

    // Điều kiện cuối tuần: thứ Sáu
    @Test
    public void testTC44_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 5;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        expResult = 1_045_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Điều kiện cuối tuần: thứ Bảy
    @Test
    public void testTC45_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 6;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        expResult = 1_045_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Điều kiện cuối tuần: Chủ nhật
    @Test
    public void testTC46_Condition() {
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

    // Điều kiện cuối tuần: ngày thường
    @Test
    public void testTC47_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = "Thuong";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        expResult = 950_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Hành lý <= 7kg, không giảm phí
    @Test
    public void testTC48_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = "Gold";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        expResult = 950_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Hành lý > 7kg, Gold giảm 20%
    @Test
    public void testTC49_Condition() {
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

    // Hành lý > 7kg, Platinum giảm 20%
    @Test
    public void testTC50_Condition() {
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

    // Hành lý > 7kg, không phải Gold/Platinum
    @Test
    public void testTC51_Condition() {
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

    // Hành lý <= 7kg, không áp dụng Silver
    @Test
    public void testTC52_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 5;
        thanhVien = "Silver";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        expResult = 950_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    // Hành lý > 7kg, không phải Silver
    @Test
    public void testTC53_Condition() {
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

    // Hành lý > 7kg, Silver giảm 10%
    @Test
    public void testTC54_Condition() {
        loaiVe = "MotChieu";
        hangGhe = "Economy";
        soNgayDatTruoc = 15;
        thuBay = 2;
        hanhLy = 8;
        thanhVien = "Silver";
        ngayLe = false;
        giaVeCoBan = 1_000_000;
        expResult = 1_085_000;
        actResult = Airplane.tinhGiaVe(loaiVe, hangGhe, soNgayDatTruoc, thuBay, hanhLy, thanhVien, ngayLe, giaVeCoBan);

        assertEquals(expResult, actResult);
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {

        String testcaseID = testInfo.getTestMethod()
                .get().getName()
                .replace("test", "");

        TestResult.addResult(
                testcaseID,
                expResult,
                actResult,
                loaiVe,
                hangGhe,
                soNgayDatTruoc,
                thuBay,
                hanhLy,
                thanhVien,
                ngayLe,
                giaVeCoBan
        );
    }

    @AfterAll
    public static void tearDownClass() {
        TestResult.exportCSV();
    }
}
