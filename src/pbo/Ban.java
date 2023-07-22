/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo;

/**
 *
 * @author ASUS
 */
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
