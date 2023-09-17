import java.util.ArrayList;

public class Piyon extends AbstractTas{




//abstract classa piyonu ekleme
    Piyon(char team, int[] konum){
        this.konum = konum;
        this.team = team;
    }
//piyonun hareketleri
    @Override
    public ArrayList<int[]> moves() {
        ArrayList<int[]> piyonHareketleri = new ArrayList<>() ;
        //piyon rengi siyahsa edeceği hareket
        if (this.team=='s') {
            piyonHareketleri.add(new int[]{1, 1});
            piyonHareketleri.add(new int[]{1, -1});
        }
        //piyon rengi beyazsa edeceği hareket
        else {
            piyonHareketleri.add(new int[]{-1, 1});
            piyonHareketleri.add(new int[]{-1, -1});
        }


        return piyonHareketleri;
    }
}
