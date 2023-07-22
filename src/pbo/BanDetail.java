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
public class BanDetail extends Ban{
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
