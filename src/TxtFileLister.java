import java.io.File;
import java.util.ArrayList;

public class TxtFileLister {
    public static ArrayList<String> listTxtFiles(String directoryPath) {
        ArrayList<String> namesOfBoards = new ArrayList<>();
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Geçersiz dizin.");

        }

        File[] txtFiles = directory.listFiles((dir, name) -> (name.startsWith("board") && name.endsWith(".txt")) ) ;

        if (txtFiles != null) {
            System.out.println("Dizin içindeki .txt dosyaları:");
            for (File txtFile : txtFiles) {
                namesOfBoards.add(txtFile.getName());
                //System.out.println(txtFile.getName());
            }
        } else {
            System.out.println("Dizin içinde .txt dosyası bulunamadı.");
        }
        return namesOfBoards;
    }
}