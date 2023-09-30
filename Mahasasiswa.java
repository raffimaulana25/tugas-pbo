import java.util.Scanner;

public class Main {
    static final int MAX_MAHASISWA = 100;
    static Mahasiswa[] daftarMahasiswa = new Mahasiswa[MAX_MAHASISWA];
    static int jumlahMahasiswa = 0;

    static class Mahasiswa {
        String nama;
        long nim;
        String jurusan;
        int semester;
    }
//program untuk menambah data mahasiswa
    public static void tambahMahasiswa() {
        if (jumlahMahasiswa >= MAX_MAHASISWA) {
            System.out.println("Kapasitas mahasiswa penuh.");
            return;
        }
        Mahasiswa mhs = new Mahasiswa();
        Scanner input = new Scanner(System.in);
        System.out.print("Nama: ");
        mhs.nama = input.nextLine();
        System.out.print("NIM: ");
        mhs.nim = input.nextLong();
        input.nextLine(); // Membersihkan newline dari masukan sebelumnya
        System.out.print("Jurusan: ");
        mhs.jurusan = input.nextLine();
        System.out.print("Semester: ");
        mhs.semester = input.nextInt();
        input.nextLine(); // Membersihkan newline dari masukan sebelumnya
        daftarMahasiswa[jumlahMahasiswa] = mhs;
        jumlahMahasiswa++;
        System.out.println("Data mahasiswa berhasil ditambahkan!");
    }
//program untuk mencari data mahasiswa dengan menuliskan nim
    public static void cariMahasiswa(int nim) {
        boolean found = false;
        for (int i = 0; i < jumlahMahasiswa; i++) {
            if (daftarMahasiswa[i].nim == nim) {
                System.out.println("Data Mahasiswa");
                System.out.println("--------------------------");
                System.out.println("Nama: " + daftarMahasiswa[i].nama);
                System.out.println("NIM: " + daftarMahasiswa[i].nim);
                System.out.println("Jurusan: " + daftarMahasiswa[i].jurusan);
                System.out.println("Semester: " + daftarMahasiswa[i].semester);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Data mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }
//program untuk menghapus data mahasiswa dengan menuliskan nim
    public static void hapusMahasiswa(int nim) {
        boolean found = false;
        for (int i = 0; i < jumlahMahasiswa; i++) {
            if (daftarMahasiswa[i].nim == nim) {
                for (int j = i; j < jumlahMahasiswa - 1; j++) {
                    daftarMahasiswa[j] = daftarMahasiswa[j + 1];
                }
                jumlahMahasiswa--;
                System.out.println("Data mahasiswa dengan NIM " + nim + " berhasil dihapus.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Data mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }
//program untuk menampilkan seluruh data mahasiswa yang telah diinputkan
    public static void tampilkanDaftarMahasiswa() {
        if (jumlahMahasiswa == 0) {
            System.out.println("Belum ada data mahasiswa yang terdaftar.");
        } else {
            System.out.println("Daftar Mahasiswa");
            System.out.println("--------------------------");
            for (int i = 0; i < jumlahMahasiswa; i++) {
                System.out.println("Nama: " + daftarMahasiswa[i].nama);
                System.out.println("NIM: " + daftarMahasiswa[i].nim);
                System.out.println("Jurusan: " + daftarMahasiswa[i].jurusan);
                System.out.println("Semester: " + daftarMahasiswa[i].semester);
                System.out.println("-----------------------");
            }
        }
    }
//program untuk memperbarui data mahasiswa
    public static void updateMahasiswa(int nim) {
        boolean found = false;
        for (int i = 0; i < jumlahMahasiswa; i++) {
            if (daftarMahasiswa[i].nim == nim) {
                System.out.println("Data Mahasiswa");
                System.out.println("--------------------------");
                System.out.println("Nama: " + daftarMahasiswa[i].nama);
                System.out.println("NIM: " + daftarMahasiswa[i].nim);
                System.out.println("Jurusan: " + daftarMahasiswa[i].jurusan);
                System.out.println("Semester: " + daftarMahasiswa[i].semester);

                // Meminta input untuk memperbarui data mahasiswa
                System.out.println();
                Scanner input = new Scanner(System.in);
                System.out.print("Masukkan data baru:" + "\n" + "Nama: ");
                daftarMahasiswa[i].nama = input.nextLine();
                System.out.print("Jurusan: ");
                daftarMahasiswa[i].jurusan = input.nextLine();
                System.out.print("Semester: ");
                daftarMahasiswa[i].semester = input.nextInt();
                input.nextLine(); // Membersihkan newline dari masukan sebelumnya

                System.out.println("Data mahasiswa dengan NIM " + nim + " berhasil diperbarui.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Data mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }

    public static void clearScreen() {
        // Membersihkan layar di lingkungan Replit
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
	public static void pause() {
    System.out.print("Tekan Enter untuk melanjutkan...");
    new Scanner(System.in).nextLine();
}


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("Program Pengelolaan Data Mahasiswa");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Cari Data Mahasiswa");
            System.out.println("3. Hapus Data Mahasiswa");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("5. Edit atau Perbarui Data Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // Membersihkan newline dari masukan sebelumnya

            switch (pilihan) {
                case 1:
                    System.out.println();
                    tambahMahasiswa();
                    System.out.println();
								pause();
								clearScreen();
                    break;
                case 2:
                    System.out.print("Masukkan NIM yang ingin dicari: ");
                    int nimCari = input.nextInt();
                    input.nextLine(); // Membersihkan newline dari masukan sebelumnya
                    System.out.println();
                    cariMahasiswa(nimCari);
                    System.out.println();
								pause();
								clearScreen();
                    break;
                case 3:
                    System.out.print("Masukkan NIM yang ingin dihapus: ");
                    int nimHapus = input.nextInt();
                    input.nextLine(); // Membersihkan newline dari masukan sebelumnya
                    System.out.println();
                    hapusMahasiswa(nimHapus);
                    System.out.println();
								pause();
								clearScreen();
                    break;
                case 4:
                    System.out.println();
                    tampilkanDaftarMahasiswa();
                    System.out.println();
								pause();
								clearScreen();
                    break;
                case 5:
                    System.out.print("Masukkan NIM mahasiswa yang ingin diperbarui datanya: ");
                    int nimUpdate = input.nextInt();
                    input.nextLine(); // Membersihkan newline dari masukan sebelumnya
                    System.out.println();
                    updateMahasiswa(nimUpdate);
                    System.out.println();
								pause();
								clearScreen();
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
            }

            System.out.println();
        } while (pilihan != 0);
    }
}
