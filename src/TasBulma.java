import java.util.ArrayList;

public class TasBulma {
    public static ArrayList<AbstractTas> tasBul(char[][][] konum) {
        ArrayList<AbstractTas> taslar = new ArrayList<>();

        int satirNo=0;


        for (char[][] satır : konum) {

            int sutunNo=0;

            for (char[] sutun : satır) {
                AbstractTas tas = null;
                char renk = sutun[1];
                char cins = sutun[0];
                switch (cins) {
                    case 'p':
                        tas = new Piyon(renk,new int[]{satirNo,sutunNo++} );
                        break;
                    case 'v':
                        tas = new Vezir(renk,new int[]{satirNo,sutunNo++});
                        break;
                    case 'a':
                        tas = new At(renk,new int[]{satirNo,sutunNo++});
                        break;
                    default:
                        sutunNo++;


                }
                if (tas != null) {
                    taslar.add(tas);

                }

            }
            satirNo++;
        }

        return taslar;
    }

}