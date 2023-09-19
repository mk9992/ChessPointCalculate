import java.io.*;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {

    public static void main(String[] args) {
        ArrayList<String> output = new ArrayList<>();
        String directoryPath = "."; // Mevcut çalışma dizini


        for (String fileName: TxtFileLister.listTxtFiles(directoryPath)){

            HashSet<TehditAltindaOlanlar> tehditler = new HashSet<>();



            char[][][] konum = MatrisOlusturma.doldur(fileName);
            //MatrisOlusturma.yazdir(MatrisOlusturma.doldur());
            // System.out.println(konum[5][2]);
            List<AbstractTas> taslar = TasBulma.tasBul(konum);
            for (AbstractTas tas : taslar) {
                int dikeyKonum = tas.konum[0];
                int yatayKonum = tas.konum[1];
                ArrayList<int[]> hareketler = tas.moves();
                ArrayList<int[]> hamleler = new ArrayList<>();
                if (tas instanceof Vezir) {
                    ArrayList<ArrayList<int[]>> vezirHareket = ((Vezir) tas).vezirMoves();

                    for (ArrayList<int[]> vezirYon : vezirHareket) {
                        for (int[] vezirHamle : vezirYon) {
                            int dikey = vezirHamle[0];
                            int yatay = vezirHamle[1];
                            int dikeyHamle = dikey + dikeyKonum;
                            int yatayHamle = yatay + yatayKonum;

                            try {
                                char[] hedef = konum[dikeyHamle][yatayHamle];
                                char cins = hedef[0];
                                char renk = hedef[1];


                                if (renk != '-') {
                                    if (tas.team == renk) {
                                        break;
                                    } else {

                                        //  System.out.println(tas.team);
                                        //System.out.println("hedefin konumu: " + dikeyHamle + ", " + yatayHamle + " cins: " + cins );
                                        tehditler.add(new TehditAltindaOlanlar(dikeyHamle, yatayHamle, renk, cins));
                                        break;
                                    }

                                }
                            } catch (Exception e) {

                            }
                        }
                    }
                }

                else {
                    for (int[] hareket : hareketler) {
                        int dikeyHareket = hareket[0];
                        int yatayHareket = hareket[1];
                        int dikeyHamle = dikeyHareket + dikeyKonum;
                        int yatayHamle = yatayHareket + yatayKonum;

                        try {
                            char[] hedef = konum[dikeyHamle][yatayHamle];
                            char cins = hedef[0];
                            char renk = hedef[1];
                            if (tas instanceof Vezir) {
                                System.out.println("vezir bulundu");

                                continue;

                            }
                            if (renk != '-' && renk != tas.team) {
                                // System.out.println(tas.team);
                                // System.out.println("hedefin konumu: " + dikeyHamle + ", " + yatayHamle + " cins: " + cins + " renk: " + renk);
                                tehditler.add(new TehditAltindaOlanlar(dikeyHamle, yatayHamle, renk, cins));

                            }
                        } catch (Exception e) {


                        }


                        // System.out.println(dikeyHamle + "," + yatayHamle);

                    }
                    // System.out.println(tas.konum[0] + " ," + tas.konum[1]);


                }
            }
            for (TehditAltindaOlanlar tehdit: tehditler){
                int dikeyKonum = tehdit.dikeyKonum;
                int yatayKonum = tehdit.yatayKonum;
                char cins = tehdit.cins;
                char takim = tehdit.takim;

                //System.out.println(dikeyKonum+" "+yatayKonum+" "+cins+" "+takim);


            }
            //System.out.println(ToplamPuan.sonuc(ToplamPuan.toplam(konum))[0] + "siyah");
            //System.out.println(ToplamPuan.sonuc(ToplamPuan.toplam(konum))[1] + "beyaz");



            double siyahSonuc = ToplamPuan.sonuc(ToplamPuan.toplam(konum),fileName)[0];
            double beyazSonuc = ToplamPuan.sonuc(ToplamPuan.toplam(konum), fileName)[1];
            int siyahInt = 0;
            int beyazInt = 0;
            String siyahStr = String.valueOf(siyahSonuc);
            String beyazStr = String.valueOf(beyazSonuc);
            if (siyahSonuc % 1 == 0) {
                 siyahInt = (int) siyahSonuc;
                 siyahStr = String.valueOf(siyahInt);
            }
            if (beyazSonuc % 1 == 0){
                beyazInt = (int) beyazSonuc;
                beyazStr = String.valueOf(beyazInt);
            }
            // Dosya adı ve içeriği
            String veri = fileName + "        " + "Siyah:" + (siyahSonuc % 1 == 0 ? siyahStr  : siyahSonuc ) + "    " + "Beyaz" + (beyazSonuc % 1 == 0 ? beyazStr : beyazSonuc) ;
            output.add(veri);



            System.out.println(fileName);
        }
        try {
            // FileWriter ve PrintWriter nesneleri oluştur
            FileWriter dosyaYazici = new FileWriter("bulunansonuclar.txt");
            PrintWriter yazdirici = new PrintWriter(dosyaYazici);

            yazdirici.println("Tahta Dosya Adi" + "        " + "Sonuclar");
            // Veriyi dosyaya yaz
            for (String satir: output) {
                yazdirici.println(satir);
            }
            // Dosyayı kapat
            yazdirici.close();
            System.out.println("Dosya oluşturuldu ve veri yazıldı." + "\n" + "veriler bulunansonuclar.txt'ye kaydedildi");
        } catch (IOException e) {
            System.out.println("Dosya oluşturma hatası: " + e.getMessage());

        }



    }


}