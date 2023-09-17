import java.io.File;

public class TxtFileLister {
    public static void listTxtFiles(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Geçersiz dizin.");
            return;
        }

        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (txtFiles != null) {
            System.out.println("Dizin içindeki .txt dosyaları:");
            for (File txtFile : txtFiles) {
                System.out.println(txtFile.getName());
            }
        } else {
            System.out.println("Dizin içinde .txt dosyası bulunamadı.");
        }
    }
}