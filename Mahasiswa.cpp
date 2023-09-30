#include <iostream>
using namespace std;

const int MAX_MAHASISWA = 100;
struct Mahasiswa {
    string nama;
    double nim;
    string jurusan;
    int semester;
};
void tambahMahasiswa(Mahasiswa daftarMahasiswa[], int& jumlahMahasiswa) {
    if (jumlahMahasiswa >= MAX_MAHASISWA) {
        cout << "Kapasitas mahasiswa penuh." << endl;
        return;
    }
    Mahasiswa mhs;
    cout << "Nama: ";
    getline(cin.ignore(), mhs.nama);
    cout << "NIM: ";
    cin >> mhs.nim;
    cin.ignore();
    cout << "Jurusan: ";
    getline(cin, mhs.jurusan);
    cout << "Semester: ";
    cin >> mhs.semester;
    cin.ignore();
    daftarMahasiswa[jumlahMahasiswa] = mhs;
    jumlahMahasiswa++;
    cout << "Data mahasiswa berhasil ditambahkan!" << endl;
}
void cariMahasiswa(const Mahasiswa daftarMahasiswa[], int jumlahMahasiswa, int nim) {
    bool found = false;
    int i = 0;
    
    while (i < jumlahMahasiswa) {
        if (daftarMahasiswa[i].nim == nim) {
            cout << "Data Mahasiswa" << endl;
            cout << "--------------------------" << endl;
            cout << "Nama: " << daftarMahasiswa[i].nama << endl;
            cout << "NIM: " << daftarMahasiswa[i].nim << endl;
            cout << "Jurusan: " << daftarMahasiswa[i].jurusan << endl;
            cout << "Semester: " << daftarMahasiswa[i].semester << endl;
            found = true;
            break;
        }
        i++;
    }
    
    if (!found) {
        cout << "Data mahasiswa dengan NIM " << nim << " tidak ditemukan." << endl;
    }
}

void hapusMahasiswa(Mahasiswa daftarMahasiswa[], int& jumlahMahasiswa, int nim) {
    bool found = false;
    for (int i = 0; i < jumlahMahasiswa; i++) {
        if (daftarMahasiswa[i].nim == nim) {
            for (int j = i; j < jumlahMahasiswa - 1; j++) {
                daftarMahasiswa[j] = daftarMahasiswa[j + 1];
            }
            jumlahMahasiswa--;
            cout << "Data mahasiswa dengan NIM " << nim << " berhasil dihapus." << endl;
            found = true;
            break;
        }
    }
    if (!found) {
        cout << "Data mahasiswa dengan NIM " << nim << " tidak ditemukan." << endl;
    }
}
void tampilkanDaftarMahasiswa(const Mahasiswa daftarMahasiswa[], int jumlahMahasiswa) {
    if (jumlahMahasiswa == 0) {
        cout << "Belum ada data mahasiswa yang terdaftar." << endl;
    } else {
        cout << "Daftar Mahasiswa" << endl;
        cout<<"--------------------------"<<endl;
        for (int i = 0; i < jumlahMahasiswa; i++) {
            cout << "Nama: " << daftarMahasiswa[i].nama << endl;
            cout << "NIM: " << daftarMahasiswa[i].nim << endl;
            cout << "Jurusan: " << daftarMahasiswa[i].jurusan << endl;
            cout << "Semester: " << daftarMahasiswa[i].semester << endl;
            cout << "-----------------------" << endl;
        }
    }
}
void updateMahasiswa(Mahasiswa daftarMahasiswa[], int jumlahMahasiswa, int nim) {
    bool found = false;
    for (int i = 0; i < jumlahMahasiswa; i++) {
        if (daftarMahasiswa[i].nim == nim) {
            cout << "Data Mahasiswa" << endl;
            cout<<"--------------------------"<<endl;
            cout << "Nama: " << daftarMahasiswa[i].nama << endl;
            cout << "NIM: " << daftarMahasiswa[i].nim << endl;
            cout << "Jurusan: " << daftarMahasiswa[i].jurusan << endl;
            cout << "Semester: " << daftarMahasiswa[i].semester << endl;

            // Meminta input untuk memperbarui data mahasiswa
            cout << endl;
            cout << "Masukkan data baru:" << endl;
            cout << "Nama: ";
            getline(cin.ignore(), daftarMahasiswa[i].nama);
            cout << "Jurusan: ";
            getline(cin, daftarMahasiswa[i].jurusan);
            cout << "Semester: ";
            cin >> daftarMahasiswa[i].semester;
            cin.ignore();

            cout << "Data mahasiswa dengan NIM " << nim << " berhasil diperbarui." << endl;
            found = true;
            break;
        }
    }
    if (!found) {
        cout << "Data mahasiswa dengan NIM " << nim << " tidak ditemukan." << endl;
    }
}

void display(){
	 Mahasiswa daftarMahasiswa[MAX_MAHASISWA];
    int jumlahMahasiswa = 0;
    int pilihan;

    do {
        cout << "Program Pengelolaan Data Mahasiswa" << endl;
        cout << "1. Tambah Data Mahasiswa" << endl;
        cout << "2. Cari Data Mahasiswa" << endl;
        cout << "3. Hapus Data Mahasiswa" << endl;
        cout << "4. Tampilkan Daftar Mahasiswa" << endl;
        cout << "5. Edit Atau Perbarui Data Mahasiswa "<<endl;
        cout << "0. Keluar" << endl;
        cout << "Pilih menu: ";
        cin >> pilihan;
        cin.ignore();

        switch (pilihan) {
            case 1:
            	 cout<<endl;
                tambahMahasiswa(daftarMahasiswa, jumlahMahasiswa);
                
                system("pause");
                system("cls");
                break;
            case 2:
                int nim;
                cout << "Masukkan NIM yang ingin dicari: ";
                cin >> nim;
                cin.ignore();
                 cout<<endl;
                cariMahasiswa(daftarMahasiswa, jumlahMahasiswa, nim);
                 system("pause");
                system("cls");
                break;
            case 3:
                int nimHapus;
                cout << "Masukkan NIM yang ingin dihapus: ";
                cin >> nimHapus;
                cin.ignore();
                 cout<<endl;
                hapusMahasiswa(daftarMahasiswa, jumlahMahasiswa, nimHapus);
                 system("pause");
                system("cls");
                break;
            case 4:
            	 cout<<endl;
                tampilkanDaftarMahasiswa(daftarMahasiswa, jumlahMahasiswa);
                 system("pause");
                system("cls");
                break;
            case 5:
            	cout<<endl;
            	int nimUpdate;
			    cout << "Masukkan NIM mahasiswa yang ingin diperbarui datanya: ";
			    cin >> nimUpdate;
			    cin.ignore();
			    cout << endl;
			    updateMahasiswa(daftarMahasiswa, jumlahMahasiswa, nimUpdate);
			    system("pause");
			    system("cls");
			    break;
            case 0:
                cout << "Terima kasih!" << endl;
                break;
            default:
                cout << "Pilihan tidak valid. Silakan pilih kembali." << endl;
        }

        cout << endl;
    } while (pilihan != 0);
}

int main() {
	display();
   

    return 0;
}

