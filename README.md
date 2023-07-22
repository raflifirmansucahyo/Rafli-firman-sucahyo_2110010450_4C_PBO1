# Proyek Akhir Pemrograman Berbasis Objek 1

Proyek ini adalah contoh sederhana aplikasi pengolahan data Ban menggunakan Java sebagai tugas akhir dari mata kuliah pemrograman berbasis objek 1.

## Deskripsi

Aplikasi ini menerima input berupa jenis kendaraan dan kode Ban, dan memberikan output berupa informasi detail dari kode tersebut seperti tahun produksi, merk, dan jenis ban.

Aplikasi ini mengimplementasikan beberapa konsep penting dalam pemrograman berorientasi objek (OOP) seperti Class, Object, Atribut, Method Constructor, Method Mutator, Method Accessor, Encapsulation, Inheritance, Overloading, Overriding, Seleksi, Perulangan, IO Sederhana, Array, dan Error Handling.

## Penjelasan Kode

Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:

1. **Class** adalah template atau blueprint dari object. Pada kode ini, `Ban`, `BanDetail`, dan `BanBeraksi` adalah contoh dari class.

```bash
public class Ban {
    //    atribut dan enkapsulasi
    private String merk;
    private String kode;
    
//    construktor
    public Ban(String merk, String kode) {
        this.merk = merk;
        this.kode = kode;
    }
    
//    mutator (seter)
    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

//    accesor (getter)
    public String getMerk() {
        return merk;
    }

    public String getKode() {
        return kode;
    }
    
    public String displayInfo(){
       return "Merk: "+getMerk()+
              "\nKode: "+getKode(); 
    }
    
//    polymorphism (overloading)
    public String displayInfo(String kelas){
        return displayInfo() + "\nKelas: "+kelas;
    }
}

public class BanDetail extends Ban {
     //    overriding
    public BanDetail(String merk, String kode) {
        super(merk, kode);
    }
    
    public int getTahunProduksi() {
        return Integer.parseInt(getKode().substring(5, 7)) + 2000;
    }
     
    public String getJenis(){
        String kodeJenis = getKode().substring(0, 2);
//        seleksi switch
        switch (kodeJenis){
            case "TB":
                return "Ban Tebeless";
            case "RD":
                return "Ban Radial";
            default:
                return "tidak ada jenis lain";
        }
    }
    
    public String getMerk(){
        String kodeMerk = getKode().substring(2, 5);
//        seleksi switch
        switch (kodeMerk){
            case "075":
                return "Accelera";
            case "153":
                return "GoodYear";
            case "201":
                return "Hankook";
            default:
                return "tidak ada jenis lain";
        }
    }   
    
//    polymorphism (overriding)
    @Override
    public String displayInfo(){
        return super.displayInfo() +
                "\nJenis ban: "+getJenis()+
                "\nMerk: "+getMerk()+
                "\nTahun Lahir: "+getTahunProduksi();
        
    }
}


package pbo;

import java.util.Scanner;

public class BanBeraksi {
    public static void main(String[] args) {

try{
    //io sederhana
    Scanner scanner = new Scanner (System.in);

    //array
        BanDetail[] ban = new BanDetail[2];
        for(int i=0; i<ban.length; i++) {
                System.out.print("Masukkan jenis kendaraan "+(i+1)+" ");
                String merk = scanner.nextLine();
                System.out.print("Masukkan Kode  "+(i+1)+" ");
                String kode = scanner.nextLine();

        //        objek
                ban[i] = new BanDetail (merk, kode);
    }

        for(BanDetail data: ban) {
            System.out.println("==================");
            System.out.println("Data Cat: ");
            System.out.println(data.displayInfo());
        }
    } catch (NumberFormatException e){
        System.out.println("Kesalahan format ban: "+e.getMessage());
    } catch (StringIndexOutOfBoundsException e) {
        System.out.println("Kesalahan format kode: "+e.getMessage());
    } catch (Exception e) {
        System.out.println("Kesalahan umum: "+e.getMessage());
    }
  }
}
```

2. **Object** adalah instance dari class. Pada kode ini, `ban[i] = new BanDetail(merk, kode);` adalah contoh pembuatan object.

```bash
ban[i] = new BanDetail(merk, kode);
```

3. **Atribut** adalah variabel yang ada dalam class. Pada kode ini, `merk` dan `kode` adalah contoh atribut.

```bash
String merk;
String kode;
```

4. **Constructor** adalah method yang pertama kali dijalankan pada saat pembuatan object. Pada kode ini, constructor ada di dalam class `Mahasiswa` dan `MahasiswaDetail`.

```bash
public Ban(String merk, String kode) {
    this.nama = merk;
    this.npm = kode;
}

public BanDetail(String merk, String kode) {
    super(merk, kode);
}
```

5. **Mutator** atau setter digunakan untuk mengubah nilai dari suatu atribut. Pada kode ini, `setMerk` dan `setKode` adalah contoh method mutator.

```bash
public void setMerk(String merk) {
    this.merk = merk;
}

public void setKode(String kode) {
    this.kode = kode;
}
```

6. **Accessor** atau getter digunakan untuk mengambil nilai dari suatu atribut. Pada kode ini, `getMerk`, `getKode`, `getProduksi`, `getJenis`. adalah contoh method accessor.

```bash
public String getMerk() {
    return merk;
}

public String getKode() {
    return kode;
}
```

7. **Encapsulation** adalah konsep menyembunyikan data dengan membuat atribut menjadi private dan hanya bisa diakses melalui method. Pada kode ini, atribut `merk` dan `kode` dienkapsulasi dan hanya bisa diakses melalui method getter dan setter.

```bash
private String merk;
private String kode;
```

8. **Inheritance** adalah konsep di mana sebuah class bisa mewarisi property dan method dari class lain. Pada kode ini, `BanDetail` mewarisi `Ban` dengan sintaks `extends`.

```bash
public class BanDetail extends Ban {
    ...
}
```

9. **Polymorphism** adalah konsep di mana sebuah nama dapat digunakan untuk merujuk ke beberapa tipe atau bentuk objek berbeda. Ini memungkinkan metode-metode dengan nama yang sama untuk berperilaku berbeda tergantung pada tipe objek yang mereka manipulasi, polymorphism bisa berbentuk Overloading ataupun Overriding. Pada kode ini, method `displayInfo(String)` di `Ban` merupakan overloading method `displayInfo` dan `displayInfo` di `BanDetail` merupakan override dari method `displayInfo` di `Ban`.

```bash
public String displayInfo(String kelas) {
    return displayInfo() + "\nKelas: " + kelas;
}

@Override
public String displayInfo() {
    ...
}
```

10. **Seleksi** adalah statement kontrol yang digunakan untuk membuat keputusan berdasarkan kondisi. Pada kode ini, digunakan seleksi `if else` dalam method `getJenis` dan seleksi `switch` dalam method `getMerk`.

```bash
public String getJenis(){
        String kodeJenis = getKode().substring(0, 2);
//        seleksi switch
        switch (kodeJenis){
            case "TB":
                return "Ban Tebeless";
            case "RD":
                return "Ban Radial";
            default:
                return "tidak ada jenis lain";
        }
    }
    
    public String getMerk(){
        String kodeMerk = getKode().substring(2, 5);
//        seleksi switch
        switch (kodeMerk){
            case "075":
                return "Accelera";
            case "153":
                return "GoodYear";
            case "201":
                return "Hankook";
            default:
                return "tidak ada jenis lain";
        }
}
```

11. **Perulangan** adalah statement kontrol yang digunakan untuk menjalankan blok kode berulang kali. Pada kode ini, digunakan loop `for` untuk meminta input dan menampilkan data.

```bash
for(int i=0; i<ban.length; i++) {
    ...
}
```

12. **Input Output Sederhana** digunakan untuk menerima input dari user dan menampilkan output ke user. Pada kode ini, digunakan class `Scanner` untuk menerima input dan method `System.out.println` untuk menampilkan output.

```bash
System.out.print("Masukkan jenis kendaraan "+(i+1)+" ");
String merk = scanner.nextLine();
System.out.print("Masukkan Kode  "+(i+1)+" ");
String kode = scanner.nextLine();
```

13. **Array** adalah struktur data yang digunakan untuk menyimpan beberapa nilai dalam satu variabel. Pada kode ini, `BanDetail[] ban = new BanDetail[2];` adalah contoh penggunaan array.

```bash
BanDetail[] ban = new BanDetail[2];
```

14. **Error Handling** digunakan untuk menangani error yang mungkin terjadi saat runtime. Pada kode ini, digunakan `try catch` untuk menangani error.

```bash
try {
   catch (NumberFormatException e){
        System.out.println("Kesalahan format ban: "+e.getMessage());
    } catch (StringIndexOutOfBoundsException e) {
        System.out.println("Kesalahan format kode: "+e.getMessage());
    } catch (Exception e) {
        System.out.println("Kesalahan umum: "+e.getMessage());
    }
}
```

## Usulan nilai

| No  | Materi         |  Nilai  |
| :-: | -------------- | :-----: |
|  1  | Class          |    5    |
|  2  | Object         |    5    |
|  3  | Atribut        |    5    |
|  4  | Constructor    |    5    |
|  5  | Mutator        |    5    |
|  6  | Accessor       |    5    |
|  7  | Encapsulation  |    5    |
|  8  | Inheritance    |    5    |
|  9  | Polymorphism   |   10    |
| 10  | Seleksi        |    5    |
| 11  | Perulangan     |    5    |
| 12  | IO Sederhana   |   10    |
| 13  | Array          |   15    |
| 14  | Error Handling |   15    |
|     | **TOTAL**      | **100** |

## Pembuat

Nama : Rafli Firman Sucahyo
NPM: 2110010450
