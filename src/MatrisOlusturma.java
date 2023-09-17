import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class MatrisOlusturma {

  public static char[][][] doldur(){

        char[][][] matris = new char[8][8][2]; // 8x8x2 matris oluştur

        try {
            FileReader dosyaOkuyucu = new FileReader("board3.txt");
            BufferedReader bufferedReader = new BufferedReader(dosyaOkuyucu);

            int satirNo = 0;

            while (satirNo < 8) {
                String satir = bufferedReader.readLine();
                if (satir == null) {
                    break; // Dosya sonuna geldik
                }

                for (int sutun = 0; sutun < 8 && sutun * 2 + 1 < satir.length(); sutun++) {
                    char cins = satir.charAt(sutun * 2);
                    char renk = satir.charAt(sutun * 2 + 1);

                    matris[satirNo][sutun][0] = cins;
                    matris[satirNo][sutun][1] = renk;
                }

                satirNo++;
            }

            dosyaOkuyucu.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Matrisi ekrana yazdır
        return matris;
    }

    public static void yazdir(char[][][] matris) {
        for (int satir = 0; satir < 8; satir++) {
            for (int sutun = 0; sutun < 8; sutun++) {
                System.out.print(matris[satir][sutun][0] + "" + matris[satir][sutun][1] + " ");
            }
            System.out.println();
        }


    }


}
