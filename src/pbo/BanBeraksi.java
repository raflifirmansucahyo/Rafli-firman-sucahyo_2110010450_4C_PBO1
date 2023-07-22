/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
