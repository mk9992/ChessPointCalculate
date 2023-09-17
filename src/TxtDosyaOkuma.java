import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TxtDosyaOkuma {
    public static String[] getTxtDosyaOkuma() {
        // Proje klasörünüzün yolunu alın
        String projeKlasoru = System.getProperty("user.dir");

        // Klasörü temsil eden File nesnesini oluştur
        File klasor = new File(projeKlasoru);

        // Klasördeki .txt dosyalarını saklamak için bir liste kullanın
        List<String> txtDosyaIsimleri = new ArrayList<>();

        // Klasördeki dosyaları listele
        File[] dosyalar = klasor.listFiles();

        if (dosyalar != null) {
            for (File dosya : dosyalar) {
                if (dosya.isFile() && dosya.getName().endsWith(".txt")) {
                    // Yalnızca .txt uzantılı dosya isimlerini listeye ekleyin
                    txtDosyaIsimleri.add(dosya.getName());
                }
            }
        }

        // Listeyi bir dizi olarak dönüştürün ve döndürün
        String[] dosyaIsimleri = txtDosyaIsimleri.toArray(new String[0]);
        return dosyaIsimleri;
    }
}