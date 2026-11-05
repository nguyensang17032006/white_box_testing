/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany._02;

/**
 *
 * @author Sang
 */
public class Airplane {

    public static long tinhGiaVe(String loaiVe, String hangGhe,
            int soNgayDatTruoc, int thuBay, double hanhLy,
            String thanhVien, boolean ngayLe, double giaVeCoBan) {

        // 1. Kiem tra du lieu dau vao
        if (loaiVe == null || hangGhe == null || thanhVien == null
                || (!loaiVe.equals("MotChieu") && !loaiVe.equals("KhuHoi"))
                || (!hangGhe.equals("Economy")
                && !hangGhe.equals("Business")
                && !hangGhe.equals("FirstClass"))
                || (!thanhVien.equals("Thuong")
                && !thanhVien.equals("Silver")
                && !thanhVien.equals("Gold")
                && !thanhVien.equals("Platinum"))
                || soNgayDatTruoc < 0
                || thuBay < 1 || thuBay > 7
                || !Double.isFinite(hanhLy)
                || hanhLy < 0 || hanhLy > 30
                || !Double.isFinite(giaVeCoBan)
                || giaVeCoBan <= 0) {
            return -1;
        }

        double gia = giaVeCoBan;
        
        // 2. Loai ve: khu hoi gom 2 chieu, giam 10%
        if (loaiVe.equals("KhuHoi")) {
            gia *= 2 * 0.90;
        }

        // 3. Hang ghe
        if (hangGhe.equals("Business")) {
            gia *= 2;
        } else if (hangGhe.equals("FirstClass")) {
            gia *= 3;
        }

        // 4. Thoi diem dat ve
        if (soNgayDatTruoc >= 30) {
            gia *= 0.85;
        } else if (soNgayDatTruoc >= 7 && soNgayDatTruoc < 30) {
            gia *= 0.95;
        } else {
            gia *= 1.20;
        }

        // 5. Ngay bay va ngay le (co ca AND va OR)
        if (ngayLe && (thuBay == 5 || thuBay == 6 || thuBay == 7)) {
            gia *= 1.35;
        } else if (ngayLe) {
            gia *= 1.25;
        } else if (thuBay == 5 || thuBay == 6 || thuBay == 7) {
            gia *= 1.10;
        }

        // 6. Hanh ly va uu dai thanh vien
        double phiHanhLy = 0;

        if (hanhLy > 20) {
            phiHanhLy = 300_000;
        } else if (hanhLy > 7) {
            phiHanhLy = 150_000;
        }

        // Thanh vien Gold hoac Platinum duoc giam 20% phi hanh ly
        if (hanhLy > 7 && (thanhVien.equals("Gold") || thanhVien.equals("Platinum"))) {
            phiHanhLy *= 0.80;
        } else if (hanhLy > 7 && thanhVien.equals("Silver")) {
            phiHanhLy *= 0.90;
        }

        gia += phiHanhLy;

        return Math.round(gia);
    }
}
