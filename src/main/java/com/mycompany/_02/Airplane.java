package com.mycompany._02;

public class Airplane {

    public static long tinhGiaVe(String loaiVe, String hangGhe,
            int soNgayDatTruoc, int thuBay, double hanhLy,
            String thanhVien, boolean ngayLe) {

        // 1. Kiem tra du lieu dau vao
        if (loaiVe == null || hangGhe == null || thanhVien == null) {
            throw new IllegalArgumentException("Thieu thong tin ve");
        } // Kiem tra loai ve
        else if (!loaiVe.equals("MotChieu")
                && !loaiVe.equals("KhuHoi")) {
            throw new IllegalArgumentException("Loai ve khong hop le");
        } // Kiem tra hang ghe
        else if (!hangGhe.equals("Economy")
                && !hangGhe.equals("Business")
                && !hangGhe.equals("FirstClass")) {
            throw new IllegalArgumentException("Hang ghe khong hop le");
        } // Kiem tra thanh vien
        else if (!thanhVien.equals("Thuong")
                && !thanhVien.equals("Silver")
                && !thanhVien.equals("Gold")
                && !thanhVien.equals("Platinum")) {
            throw new IllegalArgumentException("Thanh vien khong hop le");
        } // Kiem tra so ngay dat truoc
        else if (soNgayDatTruoc < 0) {
            throw new IllegalArgumentException("So ngay dat truoc khong hop le");
        } // Kiem tra thu bay
        else if (thuBay < 1 || thuBay > 7) {
            throw new IllegalArgumentException("Thu bay khong hop le");
        } // Kiem tra hanh ly
        else if (!Double.isFinite(hanhLy)
                || hanhLy < 0 || hanhLy > 30) {
            throw new IllegalArgumentException("Hanh ly khong hop le");
        }

        double gia = 1_000_000;

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
        } else if (soNgayDatTruoc >= 7) {
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

        // 6. Hanh ly
        if (hanhLy > 20) {
            gia += 300_000;
        } else if (hanhLy > 7) {
            gia += 150_000;
        }

        // 7. Thanh vien
        if (thanhVien.equals("Silver")) {
            gia *= 0.95;
        } else if (thanhVien.equals("Gold")) {
            gia *= 0.90;
        } else if (thanhVien.equals("Platinum")) {
            gia *= 0.85;
        }

        return Math.round(gia);
    }
}
